package com.mycompany.peladaautomatica.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Path filePath = Paths.get("PeladaAutomatica/src/main/java/com/mycompany/peladaautomatica/service/Data.txt").toAbsolutePath();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toString()))) {
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
        for (int i = 0; i < times.length; i++) {
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
        if(nota >= 8) return 0;
        else if(nota >= 6) return 1;
        else if(nota >= 4) return 2;
        else return 3;
    }

    public static void printTime(){
        for(int i = 0; i < 3; i++){
            if(i == 0) System.out.println("Branco: ");
            else if(i == 1) System.out.println("Preto: ");
            else System.out.println("Azul: ");
            
            ArrayList<Jogador> aux = times[i].getJogadores();
            for(Jogador w : aux){
                System.out.println(w.getNome());
            }
            
        
            double media = times[i].Media();
            System.out.printf("Média: %.2f%n", media);
            System.out.println();
        }
    }
    public static double Media(Time time) {
        int soma = 0;
        for (Jogador jogador : time.getJogadores()) {
            soma += jogador.getNivel();
        }
        return (double) soma / time.getJogadores().size();
    }
    

    public static void setTimes(){
        int rodada = 0;
        int aux = 0;

        for(int i=0; i<potes.length; i++){
            for(int j=0; j<potes[i].tamanho(); j++){
                if(times[rodada].getSize() == 5){
                    rodada++;
                    j--;
                    if(rodada == 3) rodada = 0;
                    continue;
                }
                Jogador w = potes[i].getJogador(j);
                times[rodada].addJogador(w);
                rodada++;
                if(rodada == 3){
                    rodada = aux;
                    aux = 0;
                }
            }
            aux = rodada;
        }
    }
}
