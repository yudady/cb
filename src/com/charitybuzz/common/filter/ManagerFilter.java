package com.charitybuzz.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.charitybuzz.dto.Operator;

public class ManagerFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chan) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String indexUrl = request.getServletPath();

		Operator operator = (Operator) request.getSession().getAttribute(
				"operator");
		if ("/manager/index.do".equals(indexUrl)) {
			chan.doFilter(req, res);
		} else if (operator == null) {
			// redirect
			HttpServletResponse response = (HttpServletResponse) res;
			response.sendRedirect(request.getContextPath()
					+ "/manager/index.do");
		} else {
			//have session 
			chan.doFilter(req, res);
		}

	}

	@Override
	public void init(FilterConfig cf) throws ServletException {

	}

}
