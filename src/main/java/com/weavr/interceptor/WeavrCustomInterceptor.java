package com.weavr.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

import com.wavemaker.runtime.rest.processor.request.AbstractHttpRequestProcessor;
import com.wavemaker.runtime.rest.processor.request.HttpRequestProcessorContext;
import com.wavemaker.runtime.security.SecurityService;

/**
 * Created by saraswathir on 30/06/21
 */
public class WeavrCustomInterceptor extends AbstractHttpRequestProcessor {

    private static final Logger logger = LoggerFactory.getLogger(WeavrCustomInterceptor.class);

    @Value("${app.environment.apikey}")
    private String apiKey;

    @Autowired
    private SecurityService securityService;

    @Override
    protected void doProcess(HttpRequestProcessorContext httpRequestProcessorContext) {
        logger.info("---- Interceptor Logic start ---------");
        HttpHeaders headers = httpRequestProcessorContext.getHttpRequestDetails().getHeaders();
        String endpointAddress = httpRequestProcessorContext.getHttpRequestDetails().getEndpointAddress();
        logger.info("----Endpoint address: " + endpointAddress);
        // HttpServletRequest httpServletRequest = httpRequestProcessorContext.getHttpServletRequest();
        headers.set("api-key", apiKey);
        headers.set("Content-Type", "application/json");
        if (!endpointAddress.contains("password")) {
            Object authtoken = securityService.getSecurityInfo().getUserInfo().getUserAttributes().get("authtoken");
            logger.info("Authtoken -- " + authtoken);
            if (authtoken.toString() != null) {
                headers.setBearerAuth(authtoken.toString());
                
            }
        }
        logger.info("-----Interceptor headers: " + headers.toString());
    }
}
