package com.mycompany.peladaautomatica.exceptions;

public class NotaInvalidaException extends Exception{
    public NotaInvalidaException(){
        super("Insira uma nota valida");
    }
}
