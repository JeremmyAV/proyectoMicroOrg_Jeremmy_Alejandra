package com.mycompany.juego;

public abstract class Organismo{
    private Posicion pos;
    private Posicion anterior;
    private boolean comido;
    private int tipo;
    
    public abstract String getTipo();   
    
    
 // Variables
    static final int maxEnergia = 100;
    static final int maxVision = 10;
    static final int maxVelocidad = 10;
    static final int  maxEdad = 30;

    static final int minEnergia = 0;
    static final int  minVision = 1;
    static final int  minVelocidad = 1;
    static final int  minEdad = 0;
    
// Metodos abstractos

// Energia

    public abstract int getEnergia();
    public abstract int restarEnergia();
    public abstract void setEnergia(int energia);
    
// Vision    
    public abstract int getVision();
    public abstract void setVision(int vision);

// Velocidad

    public abstract int getVelocidad();
    public abstract void setVelocidad(int velocidad);
// Edad
    public abstract int getEdad();
    public abstract void setEdad(int edad);

// Maximos y minimos 

    public abstract int getMaxEnergia();
    public abstract int getMaxVision();
    public abstract int getMaxVelocidad();
    public abstract int getMaxEdad();
    public abstract int getMinEnergia();
    public abstract int getMinVision();
    public abstract int getMinVelocidad();
    public abstract int getMinEdad();    

// Constructor
    
  /*  public Organismo(int tipo, Posicion pos){
        this.pos = pos;
        comido = false;
        this.tipo = tipo;
    }*/
    
    public void actualizarPos(){
        anterior = new Posicion(pos.posX, pos.posY);
    }
    public void actualizarPos(Posicion pos){
        anterior = pos;
    }   
    
    public Posicion getPos(){
        return pos;
    }
    
    public void setPos(Posicion pos){
        this.pos = pos;
    }
    
    public boolean esComido(){
        return comido;
    }
    

    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    
    public Posicion getAnterior(){
        return anterior;
    }
    public void setAnterior(Posicion anterior){
        this.anterior = anterior;
    }
 
}