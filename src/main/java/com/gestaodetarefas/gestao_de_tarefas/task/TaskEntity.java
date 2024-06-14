package com.gestaodetarefas.gestao_de_tarefas.task;

import java.util.UUID;

public class TaskEntity {
    // private UUID id;
    private int id;
    private String title;
    private String status;
    private String description;

    public TaskEntity(int id, String title, String status, String description){
        this.id = id;
        this.title = title;
        this.status = status;
        this.description = description;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


// id: Chave primária da entidade.
// Tipo de dado: UUID.
// title: Título da tarefa. Este campo é obrigatório.
// Tipo de dado: String.
// status: Representa o status atual da tarefa. Este campo é obrigatório.
// Tipo de dado: String.
// description: Representa a descrição da tarefa. Este campo é obrigatório.
// Tipo de dado: String.