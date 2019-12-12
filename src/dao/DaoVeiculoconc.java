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
			String command = "INSERT INTO veiculo " + "(id_Cor, id_Modelo, id_Cliente, descri, ano, motor, placa, chassis) " + "VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement state = conexao.prepareStatement(command);
			state.setLong(1, veic.getCor().getId());
			state.setString(2, veic.getModel());
			state.setLong(3, cli.getId());
			state.setString(4, veic.getDesc());
			state.setInt(5, veic.getAnoFabrica());
			state.setDouble(6, veic.getMotor());
			state.setString(7, veic.getPlaca());
			state.setString(8, veic.getChassis());
			state.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void desativaVeiculo(Veiculo veic, Cliente cli) 
	{
		try {
			String sql = "DELETE FROM veiculo WHERE id_Veiculo = ? ";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setLong(1, veic.getId());
			state.execute();
			state.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void editaVeiculo(Veiculo veic) 
	{
		try {
			String sql = "UPDATE veiculo SET placa = ?, id_Cor = ?, descri = ?, motor = ? WHERE chassis = ?";
			PreparedStatement state = conexao.prepareStatement(sql);
			state.setString(1, veic.getPlaca());
			state.setLong(2, veic.getCor().getId());
			state.setString(3, veic.getDesc());
			state.setDouble(4, veic.getMotor());
			state.setString(4, veic.getChassis());
			state.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public Veiculo pesquisaVeiculoPlaca(String placa) 
	{
		Veiculo veic = new Veiculo();
		try 
		{
			String command = "SELECT id_Veiculo, id_Modelo, id_Cor, id_Cliente, descri, ano, motor, placa, chassis FROM Veiculo WHERE placa = ?";
			PreparedStatement state = conexao.prepareStatement(command);
			state.setString(1, placa);
			ResultSet resultado = state.executeQuery();
			resultado.next();
			veic.setId(resultado.getLong("id_Veiculo"));
			String marca = "SELECT nome_Marca, mar.id_Marca, md.nome_Modelo FROM marca mar INNER JOIN Modelo md ON mar.id_Marca = md.id_Marca INNER JOIN Veiculo vei ON vei.id_Modelo = md.id_Modelo WHERE md.id_Modelo = ?";
			PreparedStatement stateMarc = conexao.prepareStatement(marca);
			stateMarc.setLong(1, resultado.getLong("id_Modelo"));
			ResultSet marcaSet = stateMarc.executeQuery();
			marcaSet.next();
			veic.setMarca(marcaSet.getString("nome_Marca"));
			veic.setChassis(resultado.getString("chassis"));
			veic.setPlaca(resultado.getString("placa"));
			veic.setMotor(resultado.getDouble("motor"));
			veic.setAnoFabrica(resultado.getInt("ano"));
			veic.setDesc(resultado.getString("descri"));
			String modSql = "SELECT nome_Modelo FROM Modelo INNER JOIN Veiculo ON Veiculo.id_modelo = Modelo.id_Modelo WHERE Veiculo.placa = ?";
			PreparedStatement stateModel = conexao.prepareStatement(modSql);
			stateModel.setString(1, placa);
			ResultSet model = stateModel.executeQuery();
			model.next();
			veic.setModel(model.getString("nome_Modelo"));
			String cor = "Select * FROM cor WHERE id_Cor = ?";
			PreparedStatement corState = conexao.prepareStatement(cor);
			corState.setLong(1, resultado.getLong("id_Cor"));
			ResultSet cores = corState.executeQuery();
			cores.next();
			Cor corCar = new Cor();
			corCar.setCor(cores.getString("nome_Cor"));
			corCar.setId(cores.getLong("id_Cor"));
			veic.setCor(corCar);
			state.close();
			stateMarc.close();
			corState.close();
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
			String marca = "SELECT id_Marca FROM marca Where id_Marca = ?";
			PreparedStatement stateMarc = conexao.prepareStatement(marca);
			stateMarc.setLong(1, resultado.getLong("id_Marca"));
			ResultSet marcaSet = stateMarc.executeQuery();
			veic.setMarca(marcaSet.getString("nome_Marca"));
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
			state.close();
			stateMarc.close();
			corState.close();
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
			state.setLong(1, cli.getId());
			ResultSet result = state.executeQuery();
			while(result.next()) 
			{
				Veiculo veic = new Veiculo();
				veic.setId(result.getLong("id_Veiculo"));
				String marca = "SELECT nome_Marca, marca.id_Marca FROM marca INNER JOIN Modelo ON marca.id_Marca = Modelo.id_Marca WHERE id_Modelo = ?";
				PreparedStatement stateMarc = conexao.prepareStatement(marca);
				stateMarc.setLong(1, result.getLong("id_Modelo"));
				ResultSet marcaSet = stateMarc.executeQuery();
				marcaSet.next();
				veic.setMarca(marcaSet.getString("nome_Marca"));
				String model = "SELECT nome_Modelo, id_Modelo FROM modelo WHERE id_Modelo = ?";
				PreparedStatement stateModel = conexao.prepareStatement(model);
				stateModel.setLong(1, result.getLong("id_Modelo"));
				ResultSet modelo = stateModel.executeQuery();
				modelo.next(); 
				veic.setModel(modelo.getString("nome_Modelo"));
				veic.setAnoFabrica(result.getInt("ano"));
				veic.setChassis(result.getString("chassis"));
				veic.setPlaca(result.getString("placa"));
				veic.setMotor(result.getDouble("motor"));
				String cor = "Select * FROM cor WHERE id_Cor = ?";
				PreparedStatement corState = conexao.prepareStatement(cor);
				corState.setLong(1,result.getLong("id_Cor"));
				ResultSet cores = corState.executeQuery();
				Cor corCar = new Cor();
				if(cores.next()) 
				{
					corCar.setCor(cores.getString("nome_Cor"));
					corCar.setId(cores.getLong("id_Cor"));
				}
				veic.setCor(corCar);
				corState.close();
				stateMarc.close();
				listaVeic.add(veic);
			}
			result.close();
			state.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return listaVeic;
	}
}
