package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Historico 
{
	private double gastos;
	private long id;
	private ObservableList<Ordem_Servico> manutencao = FXCollections.observableArrayList();
	public ObservableList<Ordem_Servico> getManutencao() 
	{
		return manutencao;
	}

	public void setManutencao(ObservableList<Ordem_Servico> manutencao) 
	{
		this.manutencao = manutencao;
	}
	
	public double getGastos() {
		return gastos;
	}
	
	public void setGastos(double gastos) {
		this.gastos = gastos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
