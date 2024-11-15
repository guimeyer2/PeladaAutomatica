package com.mycompany.peladaautomatica;

import com.mycompany.peladaautomatica.pages.NewJFrame;
import com.mycompany.peladaautomatica.service.DataBase;
public class PeladaAutomatica {

    public static void main(String[] args) {
        DataBase.readData();
        DataBase.printTime();
        NewJFrame tela = new NewJFrame();
        tela.setVisible(true);
    }

}
