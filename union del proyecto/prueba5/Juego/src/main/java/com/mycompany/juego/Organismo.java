package com.mycompany.juego;
public abstract class Organismo {
    String tipo;
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
    public abstract void setEnergia(int energia);
    public abstract void setVision(int vision);
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


    public abstract int getEnergia();
    public abstract int getVelocidad();
    public abstract int getVision() ;
    public abstract int getEdad();
    public abstract int getPosX(); 
    public abstract int getPosY(); 
    public abstract int getBuscPosX();
    public abstract int getBuscPosY();
    public abstract void vaciarCordBuscar(Mapa tempMapa);
    public abstract void consAlim(int enA, int viA, int veA);
    public abstract void cambiarBuscarCorden(int nuevoBuscPosX, int nuevoBuscPosY);
    public abstract int[] mover(Mapa temMapa);
    public abstract void actualizarCoord(int tempX, int tempY);
    public abstract void Imprimir();

    public abstract int valEsJug();
}

