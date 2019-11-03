package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Boundary_Principal extends Application implements EventHandler<ActionEvent>
{
	private MenuBar menuprinc = new MenuBar();
	private Menu itens = new Menu("Cadastros/Pesquisas");
	private MenuItem mniMantVeiculos = new MenuItem("Manter Veiculos");
	private MenuItem mniMantServicos = new MenuItem("Manter Serviços");
	private Map<MenuItem, Boundary_Constructor> interfaces = new HashMap<>();
	private BorderPane princ = new BorderPane();
	public MenuBar menuConstruction() 
	{
		menuprinc.getMenus().add(itens);
		itens.getItems().addAll(mniMantVeiculos, mniMantServicos);
		interfaces.put(mniMantVeiculos, new Boundary_Veiculo());
		interfaces.put(mniMantServicos, new Boundary_Servico());
		Set<MenuItem> opcoes = interfaces.keySet();
		for(MenuItem mn : opcoes) 
		{
			mn.addEventHandler(ActionEvent.ANY, this);
		}
		return menuprinc;
	}
	@Override
	public void start(Stage stage) throws Exception 
	{
		princ.setTop(menuConstruction());
		Scene cena = new Scene(princ, 800, 600);
		princ.setStyle("-fx-padding: 10px");
		princ.setTop(menuprinc);
		stage.setScene(cena);
		stage.setTitle("Gerenciador de Oficinas");
		stage.show();
	}
	@Override
	public void handle(ActionEvent event) 
	{
		Boundary_Constructor fronteira = interfaces.get(event.getTarget());
		if(interfaces != null) 
		{
			princ.setCenter(fronteira.constructBoundary());
		}
	}
	public static void main(String[] args) 
	{
		launch(args);
	}
	
}
