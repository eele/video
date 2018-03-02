package edu.zhku.jsj144.lzc.video.plugin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class BaseSqlInterceptor implements Interceptor {

	private Properties tableNameMapping = new Properties();

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);

		BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
		String sql = boundSql.getSql();
		if (sql.charAt(0) == '$') {
			Object pObj = boundSql.getParameterObject();
			sql = reWriteSQL(sql, pObj);
			metaStatementHandler.setValue("delegate.boundSql.sql", sql);
		}

		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		try {
			String path = properties.getProperty("tableNameMappingPath");
			if (path == null) {
				throw new IllegalArgumentException("Property \"tableNameMappingPath\" not set");
			} else {
				ClassLoader classLoader = getClass().getClassLoader();
				URL url = classLoader.getResource(path);
				if (url == null) {
					throw new IllegalArgumentException(
							"Property \"tableNameMappingPath\": file \"" + path + "\" not found");
				} else {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(url.getFile()));
					tableNameMapping.load(bufferedReader);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String reWriteSQL(String sql, Object pObj) throws IllegalArgumentException, IllegalAccessException {
		String pType = pObj.getClass().getSimpleName();
		if (tableNameMapping.getProperty(pType) != null) {
			StringBuilder sbu = new StringBuilder(sql);
			sbu.deleteCharAt(0);
			Field[] fields = pObj.getClass().getDeclaredFields();
			switch (sql) {
			case "$insert into":
				sbu.append(" ").append(tableNameMapping.getProperty(pType)).append("(");
				for (Field f : fields) {
					f.setAccessible(true);
					sbu.append(f.getName()).append(',');
				}
				sbu.deleteCharAt(sbu.length() - 1);
				sbu.append(") values(");
				for (Field f : fields) {
					if ((f.getType() == String.class || f.getType() == Timestamp.class) && f.get(pObj) != null) {
						sbu.append('"').append(f.get(pObj)).append("\",");
					} else {
						sbu.append(f.get(pObj)).append(",");
					}
				}
				sbu.deleteCharAt(sbu.length() - 1);
				sbu.append(")");
				break;
			case "$update":
				sbu.append(" ").append(tableNameMapping.getProperty(pType)).append(" set ");
				String id = null;
				for (Field f : fields) {
					f.setAccessible(true);
					if (f.getName().equals("id")) {
						id = (String) f.get(pObj);
					}
					
					if ((f.getType() == String.class || f.getType() == Timestamp.class) && f.get(pObj) != null) {
						sbu.append(f.getName()).append('=').append('"').append(f.get(pObj)).append("\",");
					} else {
						sbu.append(f.getName()).append('=').append(f.get(pObj)).append(",");
					}
				}
				sbu.deleteCharAt(sbu.length() - 1);
				sbu.append(" where id=\"").append(id).append("\"");
				break;
			case "$delete from":
				sbu.append(" ").append(tableNameMapping.getProperty(pType)).append(" where ");
				for (Field f : fields) {
					f.setAccessible(true);
					if (f.get(pObj) != null) {
						sbu.append(f.getName()).append('=').append('"').append(f.get(pObj)).append("\" and ");
					}
				}
				sbu.delete(sbu.length() - 5, sbu.length());
				break;
			}
			sql = sbu.toString();
		} else {
			throw new IllegalArgumentException(
					"Mapping of class \"" + pObj.getClass().getSimpleName() + "\" not found");
		}
		return sql;
	}

}
