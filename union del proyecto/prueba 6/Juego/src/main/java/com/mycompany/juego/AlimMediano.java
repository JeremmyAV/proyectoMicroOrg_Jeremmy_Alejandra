package com.mycompany.juego;
public class AlimMediano extends Alimento{
    
    public AlimMediano() {
        super( (int)(Math.random()*5+6), (int)(Math.random()*5+6), (int)(Math.random()*5+6));
    }
}
