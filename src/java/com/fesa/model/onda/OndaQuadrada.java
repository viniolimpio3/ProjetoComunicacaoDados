/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fesa.model.onda;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author vinio
 */
public class OndaQuadrada extends Onda {

    //TODO: Review
    public double[] calcOndaEmitida() {
        double frequencia = this.getFrequenciaFundamental();

        // Parâmetros da onda
        double fase = 0; // Fase inicial da onda

        // Duração da onda em segundos
        double duracao = 1; // 1 segundo

        // Taxa de amostragem (samples per second)
        int sampleRate = 10000; // Taxa de amostragem padrão para áudio

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
            double value = Math.signum(Math.sin(2 * Math.PI * frequencia * (tempo + fase)));
            matriz[i] = value;
        }
        return matriz;
    }

    @Override
    public double[] calcOndaRecebida() {
        // TODO: David
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void calcAnBn() {
        // Calcula array an e bn e An
        for (int i = 0; i < this.getNumeroHarmonicas(); i++) {

            double an = 0;
            double bn = i % 2 == 0 ? 0 : 4 / (Math.PI * i);
            double An = Math.sqrt(Math.pow(an, 2) + Math.pow(bn, 2));

            
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
        for (int i = 0; i < this.getNumeroHarmonicas(); i++) {
            double an = this.an[i];
            double bn = this.bn[i];
            if (an > 0) {
                this.fase[i] = Math.atan(bn / an);
            } else if ((an < 0 && bn >= 0) || (an < 0 && bn < 0)) {
                this.fase[i] = Math.atan(bn / an) + Math.toDegrees(Math.PI);
            } else if (an == 0 && bn > 0) {
                this.fase[i] = -(Math.toDegrees(Math.PI / 2));
            } else if (an == 0 && bn < 0) {
                this.fase[i] = Math.toDegrees(Math.PI / 2);
            } else {
                this.fase[i] = 0;
            }
        }
    }

}
