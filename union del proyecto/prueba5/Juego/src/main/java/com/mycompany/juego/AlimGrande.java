package com.mycompany.juego;

public class AlimGrande extends Alimento{
    public AlimGrande() {
        super( (int)(Math.random()*5+11), (int)(Math.random()*5+11), (int)(Math.random()*5+11));
    }
}
