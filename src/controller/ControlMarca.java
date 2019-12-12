package controller;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
			List<Marca> lista = new LinkedList<Marca>();
			try {
				DaoMarca persistencia  = new DaoMarcaconc();
				lista =  persistencia.getMarca();
				for(Marca mar : lista) 
				{
					fabricantes.add(mar);
				}
			} catch (DaoException | SQLException e) {
				e.printStackTrace();
			}
		return fabricantes;
	}
	public Marca procMarca(String nome) 
	{
		Marca marc = new Marca();
		try {
			DaoMarca dao = new DaoMarcaconc();
			marc = dao.procMarca(nome);
		}
		catch (DaoException | SQLException e)
		{
			e.printStackTrace();
		}
		return marc;
	}
}
