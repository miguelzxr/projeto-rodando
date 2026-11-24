package com.example.testeprojeto.controller;

import com.example.testeprojeto.dominio.Prioridade;
import com.example.testeprojeto.dominio.Status;
import com.example.testeprojeto.dominio.Tarefa;
import com.example.testeprojeto.dominio.TarefasServicos;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class CadastroController {

    @FXML
    private AnchorPane principaltela;

    @FXML
    private TextField nometarefa;

    @FXML
    private ComboBox<Prioridade> prioridadesdp;

    @FXML
    private DatePicker dataselect;

    @FXML
    private TextField textdecricao;

    @FXML
    private Label titulotarefa;

    @FXML
    private Label labeltarefa;

    @FXML
    private Label labelprioridade;

    @FXML
    private Label lbdataentrega;

    @FXML
    private Label labeldescricao;

    private final TarefasServicos tarefasServicos = new TarefasServicos();

    @FXML
    public void initialize() {
        prioridadesdp.setItems(FXCollections.observableArrayList(Prioridade.values()));
    }

    @FXML
    public void salvarTarefa(ActionEvent event) throws IOException {
        String nome = nometarefa.getText();
        String descricao = textdecricao.getText();
        LocalDate data = dataselect.getValue();
        Prioridade prioridade = prioridadesdp.getValue();

        if (nome == null || nome.isBlank() || descricao == null || descricao.isBlank()
                || data == null || prioridade == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cadastro");
            alert.setContentText("Todos os campos são obrigatórios");
            alert.show();
            return;
        }

        tarefasServicos.adicionar(new Tarefa(nome, descricao, data, Status.PENDENTE, prioridade));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro");
        alert.setContentText("Tarefa cadastrada com sucesso!");
        alert.showAndWait();

        abrirListaTarefas(event);
    }

    @FXML
    public void voltar(ActionEvent event) throws IOException {
        abrirListaTarefas(event);
    }

    private void abrirListaTarefas(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/com/example/testeprojeto/lista-tarefas.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}