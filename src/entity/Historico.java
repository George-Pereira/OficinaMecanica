package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Historico 
{
	private double gastos;
	private ObservableList<Ordem_Servico> manutencao = FXCollections.observableArrayList();
	public ObservableList<Ordem_Servico> getManutencao() 
	{
		return manutencao;
	}

	public void setManutencao(ObservableList<Ordem_Servico> manutencao) 
	{
		this.manutencao = manutencao;
	}
}
