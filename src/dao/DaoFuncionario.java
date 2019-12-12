package dao;

import java.util.List;

import entity.Funcionario;
import entity.Gerente;
import entity.Servico;

public interface DaoFuncionario 
{
	void adicionarFuncionario(Funcionario func, long ger) throws DaoException;
	void editarFuncionario(Funcionario func) throws DaoException;
	void removerFuncionario(long func) throws DaoException;
	void adicionarHabilidades(long func, long serv) throws DaoException;
	List<Funcionario> getFuncionarios() throws DaoException;
	List<Funcionario> getHabilitados(long serv) throws DaoException;
	Funcionario pesqFuncionario(String nome) throws DaoException;
	boolean existenciaFuncionario(Funcionario func) throws DaoException;
	List<Servico> getHabilidades(long func) throws DaoException;
}
