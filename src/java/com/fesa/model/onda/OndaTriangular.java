/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fesa.model.onda;

import com.fesa.model.canal.Canal;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
        int numAmostras = 10000; // Aumentar o número de amostras para uma alta resolução
        
        

        double[] matriz = new double[numAmostras];
        double deltaT = duracao / numAmostras;
        double periodo = 1.0 / frequencia;

        for (int i = 0; i < numAmostras; i++) {
            double tempo = i * deltaT;
            double tModulo = tempo % periodo;
            double value = 2 * amplitude / Math.PI * Math.asin(Math.sin(2 * Math.PI * frequencia * tempo));
            matriz[i] = (new BigDecimal(value).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
        }
        return matriz;
    }


    @Override
    public void calcAnBn() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void calcFaseEntrada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public double[] calcOndaRecebida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
