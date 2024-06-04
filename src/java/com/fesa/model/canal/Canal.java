/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fesa.model.canal;

import com.fesa.model.onda.Onda;


public abstract class Canal {
    protected double freqInicial;
    protected double freqFinal;
    
    protected final int totalFreq = 100;
    
    public abstract double [] calcModuloFreqCanal(Onda onda);
    public abstract double [] calcFaseCanal(Onda onda);
    
}
