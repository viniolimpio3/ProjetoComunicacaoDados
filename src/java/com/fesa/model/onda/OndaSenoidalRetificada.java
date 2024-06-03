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
public class OndaSenoidalRetificada extends Onda {
    @Override
    public double[] calcOndaEmitida() {
        double frequencia = this.getFrequenciaFundamental();

        // Parâmetros da onda
        double fase = 0; // Fase inicial da onda

        // Duração da onda em segundos
        double duracao = 1; // 1 segundo

        // Taxa de amostragem (samples per second)
        int sampleRate = 1000; // Taxa de amostragem padrão para áudio

        // Calculando o número de amostras necessário para representar a onda corretamente
        int numAmostras = (int) (duracao * sampleRate);

        // Intervalo de tempo entre cada amostra
        double deltaT = 1.0 / sampleRate;

        // Criando a matriz
        double[] matriz = new double[numAmostras];

        for (int i = 0; i < numAmostras; i++) {
            // Calculando o tempo para esta amostra
            double tempo = i * deltaT;
            // Calculando a onda quadrada
            double value = Math.abs(Math.sin(2 * Math.PI * frequencia * tempo + fase));
            System.out.println(tempo);
            matriz[i] = value;
        }
        return matriz;
    }


    @Override
    public void calcAnBn() {
        for (int i = 0; i < this.getNumeroHarmonicas(); i++) {
            double an = 0;
            double bn = i == 0 ? 0 : (1 / (2 * Math.PI)) * Math.sin(Math.PI - 2 * Math.PI * i);
            double An = 0; // TODO ?

            an = Double.isNaN(an) ? 0 : an;
            bn = Double.isNaN(bn) ? 0 : bn;
            An = Double.isNaN(An) ? 0 : An;

            an = (new BigDecimal(an).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            bn = (new BigDecimal(bn).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            An = (new BigDecimal(An).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();

            this.an[i] = an;
            this.bn[i] = bn;

            this.An[i] = An;
        }
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
