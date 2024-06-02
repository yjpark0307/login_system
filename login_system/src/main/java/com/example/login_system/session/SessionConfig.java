package com.example.login_system.session;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession
public class SessionConfig {
    // 빈이 필요 없다면 HttpSessionIdResolver를 제거해보세요.
}
