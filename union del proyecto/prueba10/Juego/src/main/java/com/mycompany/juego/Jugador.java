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
        return maxEnergia;
    }

    @Override
    public int getMaxVision() {
        return maxVision;
    }

    @Override
    public int getMaxVelocidad() {
        return maxVelocidad;
    }

    @Override
    public int getMaxEdad() {
        return maxEdad;
    }

    @Override
    public int getMinEnergia() {
        return minEnergia;
    }

    @Override
    public int getMinVision() {
        return minVision;
    }

    @Override
    public int getMinVelocidad() {
        return minVelocidad;
    }

    @Override
    public int getMinEdad() {
        return minEdad;
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
        if(this.energia > minEnergia ){
            //puede moverse
            return true; 
        }else{
            return false;} 
    }
    

    public int restarEnergia(){
        this.energia = this.energia - 1;
        if (this.energia <= minEnergia || this.energia >= maxEnergia){ // debe estar dentro del rango  
            setEnergia(this.energia);
        }
        return this.velocidad; 
    }
    
    public int restarVelocidad(int mov){ // se le indica la distancia y se le resta esa cantidad de movimientos a la velocidad
        this.velocidad = this.velocidad - mov;
        if (this.velocidad<= minVelocidad || this.velocidad>=maxVelocidad){ // debe estar dentro del rango  
            setVelocidad(this.velocidad);
        }
        return this.velocidad; 
    }
    
    public int incrementaEdad(){//incrementa la edad en cada turno
        this.edad = this.edad + 1; 
        this.vision = this.vision - 1;
        setVision(this.vision);
        if (this.edad <= minEdad || this.edad >= maxEdad){ // debe estar dentro del rango  
            setEdad(this.edad);
        }
        return this.edad;         
    }
    
    public void comerAlimento(int energiaAlimento, int velocidadAlimento, int visionAlimento) {
        if ((this.energia + energiaAlimento) <= maxEnergia)
        { this.energia += energiaAlimento;}
        else
        { this.energia = maxEnergia;}

        if ((this.velocidad + velocidadAlimento) <= maxVelocidad)
        { this.velocidad += velocidadAlimento;}
        else
        { this.velocidad = maxVelocidad;}

        if ((this.vision + visionAlimento) <= maxVision)
        { this.vision += visionAlimento;}
        else
        { this.vision = maxVision;}
        
    }

    public void comerMicro(int energiaMicro, int velocidadMicro, int visionMicro) {
        energiaMicro = energiaMicro/2;
        velocidadMicro = velocidadMicro/2;
        visionMicro =visionMicro/2;
        
        if ((energia + energiaMicro) <= maxEnergia)
        { this.energia += energiaMicro;}
        else
        { this.energia = maxEnergia;}

        if ((velocidad + velocidadMicro) <= maxVelocidad)
        { this.velocidad += velocidadMicro;}
        else
        { this.velocidad = maxVelocidad;}

        if ((vision + visionMicro) <= maxVision)
        { this.vision += visionMicro;}
        else
        { this.vision = maxVision;}
        
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

