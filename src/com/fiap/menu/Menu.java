package com.fiap.menu;

import com.fiap.controller.Controle;

import javax.swing.*;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Menu {
    public static String menuIniciar(){
        String aux = "Escolha uma opção:\n";
        aux += "1. Cadastrar paciente\n";
        aux += "2. Atender paciente\n";
        aux += "3. Liberar Vaga\n";
        aux += "4. Consultar registro do paciente\n";
        aux += "5. Imprimir fila de atendimento\n";
        aux += "6. Sair\n";
        return aux;
    }
    public static String menuPessoa(){
        String aux = "Escolha uma opção:\n";
        aux += "1. Pessoa Fisica\n";
        aux += "2. Pessoa Juridica\n";
        return aux;
    }
    public static void oQueFazAcontecer(){
        Controle controle = new Controle();
        int opcao;
        do{
            opcao = parseInt(showInputDialog(Menu.menuIniciar()));
            if(opcao < 1 || opcao > 6){
                showMessageDialog(null,"Opção invalida");
            }else{
                switch(opcao){
                    case 1:
                        controle.cadastrarPaciente();
                        break;
                    case 2:
                        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente: ");
                        controle.atenderPaciente(cpf);
                        break;
                    case 3:
                        controle.liberarVaga();
                        break;
                    case 4:
                        //String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente: ");
                        //controle.consultarRegsitroPaciente(cpf);
                        break;
                    case 5:
                        controle.imprimirFilaAtendimento();
                }
            }
        }while(opcao != 6);
    }
}
