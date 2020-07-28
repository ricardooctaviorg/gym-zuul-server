package com.rorg.gym.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class PostTimeFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(PostTimeFilter.class);
	
	private static final String POST						= "post";
	private static final String ATTR_TIME_START_REQ			= "timeStartReq";
	private static final String INFO_POST_FILTER			= "INIT POST FILTER ...";

	public PostTimeFilter() {
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext requestContent = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContent.getRequest();
		log.info(INFO_POST_FILTER);
		Long timeStartReq = (Long)request.getAttribute(ATTR_TIME_START_REQ);
		long currentTimeMillis = System.currentTimeMillis();
		Long timeRequest = timeStartReq - currentTimeMillis;
		log.info(String.format("Time to Request in seconds: %s", timeRequest.doubleValue()/1000.00));
		log.info(String.format("Time to Request in miliseconds: %s ", timeRequest));
		return null;
	}

	@Override
	public String filterType() {
		return POST;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
