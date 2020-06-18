package com.fiap.controller;

import com.fiap.menu.Triagem;
import com.fiap.model.Paciente;

import javax.swing.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Controle {
    List<Paciente> filaAtendimento = new LinkedList<>();
    List<Paciente> listaPacientes = new LinkedList<>();
    List<Paciente> filaInternacao = new LinkedList<>();

    public void cadastrarPaciente() {
        String nome = JOptionPane.showInputDialog("Digite o nome do paciente:");
        String cpf = JOptionPane.showInputDialog("Digite o cpf do paciente:");

        filaAtendimento.add(new Paciente(nome,cpf, "filaAtendimento"));

        listaPacientes.add(new Paciente(nome,cpf, "filaAtendimento"));

        JOptionPane.showMessageDialog(null, "Paciente adicionado na fila de atendimento");
    }

    public void atenderPaciente(String cpf) {
       filaAtendimento.get(0);

    }

    public void imprimirFilaAtendimento() {
        if(filaAtendimento.isEmpty()){
            JOptionPane.showMessageDialog(null, "Fila de Atendimento está vazia");
        }else{
            JOptionPane.showMessageDialog(null, Arrays.toString(filaAtendimento.toArray()));
        }
    }

    public void liberarVaga(Paciente paciente) {
        String safe = "em alta";
        String notSafe = "obito";
        String aux = JOptionPane.showInputDialog("Digite '1' para Alta ou '2' para Obito");
        if(aux == "1"){
            paciente.setStatus(safe);
        }else if (aux == "2"){
            paciente.setStatus(notSafe);
        }
        for(int i = 0; i < listaPacientes.size(); i++) {
            Paciente p = filaAtendimento.get(i);
            if(p.getStatus() == safe || p.getStatus() == notSafe){
                filaInternacao.remove(p);
            }

        }
    }
}
