/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fesa.model;

import java.util.HashMap;

/**
 *
 * @author vinio
 */
public class OndaSenoidalRetificada extends Onda {
    @Override
    public double[] calcOndaEmitida() {
        int frequencia = this.getFrequenciaFundamental();
        
        // Parâmetros da onda senoidal
        double fase = 0; // Fase inicial da onda

        // Duração da onda em segundos
        double duracao = 1.0; // 1 segundo

        // Calculando o número de amostras necessário para representar a onda corretamente
        int numAmostras = frequencia * 100; // Aumentando a resolução para maior precisão

        // Intervalo de tempo entre cada amostra
        double deltaT = duracao / numAmostras;

        // Criando a matriz
        double[] matriz = new double[numAmostras];
        
        for (int i = 0; i < numAmostras; i++) {
            // Calculando o tempo para esta amostra
            double tempo = i * deltaT;
            // Calculando a onda senoidal e aplicando a retificação
            double value = Math.abs(Math.sin(2 * Math.PI * frequencia * tempo + fase));
            matriz[i] = value;
        }
        return matriz;
    }

    @Override
    public HashMap<Long, Double> calcOndaRecebida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
