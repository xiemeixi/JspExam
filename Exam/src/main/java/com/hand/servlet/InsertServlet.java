package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.bean.FilmBean;
import com.hand.connection.ConnectionFactory;
import com.hand.dao.filmimpl.FilmImpl;

public class InsertServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	public InsertServlet() {
        super();
    }
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String title = request.getParameter("tl");
			
			String description = request.getParameter("ds");
		
			int language_id=Integer.parseInt(request.getParameter("language"));
			
		
			RequestDispatcher rd = null;
			String forward = null;
			Connection conn=null;
			
			try{
			conn = ConnectionFactory.getInstance().makeConnection();
			FilmBean fb=new FilmBean();

			fb.setTitle(title);
			fb.setDescription(description);
			fb.setLanguage_id(language_id);
			
			FilmImpl fl=new FilmImpl();
			
	        fl.save(conn, fb);
			
			forward = "/03/insertsuccess.jsp";
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
			}catch (SQLException e) {

				forward = "/03/insertfail.jsp";
				rd = request.getRequestDispatcher(forward);
				rd.forward(request, response);
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
			

		}
	}
}




