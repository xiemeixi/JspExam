package com.hand.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionFilter implements Filter {

   
    public PermissionFilter() {
      
    }

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	
	public void doFilter(ServletRequest servletRequest, ServletResponse  servletResponse, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String servletPath = request.getServletPath();
		
		HttpSession session = request.getSession();
		String flag = (String) session.getAttribute("flag");

		if (servletPath != null
				&& (servletPath.equals("/01/login.jsp") || servletPath.equals("/CustomServlet") || servletPath
						.equals("/05/index.jsp"))) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			
			if (flag != null && flag.equals("login_success")) {
				chain.doFilter(servletRequest, servletResponse);
			} else if (flag != null && flag.equals("login_error")) {
				request.setAttribute("msg", "登陆失败，请重新登录!<br/>");
				request.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = request.getRequestDispatcher("/01/login.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msg", "您尚未登陆！<br/>");
				request.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = request.getRequestDispatcher("/01/login.jsp");
				rd.forward(request, response);
			}
		}
	}
	

	public void destroy() {
	
	}

	

}
