package com.rorg.gym.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class PreTimeFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(PreTimeFilter.class);
	
	private static final String PRE							= "pre";
	private static final String ATTR_TIME_START_REQ			= "timeStartReq";

	public PreTimeFilter() {
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext requestContent = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContent.getRequest();
		log.info(String.format("%s request route to %s", request.getMethod(), request.getRequestURL().toString()));
		Long timeStartReq = System.currentTimeMillis();
		request.setAttribute(ATTR_TIME_START_REQ, timeStartReq);
		return null;
	}

	@Override
	public String filterType() {
		return PRE;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
