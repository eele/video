package edu.zhku.jsj144.lzc.video.plugin;

import edu.zhku.jsj144.lzc.video.exception.IllegalResourceAccessException;
import edu.zhku.jsj144.lzc.video.plugin.annotation.RequireToken;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxrs.impl.MetadataMap;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 资源访问拦截器，若指定请求开启@RequireToken注解Own Resource Only设置，则该业务请求只允许用户访问自己的资源
 */
@Component("resourceAccessInInterceptor")
public class ResourceAccessInInterceptor extends AbstractPhaseInterceptor<Message> {
    public ResourceAccessInInterceptor() {
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        Boolean ownResourceOnly = (Boolean) message.get("ownResourceOnly");
        if (ownResourceOnly != null && ownResourceOnly == true) {
            MetadataMap metadataMap =
                    (MetadataMap) message.get("jaxrs.template.parameters");
            String id = (String) metadataMap.get("id").get(0);
            if (id == null) {
                throw new Fault(new IllegalStateException());
            }
            System.out.println(message.get("uid") + "    -------------");
            if (! ((String) message.get("uid")).substring(0, 2).equals("a#")) { // 若用户不是管理员
                // 若资源id中uid部分与用户ID不匹配，说明该资源不属于本用户资源
                if (id.length() > 32 && ! id.substring(0, 32).equals(message.get("uid"))) {
                    throw new Fault(new IllegalResourceAccessException());
                }
            }
        }
    }
}
