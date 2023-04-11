package com.mycompany.juego;

import java.util.Map;

public class Alimento extends Organismo {
    
    private int enerAlim;
    private int visionAlim;
    private int velocAlim;

    // genera los atributos del alimento
    public Alimento( int enA,  int veA, int viA)
    {
        enerAlim = enA;
        tipo = "alimento";

        visionAlim = viA;
        velocAlim = veA;

    }


    public void Imprimir()
    {
        System.out.println(enerAlim);
    }

    public int getEnergia()
    {
        return enerAlim;
    }

    public int getVelocidad()
    {
        return velocAlim;
    }

    public int getVision()
    {
        return visionAlim;
    }

    public int getEdad()
    {
        return 0;
    }
    public int getPosX()
    {
        return 0;
    }

    public int getPosY()
    {
        return 0;
    } 

    public int getBuscPosX()
    {
        return 0;
    }
    public int getBuscPosY()
    {
        return 0;
    }
    public void vaciarCordBuscar(Mapa tempMapa)
    {
    }

    public void consAlim(int enA, int viA, int veA)
    {
    }
    public void cambiarBuscarCorden(int nuevoBuscPosX, int nuevoBuscPosY)
    {
    }
    public void actualizarCoord(int tempX, int tempY)
    {
    }

    public int[] mover(Mapa temMapa)
    {
        int tempSalida[];
        tempSalida = new int[2];
        tempSalida[0] = 1;
        tempSalida[1] = 1;
        return tempSalida;
    }

    public int valEsJug()
    {
        return 0;
    }

    //minimos y maximos

    @Override
    public String getTipo(){
        return "Alimento";
    }



    @Override
    public void setEnergia(int energia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setVision(int vision) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEdad(int edad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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


}
