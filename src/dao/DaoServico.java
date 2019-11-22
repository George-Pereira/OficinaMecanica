package dao;

import java.util.List;

import entity.Servico;

public interface DaoServico 
{
	void adicionarServico(Servico serv) throws DaoException;
	void editarServico(Servico serv) throws DaoException;
	void desativarServico(Servico serv) throws DaoException;
	Servico pesquisarServico(Servico serv) throws DaoException;
	List<Servico> getServicos(Servico serv) throws DaoException;
}
