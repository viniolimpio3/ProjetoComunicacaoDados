/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fesa.model.canal;


public abstract class Canal {
    protected int freqInicial;
    protected int freqFinal;
    
    protected final int totalFreq = 100;
    
    public abstract double [] calcModuloFreqCanal();
    public abstract double [] calcFaseCanal();
    
}
