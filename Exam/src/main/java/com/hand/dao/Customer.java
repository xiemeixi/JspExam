package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.bean.CustomerBean;

public interface Customer {
	public interface AddressDao {
		public ResultSet select(Connection conn, CustomerBean csb) throws SQLException;
		}
}
