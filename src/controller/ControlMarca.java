package controller;

import java.sql.SQLException;

import dao.DaoException;
import dao.DaoMarca;
import dao.DaoMarcaconc;
import entity.Marca;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlMarca 
{
	private ObservableList<Marca> fabricantes = FXCollections.observableArrayList();
	public void adicionarMarca(String marca) 
	{
		try {
			DaoMarca persistencia = new DaoMarcaconc();
			persistencia.adicionarMarca(marca);
		} catch (DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public ObservableList<Marca> getMarcas()
	{
			try {
				DaoMarca persistencia  = new DaoMarcaconc();
				fabricantes = (ObservableList<Marca>) persistencia.getMarca();
			} catch (DaoException | SQLException e) {
				e.printStackTrace();
			}
		return fabricantes;
	}
}
