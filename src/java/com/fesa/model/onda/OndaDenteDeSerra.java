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
public class OndaDenteDeSerra extends Onda {

    public double[] calcOndaEmitida() {
        int N = 10000; // Número total de amostras
        double[] points = new double[N];

        double frequencia = this.getFrequenciaFundamental(); // Frequência da onda em Hz
        double periodo = (double) N / (frequencia * 2); // Período da onda em número de amostras
        double step = 1.0 / (periodo - 1); // Tamanho do passo para garantir que a onda aumenta linearmente até 1

        for (int i = 0; i < N; i++) {
            points[i] = (i % periodo) * step;
        }

        return points;
    }

    @Override
    public void calcAnBn() {
        for (int i = 0; i < this.getNumeroHarmonicas(); i++) {
            double an = 0;
            double bn = i <= 0 ? 0 : Math.pow(2/(Math.PI * i) * (-1), i + 1);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double[] calcOndaRecebida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
