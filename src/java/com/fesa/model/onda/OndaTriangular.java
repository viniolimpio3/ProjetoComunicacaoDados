/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fesa.model.onda;

import com.fesa.model.canal.Canal;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author vinio
 */
public class OndaTriangular extends Onda {

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
    public double[] calcOndaRecebida(Canal canal){
        double [] tempo = new double[10000];
        double temp = 0; 
        for(int i = 0; i < 10000; i++){
            tempo[i] = temp;
            temp += .0001;
        }
        double[] saida = new double[tempo.length];
        
        double [] AN_Saida = this.calcAmplitudeSaida(canal);
        double [] FaseSaida = this.calcFaseSaida(canal);
        
        for(int j=0; j < tempo.length; j++){
            double value =0;
            for (int i = 0; i < this.getNumeroHarmonicas(); i++) {
                value += AN_Saida[i] * Math.cos(2 * Math.PI * this.getFrequenciaFundamental() * i * tempo[j] + Math.toRadians(FaseSaida[i]));
            }
            value = Double.isNaN(value) ? 0 : value;
            value = (new BigDecimal(value).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
            
            saida[j] = value; 
        }
        return saida;
    }

}
