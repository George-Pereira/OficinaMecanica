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
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Boundary_Principal extends Application implements EventHandler<ActionEvent>, gerenciadorTelas
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
	private MenuItem mniMantHist = new MenuItem("Manter Historico");
	private MenuItem mniMantModel = new MenuItem("Manter Modelo");
	private Map<String, Boundary_Constructor> interfaces = new HashMap<>();
	private BorderPane princ = new BorderPane();
	public MenuBar menuConstruction() 
	{
		mniMantVeiculos.setUserData("Veiculos");
		mniMantClient.setUserData("Clientes");
		mniMantFuncionario.setUserData("Funcionario");
		mniMantOS.setUserData("OS");
		mniMantServicos.setUserData("Servicos");
		mniVisualBalanco.setUserData("Balancos");
		mniMantHist.setUserData("Historico");
		mniMantModel.setUserData("Modelos");
		menuprinc.getMenus().addAll(itensCad, itensGerenc);
		itensGerenc.getItems().addAll(mniVisualBalanco, mniMantHist);
		itensCad.getItems().addAll(mniMantVeiculos, mniMantServicos, mniMantFuncionario, mniMantOS, mniMantClient, mniMantModel);
		interfaces.put("Veiculos", new Boundary_Veiculo(this));
		interfaces.put("Servicos", new Boundary_Servico());
		interfaces.put("Funcionario", new Boundary_Funcionario());
		interfaces.put("Balancos", new Boundary_Balancos(this));
		interfaces.put("OS", new Boundary_ManterOrdemServico(this));
		interfaces.put("Clientes", new Boundary_Cliente(this));
		interfaces.put("Historico", new Boundary_ManterHistorico());
		interfaces.put("Modelos", new Boundary_Modelo(this));
		mniMantClient.addEventHandler(ActionEvent.ANY, this);
		mniMantServicos.addEventHandler(ActionEvent.ANY, this);
		mniMantVeiculos.addEventHandler(ActionEvent.ANY, this);
		mniMantOS.addEventHandler(ActionEvent.ANY, this);
		mniMantFuncionario.addEventHandler(ActionEvent.ANY, this);
		mniVisualBalanco.addEventHandler(ActionEvent.ANY, this);
		mniMantHist.addEventHandler(ActionEvent.ANY, this);
		mniMantModel.addEventHandler(ActionEvent.ANY, this);
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
		BackgroundImage myBI= new BackgroundImage(new Image("https://i.redd.it/pova3bmbezvz.jpg",cena.getWidth(),cena.getHeight(),false,true),
		BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		BackgroundSize.DEFAULT);
		princ.setBackground(new Background(myBI));
	}
	@Override
	public void handle(ActionEvent event) 
	{
		if (event.getTarget() instanceof MenuItem) 
		{
			MenuItem mni = (MenuItem)event.getTarget();
			request(mni.getUserData().toString());
		}
	}
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	@Override
	public void request(String requisition) 
	{
		Boundary_Constructor fronteira = interfaces.get(requisition);
		if(interfaces != null) 
		{
			princ.setCenter(fronteira.constructBoundary());
		}
	}
}
