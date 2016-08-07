package com.hand.service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hand.bean.CustomerBean;
import com.hand.connection.ConnectionFactory;
import com.hand.dao.customerimpl.CustomerImpl;

public class CheckService {
	private CustomerImpl cs= new  CustomerImpl();

	public boolean check(CustomerBean csb) {

		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			ResultSet rs = cs.select(conn, csb);
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

