package view;

import java.util.Date;

import controller.ControlCliente;
import controller.ControlManterOrdemServico;
import controller.ControlVeiculo;
import entity.Cliente;
import entity.Ordem_Servico;
import entity.Veiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Boundary_ManterHistorico implements Boundary_Constructor, EventHandler<ActionEvent> {
	
	private BorderPane principal = new BorderPane();
	private Button btnpesquisarC = new Button("Buscar Cliente");
	private ComboBox<Veiculo> comboV = new ComboBox<Veiculo>();
	private TableView<Ordem_Servico> tabS = new TableView<Ordem_Servico>();
	private Button btnpesquisarS = new Button("Buscar OS");
	private TextField txtCliente = new TextField();
	private TextField txtServico = new TextField();
	private TextArea txtObserv = new TextArea();
	private Button btnSalvar = new Button("Salvar");
	private Button btnEditar = new Button("Editar");
	private ControlManterOrdemServico mos = new ControlManterOrdemServico();
	private ControlCliente ctrCli = new ControlCliente();
	
	public Boundary_ManterHistorico() {
		principal.setStyle("-fx-padding: 10px");
		GridPane pCampos = new GridPane();
		GridPane painel1 = new GridPane();
		GridPane painel2 = new GridPane();
		GridPane pbutton = new GridPane();
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(20);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(25);
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
		pCampos.add(tabS, 1, 3, 3, 5);
		painel2.add(new Label("OS"), 0, 1);
		painel2.add(txtServico, 1, 1, 2, 1);
		painel2.add(btnpesquisarS, 3, 1);
		pCampos.add(painel2, 1, 9, 3, 2);
		pCampos.add(new Label("Observações"), 2, 11);
		pCampos.add(txtObserv, 1, 12, 2, 1);
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
		
		btnpesquisarC.addEventHandler(ActionEvent.ANY, this);
		btnpesquisarS.addEventHandler(ActionEvent.ANY, this);
		btnSalvar.addEventHandler(ActionEvent.ANY, this);
		btnEditar.addEventHandler(ActionEvent.ANY, this);
		comboV.addEventHandler(ActionEvent.ANY, this);
	}
	
	
	private void adicionarTableColumns() {
		
		TableColumn<Ordem_Servico, Integer> OS = new TableColumn<Ordem_Servico, Integer>("OS");
	    OS.setCellValueFactory(new PropertyValueFactory<Ordem_Servico, Integer>("OS"));
	    OS.setMinWidth(50);
	    
	    TableColumn<Ordem_Servico, Date> dt = new TableColumn<Ordem_Servico, Date>("Data");
	    dt.setCellValueFactory(new PropertyValueFactory<Ordem_Servico, Date>("dtSaida"));
	    dt.setMinWidth(100);
	    
	    TableColumn<Ordem_Servico, String> serv = new TableColumn<Ordem_Servico, String>("Serviço");
	    serv.setCellValueFactory(new PropertyValueFactory<Ordem_Servico, String>("nomeS"));
	    serv.setMinWidth(140);
	    
	    TableColumn<Ordem_Servico, String> func = new TableColumn<Ordem_Servico, String>("Funcionario");
	    func.setCellValueFactory(new PropertyValueFactory<Ordem_Servico, String>("nome"));
	    func.setMinWidth(170);
	    
	    tabS.getColumns().addAll(OS, dt, serv, func);
	}


	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnpesquisarC) 
		{
			try {
				comboV.getItems().clear();
				Cliente c = new Cliente();
					c = ctrCli.pesquisarPorNome(txtCliente.getText());
				comboV.getItems().addAll(c.getPosses());
				entidadeParaBoundary(c);
			}catch(Exception e) 
			{
				System.out.println("Não há parametros para pesquisa");
			}

		}else if(event.getTarget() == comboV) {
			tabS.setItems(mos.MostraServico(comboV.getValue().getModel()));
		}
		else if(event.getTarget() == btnpesquisarS) {
			mos.getTemp().clear();
			tabS.setItems(mos.BuscarServico(Integer.parseInt(txtServico.getText())));
		}
		else if(event.getTarget() == btnSalvar) {
			
		}
		else if(event.getTarget() == btnEditar) {
			
		}
		
	}

	private void entidadeParaBoundary(Cliente c) {
		if (c != null) {
			txtCliente.setText(c.getNome());
		}
		
	}


	@Override
	public Pane constructBoundary() {
		return principal;
	}
	
}

