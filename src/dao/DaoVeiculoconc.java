package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Cliente;
import entity.Cor;
import entity.Marca;
import entity.Modelo;
import entity.Veiculo;

public class DaoVeiculoconc implements DaoVeiculo
{
	private Connection conexao;
	
	public DaoVeiculoconc() throws DaoException, ClassNotFoundException, SQLException
	{
		DaoGenerica i = new DaoGenericoconc();
		conexao = i.getConnection();
	}			
	
	@Override
	public void adicionaVeiculo(Veiculo veic, Cliente cli) throws DaoException 
	{
		try 
		{
			String command = "INSERT INTO veiculo " + "(id_Marca, id_Cor, id_Modelo, id_Cliente, descri, ano, motor, placa, chassis) " + "VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement state = conexao.prepareStatement(command);
			state.setLong(1, veic.getMarca().getId());
			state.setLong(2, veic.getCor().getId());
			state.setLong(3, veic.getModel().getId());
			state.setLong(4, cli.getId());
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
		Veiculo veic = new Veiculo();
		try 
		{
			String command = "SELECT * FROM Veiculo WHERE placa = ?";
			PreparedStatement state = conexao.prepareStatement(command);
			state.setString(1, placa);
			ResultSet resultado = state.executeQuery();
			veic.setId(resultado.getLong("id_Veiculo"));
			String marca = "SELECT * FROM marca Where id_Marca = ?";
			PreparedStatement stateMarc = conexao.prepareStatement(marca);
			stateMarc.setLong(1, resultado.getLong("id_Marca"));
			ResultSet marcaSet = stateMarc.executeQuery();
			Marca marc = new Marca();
			marc.setId(marcaSet.getLong("id_Marca"));
			marc.setNome_Marca(marcaSet.getString("nome_Marca"));
			veic.setMarca(marc);
			veic.setChassis(resultado.getString("chassis"));
			veic.setPlaca(resultado.getString("placa"));
			veic.setMotor(resultado.getDouble("motor"));
			String cor = "Select * FROM cor WHERE id_Cor = ?";
			PreparedStatement corState = conexao.prepareStatement(cor);
			ResultSet cores = corState.executeQuery();
			Cor corCar = new Cor();
			corCar.setCor(cores.getString("nome_Cor"));
			corCar.setId(cores.getLong("id_Cor"));
			veic.setCor(corCar);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return veic;
	}

	@Override
	public Veiculo pesquisaVeiculoChassis(String chassis) throws DaoException
	{
		Veiculo veic = new Veiculo();
		try 
		{
			String command = "SELECT * FROM Veiculo WHERE chassis = ?";
			PreparedStatement state = conexao.prepareStatement(command);
			state.setString(1, chassis);
			ResultSet resultado = state.executeQuery();
			veic.setId(resultado.getLong("id_Veiculo"));
			String marca = "SELECT * FROM marca Where id_Marca = ?";
			PreparedStatement stateMarc = conexao.prepareStatement(marca);
			stateMarc.setLong(1, resultado.getLong("id_Marca"));
			ResultSet marcaSet = stateMarc.executeQuery();
			Marca marc = new Marca();
			marc.setId(marcaSet.getLong("id_Marca"));
			marc.setNome_Marca(marcaSet.getString("nome_Marca"));
			veic.setMarca(marc);
			veic.setChassis(resultado.getString("chassis"));
			veic.setPlaca(resultado.getString("placa"));
			veic.setMotor(resultado.getDouble("motor"));
			String cor = "Select * FROM cor WHERE id_Cor = ?";
			PreparedStatement corState = conexao.prepareStatement(cor);
			ResultSet cores = corState.executeQuery();
			Cor corCar = new Cor();
			corCar.setCor(cores.getString("nome_Cor"));
			corCar.setId(cores.getLong("id_Cor"));
			veic.setCor(corCar);
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
		return veic;
	}

	@Override
	public List<Veiculo> pesquisaVeiculocliente(Cliente cli)
	{
		List <Veiculo> listaVeic = new LinkedList<Veiculo>();
		try {
			String pesquisa = "SELECT * FROM veiculo vei INNER JOIN Cliente cli ON vei.id_Cliente = cli.id_Cliente WHERE vei.id_Cliente = ?";
			PreparedStatement state = conexao.prepareStatement(pesquisa);
			ResultSet result = state.executeQuery();
			while(result.next()) 
			{
				Veiculo veic = new Veiculo();
				veic.setId(result.getLong("id_Veiculo"));
				String marca = "SELECT * FROM marca Where id_Marca = ?";
				PreparedStatement stateMarc = conexao.prepareStatement(marca);
				stateMarc.setLong(1, result.getLong("id_Marca"));
				ResultSet marcaSet = stateMarc.executeQuery();
				Marca marc = new Marca();
				marc.setId(marcaSet.getLong("id_Marca"));
				marc.setNome_Marca(marcaSet.getString("nome_Marca"));
				veic.setMarca(marc);
				veic.setChassis(result.getString("chassis"));
				veic.setPlaca(result.getString("placa"));
				veic.setMotor(result.getDouble("motor"));
				String cor = "Select * FROM cor WHERE id_Cor = ?";
				PreparedStatement corState = conexao.prepareStatement(cor);
				ResultSet cores = corState.executeQuery();
				Cor corCar = new Cor();
				corCar.setCor(cores.getString("nome_Cor"));
				corCar.setId(cores.getLong("id_Cor"));
				veic.setCor(corCar);
				listaVeic.add(veic);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return listaVeic;
	}
}
