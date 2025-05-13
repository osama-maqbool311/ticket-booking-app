package com.daas.filter;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;
import java.util.Optional;

@Provider
@Priority(Priorities.USER)
public class MdcLoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        MDC.put("request.id", UUID.randomUUID().toString());
        MDC.put("request.method", safe(requestContext.getMethod()));
        MDC.put("request.path", safe(requestContext.getUriInfo().getPath()));
        MDC.put("request.query", safe(requestContext.getUriInfo().getRequestUri().getQuery()));
        MDC.put("remote.addr", safe(getClientIp(requestContext)));
        MDC.put("user.agent", safe(requestContext.getHeaderString("User-Agent")));
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        MDC.clear();
    }

    private String getClientIp(ContainerRequestContext requestContext) {
        String xfHeader = requestContext.getHeaderString("X-Forwarded-For");
        if (xfHeader != null && !xfHeader.isEmpty()) {
            return xfHeader.split(",")[0];
        }
        return Optional.ofNullable(requestContext.getHeaderString("Remote-Addr")).orElse("unknown");
    }

    private String safe(String value) {
        return value != null ? value : "unknown";
    }
}