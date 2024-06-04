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
public class OndaQuadrada extends Onda {

    @Override
    public void calcAnBn() {
        // Calcula array an e bn e An
        for (int i = 0; i < this.getNumeroHarmonicas(); i++) {

            double an = 0;
            double bn = i % 2 == 0 ? 0 : 4 / (Math.PI * i);
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
        for (int i = 0; i < this.getNumeroHarmonicas(); i++) {
            double an = this.an[i];
            double bn = this.bn[i];
            if (an > 0) {
                this.fase[i] = Math.atan(bn / an);
            } else if ((an < 0 && bn >= 0) || (an < 0 && bn < 0)) {
                this.fase[i] = Math.atan(bn / an) + Math.toDegrees(Math.PI);
            } else if (an == 0 && bn > 0) {
                this.fase[i] = -(Math.toDegrees(Math.PI / 2));
            } else if (an == 0 && bn < 0) {
                this.fase[i] = Math.toDegrees(Math.PI / 2);
            } else {
                this.fase[i] = 0;
            }
        }
    }
}
