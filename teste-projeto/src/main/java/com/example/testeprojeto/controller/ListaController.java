


package com.example.testeprojeto.controller;

import com.example.testeprojeto.dominio.Prioridade;
import com.example.testeprojeto.dominio.Status;
import com.example.testeprojeto.dominio.Tarefa;
import com.example.testeprojeto.dominio.TarefasServicos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class ListaController {

    @FXML
    private TextField abaadd;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnconcluidas;

    @FXML
    private Button btnpendentes;

    @FXML
    private Button btntodas;

    @FXML
    private Label lblh2;

    @FXML
    private Label lbltarefa;

    @FXML
    private TableView<Tarefa> listaTrefas;

    @FXML
    private TableColumn<Tarefa, String> colNome;

    @FXML
    private TableColumn<Tarefa, String> colDesc;

    @FXML
    private TableColumn<Tarefa, LocalDate> colData;

    @FXML
    private TableColumn<Tarefa, Status> colStatus;

    @FXML
    private TableColumn<Tarefa, Prioridade> colPrioridade;

    @FXML
    private TableColumn<Tarefa, Void> colEditar;



    private final TarefasServicos tarefasServicos = new TarefasServicos();

    @FXML
    public void initialize() {

        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colPrioridade.setCellValueFactory(new PropertyValueFactory<>("prioridade"));


        listaTrefas.setItems(tarefasServicos.getTarefas());
    }

    @FXML
    public void abrirCadastro(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/com/example/testeprojeto/cadastro-tarefa.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void filtrarTodas() {
        listaTrefas.setItems(tarefasServicos.getTarefas());
    }

    @FXML
    public void filtrarPendentes() {
        ObservableList<Tarefa> filtradas = FXCollections.observableArrayList();
        for (Tarefa t : tarefasServicos.getTarefas()) {
            if (t.getStatus() == Status.PENDENTE) {
                filtradas.add(t);
            }
        }
        listaTrefas.setItems(filtradas);
    }

    @FXML
    public void filtrarConcluidas() {
        ObservableList<Tarefa> filtradas = FXCollections.observableArrayList();
        for (Tarefa t : tarefasServicos.getTarefas()) {
            if (t.getStatus() == Status.CONCLUIDA) {
                filtradas.add(t);
            }
        }
        listaTrefas.setItems(filtradas);
    }


}
