package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface interfaceGenerica 
{
	public Connection getConnection() throws DaoException, SQLException;
}
