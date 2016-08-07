package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.bean.CustomerBean;
import com.hand.connection.ConnectionFactory;
import com.hand.dao.customerimpl.CustomerImpl;

public class Test {

	public static void main(String[] args) {
				Connection conn = null;

				try {
					conn = ConnectionFactory.getInstance().makeConnection();
					conn.setAutoCommit(false);
					
			        CustomerImpl cs = new CustomerImpl();
					CustomerBean csb = new CustomerBean();
					csb.setFirst_name("Mary");
					ResultSet rs=cs.select(conn, csb);
					CheckService ck = new CheckService();
					boolean b=ck.check(csb);
					System.out.println(b);
					
					while(rs.next())
					{
						System.out.print(rs.getString("first_name") + "  ");
						
					}

					conn.commit();
				} catch (SQLException e) {

					try {
						conn.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}

	}
