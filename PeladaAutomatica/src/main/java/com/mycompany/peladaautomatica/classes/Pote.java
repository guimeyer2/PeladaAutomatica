package com.mycompany.peladaautomatica.classes;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Pote {
    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public ArrayList<Jogador> randomizacao(){
        ArrayList<Jogador> sorteado = this.jogadores;
        SecureRandom random = new SecureRandom();
        for(int i=0; i<jogadores.size(); i++){
            int newPos = random.nextInt(sorteado.size());
            Jogador aux = sorteado.get(newPos);
            sorteado.set(newPos, jogadores.get(i));
            sorteado.set(i, aux);
        }
        
        return sorteado;
    }

    public void printTime(){
        for(int i=0; i<jogadores.size(); i++){
            Jogador a = jogadores.get(i);
            System.out.println(a.getNome() + "#");
        }
    }

    public void addJogador(Jogador w){
        jogadores.add(w);
    }

    public int tamanho(){
        return jogadores.size();
    }

    public Jogador getJogador(int index){
        Jogador j = jogadores.get(index);
        return j;
    }

    public void setJogadores(ArrayList<Jogador> j){
        jogadores = j;
    }
}
