package com.example.viniciusvianna.smavc_paciente.modelo;

/**
 * Created by ViniciusVianna on 27/07/2017.
 */

public class Usuario {

    private String id;
    private String login;
    private String senha;
    private String nome;
    private String user;
    private int idade;
    private String sexo;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario() {
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return " Nome: '" + nome +
                "\nUsuário: '" + user +
                "\nIdade: " + idade +
                "\nSexo:'" + sexo +
                "\nLogin: '" + login +
                "\nSenha: '" + senha
                ;
    }

}//fecha classe
