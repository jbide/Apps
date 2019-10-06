package fr.jyb.app.config;

import fr.jyb.app.rest.interceptor.LogContextInitInterceptor;
import fr.jyb.app.rest.interceptor.ReadHeadersInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */

@Configuration
public class WebMvcConfig {

    @Autowired
    private LogContextInitInterceptor logContextInitInterceptor;

    @Autowired
    private ReadHeadersInterceptor readHeadersInterceptor;

    @Autowired
    private AppConfig appConfig;

    @Bean
    public WebMvcConfigurer interceptorConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                addCustomInterceptors(registry);
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

    private void addCustomInterceptors(InterceptorRegistry registry) {
        this.addInterceptorToRegistry(registry, readHeadersInterceptor, true, "/api/**");
        this.addInterceptorToRegistry(registry, logContextInitInterceptor, appConfig.isLogContextInitInterceptorEnabled(), appConfig.getPathPatternLogContextInitInterceptor());
    }

    private void addInterceptorToRegistry(InterceptorRegistry registry, HandlerInterceptor interceptor, boolean isInterceptorEnabled, String pathPatternInterceptor) {
        if (isInterceptorEnabled) {
            if (pathPatternInterceptor != null) {
                registry.addInterceptor(interceptor).addPathPatterns(new String[]{pathPatternInterceptor});
            } else {
                registry.addInterceptor(interceptor);
            }
        }
    }
}
