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
public class OndaSenoidalRetificada extends Onda {

    @Override
    public void calcAnBn() {
        for (int i = 0; i < this.getNumeroHarmonicas(); i++) {
            double an = 0;
            double bn = i == 0 ? 0 : (1 / (2 * Math.PI)) * Math.sin(Math.PI - 2 * Math.PI * i);
            double An = bn;

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
            if(i >= 1){
                this.fase[i] = Math.toDegrees(Math.PI / 2);
            } else {
                this.fase[i] = 0; 
            }
        }
    }
}
