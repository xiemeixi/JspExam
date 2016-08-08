package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.bean.FilmBean;
import com.hand.connection.ConnectionFactory;
import com.hand.dao.filmimpl.FilmImpl;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int film_id = Integer.parseInt(request.getParameter("id"));
		
		Connection conn=null;
		try{
		conn = ConnectionFactory.getInstance().makeConnection();
		FilmBean fb=new FilmBean();
		fb.setFilm_id(film_id);
		FilmImpl fl=new FilmImpl();
	
		fl.delete(conn, fb);
		
		response.sendRedirect(request.getContextPath() + "/04/deletesuccess.jsp");
		}catch (SQLException e) {
			response.sendRedirect(request.getContextPath() + "/04/deletefail.jsp");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		

	}
	}
}
