package controller;

import entity.Ordem_Servico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlManterOrdemServico {
	private static ObservableList<Ordem_Servico> listaOS = FXCollections.observableArrayList();
	
	public void SalvarInformacoes(Ordem_Servico OS) {
			listaOS.add(OS);
	}

	public static ObservableList<Ordem_Servico> getListaOS() {
		return listaOS;
	}

	public static void setListaOS(ObservableList<Ordem_Servico> listaOS) {
		ControlManterOrdemServico.listaOS = listaOS;
	}
	
}
