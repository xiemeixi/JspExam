package com.hand.dao.filmimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.bean.FilmBean;
import com.hand.dao.Film;

public class FilmImpl implements Film{
	public ResultSet select(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select f.film_id,f.title,f.description,l.name "
				+ "from film f,language l where f.language_id=l.language_id ");
	    return ps.executeQuery();
		}
	public void save(Connection conn, FilmBean fb) throws SQLException {
		PreparedStatement ps = conn.prepareCall("insert into film(title,description,language_id) values (?,?,?)");
		ps.setString(1, fb.getTitle());
		ps.setString(2,fb.getDescription());
		ps.setInt(3,fb.getLanguage_id());
		ps.execute();
		

	}
	
	public void delete(Connection conn, FilmBean fb) throws SQLException {
		PreparedStatement ps = conn.prepareCall("delete from film where film_id=?");
		ps.setInt(1, fb.getFilm_id());
		ps.execute();
		
	}
}
