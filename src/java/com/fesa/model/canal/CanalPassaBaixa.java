package com.fesa.model.canal;

import com.fesa.model.onda.Onda;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author vinio
 */
public class CanalPassaBaixa extends Canal {

    public CanalPassaBaixa(double freqCorte){
        this.freqInicial = freqCorte * 1000; // kHz
    }
    @Override
    public double[] calcModuloFreqCanal(Onda onda) {
        double[] matriz = new double[this.totalFreq];
        
        for(int i=0; i < this.totalFreq; i++){
            
            double f = onda.getFrequenciaFundamental() * i * 1000;
            
            double value = 1 / Math.sqrt((1 + Math.pow(f / this.freqInicial, 1)));
            value = Double.isNaN(value) ? 0 : value;
            
            value = (new BigDecimal(value).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            matriz[i] = value;
        }
        
        return matriz;
    }

    @Override
    public double[] calcFaseCanal(Onda onda) {
        double[] matriz = new double[this.totalFreq];
        
        for(int i=0; i < this.totalFreq; i++){
            
            double f = onda.getFrequenciaFundamental() * i * 1000;
            
            double value = Math.toDegrees(Math.atan(-(f / this.freqInicial)));
            value = Double.isNaN(value) ? 0 : value;
            
            value = (new BigDecimal(value).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            matriz[i] = value;
        }
        
        return matriz;
    }
}
