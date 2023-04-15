package com.mycompany.juego;

public class AlimPeque extends Alimento{
    
    
    public AlimPeque() {
        super((int)(5*Math.random()+1), (int)(Math.random()*5+1), (int)(Math.random()*5+1));
    }
    

    
}
