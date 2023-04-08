
//package com.mycompany.juego;

public class Posicion{
    public int posX;
    public int posY;
    
    public Posicion(int x, int y){
        posX = x;
        posY = y;
    }
    
    public boolean esCorrecta(){
        if(posX<0||posY<0||posX>24 ||posY>24){
            return false;
        }
        else{
            return true;
        }
    }
}

