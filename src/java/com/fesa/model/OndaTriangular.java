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
public class OndaTriangular extends Onda {
    @Override
    public double[] calcOndaEmitida() {
        int frequencia = this.getFrequenciaFundamental(); // Frequência da onda em Hz
        double amplitude = 1.0; // Amplitude da onda
        double duracao = 1.0; // Duração da onda em segundos
        int numAmostras = 1000; // Aumentar o número de amostras para uma alta resolução

        double[] matriz = new double[numAmostras];
        double deltaT = duracao / numAmostras;
        double periodo = 1.0 / frequencia;

        for (int i = 0; i < numAmostras; i++) {
            double tempo = i * deltaT;
            matriz[i] = 2 * amplitude / Math.PI * Math.asin(Math.sin(2 * Math.PI * frequencia * tempo));
        }
        return matriz;
    }

    @Override
    public HashMap<Long, Double> calcOndaRecebida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
