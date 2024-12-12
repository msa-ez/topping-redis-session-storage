path: {{source.boundedContext.name}}/{{{options.packagePath}}}/config/redis
except: {{contexts.except}}
---
package {{options.package}}.config.redis;

import javax.servlet.http.Cookie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                if (attributes != null) {
                    Cookie[] cookies = attributes.getRequest().getCookies();
                        // Start Generation Here
                        for (Cookie cookie : cookies) {
                            if ("JSESSIONID".equals(cookie.getName())) {
                                template.header("Cookie", "JSESSIONID=" + cookie.getValue());
                                break;
                            }
                        }
                    // 세션 ID를 헤더에 추가
                    // String cookies = "JSESSIONID=YmRjYWNmMmMtMmM4MC00Zjg1LWEwY2ItNDY3NmMyZDI1YzE3; SameSite=None;";

                    // 쿠키 헤더에 설정
                    // template.header("Cookie", cookies);
                }
            }
        };
    }
}
<function>
    let isPostInvocation = ((this.source._type.endsWith("Event") || this.source._type.endsWith("Policy")) && this.target._type.endsWith("Command"))
    let isExternalInvocation = (this.source.boundedContext.name != this.target.boundedContext.name)

    this.contexts.except = !(isExternalInvocation && isPostInvocation)
</function>