package com.gnn.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;


@Component
@Slf4j
public class PreRequestFilter extends ZuulFilter {


    /**
     * 定义filter类型，这里定义为pre
     * PRE：在请求被路由之前调用，可以使用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试Log等。
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 返回值越小，越先被调用
     * @return
     */
    @Override
    public int filterOrder() {
//        return PRE_DECORATION_FILTER_ORDER-1;
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //拿到当前的上下文
        RequestContext requestContext=RequestContext.getCurrentContext();

        //记录当前时间戳
        requestContext.set("startTime",System.currentTimeMillis());


        return null;
    }
}
