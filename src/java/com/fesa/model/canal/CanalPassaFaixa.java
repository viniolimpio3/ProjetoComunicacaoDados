package com.fesa.model.canal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author vinio
 */
public class CanalPassaFaixa extends Canal {
    
    public CanalPassaFaixa(int freqInicial, int freqFinal){
        //
        this.freqInicial = freqInicial * 1000;
        this.freqFinal = freqFinal * 1000;
    }

    @Override
    public double[] calcModuloFreqCanal() {
        double[] matriz = new double[this.totalFreq];
        
        
        double value;
        for(int i=0; i < this.totalFreq; i++){
            
            i *= 1000;
            
            value = (1 / freqInicial) * (i / Math.sqrt((1 + Math.pow((i / freqInicial), 2)) * (1 + Math.pow((i / freqFinal), 2))));
            
            System.out.println("aModulo> " + value + " i> " + i + " ini> " + this.freqInicial + " f>" + this.freqFinal);
            
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
            double value = -90 - Math.atan((i * (this.freqInicial + this.freqFinal)) / (this.freqInicial * this.freqFinal - Math.pow(i, 2)));
            value = Double.isNaN(value) ? 0 : value;
            
            value = (new BigDecimal(value).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            matriz[i / 1000] = value;
        }
        
        return matriz;
    }
    
}
