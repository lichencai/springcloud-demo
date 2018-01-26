package com.licc.demo;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.context.RequestContext;

/**
 * 用户鉴权
 */
@Component
public class BookingCarPreFilter extends ZuulFilter{

	@Override
	public Object run() {
		System.out.println("=============BookingCarPreFilter===========");
		try {
			RequestContext ctx = RequestContext.getCurrentContext();
			HttpServletRequest request = ctx.getRequest();
			String userId = request.getParameter("userId");
			if(StringUtils.isEmpty(userId)) {
				ctx.setSendZuulResponse(false);
				ctx.setResponseStatusCode(401);
				ctx.getResponse().getWriter().write("param userId is null");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
