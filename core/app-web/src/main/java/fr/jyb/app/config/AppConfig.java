package fr.jyb.app.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class AppConfig {

    @Value("${app.intercepors.logcontext.isLogContextInitInterceptorEnabled:false}")
    private boolean logContextInitInterceptorEnabled;

    @Value("${app.intercepors.logcontext.pathPatternLogContextInitInterceptor:}")
    private String pathPatternLogContextInitInterceptor;
}
