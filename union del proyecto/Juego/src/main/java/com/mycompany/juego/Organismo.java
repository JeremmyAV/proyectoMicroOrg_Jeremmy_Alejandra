package com.mycompany.juego;

import static com.mycompany.juego.Casilla.columna;
import static com.mycompany.juego.Casilla.columnaSeleccionada;
import static com.mycompany.juego.Casilla.fila;
import static com.mycompany.juego.Casilla.filaSeleccionada;
import static com.mycompany.juego.Casilla.posX;
import static com.mycompany.juego.Casilla.posY;
import static com.mycompany.juego.Interfaz.matriz;
import static com.mycompany.juego.Juego.mapa1;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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
    
    public void moverJugador(JButton botonClicado) {      
       for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == botonClicado) {
                    filaSeleccionada = i;
                    columnaSeleccionada = j;
                    break;
                }
           }
        }     
        posX = Juego.jugador.getFila();
        posY = Juego.jugador.getColumna(); 

        //calculo de la distancia entre la pos inicial y la cliqueada
        double distancia = Math.sqrt(Math.pow(filaSeleccionada - posX, 2) + Math.pow(columnaSeleccionada - posY, 2));
        int distanciaIn = (int) Math.round(distancia);

        if ((fila == posX) || (columna == posY))
        {
            if (Juego.turno == 1) {
                if (distancia <= Juego.jugador.getVelocidad() && Juego.jugador.getEnergia()>0){
                    if("".equals(botonClicado.getText())){ //la casilla esta vacia
                        System.out.println("se puede mover");
                        System.out.println("Distancia recorrida: " + distanciaIn);
                        System.out.println("Velocidad: "+ Juego.jugador.getVelocidad());

                        int respuesta = JOptionPane.showOptionDialog(null, "Deseas moverte " + distanciaIn + " casillas?", "Confirmar movimiento", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);

                        if (respuesta == JOptionPane.YES_OPTION) {    
                        Juego.jugador.restarEnergia();
                        Juego.jugador.restarVelocidad(distanciaIn);
                        System.out.println(Juego.jugador.getEnergia());
                        System.out.println(Juego.jugador.getVelocidad());
                        botonClicado.setBackground(Color.RED);
                        botonClicado.setText("J");

                        mapa1.vaciarCasilla(Juego.jugador.getPosX(), Juego.jugador.getPosY());

                        Juego.jugador.setPosicionX(filaSeleccionada);
                        Juego.jugador.setPosicionY(columnaSeleccionada);

                        matriz[posX][posY].setText("");
                        matriz[posX][posY].setForeground(Color.WHITE);
                        matriz[posX][posY].setBackground(Color.WHITE);

                        posX = Juego.jugador.getFila();
                        posY = Juego.jugador.getColumna();

                        mapa1.vaciarCasilla(Juego.jugador.getPosX(), Juego.jugador.getPosY());
                        mapa1.rellenarCasilla(Juego.jugador.getPosX(), Juego.jugador.getPosY(), Juego.jugador);
                        
                        //Juego.turno = 2;
                        }
                                        
                    }
                }
            }
        }
    } // mientras !!! esto es de prueba la otra parte del codigo lo tengo guardado es para ver si funciona el metodo


}

