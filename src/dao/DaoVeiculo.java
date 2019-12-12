package dao;

import java.util.List;

import entity.Cliente;
import entity.Veiculo;

public interface DaoVeiculo 
{
	void adicionaVeiculo(Veiculo veic, Cliente cli) throws DaoException;
	void desativaVeiculo(Veiculo veic, Cliente cli) throws DaoException;
	void editaVeiculo(Veiculo veic) throws DaoException;
	Veiculo pesquisaVeiculoPlaca(String placa) throws DaoException;
	Veiculo pesquisaVeiculoChassis(String chassis) throws DaoException;
	List<Veiculo> pesquisaVeiculocliente(Cliente cli) throws DaoException;
}
