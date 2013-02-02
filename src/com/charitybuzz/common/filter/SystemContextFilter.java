package com.charitybuzz.common.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.ConnectionUtil;

public class SystemContextFilter implements Filter {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(SystemContextFilter.class);
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chan) throws IOException, ServletException {

		try {
			//req.getAttribute("user");
			
			
			chan.doFilter(req, res);
			try {
				//if (insert update delete)
				if (ConnectionUtil.isConnectionInThreadLocal()) {
					//commit;
					ConnectionUtil.commitWriteConnection();
				}
			} catch (SQLException e) {
				log.error(" ConnectionUtil.commitWriteConnection error",e);
			}
		} finally {
			
			//不管有無出錯，都要判斷是否有拿WriteConnection
			//關閉
			//移除
			
			if (ConnectionUtil.isConnectionInThreadLocal()) {
				try {
					Connection conn = ConnectionUtil.getWriteConnection();
					conn.close();
					ConnectionUtil.removeWriteConnection();
				} catch (SQLException e) {
					log.error(" SystemContextFilter error",e);
				}
			}

		}

	}

	@Override
	public void init(FilterConfig cf) throws ServletException {

	}

}
