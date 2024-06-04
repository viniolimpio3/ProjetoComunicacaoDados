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
            double _an = 0;
            
            // TODO: Incorreto!
            double _bn = i == 0 ? 0 : (1 / (2 * Math.PI)) * Math.sin(Math.PI - 2 * Math.PI * ((double)i));
            double _An = _bn;

            //
            _an = Double.isNaN(_an) ? 0 : _an;
            _bn = Double.isNaN(_bn) ? 0 : _bn;
            _An = Double.isNaN(_An) ? 0 : _An;

//            _an = (new BigDecimal(_an).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
//            _bn = (new BigDecimal(_bn).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();
//            _An = (new BigDecimal(_An).setScale(6, RoundingMode.HALF_EVEN)).doubleValue();

            this.an[i] = _an;
            this.bn[i] = _bn;

            this.An[i] = _An;
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
