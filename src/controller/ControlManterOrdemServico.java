package controller;

import java.util.Date;

import entity.Funcionario;
import entity.Ordem_Servico;
import entity.Servico;
import entity.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlManterOrdemServico {
	private static ObservableList<Ordem_Servico> listaOS = FXCollections.observableArrayList();
	private static ObservableList<Ordem_Servico> listO = FXCollections.observableArrayList();
	
	public ObservableList<Ordem_Servico> getListaOS() {
		return listaOS;
	}

	public static void setListaOS(ObservableList<Ordem_Servico> listaOS) {
		ControlManterOrdemServico.listaOS = listaOS;
	}

	public void SalvarInformacoes(int i, String s, Date d1, Funcionario value) {
		Ordem_Servico os = new Ordem_Servico(i, s, d1, value, null, null);
		listaOS.add(os);
	}
	
	public void ReSalvar(Veiculo nome, Date inicio) {
		for(Ordem_Servico o : listaOS) 
		{
			if(o.getNomeV() == null && o.getDtEntrada() == null) 
			{
				Ordem_Servico os = new Ordem_Servico(o.getOS(), o.getNomeS(), o.getDtSaida(), o.getNome(), inicio, nome);
				listO.add(os);
			}
		}
	}
	public static ObservableList<Ordem_Servico> getListO() {
		return listO;
	}
	
}
