package controller;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
	public void adicionaModelo(String modelo, long marca) throws DaoException 
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
	public ObservableList<Modelo> getModelos(long marca)
	{
		List<Modelo> models = new LinkedList<Modelo>();
		try {
			DaoModelo persistencia = new DaoModeloconc();
			models = persistencia.getModelos(marca);
			for(Modelo mod : models) 
			{
				modelos.add(mod);
			}
		} catch (ClassNotFoundException | DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return modelos;
	}
	public Modelo pesquisaModelo(String model) 
	{
		Modelo mod = new Modelo();
		try {
			DaoModelo persistencia = new DaoModeloconc();
			mod = persistencia.pesqModelo(model);
		} 
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return mod;
	}
}
