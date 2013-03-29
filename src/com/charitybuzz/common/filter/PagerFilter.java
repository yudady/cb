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

import com.charitybuzz.common.Constant;
import com.charitybuzz.common.context.PagerContext;

/**
 * Pager分頁
 * 
 * @author Administrator
 * 
 */
public class PagerFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		/**
		 * 第一頁
		 */
		int pageOffset = 0;
		/**
		 * 每頁幾條記錄
		 */
		int pageSize = 10;
		try {

			try {
				pageOffset = Integer.parseInt(req.getParameter("pager.offset"));
			} catch (NumberFormatException e) {
				pageOffset = 0;
			}
			try {
				pageSize = Integer.parseInt(req.getParameter("pageSize"));
			} catch (NumberFormatException e) {
				pageSize = 10;
			}
			// add to ThreadLocal
			PagerContext.setPageOffset(pageOffset);
			PagerContext.setPageSize(pageSize);
			// here chain
			chain.doFilter(request, response);
		} finally {
			// remove from ThreadLocal
			PagerContext.removePageOffset();
			PagerContext.removePageSize();
		}

	}

	@Override
	public void init(FilterConfig cf) throws ServletException {
		/**
		 * 初始化 設定常量
		 */
		String path = cf.getServletContext().getRealPath("/");
		String uploadFolder = path + "pic/upload/";
		Constant.UPLOAD_FOLDER = uploadFolder;
		Constant.UPLOAD_FOLDER_ITEM = uploadFolder + "item/";
		Constant.UPLOAD_FOLDER_AUCTION = uploadFolder + "auction/";
	}

}
