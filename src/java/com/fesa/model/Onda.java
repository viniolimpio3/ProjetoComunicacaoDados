/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fesa.model;

import java.util.HashMap;

/**
 *
 * @author 081210022
 */
public abstract class Onda {
    private final int numeroHarmonicas = 50;
    private int frequenciaFundamental;
    private String tipoCanal;

    public int getFrequenciaFundamental() {
        return frequenciaFundamental;
    }

    public void setFrequenciaFundamental(int frequenciaFundamental) {
        this.frequenciaFundamental = frequenciaFundamental;
    }

    public String getTipoCanal() {
        return tipoCanal;
    }

    public void setTipoCanal(String tipoCanal) {
        this.tipoCanal = tipoCanal;
    }      
    
    public abstract double[] calcOndaEmitida();
    public abstract HashMap<Long, Double> calcOndaRecebida();
    
}
