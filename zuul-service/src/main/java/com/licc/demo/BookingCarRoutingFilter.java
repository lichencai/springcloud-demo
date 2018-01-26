package com.licc.demo;

import java.net.URL;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 拦截请求的实现
 */
@Component
public class BookingCarRoutingFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("=============BookingCarRoutingFilter===========");
		try {
			RequestContext ctx = RequestContext.getCurrentContext();
			ctx.setRouteHost(new URL("http://www.baidu.com"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
