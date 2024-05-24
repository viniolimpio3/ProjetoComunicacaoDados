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
public class OndaDenteDeSerra extends Onda {
    @Override
    public double[] calcOndaEmitida() {
        int N = 200;
        double[] points = new double[N];
        
        
        int period = N / this.getFrequenciaFundamental(); // Adjust the period of the wave
        double step = 2.0 / period; // Step size to ensure the wave increases linearly

        for (int i = 0; i < N; i++) {
            points[i] = (i % period) * step;
        }

        return points;

    }
    
    @Override
    public HashMap<Long, Double> calcOndaRecebida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
