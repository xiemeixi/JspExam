package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.bean.CustomerBean;
import com.hand.service.CheckService;


public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckService ck = new CheckService();   
    public CustomerServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String returnUri=request.getParameter("return_uri");
		RequestDispatcher rd=null;
		CustomerBean csb = new CustomerBean();
		csb.setFirst_name(uname);
		boolean bool = ck.check(csb);
        if (bool) {
        	request.getSession().setAttribute("flag", "login_success");
        	if(returnUri!=null){
    			rd=request.getRequestDispatcher(returnUri);
    			rd.forward(request, response);
    		}else{
    			rd=request.getRequestDispatcher("05/index.jsp");
    			rd.forward(request, response);
		} 
        }else {
			request.getSession().setAttribute("flag", "login_error");
    		request.setAttribute("msg", "用户名输入错误");
    		rd=request.getRequestDispatcher("/01/login.jsp");
    		rd.forward(request, response);
		}
	}
	}

