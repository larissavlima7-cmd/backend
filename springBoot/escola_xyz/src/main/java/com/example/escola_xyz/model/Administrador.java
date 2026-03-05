package com.example.escola_xyz.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//classe para conectar com o BD - Entidade do Banco
//colocar a anotação de Entity
@Entity
public class Administrador implements Serializable{ //Seriializable converte os dados para binário
    //atributos
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    
    //metodos (Getters and Setters)
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
