package controller;
import java.sql.SQLException;

import dao.DaoException;
import dao.DaoVeiculo;
import dao.DaoVeiculoconc;
import entity.Cliente;
import entity.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlVeiculo
{
	public void insereVeiculo(Veiculo v, Cliente cli) 
	{
		try 
		{
			DaoVeiculo persVeiculo = new DaoVeiculoconc();
			persVeiculo.adicionaVeiculo(v, cli);
		} catch (ClassNotFoundException | DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void desativarVeiculo(String v, Cliente cli) 
	{
	}
	public Veiculo pesquisaVeiculo(String placa) 
	{
		Veiculo veic = new Veiculo();
		try {
			DaoVeiculo pesquisa = new DaoVeiculoconc();
			veic = pesquisa.pesquisaVeiculoPlaca(placa);
		} catch (ClassNotFoundException | DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return veic;
	}
	public Veiculo pesquisaVeiculoAlt(String chassis) 
	{
		Veiculo veic = new Veiculo();
		try {
			DaoVeiculo pesquisa = new DaoVeiculoconc();
			veic = pesquisa.pesquisaVeiculoChassis(chassis);
		} 
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return veic;
	}
	public ObservableList<Veiculo> getVeiculos(Cliente cli) 
	{
		return null;
	}
}
