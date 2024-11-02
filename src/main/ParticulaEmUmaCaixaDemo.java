package main;

import controller.ControllerPrincipal;

public class ParticulaEmUmaCaixaDemo {
    public static void main(String[] args) {
        try {
            ControllerPrincipal controller = new ControllerPrincipal();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
