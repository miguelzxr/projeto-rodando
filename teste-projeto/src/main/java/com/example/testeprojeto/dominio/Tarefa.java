package com.example.testeprojeto.dominio;

import java.time.LocalDate;

public class Tarefa {
    private String nome;
    private String descricao;
    private LocalDate data;
    private Status status;
    private Prioridade prioridade;

    public Tarefa(String nome, String descricao, LocalDate data, Status status, Prioridade prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
        this.prioridade = prioridade;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Prioridade getPrioridade() { return prioridade; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }
}