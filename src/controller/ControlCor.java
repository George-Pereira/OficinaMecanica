package controller;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DaoCor;
import dao.DaoCorconc;
import dao.DaoException;
import entity.Cor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlCor 
{
	private ObservableList<Cor> cores = FXCollections.observableArrayList();
	public ObservableList<Cor> getCores() 
	{
		List<Cor> color = new LinkedList<Cor>();
		try {
			DaoCor dao = new DaoCorconc();
			color = dao.getCores();
			for(Cor colors : color) 
			{
				cores.add(colors);
			}
		} 
		catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return cores;
	}
}
