package com.mycompany.peladaautomatica;

import com.mycompany.peladaautomatica.pages.MainScreen;
import com.mycompany.peladaautomatica.service.DataBase;
public class PeladaAutomatica {

    public static void main(String[] args) {
        DataBase.readData();
        MainScreen tela = new MainScreen();
        tela.setVisible(true);
    }
}
