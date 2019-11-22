package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoGenericoconc implements DaoGenerica
{
	private Connection connect;
	private static final String USER = "gerente";
	private static final String PASSWORD = "123456";
	@Override
	public Connection getConnection() throws DaoException, SQLException
	{
		try 
		{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost;DatabaseName:Oficina_Mecanica;namedPipes=true", USER, PASSWORD);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return connect;
	}
}
