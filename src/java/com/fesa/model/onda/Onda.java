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
 * @author 081210022
 */
public abstract class Onda {
    
    public Onda(){
        this.calcAnBn();
        this.calcFaseEntrada();
    }
    
    private final int numeroHarmonicas = 100;

    private int frequenciaFundamental;
    private String tipoCanal;
    
    protected double[] an = new double[this.numeroHarmonicas];
    protected double[] bn = new double[this.numeroHarmonicas];
    protected double[] An = new double[this.numeroHarmonicas];
    protected double[] fase = new double[this.numeroHarmonicas];

    public double[] getan() {
        return an;
    }

    public double[] getBn() {
        return bn;
    }

    public double[] getAn() {
        return An;
    }
    
    public double[] getFase(){
        return this.fase;
    }
        

    public int getNumeroHarmonicas() {
        return numeroHarmonicas;
    }
    
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
    
    // Gráficos principais
    public abstract double[] calcOndaEmitida();
    public abstract void calcAnBn();
    
    // Gráficos de Entrada
    public abstract void calcFaseEntrada();
   
    // Gráficos de Saída
    
    public double [] calcAmplitudeSaida(Canal canal){
        
        // Amplitude de saída = Amplitude Entrada * Modulo Canal
        
        double[] saida = new double[this.numeroHarmonicas];
        
        double[] modCanal = canal.calcModuloFreqCanal();
        
        for(int i = 0; i < this.numeroHarmonicas; i++){
            double value = this.An[i] * modCanal[i];
            value = Double.isNaN(value) ? 0 : value;
            value = (new BigDecimal(value).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            
            saida[i] = value;
        }
        return saida;
    }
    
    public double[] calcFaseSaida(Canal canal){
        // Fase de saída = Fase Entrada + Fase do Canal
        
        double[] saida = new double[this.numeroHarmonicas];
        
        double[] faseCanal = canal.calcFaseCanal();
        
        for(int i = 0; i < this.numeroHarmonicas; i++){
            
            if(fase[i] == 0){
                saida[i] = 0;
                continue;
            }
            double value = this.fase[i] + faseCanal[i];
            
            value = Double.isNaN(value) ? 0 : value;
            value = (new BigDecimal(value).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            
            saida[i] = value;
        }
        return saida;
    }
    public abstract double[] calcOndaRecebida();
}
