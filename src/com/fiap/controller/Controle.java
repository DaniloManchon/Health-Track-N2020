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
    List<Paciente> internados = new LinkedList<>();

    public boolean isFull(){
        return filaInternacao != null && filaInternacao.size() >= 6;
    }

    public void cadastrarPaciente() {
        String nome = JOptionPane.showInputDialog("Digite o nome do paciente:");
        String cpf = JOptionPane.showInputDialog("Digite o cpf do paciente:");

        filaAtendimento.add(new Paciente(nome,cpf, "filaAtendimento"));

        listaPacientes.add(new Paciente(nome,cpf, "filaAtendimento"));

        JOptionPane.showMessageDialog(null, "Paciente adicionado na fila de atendimento");
    }

    public void atenderPaciente() {
       Paciente aux = filaAtendimento.get(0);
        Triagem.fazerTriagem();
        if(Triagem.fazerTriagem()){
            JOptionPane.showMessageDialog(null, "Há necessidade de internação");
            if(!isFull()){
                aux.setStatus("internado");
                internados.add(aux);
            }else {
                JOptionPane.showMessageDialog(null, "Fila de internaçao está cheia, adicionando o paciente a fila de internação");
                aux.setStatus("filaInternação");
                filaInternacao.add(aux);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Você vai viver, não há necessidade de internaçao");
            aux.setStatus("liberado");
        }


    }

    public void imprimirFilaAtendimento() {
        if(filaAtendimento.isEmpty()){
            JOptionPane.showMessageDialog(null, "Fila de Atendimento está vazia");
        }else{
            JOptionPane.showMessageDialog(null, Arrays.toString(filaAtendimento.toArray()));
        }
    }

    public void liberarVaga(){
        String entrada = JOptionPane.showInputDialog("Digite o CPF do paciente");

        for(int i = 0; i < internados.size(); i++) {
            Paciente p = internados.get(i);

            if (p.getCpf().equals(entrada)) {
                String situacao = JOptionPane.showInputDialog("Digite 1 para Alta ou 2 para Óbito");
                if(situacao == "1"){
                    p.setStatus("em alta");
                    internados.remove(p);
                    JOptionPane.showMessageDialog(null, "paciente não mais internado");
                    internados.add(filaInternacao.get(0));
                }else if(situacao == "2"){
                    p.setStatus("óbito");
                    internados.remove(p);
                    JOptionPane.showMessageDialog(null, "paciente não mais internado");
                    internados.add(filaInternacao.get(0));
                }else{
                    JOptionPane.showMessageDialog(null, "Opção invalida");
                }
                break;
            }
        }
}

    public void consultarRegistroPaciente(String cpf) {
        for (int i = 0; i < listaPacientes.size(); i++) {
            Paciente p = listaPacientes.get(i);
            if (p.getCpf().equals(cpf)) {
                JOptionPane.showMessageDialog(null, p.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Paciente não encontrado");
            }

        }
    }
}
