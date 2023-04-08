//package com.mycompany.juego;

public final class MicroorganismoNPC extends Organismo {

    private int energia, vision, velocidad, edad;   
    //private Posicion posX;
    //private Posicion posY;
    private int posY;
    private int posX;
    private int BuscPosX;
    private int BuscPosY;
    
    public MicroorganismoNPC(int energia, int vision, int velocidad, int edad) {
        this.setEnergia(energia);
        this.setVision(vision);
        this.setVelocidad(velocidad);
        this.setEdad(edad);


    }
    
    
    public void cambiarBuscarCorden(int nuevoBuscPosX, int nuevoBuscPosY)
    {
        BuscPosX = nuevoBuscPosX;
        BuscPosY = nuevoBuscPosY;
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


    public void setVelocidad(int velocidad) {
        if (velocidad < minVelocidad) {
            this.velocidad = minVelocidad;
        } else if (velocidad > maxVelocidad) {
            this.velocidad = maxVelocidad;
        } else {
            this.velocidad = velocidad;
        }
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
    public String getTipo(){
        return "Microorganismo";
    }
// otros metodos importantes:


    public int restarEnergia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
