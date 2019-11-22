package controller;

import java.sql.SQLException;
import java.util.List;

import dao.DaoEndereco;
import dao.DaoEnderecoconc;
import dao.DaoException;
import entity.Cliente;
import entity.Endereco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlEndereco 
{
	private ObservableList<Endereco> listaEnd = FXCollections.observableArrayList();
	
	public void adicionarEndereco(Endereco end, Cliente cli) throws DaoException, SQLException 
	{
		DaoEndereco persist = new DaoEnderecoconc();
		persist.adicionarEndereco(cli, end);
		listaEnd.add(end);
	}
	public ObservableList<Endereco> getEnderecos(Cliente cli) throws DaoException, SQLException
	{
		DaoEndereco persist = new DaoEnderecoconc();
		List<Endereco> lista = persist.enderecosCliente(cli);
		for(Endereco end : lista) 
		{
			listaEnd.add(end);
		}
		return listaEnd;
	}
}
