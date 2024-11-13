package com.mycompany.peladaautomatica.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.mycompany.peladaautomatica.classes.Jogador;
import com.mycompany.peladaautomatica.classes.Pote;
import com.mycompany.peladaautomatica.classes.Time;

public class DataBase {
    public static ArrayList<Jogador> peladeiros = new ArrayList<>();
    public static Pote[] potes= new Pote[4];
    public static Time[] times = new Time[3];

    public static void readData() {
        try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] aux = line.split(";");
                Integer x = Integer.parseInt(aux[1]);
                Jogador jogador = new Jogador(aux[0], x);
                peladeiros.add(jogador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataBase.ordenha();
        DataBase.initializePotes();
        DataBase.setPotes();
        for(int i=0; i<4; i++){
            potes[i].randomizacao();
        }
        DataBase.initializeTimes();
        DataBase.setTimes();
    }

    public static void initializePotes() {
        for (int i = 0; i < potes.length; i++) {
            potes[i] = new Pote();
        }
    }

    public static void initializeTimes() {
        for (int i = 0; i < 3; i++) {
            times[i] = new Time();
        }
    }

    public static void ordenha() {
        Collections.sort(peladeiros, new Comparator<Jogador>() {
            public int compare(Jogador j1, Jogador j2) {
                return Integer.compare(j2.getNivel(), j1.getNivel());
            }
        });
    }

    public static void setPotes(){
        for(Jogador w : peladeiros){
            int index = setPote(w.getNivel());
            potes[index].addJogador(w);
        }
    }

    public static int setPote(int nota){
        if(nota >= 9) return 0;
        else if(nota >= 7) return 1;
        else if(nota >= 4) return 2;
        else return 3;
    }

    public static void printTime(){
        for(int i=0; i<3; i++){
            if(i == 0) System.out.println("Branco: ");
            else if(i == 1) System.out.println("Preto: ");
            else System.out.println("Azul: ");
            ArrayList<Jogador> aux = times[i].getJogadores();
            for(Jogador w : aux){
                System.out.println(w.getNome());
            }
            System.out.println();
        }
    }

    public static void setTimes(){
        int rodada = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<potes[i].tamanho(); j++){
                Jogador w = potes[i].getJogador(j);
                times[rodada].addJogador(w);
                rodada++;
                if(rodada == 3) rodada = 0;
            }  
        }
    }
}