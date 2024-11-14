package com.mycompany.peladaautomatica.classes;

import java.util.ArrayList;

public class Time {
    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public void addJogador(Jogador w){
        jogadores.add(w);
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public int getSize(){
        return jogadores.size();
    }
}
