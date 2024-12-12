forEach: Relation
path: {{source.boundedContext.name}}/{{{options.packagePath}}}/config/redis
except: {{contexts.except}}
---
package {{options.package}}.config.redis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            try {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                if (attributes != null) {
                    HttpServletRequest request = attributes.getRequest();
                    
                    // 세션 ID를 SESSION 헤더로 전달
                    String sessionId = request.getSession().getId();
                    template.header("SESSION", sessionId);
                    
                    // 모든 쿠키도 함께 전달
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null) {
                        StringBuilder cookieValue = new StringBuilder();
                        for (Cookie cookie : cookies) {
                            if (cookieValue.length() > 0) {
                                cookieValue.append("; ");
                            }
                            cookieValue.append(cookie.getName()).append("=").append(cookie.getValue());
                        }
                        template.header("Cookie", cookieValue.toString());
                    }
                }
            } catch (Exception e) {
                template.header("Content-Type", "application/json");
            }
        };
    }
} 
<function>
    let isPostInvocation = ((this.source._type.endsWith("Event")  && this.target._type.endsWith("Command")) || (this.source._type.endsWith("Command") && this.target._type.endsWith("View")))
    let isExternalInvocation = (this.source.boundedContext.name != this.target.boundedContext.name)

    this.contexts.except = !(isExternalInvocation && isPostInvocation)
</function>