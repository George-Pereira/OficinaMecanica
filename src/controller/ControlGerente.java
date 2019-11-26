package controller;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DaoException;
import dao.DaoGerente;
import dao.DaoGerenteconc;
import entity.Gerente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlGerente 
{
	private ObservableList<Gerente> gerentes = FXCollections.observableArrayList();
	
	public void adicionaGerente(Gerente ger) 
	{
		try {
			DaoGerente dao = new DaoGerenteconc();
			dao.adicionarGerente(ger);
		}
		catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void editaGerente(Gerente ger) 
	{
		try {
			DaoGerente dao = new DaoGerenteconc();
			dao.editarGerente(ger);
		}
		catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public ObservableList<Gerente> getGerentes()
	{
		try {
			List<Gerente> gerent = new LinkedList<Gerente>();
			DaoGerente dao = new DaoGerenteconc();
			gerent = dao.getGerente();
			for(Gerente ger : gerent) 
			{
				gerentes.add(ger);
			}
		}
		catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return gerentes;
	}
}
