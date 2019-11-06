package view;

import controller.ControlFuncionario;
import controller.ControlServico;
import entity.Funcionario;
import entity.Servico;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
	private TableView tableServicos = new TableView();
	private TableView tableHabilidades = new TableView();
	private ControlServico ctrServ = new ControlServico();
	private Button btnAdd = new Button("Adicionar");
	private CheckBox chFunc = new CheckBox("Funcionario Ativo");
	private Button btnAddserv = new Button("Adicionar Habilidade");
	private ControlFuncionario ctrFunc = new ControlFuncionario();
	private Funcionario atual = new Funcionario();
	TableColumn<Servico, String> clnServico = new TableColumn<Servico, String>("Servi�os");
	@Override
	public Pane constructBoundary() 
	{
		btnAdd.addEventHandler(ActionEvent.ANY, this);
		btnAddserv.addEventHandler(ActionEvent.ANY, this);
		GridPane grd = new GridPane();
		grd.setHgap(10);
		grd.setVgap(10);
		ColumnConstraints col = new ColumnConstraints();
		col.setFillWidth(true);
		col.setPercentWidth(15);
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
		grd.add(new Label("N� Carteira Trabalho"), 0, 1);
		grd.add(btnPesqfunc, 2, 0);
		grd.add(txtCartrab, 1, 1);
		grd.add(new Label("CPF"), 2, 1);
		grd.add(txtCpf, 3, 1);
		grd.add(new Label("Telefone"), 0, 2);
		grd.add(txtTel, 1, 2);
		grd.add(new Label("Sal�rio"), 2, 2);
		grd.add(txtSalario, 3, 2);
		grd.add(chFunc, 0, 3);
		constructTables();
		FlowPane flwBotoes = new FlowPane();
		flwBotoes.getChildren().add(btnAdd);
		return brdp;
	}
	public void constructTables() 
	{
		GridPane grd = new GridPane();
		clnServico.setCellValueFactory(new PropertyValueFactory<Servico, String>("nomeServ"));
		tableServicos.getColumns().add(clnServico);
		TableColumn<Funcionario, Servico> clnHabserv = new TableColumn<Funcionario, Servico>("Habilidades");
		tableHabilidades.getColumns().add(clnHabserv);
		tableServicos.setItems(ctrServ.getListaServ());
		clnServico.addEventHandler(ActionEvent.ANY, this);
		tableHabilidades.setItems(atual.getHabilidades());
		grd.add(tableHabilidades, 1, 0);
		grd.add(tableServicos, 2, 0);
		grd.add(btnAddserv, 0, 0);
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
			atual = new Funcionario(txtNome.getText(), txtCartrab.getText(), txtCpf.getText(), txtTel.getText(), Double.parseDouble(txtSalario.getText()));
			ctrFunc.insertFuncionario(atual);
		}
		else if (event.getTarget() == btnPesqfunc) 
		{
			atual = (ctrFunc.pesqFuncionario(txtNome.getText()));
			carregaDados(atual);
		}
		else if(event.getTarget() == clnServico) 
		{
			Servico serv = (Servico) tableServicos.getSelectionModel().getSelectedItem();
			System.out.println(serv.getNomeServ());
			ctrFunc.insereHabilidade(atual, (Servico) tableServicos.getSelectionModel().getSelectedItem());
			tableHabilidades.setUserData(tableServicos.getSelectionModel().getSelectedItem());
		}
	}
}
