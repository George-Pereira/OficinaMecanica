package view;

import java.util.Date;
import controller.ControlCliente;
import controller.ControlManterOrdemServico;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Boundary_Balancos implements Boundary_Constructor, EventHandler<ActionEvent> , telaLoader {

	private BorderPane principal = new BorderPane();
	private Button btnpesquisarC = new Button("Buscar Cliente");
	private ComboBox<Veiculo> comboV = new ComboBox<Veiculo>();
	private TableView<Ordem_Servico> tabOS = new TableView<Ordem_Servico>();
	private Button btnpesquisarS = new Button("Buscar OS");
	private TextField txtCliente = new TextField();
	private TextField txtCPF = new TextField();
	private ControlCliente ctrCli = new ControlCliente();
	private gerenciadorTelas gerente;

	public Boundary_Balancos(gerenciadorTelas gerente) {

		this.gerente = gerente;
		principal.setStyle("-fx-padding: 10px");
		GridPane pCampos = new GridPane();
		GridPane painel1 = new GridPane();
		tabOS.setEditable(true);
		adicionarTableColumns();
		pCampos.add(tabOS, 1, 5, 3, 5);
		painel1.add(new Label("Cliente"), 0, 0);
		painel1.add(txtCliente, 1, 0, 2, 1);
		painel1.add(new Label("CPF"), 0, 1);
		painel1.add(txtCPF, 1, 1, 2, 1);
		painel1.add(btnpesquisarC, 3, 0);
		painel1.add(new Label("Veículo"), 0, 2);
		painel1.add(comboV, 1, 2, 3, 1);
		principal.setTop(painel1);
		principal.setBottom(tabOS);
		painel1.setHgap(10);
		painel1.setVgap(10);
		btnpesquisarC.addEventHandler(ActionEvent.ANY, this);
		comboV.addEventHandler(ActionEvent.ANY, this);

	}

        private void adicionarTableColumns() {
		TableColumn<Ordem_Servico, Integer> OS = new TableColumn<Ordem_Servico, Integer>("OS");
	    OS.setCellValueFactory(new PropertyValueFactory<Ordem_Servico, Integer>("OS"));
	    OS.setMinWidth(50);

	    TableColumn<Ordem_Servico, Date> dt = new TableColumn<Ordem_Servico, Date>("Data");
	    dt.setCellValueFactory(new PropertyValueFactory<Ordem_Servico, Date>("dtSaida"));
	    dt.setMinWidth(140);

	    TableColumn<Ordem_Servico, String> serv = new TableColumn<Ordem_Servico, String>("Serviço");
	    serv.setCellValueFactory(new PropertyValueFactory<Ordem_Servico, String>("nomeS"));
	    serv.setMinWidth(150);

	    TableColumn<Ordem_Servico, String> func = new TableColumn<Ordem_Servico, String>("Funcionario");
	    func.setCellValueFactory(new PropertyValueFactory<Ordem_Servico, String>("nome"));
	    func.setMinWidth(190);

	    tabOS.getColumns().add(OS);
	    tabOS.getColumns().add(dt);
	    tabOS.getColumns().add(serv);
	    tabOS.getColumns().add(func);

	}

    @Override

    	public void handle(ActionEvent event) {
    		if (event.getTarget() == btnpesquisarC) {
    			try {
    				comboV.getItems().clear();
    				Cliente c = new Cliente();
    					c = ctrCli.pesquisarPorNome(txtCliente.getText());
    				comboV.getItems().addAll(c.getPosses());
    				entidadeParaBoundary(c);
    			}
    			catch(Exception e) {
    				System.out.println("Não há parametros para pesquisa");
    			}
    		}
    		else if(event.getTarget() == comboV) {
    			ControlManterOrdemServico mos = new ControlManterOrdemServico();
    			tabOS.setItems(mos.getListO());
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

	@Override
	public void setRequest(gerenciadorTelas g) 
	{
		this.gerente = g;
	}

	@Override
	public gerenciadorTelas getRequest() 
	{
		return this.gerente;

	}

}
