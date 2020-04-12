package com.zx.springcloud.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 使用SpringCloud过滤器时，需要实现GlobalFilter, Ordered两个接口
 */

@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    Logger logger = LoggerFactory.getLogger(MyLogGateWayFilter.class);

    /**
     * ServerWebExchange：里面封装了请求的相关参数
     * GatewayFilterChain：用于封装返回值
     * 例如：我们需要判断前端的的请求是否有用户，如果有将前端的信息继续传给下一个过滤器，如果没有封装错误代码传给下一个过滤器
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        logger.info("********come in MyLogGateWayFilter " + new Date());
        //获取前端传来的uname的值
        String name = exchange.getRequest().getQueryParams().getFirst("uname");
        if (null == name) {
            logger.error("********用户名为null, 非法用户, /(ㄒoㄒ)/~~");
            //将错误代码方法Response中
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //设置完成状态
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    //过滤器的加载顺序，返回的数字越小优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
