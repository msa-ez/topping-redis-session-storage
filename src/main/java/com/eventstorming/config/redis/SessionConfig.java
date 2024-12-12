path: {{name}}/{{{options.packagePath}}}/config/redis
---
package {{options.package}}.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;



@Configuration
public class SessionConfig {
    @Bean
    public HttpSessionIdResolver httpSessionIdResolver() {
        // Feign Client를 통한 서비스 간 통신을 위해 Header 기반 세션 ID 리졸버 사용
        return new HeaderHttpSessionIdResolver("SESSION");
    }
}