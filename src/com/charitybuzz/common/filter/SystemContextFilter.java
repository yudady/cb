package com.charitybuzz.common.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.charitybuzz.common.dao.ConnectionUtil;

public class SystemContextFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chan) throws IOException, ServletException {

		try {
			
			chan.doFilter(req, res);
			
		} finally {
			
			//不管有無出錯，都要判斷是否有拿WriteConnection
			
			if (ConnectionUtil.isConnectionInThreadLocal()) {
				try {
					ConnectionUtil.removeWriteConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void init(FilterConfig cf) throws ServletException {

	}

}
