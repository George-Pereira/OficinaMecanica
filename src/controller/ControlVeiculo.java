package controller;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import dao.DaoException;
import dao.DaoVeiculo;
import dao.DaoVeiculoconc;
import entity.Cliente;
import entity.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlVeiculo
{
	private ObservableList<Veiculo> veiculos = FXCollections.observableArrayList();
	
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
		List<Veiculo> veic = new LinkedList();
		try {
			DaoVeiculo veicli = new DaoVeiculoconc();
			veic = veicli.pesquisaVeiculocliente(cli);
			for(Veiculo vei : veic) 
			{
				veiculos.add(vei);
				System.out.println(vei.getAnoFabrica());
			}
		}
		catch (ClassNotFoundException | DaoException | SQLException e) 
		{
			e.printStackTrace();
		}
		return veiculos;
	}
	public void editarVeiculo(Veiculo veic) 
	{
		try {
			DaoVeiculo dao = new DaoVeiculoconc();
			dao.editaVeiculo(veic);
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
