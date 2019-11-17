package dao;

import java.util.List;

import entity.Cliente;
import entity.Veiculo;

public interface DaoVeiculo 
{
	void adicionaVeiculo(Veiculo veic, Cliente cli) throws DaoException;
	void desativaVeiculo(Veiculo veic, Cliente cli);
	void editaVeiculo(Veiculo veic, Cliente cli);
	Veiculo pesquisaVeiculoPlaca(String placa);
	Veiculo pesquisaVeiculoChassis(String chassis);
	List<Veiculo> pesquisaVeiculocliente(Cliente cli);
}
