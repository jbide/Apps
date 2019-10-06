package fr.jyb.app.rest.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 *
 */
@Component
@Slf4j
@Order(1)
public class LogTrackFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("trackkkkkkkkkk");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
