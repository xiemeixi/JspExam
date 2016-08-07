package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.bean.FilmBean;

public interface Film {
	public ResultSet select(Connection conn) throws SQLException;
	public void save(Connection conn, FilmBean fb) throws SQLException;
	public void delete(Connection conn, FilmBean fb) throws SQLException;
}
