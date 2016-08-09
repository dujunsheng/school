/**
 * 
 */
package com.school.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.school.util.PaginationContext;

/**
 * @author c116
 *
 */
public class PageFilter implements Filter{

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest httpRequest = (HttpServletRequest) req;

	        PaginationContext.setPageNum(getPageNum(httpRequest));
	        PaginationContext.setPageSize(getPageSize(httpRequest));

	        try {
	            chain.doFilter(req, resp);
	        }
	        // 使用完Threadlocal，将其删除。使用finally确保一定将其删除
	        finally {
	            PaginationContext.removePageNum();
	            PaginationContext.removePageSize();
	        }
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
     * 获得pager.offset参数的值
     * 
     * @param request
     * @return
     */
    protected int getPageNum(HttpServletRequest request) {
        int pageNum = 1;
        try {
            String pageNums = request.getParameter("pageNum");
            if (pageNums != null && StringUtils.isNumeric(pageNums)) {
                pageNum = Integer.parseInt(pageNums);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return pageNum;
    }

    /**
     * 设置默认每页大小
     * 
     * @return
     */
    protected int getPageSize(HttpServletRequest request) {
        int pageSize = 3;    // 默认每页10条记录
        try {
            String pageSizes = request.getParameter("pageSize");
            if (pageSizes != null && StringUtils.isNumeric(pageSizes)) {
                pageSize = Integer.parseInt(pageSizes);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return pageSize;
    }
}
