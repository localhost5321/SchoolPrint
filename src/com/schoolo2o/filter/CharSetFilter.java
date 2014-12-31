package com.schoolo2o.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharSetFilter implements Filter {
	private String characterEncoding;
	private boolean enabled;

	@Override
	public void destroy() {
		characterEncoding = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (enabled || characterEncoding != null) {
			request.setCharacterEncoding(characterEncoding);
			response.setCharacterEncoding(characterEncoding);
			System.out.println("***************************");
		}
		response.getWriter().println(request.getParameter("username"));
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		characterEncoding = filterConfig.getInitParameter("encoding");
		enabled = "true".equalsIgnoreCase(filterConfig
				.getInitParameter("using").trim());
	}

}
