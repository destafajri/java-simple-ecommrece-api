package com.destaproject.core.infrastructure.logging;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class UserInfoLogger implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        this.userLog(request);

        return true;
    }

    private void userLog(HttpServletRequest request) {
        String appProtocol = String.format("request using protocol %s://%s:%s%s",
                request.getProtocol(),
                request.getServerName(),
                request.getServerPort(),
                request.getContextPath());

        String logInfo = String.format("""
                        App request: %s,
                        Protocol ID: %s,
                        App URL: %s,
                        Remote Host: %s,
                        Device: %s,
                        Request ID: %s,
                        Session ID: %s,
                        Locales: %s,
                        Local Name: %s,
                        HTTP Mapping: %s,
                        Forwarder For: %s,
                        Remote Addr: %s
                        """,
                appProtocol,
                request.getProtocolRequestId(),
                request.getRequestURL(),
                request.getRemoteHost(),
                request.getHeader("User-Agent"),
                request.getRequestId(),
                request.getRequestedSessionId(),
                request.getLocales(),
                request.getLocalName(),
                request.getHttpServletMapping(),
                request.getHeader("X-Forwarded-For"),
                request.getRemoteAddr());

        log.info("{}", logInfo);
    }
}

