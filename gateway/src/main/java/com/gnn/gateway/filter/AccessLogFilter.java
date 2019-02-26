package com.gnn.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class AccessLogFilter extends ZuulFilter {

    /**
     * POST：在请求被路由到对应的微服务以后执行，可用来为Response添加HTTP Header、将微服务的Response发送给客户端等。
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * 最后执行
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext=RequestContext.getCurrentContext();

        HttpServletRequest httpServletRequest=requestContext.getRequest();
        Long startTime=(Long)requestContext.get("startTime");
        String uri=httpServletRequest.getRequestURI();
        long duration=System.currentTimeMillis()-startTime;
        //打印请求延迟信息与请求uri
        log.info("uri: "+uri+" ,duration: "+duration/100+" ms" );

        return null;
    }
}
