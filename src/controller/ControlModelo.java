package controller;

import java.sql.SQLException;

import dao.DaoException;
import dao.DaoModelo;
import dao.DaoModeloconc;
import entity.Marca;
import entity.Modelo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlModelo 
{
	private ObservableList<Modelo> modelos = FXCollections.observableArrayList();
	public void adicionaModelo(String modelo, Marca marca) throws DaoException 
	{
		try {
			DaoModelo persistencia = new DaoModeloconc();
			Modelo model = new Modelo();
			model.setNome_Modelo(modelo);
			persistencia.adicionaModelo(model, marca);
		} catch (ClassNotFoundException | DaoException | SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	public ObservableList<Modelo> getModelos(Marca marca)
	{
		try {
			DaoModelo persistencia = new DaoModeloconc();
			modelos = (ObservableList<Modelo>) persistencia.getModelos(marca);
		} catch (ClassNotFoundException | DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return modelos;
	}
}
