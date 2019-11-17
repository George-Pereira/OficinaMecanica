package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoGenerico implements interfaceGenerica
{
	private Connection connect;
	@Override
	public Connection getConnection() throws DaoException, SQLException
	{
		try 
		{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName:Oficina_Mecanica;namedPipes=true");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return connect;
	}
}
