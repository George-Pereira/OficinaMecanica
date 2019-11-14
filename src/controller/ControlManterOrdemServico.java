package controller;

import java.util.Date;

import entity.Funcionario;
import entity.Ordem_Servico;
import entity.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlManterOrdemServico {
	private static ObservableList<Ordem_Servico> listaOS = FXCollections.observableArrayList();
	private static ObservableList<Ordem_Servico> listO = FXCollections.observableArrayList();
	private static ObservableList<Ordem_Servico> temp = FXCollections.observableArrayList();
	
	public ObservableList<Ordem_Servico> getListaOS() 
	{
		return listaOS;
	}

	public static void setListaOS(ObservableList<Ordem_Servico> listaOS) {
		ControlManterOrdemServico.listaOS = listaOS;
	}

	public void SalvarInformacoes(int i, String s, Date d1, String nomeFunc) {
		Ordem_Servico os = new Ordem_Servico(i, s, d1, nomeFunc, null, null);
		listaOS.add(os);
	}
	
	public void ReSalvar(Veiculo veic, Date inicio) {
		for(Ordem_Servico o : listaOS) 
		{
			if(o.getNomeV() == null && o.getDtEntrada() == null) 
			{
				Ordem_Servico os = new Ordem_Servico(o.getOS(), o.getNomeS(), o.getDtSaida(), o.getNome(), inicio, veic);
				veic.getHist().getManutencao().add(os);
			}
		}
	}
	public ObservableList<Ordem_Servico> getListO() {
		return listO;
	}
	
	public ObservableList<Ordem_Servico> BuscarServico(int servico) {
		for(Ordem_Servico o : listO) 
		{
			if(o.getOS() == servico) 
			{	
				temp.add(o);
				return temp;
			}
		}
		return null;
	}
	public ObservableList<Ordem_Servico> MostraServico(String NomeVeiculo) {
		for(Ordem_Servico o : listO) {
			if(o.getNomeV().equals(NomeVeiculo)) {
				return listO;
			}
		}
		return null;
	}
	
	public ObservableList<Ordem_Servico> getTemp() {
		return temp;
	}
	
}