package com.example.testeprojeto.dominio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TarefasServicos {

    private static final ObservableList<Tarefa> tarefas = FXCollections.observableArrayList();

    public ObservableList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void adicionar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }
}




