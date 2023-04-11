package com.mycompany.juego;
import com.mycompany.juego.Mapa;
//package com.mycompany.juego;

import java.awt.Color;
import java.util.Random;

public final class Jugador extends Organismo{
   private int energia;
   private int vision;
   private int velocidad;
   private int edad;
   private int filaActual; // variable para almacenar la fila actual del jugador
   private int columnaActual; // variable para almacenar la columna actual del jugador

   private int esJug = 1;
   
   
    public Jugador(int energia, int vision, int velocidad, int edad, int tempColumna, int tempFila){
        this.energia = energia;
        this.velocidad = velocidad;
        this.setEnergia(energia);
        this.setVision(vision);
        this.setVelocidad(velocidad);
        this.setEdad(edad);

        filaActual = tempFila;
        columnaActual = tempColumna;

        tipo = "jugador";
        esJug = 1;

    }

    public void setPosicionX(int x){
        this.filaActual = x;
    }
    public void setPosicionY(int y){
        this.columnaActual = y;
    }
    public int getFila(){
        return this.filaActual;
    }
    
    public int getColumna(){
        return this.columnaActual;
    }
    @Override
    public int getEnergia() {
        return this.energia;
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
        return this.vision;
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
        return this.velocidad;
    }

    @Override
    public int getEdad() {
        return this.edad;
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
        return "jugador";
    }

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
    
    public void mover(){
        if (puedeMover()){ // si se puede mover
            //quiero que me tome en cuenta la pos del jugador 
        }
    }
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
 
    public int restarEnergia(){
       int energiaRes = this.energia - 1;
        return energiaRes;
    }
    
    public int restarVelocidad(int mov){
       int velRes = this.velocidad - mov;
        return velRes;
    }

    public void comerAlimento(int energiaAlimento, int velocidadAlimento, int visionAlimento) {
        this.energia += energiaAlimento;
        this.velocidad += velocidadAlimento;
        this.vision += visionAlimento;
        
    }

    public void comerMicro(int energiaMicro, int velocidadMicro, int visionMicro) {
        energiaMicro = energiaMicro/2;
        velocidadMicro = velocidadMicro/2;
        visionMicro =visionMicro/2;
        
        this.energia += energiaMicro;
        this.velocidad += velocidadMicro;
        this.vision +=visionMicro;        
        
    }

    public void setTempMapa(Mapa TM)
    {
       Mapa tempMapa = TM;
    }

    @Override
    public int getPosX() {
        return filaActual;
    }

    @Override
    public int getPosY() {
        return columnaActual;
    }

    @Override
    public int getBuscPosX() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBuscPosX'");
    }

    @Override
    public int getBuscPosY() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBuscPosY'");
    }

    @Override
    public void vaciarCordBuscar(Mapa tempMapa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vaciarCordBuscar'");
    }

    @Override
    public void consAlim(int enA, int viA, int veA) {
        // TODO Auto-generated method stub
    }

    @Override
    public void cambiarBuscarCorden(int nuevoBuscPosX, int nuevoBuscPosY) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarBuscarCorden'");
    }

    @Override
    public int[] mover(Mapa temMapa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mover'");
    }

    @Override
    public void actualizarCoord(int tempX, int tempY) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarCoord'");
    }

    @Override
    public void Imprimir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Imprimir'");
    }

   @Override
    public int valEsJug()
    {
        return esJug;
    }

}

