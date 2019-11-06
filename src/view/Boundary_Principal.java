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
	private Menu itensCad = new Menu("Cadastros/Pesquisas");
	private Menu itensGerenc = new Menu("Relatórios Gerenciais");
	private MenuItem mniVisualBalanco = new MenuItem("Visualizar Balanços");
	private MenuItem mniMantVeiculos = new MenuItem("Manter Veiculos");
	private MenuItem mniMantServicos = new MenuItem("Manter Serviços");
	private MenuItem mniMantFuncionario = new MenuItem("Manter Funcionários");
	private MenuItem mniMantOS = new MenuItem("Manter OS");
	private MenuItem mniMantClient = new MenuItem("Manter Cliente");
	private Map<MenuItem, Boundary_Constructor> interfaces = new HashMap<>();
	private BorderPane princ = new BorderPane();
	public MenuBar menuConstruction() 
	{
		menuprinc.getMenus().addAll(itensCad, itensGerenc);
		itensGerenc.getItems().add(mniVisualBalanco);
		itensCad.getItems().addAll(mniMantVeiculos, mniMantServicos, mniMantFuncionario, mniMantOS, mniMantClient);
		interfaces.put(mniMantVeiculos, new Boundary_Veiculo());
		interfaces.put(mniMantServicos, new Boundary_Servico());
		interfaces.put(mniMantFuncionario, new Boundary_Funcionario());
		interfaces.put(mniVisualBalanco, new Boundary_Balancos());
		interfaces.put(mniMantOS, new Boundary_ManterOrdemServico());
		interfaces.put(mniMantClient, new Boundary_Cliente());
		Set<MenuItem> opcoes = interfaces.keySet();
		for(MenuItem mnI : opcoes) 
		{
			mnI.addEventHandler(ActionEvent.ANY, this);
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
		launch(Boundary_Principal.class);
	}
	
}
