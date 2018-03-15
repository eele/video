package edu.zhku.jsj144.lzc.video.plugin;

import edu.zhku.jsj144.lzc.video.exception.RequireTokenException;
import edu.zhku.jsj144.lzc.video.plugin.annotation.RequireToken;
import edu.zhku.jsj144.lzc.video.util.TokenUtil;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 令牌验证拦截器
 */
@Component("tokenInInterceptor")
public class TokenInInterceptor extends AbstractPhaseInterceptor<Message> {

    public TokenInInterceptor() {
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        try {
            // 获取请求执行的业务方法
            Method method = (Method) message.get("org.apache.cxf.resource.method");
            // 获取对应业务类的接口
            Class<?> interfaceClass = method.getDeclaringClass().getInterfaces()[0];
            // 获取对应业务类的接口方法
            Method iMethod = interfaceClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
            // 获取注解
            RequireToken iMethodAnnotation = iMethod.getDeclaredAnnotation(RequireToken.class);
            RequireToken iClassAnnotation = interfaceClass.getDeclaredAnnotation(RequireToken.class);

            // 若该方法需要令牌验证
            if (iMethodAnnotation != null || iClassAnnotation != null) {
                HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
                // 验证Token合法性
                String token = request.getParameter("token");
                if (token == null || token.equals("")) {
                    throw new Fault(new RequireTokenException());
                }
                message.put("uid", TokenUtil.checkToken(token));
                if (iMethodAnnotation != null) {
                    message.put("ownResourceOnly", iMethodAnnotation.ownResourceOnly());
                } else {
                    message.put("ownResourceOnly", iClassAnnotation.ownResourceOnly());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
