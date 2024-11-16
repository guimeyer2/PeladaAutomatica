package com.mycompany.peladaautomatica.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.mycompany.peladaautomatica.classes.Jogador;
import com.mycompany.peladaautomatica.classes.Pote;
import com.mycompany.peladaautomatica.classes.Time;
import com.mycompany.peladaautomatica.exceptions.JogadorNaoEncontradoException;
import com.mycompany.peladaautomatica.exceptions.NotaInvalidaException;

public class DataBase {
    public static HashMap<String, Jogador> peladeiros = new HashMap<String, Jogador>();
    public static Pote[] potes= new Pote[10];
    public static Time[] times = new Time[3];

    public static void readData() {
        Path filePath = Paths.get("PeladaAutomatica/src/main/java/com/mycompany/peladaautomatica/service/Data.txt").toAbsolutePath();
        DataBase.initializePotes();
        DataBase.initializeTimes();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toString()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] aux = line.split(";");
                Integer x = Integer.parseInt(aux[1]);
                Jogador jogador = new Jogador(aux[0], x);
                peladeiros.put(aux[0], jogador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sorteio(ArrayList<Jogador> convocados, int n){
        int tam;
        if(convocados.size() == 12 || convocados.size() > 15) tam = 6;
        else tam = 5;
        DataBase.setPotes(convocados);
        DataBase.randomizacao();
        DataBase.setTimes(n, tam);
    }

    public static void setPotes(ArrayList<Jogador> convocados){
        for(Jogador w : convocados){
            int index = setPote(w.getNivel());
            potes[index].addJogador(w);
        }
    }

    public static void randomizacao(){
        for(int i=0; i<potes.length; i++){
            potes[i].randomizacao();
        }
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

    public static int setPote(int nota){
        if(nota >= 8) return 0;
        else if(nota >= 6) return 1;
        else if(nota >= 4) return 2;
        else return 3;
    }

    public static void printTime(){
        for(int i = 0; i < times.length; i++){
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
    
    public static Jogador getJogador(String nome) throws JogadorNaoEncontradoException{
        Jogador w = peladeiros.get(nome);
        if (w == null) {
            throw new JogadorNaoEncontradoException(nome);
        }
        return peladeiros.get(nome);
    }

    public static void addJogador(String nome, Jogador w){
        peladeiros.put(nome, w);
    }

    public static void updateData(String nome, int nota){
        Path filePath = Paths.get("PeladaAutomatica/src/main/java/com/mycompany/peladaautomatica/service/Data.txt").toAbsolutePath();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toString(), true))) {
            writer.write(nome + ";" + nota);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }

    public static boolean notaValida(String s) throws NotaInvalidaException{
        try {
            int nota = Integer.parseInt(s);
            if (nota >= 1 && nota <= 10) {
                return true;
            } else {
                throw new NotaInvalidaException();
            }
        } catch (NumberFormatException e) {
            throw new NotaInvalidaException();
        }
    }

    public static void setTimes(int n, int tam){
        int rodada = 0;
        int aux = 0;

        for(int i=0; i<potes.length; i++){
            for(int j=0; j<potes[i].tamanho(); j++){
                if(times[rodada].getSize() == tam){
                    rodada++;
                    j--;
                    if(rodada == n) rodada = 0;
                    continue;
                }
                Jogador w = potes[i].getJogador(j);
                times[rodada].addJogador(w);
                rodada++;
                if(rodada == n){
                    rodada = aux;
                    aux = 0;
                }
            }
            aux = rodada;
        }
    }

}
