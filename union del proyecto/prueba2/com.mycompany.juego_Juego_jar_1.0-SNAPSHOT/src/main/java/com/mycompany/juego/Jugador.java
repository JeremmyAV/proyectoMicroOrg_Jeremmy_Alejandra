package com.mycompany.juego;

import java.awt.Color;
import java.util.Random;

public final class Jugador extends Organismo{
   private int energia;
   private int vision;
   private int velocidad;
   private int edad;
   private int filaActual; // variable para almacenar la fila actual del jugador
   private int columnaActual; // variable para almacenar la columna actual del jugador

   
   
    public Jugador(int energia, int vision, int velocidad, int edad){
        this.energia = energia;
        this.velocidad = velocidad;
        this.setEnergia(energia);
        this.setVision(vision);
        this.setVelocidad(velocidad);
        this.setEdad(edad);
    }

    public void setPosicioX(int x){
        this.columnaActual = x;
    }
    public void setPosicionY(int y){
        this.filaActual = y;
    }
    public int getFila(){
        return filaActual;
    }
    
    public int getColumna(){
        return columnaActual;
    }
    @Override
    public int getEnergia() {
        return energia;
    }

    @Override
    public void setEnergia(int energia) {
        if (energia < minEnergia) {
            this.energia = minEnergia;
        } else if (energia > maxEnergia) {
            this.energia = maxEnergia;
        } else {
            this.energia = energia;
        }
    }

    @Override
    public int getVision() {
        return vision;
    }

    @Override
    public void setVision(int vision) {
        if (vision < minVision) {
            this.vision = minVision;
        } else if (vision > maxVision) {
            this.vision = maxVision;
        } else {
            this.vision = vision;
        }
    }

    @Override
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int edad) {
        if (edad < minEdad) {
            this.edad = minEdad;
        } else if (edad > maxEdad) {
            this.edad = maxEdad;
        } else {
            this.edad = edad;
        }
    }

    @Override
    public int getMaxEnergia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMaxVision() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMaxVelocidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMaxEdad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMinEnergia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMinVision() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMinVelocidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMinEdad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTipo() {
        return "Jugador";
    }

   @Override
    public void setVelocidad(int velocidad) {
        if (velocidad < minVelocidad) {
            this.velocidad = minVelocidad;
        } else if (velocidad > maxVelocidad) {
            this.velocidad = maxVelocidad;
        } else {
            this.velocidad = velocidad;
        }
    }
    
    public boolean puedeMover(){ //valida si puede moverse
        int velTemp = this.velocidad;
        if(this.energia >= 1 && this.velocidad >= 1 ){
            //puede moverse
            return true; 
        }else{
            return false;} 
    }
    
  /*  public void mover(){
        if (puedeMover()){ // si se puede mover
            //quiero que me tome en cuenta la pos del jugador 
        }
    }*/
/*
    public boolean puedeMover(){ //valida si puede moverse
        int velTemp = this.velocidad;
        if(this.energia > 0 && this.velocidad >= 1 ){
            //puede moverse
            return "Puede moverse " +velTemp + " casillas" ; 
        }
        else{
            return "No puede moverse "; 
        }
        
    }*/
   @Override
    public int restarEnergia(){
        int energiaRes = energia-1;
        return energiaRes;
    }

    public void comerAlimento(int energiaAlimento, int velocidadAlimento, int visionAlimento) {
        this.energia += energiaAlimento;
        this.velocidad += velocidadAlimento;
        this.vision += visionAlimento;
        
    }

    public void comerMicro(int energiaMicro, int velocidadMicro, int visionMicro) {
        this.energia += energiaMicro;
        this.velocidad += velocidadMicro;
        this.vision +=visionMicro;        
        
    }

}
