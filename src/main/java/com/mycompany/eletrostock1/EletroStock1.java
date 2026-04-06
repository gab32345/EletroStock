package com.mycompany.eletrostock1;

public class EletroStock1 {

    public static void main(String[] args) {
        // Isso abre a sua tela de cadastro
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }
}