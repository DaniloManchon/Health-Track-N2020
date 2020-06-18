package com.fiap.model;

public class Paciente {
    private String nome;
    private String cpf;
    private String status;

    public Paciente(String nome, String cpf, String status) {
        this.nome = nome;
        this.cpf = cpf;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nome='" + nome + '\n' + ", cpf='" + cpf + '\n' + "status='" + status + '}';
    }
}
