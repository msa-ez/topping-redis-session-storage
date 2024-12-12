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
        
        return new HeaderHttpSessionIdResolver("SESSION");
    }
}