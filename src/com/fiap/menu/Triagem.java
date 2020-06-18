package com.fiap.menu;

import com.fiap.model.Paciente;

import javax.swing.*;

public class Triagem {
    public static boolean fazerTriagem(){
        String esperado = "sim";

        String resp1, resp2, resp3, resp4, resp5;
        resp1 = JOptionPane.showInputDialog("O senhor(a) tem apresentado febre alta?");
        resp2 = JOptionPane.showInputDialog("O senhor(a) tem apresentado tosse constante?");
        resp3 = JOptionPane.showInputDialog("O senhor(a) tem apresentado coriza?");
        resp4 = JOptionPane.showInputDialog("O senhor(a) tem apresentado dor de garganta?");
        resp5 = JOptionPane.showInputDialog("O senhor(a) tem apresentado dificuldade para respirar?");

        if (resp1 == esperado || resp2 == esperado || resp3 == esperado || resp4 == esperado || resp5 == esperado){
            return true;
        }else{
            return false;
        }

    }


}
