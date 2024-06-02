package com.fesa.model.canal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author vinio
 */
public class CanalPassaBaixa extends Canal {

    public CanalPassaBaixa(int freqCorte){
        this.freqInicial = freqCorte * 1000; // kHz
    }
    @Override
    public double[] calcModuloFreqCanal() {
        double[] matriz = new double[this.totalFreq];
        
        for(int i=0; i < this.totalFreq; i++){
            
            i *= 1000;
            
            double value = 1 / Math.sqrt((1 + Math.pow(i / this.freqInicial, 1)));
            value = Double.isNaN(value) ? 0 : value;
            
            value = (new BigDecimal(value).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            matriz[i / 1000] = value;
        }
        
        return matriz;
    }

    @Override
    public double[] calcFaseCanal() {
        double[] matriz = new double[this.totalFreq];
        
        for(int i=0; i < this.totalFreq; i++){
            
            i *= 1000;
            
            double value = Math.atan(-(i / this.freqInicial));
            value = Double.isNaN(value) ? 0 : value;
            
            value = (new BigDecimal(value).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            matriz[i / 1000] = value;
        }
        
        return matriz;
    }
}
