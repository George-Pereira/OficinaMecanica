package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entity.Cliente;
import entity.Veiculo;

public class DaoVeiculoconc implements DaoVeiculo
{
	private Connection conexao;
	
	public DaoVeiculoconc() throws DaoException, ClassNotFoundException, SQLException
	{
		interfaceGenerica i = new DaoGenerico();
		conexao = i.getConnection();
	}			
	
	@Override
	public void adicionaVeiculo(Veiculo veic, Cliente cli) throws DaoException 
	{
		try 
		{
			String command = "INSERT INTO veiculo " + "(id_Marca, id_Cor, id_Modelo, id_Cliente, descri, ano, motor, placa, chassis) " + "VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement state = conexao.prepareStatement(command);
			state.setString(5, veic.getDesc());
			state.setInt(6, veic.getAnoFabrica());
			state.setDouble(7, veic.getMotor());
			state.setString(8, veic.getPlaca());
			state.setString(9, veic.getChassis());
		} catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void desativaVeiculo(Veiculo veic, Cliente cli) 
	{
		
	}

	@Override
	public void editaVeiculo(Veiculo veic, Cliente cli) 
	{
		
	}

	@Override
	public Veiculo pesquisaVeiculoPlaca(String placa) 
	{
		return null;
	}

	@Override
	public Veiculo pesquisaVeiculoChassis(String chassis) 
	{
		return null;
	}

	@Override
	public List<Veiculo> pesquisaVeiculocliente(Cliente cli) 
	{
		return null;
	}
}
