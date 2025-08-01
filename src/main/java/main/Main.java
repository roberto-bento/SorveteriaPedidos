package main;

import facade.SorveteriaFacade;

public class Main {
    public static void main(String[] args) {
        SorveteriaFacade facade = new SorveteriaFacade();
        facade.iniciar();
    }
}