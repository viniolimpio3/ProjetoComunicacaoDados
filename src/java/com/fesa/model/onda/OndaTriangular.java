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
public class OndaTriangular extends Onda {
    @Override
    public double[] calcOndaEmitida() {
        double frequencia = this.getFrequenciaFundamental(); // Frequência da onda em Hz
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
        for (int i = 0; i < this.getNumeroHarmonicas(); i++) {
            double an = 0;
            double bn = i % 2 == 0 ? 0 : (8/(Math.pow(Math.PI, 2) * Math.pow(i, 2))) * Math.pow(-1, (i-1) / 2);
            double An = i % 2 == 0 ? 0 : (8/(Math.pow(Math.PI, 2) * Math.pow(i, 2)));

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
            if(((i - 1)/ 2) % 2 == 0){
                this.fase[i] = -(Math.toDegrees(Math.PI / 2)); 
            } else {
                this.fase[i] = Math.toDegrees(Math.PI / 2);
            }
        }
    }

    @Override
    public double[] calcOndaRecebida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
