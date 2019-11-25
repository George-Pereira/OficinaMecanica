package dao;

import java.util.List;

import entity.Servico;

public interface DaoServico 
{
	void adicionarServico(Servico serv) throws DaoException;
	void editarServico(Servico serv) throws DaoException;
	void desativarServico(Servico serv) throws DaoException;
	Servico pesquisarServico(String serv) throws DaoException;
	List<Servico> getServicos() throws DaoException;
	boolean consultaExistencia(Servico serv);
}
