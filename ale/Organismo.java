package com.mycompany.juego;

public abstract class Organismo {

    // Variables
    static final int maxEnergia = 100;
    static final int maxVision = 10;
    static final int maxVelocidad = 10;
    static final int  maxEdad = 30;

    static final int minEnergia = 0;
    static final int  minVision = 1;
    static final int  minVelocidad = 1;
    static final int  minEdad = 0;

    //Metodos
    public abstract int getEnergia();
    public abstract void setEnergia(int energia);
    public abstract int getVision();
    public abstract void setVision(int vision);
    public abstract int getVelocidad();
    public abstract int getEdad();
    public abstract void setEdad(int edad);
    public abstract int getMaxEnergia();
    public abstract int getMaxVision();
    public abstract int getMaxVelocidad();
    public abstract int getMaxEdad();
    public abstract int getMinEnergia();
    public abstract int getMinVision();
    public abstract int getMinVelocidad();
    public abstract int getMinEdad();
    public abstract String getTipo();


}
