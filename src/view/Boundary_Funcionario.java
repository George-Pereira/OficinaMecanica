package view;

import controller.ControlFuncionario;
import controller.ControlGerente;
import controller.ControlServico;
import entity.Funcionario;
import entity.Gerente;
import entity.Servico;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Boundary_Funcionario implements Boundary_Constructor, EventHandler<ActionEvent>
{
	private TextField txtNome = new TextField();
	private TextField txtCartrab = new TextField();
	private TextField txtCpf = new TextField();
	private TextField txtTel = new TextField();
	private TextField txtSalario = new TextField();
	private Button btnPesqfunc = new Button("Pesquisa");
	private BorderPane brdp = new BorderPane();
	private TableView<Servico> tableServicos = new TableView<Servico>();
	private TableView<Servico> tableHabilidades = new TableView<Servico>();
	private Button btnAdd = new Button("Adicionar");
	private CheckBox chFunc = new CheckBox("Funcionario Ativo");
	private Button btnAddserv = new Button("Adicionar Habilidade");
	private ControlFuncionario ctrFunc = new ControlFuncionario();
	private Funcionario atual = new Funcionario();
	private ControlGerente ctrGer = new ControlGerente();
	private ComboBox<Gerente> comboGerente = new ComboBox<Gerente>();
	private ControlServico serv = new ControlServico();
	
	public Boundary_Funcionario() 
	{
		btnAdd.addEventHandler(ActionEvent.ANY, this);
		btnAddserv.addEventHandler(ActionEvent.ANY, this);
		GridPane grd = new GridPane();
		grd.setHgap(10);
		grd.setVgap(10);
		ColumnConstraints col = new ColumnConstraints();
		col.setFillWidth(true);
		col.setPercentWidth(20);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setFillWidth(true);
		col1.setPercentWidth(25);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setFillWidth(true);
		col2.setPercentWidth(10);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setFillWidth(true);
		col3.setPercentWidth(25);
		grd.getColumnConstraints().addAll(col, col1, col2, col3);
		brdp.setTop(grd);
		grd.add(new Label("Nome do Funcionario"), 0, 0);
		grd.add(txtNome, 1, 0);
		txtNome.setMaxWidth(Double.MAX_VALUE);
		grd.add(new Label("Nº Carteira Trabalho"), 0, 1);
		grd.add(btnPesqfunc, 2, 0);
		grd.add(txtCartrab, 1, 1);
		grd.add(new Label("CPF"), 2, 1);
		grd.add(txtCpf, 3, 1);
		grd.add(new Label("Telefone"), 0, 2);
		grd.add(txtTel, 1, 2);
		grd.add(new Label("Salário"), 2, 2);
		grd.add(txtSalario, 3, 2);
		grd.add(chFunc, 0, 3);
		grd.add(comboGerente, 1, 3);
		constructTables();
		FlowPane flwBotoes = new FlowPane();
		flwBotoes.getChildren().add(btnAdd);
		flwBotoes.setVgap(10);
		flwBotoes.setAlignment(Pos.CENTER);
		brdp.setBottom(flwBotoes);
		btnAdd.addEventHandler(ActionEvent.ANY, this);
		btnPesqfunc.addEventHandler(ActionEvent.ANY, this);
	}
	 
	@Override
	public Pane constructBoundary() 
	{
		comboGerente.getItems().clear();
		comboGerente.setItems(ctrGer.getGerentes());
		return brdp;
	}
	public void constructTables() 
	{
		GridPane grd = new GridPane();
		ColumnConstraints col = new ColumnConstraints();
		col.setFillWidth(true);
		col.setPercentWidth(40);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setFillWidth(true);
		col2.setPercentWidth(40);
		grd.getColumnConstraints().addAll(col, col1, col2);
		TableColumn<Servico, String> clnServico = new TableColumn<Servico, String>("Serviços");
		clnServico.setCellValueFactory(new PropertyValueFactory<Servico, String>("nomeServ"));
		clnServico.setMinWidth(305);
		tableServicos.getColumns().add(clnServico);
		TableColumn<Servico, String> clnHabserv = new TableColumn<Servico, String>("Habilidades");
		clnHabserv.setCellValueFactory(new PropertyValueFactory<Servico, String>("nomeServ"));
		tableHabilidades.getColumns().add(clnHabserv);
		tableServicos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Servico>()
		{

			@Override
			public void changed(ObservableValue<? extends Servico> observable, Servico antigo, Servico novo) {
				tableHabilidades.getItems().add(novo);
			}
		});
		tableServicos.setItems(serv.getServicos());
		clnHabserv.setMinWidth(305);
		tableServicos.addEventHandler(ActionEvent.ANY, this);
		tableHabilidades.setItems(atual.getHabilidades());
		grd.add(tableHabilidades, 2, 0);
		grd.add(tableServicos, 0, 0);
		grd.add(btnAddserv, 1, 0);
		grd.setHgap(10);
		brdp.setCenter(grd);
	}
	public void carregaDados(Funcionario func) 
	{
		txtNome.setText(func.getNomeFunc());
		txtCartrab.setText(func.getCartTrab());
		txtCpf.setText(func.getCpf());
		txtTel.setText(func.getTelefone());
		txtSalario.setText(String.valueOf(func.getSalario()));
	}
	@Override
	public void handle(ActionEvent event) 
	{
		if(event.getTarget() == btnAdd) 
		{	
			atual = new Funcionario(txtNome.getText(), txtCartrab.getText(), txtCpf.getText(), txtTel.getText(), Double.parseDouble(txtSalario.getText()), chFunc.isSelected());
			ctrFunc.insertFuncionario(atual, comboGerente.getValue());
			txtNome.clear();
			txtCartrab.clear();
			txtCpf.clear();
			txtTel.clear();
			txtSalario.clear();
			
		}
		else if (event.getTarget() == btnPesqfunc) 
		{
			atual = (ctrFunc.pesqFuncionario(txtNome.getText()));
			tableHabilidades.getItems().clear();
			tableHabilidades.setItems(ctrFunc.getHabilidades(atual));
			carregaDados(atual);
		}
		else if(event.getTarget() == tableServicos) 
		{
			Servico serv = (Servico) tableServicos.getSelectionModel().getSelectedItem();
			System.out.println(serv.getNomeServ());
			ctrFunc.insereHabilidade(atual, (Servico) tableServicos.getSelectionModel().getSelectedItem());
			tableHabilidades.setUserData(tableServicos.getSelectionModel().getSelectedItem());
		}
	}
}

