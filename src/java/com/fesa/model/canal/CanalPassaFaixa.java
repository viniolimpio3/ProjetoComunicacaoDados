package com.fesa.model.canal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author vinio
 */
public class CanalPassaFaixa extends Canal {
    
    public CanalPassaFaixa(double freqInicial, double freqFinal){
        //
        this.freqInicial = freqInicial * 1000;
        this.freqFinal = freqFinal * 1000;
    }

    @Override
    public double[] calcModuloFreqCanal() {
        double[] matriz = new double[this.totalFreq];
        
        
        double value;
        for(int i=0; i < this.totalFreq; i++){
            
            int f = i * 1000;
            
            value = (1 / freqInicial) * (f / Math.sqrt((1 + Math.pow((f / freqInicial), 2)) * (1 + Math.pow((f / freqFinal), 2))));
            
            System.out.println("aModulo> " + value + " f> " + f + " ini> " + freqInicial + " f>" + freqFinal);
            
            value = Double.isNaN(value) ? 0 : value;
            
            value = (new BigDecimal(value).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            matriz[i] = value;
        }   
        
        return matriz;
    }

    @Override
    public double[] calcFaseCanal() {
        double[] matriz = new double[this.totalFreq];
        
        for(int i=0; i < this.totalFreq; i++){
            double f = i * 1000;
            double value = Math.toDegrees(Math.toRadians(-90) - Math.atan((f * (this.freqInicial + this.freqFinal)) / (this.freqInicial * this.freqFinal - Math.pow(f, 2))));
            value = Double.isNaN(value) ? 0 : value;
            
            value = (new BigDecimal(value).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            matriz[i] = value;
        }
        
        return matriz;
    }
    
}
