package com.hand.dao.customerimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.bean.CustomerBean;
import com.hand.dao.Customer;


public class CustomerImpl implements Customer {
	public ResultSet select(Connection conn, CustomerBean csb) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE first_name = ? ");
		ps.setString(1, csb.getFirst_name());
		return ps.executeQuery();
    
	}
}
