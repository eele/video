package edu.zhku.jsj144.lzc.video.plugin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class BaseInterceptor implements Interceptor {

	private Properties tableNameMapping = new Properties();

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		String pType = "";
		System.out.println(mappedStatement.getParameterMap().getParameterMappings());
		
		if (tableNameMapping.getProperty(pType) != null) {
			BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
			String sql = boundSql.getSql();
			
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

}
