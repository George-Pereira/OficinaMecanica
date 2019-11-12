package view;

import java.util.Date;

import entity.Funcionario;
import entity.Servico;
import entity.Veiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Boundary_ManterHistorico implements Boundary_Constructor, EventHandler<ActionEvent> {
	
	private BorderPane principal = new BorderPane();
	private Button btnpesquisarC = new Button("Buscar Cliente");
	private ComboBox<Veiculo> comboV = new ComboBox<Veiculo>();
	private TableView<Servico> tabS = new TableView<Servico>();
	private Button btnpesquisarS = new Button("Buscar OS");
	private TextField txtCliente = new TextField();
	private TextField txtServico = new TextField();
	private TextArea txtObserv = new TextArea();
	private Button btnSalvar = new Button("Salvar");
	private Button btnEditar = new Button("Editar");
	
	public Boundary_ManterHistorico() {
		principal.setStyle("-fx-padding: 10px");
		GridPane pCampos = new GridPane();
		GridPane painel1 = new GridPane();
		GridPane painel2 = new GridPane();
		GridPane pbutton = new GridPane();
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(30);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		pCampos.getColumnConstraints().addAll(col0, col1);
		tabS.setEditable(true);
		principal.setCenter(pCampos);
		principal.setBottom(pbutton);
		
		painel1.add(new Label("Cliente"), 0, 0);
		painel1.add(txtCliente, 1, 0, 2, 1);
		painel1.add(btnpesquisarC, 3, 0);
		painel1.add(new Label("Veículo"), 0, 1);
		painel1.add(comboV, 1, 1, 2, 1);
		pCampos.add(painel1, 0, 0, 4, 2);
		pCampos.add(tabS, 1, 3, 4, 5);
		painel2.add(new Label("OS"), 0, 1);
		painel2.add(txtServico, 1, 1);
		painel2.add(btnpesquisarS, 3, 1);
		painel2.add(new Label("Observações"), 1, 2);
		pCampos.add(painel2, 1, 9, 3, 2);
		pCampos.add(txtObserv, 1, 11, 2, 1);
		pbutton.add(btnSalvar, 0, 0);
		pbutton.add(btnEditar, 1, 0);
		adicionarTableColumns();
		pCampos.setVgap(10);
		pCampos.setHgap(10);
		painel1.setVgap(10);
		painel1.setHgap(10);
		painel2.setVgap(10);
		painel2.setHgap(10);
		pbutton.setVgap(10);
		pbutton.setHgap(660);
	}
	
	
	private void adicionarTableColumns() {
		
		TableColumn<Servico, String> OS = new TableColumn<Servico, String>("OS");
	    OS.setCellValueFactory(new PropertyValueFactory<Servico, String>("OS"));
	    OS.setMinWidth(50);
	    
	    TableColumn<Servico, Date> dt = new TableColumn<Servico, Date>("Data");
	    dt.setCellValueFactory(new PropertyValueFactory<Servico, Date>("DtSaida"));
	    dt.setMinWidth(50);
	    
	    TableColumn<Servico, String> serv = new TableColumn<Servico, String>("Serviço");
	    serv.setCellValueFactory(new PropertyValueFactory<Servico, String>("nomeServ"));
	    serv.setMinWidth(50);
	    
	    TableColumn<Servico, String> func = new TableColumn<Servico, String>("Funcionario");
	    func.setCellValueFactory(new PropertyValueFactory<Servico, String>("nomeServ"));
	    func.setMinWidth(50);
	    
	    tabS.getColumns().addAll(OS, dt, serv, func);
	}


	@Override
	public void handle(ActionEvent event) {
		
		
	}

	@Override
	public Pane constructBoundary() {
		return principal;
	}
	
}
