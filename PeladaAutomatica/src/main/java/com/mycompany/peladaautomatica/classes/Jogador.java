package com.mycompany.peladaautomatica.classes;

public class Jogador {
    private String nome;
    private int nivel;

    public Jogador(String nome, int nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
