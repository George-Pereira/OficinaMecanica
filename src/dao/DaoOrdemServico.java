package dao;

import java.util.List;

import entity.Funcionario;
import entity.Ordem_Servico;
import entity.Servico;
import entity.Veiculo;

public interface DaoOrdemServico 
{
	public List<Ordem_Servico> getServicos(Ordem_Servico os) throws DaoException;
	public void novaOrdemServico(Ordem_Servico os, Veiculo v, Funcionario func) throws DaoException;
	List<Servico> getServicosOS(Ordem_Servico os) throws DaoException;
}
