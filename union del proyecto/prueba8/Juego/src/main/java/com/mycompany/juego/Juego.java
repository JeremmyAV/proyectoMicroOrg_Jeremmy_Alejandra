package com.mycompany.juego;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Juego {

    public static Mapa mapa1 = new Mapa(50, 50, 10);
    public static Jugador jugador = new Jugador(10, 5, 10, 1, 5, 5);
    public static Interfaz gui;
    public static int filaSeleccionada;
    public static int columnaSeleccionada;
    public static int juegoTerminado = 0;
    public Organismo organismo;
    
    
    public static void main(String[] args) {
        JTextArea textArea = new JTextArea();
        mapa1. rellenarCasilla(jugador.getFila(), jugador.getColumna(), jugador);
        mapa1.crearMicro();
        mapa1.crearVariosAlim(20);
        

        gui = new Interfaz(50, mapa1, textArea);
        
        mapa1.imprimir();

    }

    public static void moverMicrorganismos()
        {
        mapa1.imprListaDeMicrorg();
        int cordPorMover[];
        for (int p = 0; p < mapa1.getMaximoMicroO(); p++)
        {
            if (mapa1.orgRestantesLista() == 1)
            {
                int[] orgPorMover = mapa1.getListaMicro(p);

                if (orgPorMover != null)
                {
                    Organismo tempOrgMover = mapa1.getCasilla(orgPorMover[0], orgPorMover[1]);

                    cordPorMover = tempOrgMover.mover(mapa1);
                    System.out.println("coordenadas a mover de microOrg");
                    System.out.println(cordPorMover[0]);
                    System.out.println(cordPorMover[1]);

                    int loQueComio = mapa1.rellenarCasilla(cordPorMover[0], cordPorMover[1], tempOrgMover);
                    if (loQueComio == 1)
                    {
                        System.out.println("El juego finalizo, perdiste");
                        int respuesta = JOptionPane.showOptionDialog(null, "El juego finalizo, perdiste \n Desea salir del juego? " , " cerrar programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);
                        juegoTerminado = 1;
                        gui.actualizarMatriz(mapa1);
                        if (respuesta == JOptionPane.YES_OPTION)
                        {
                            System.exit(0);
                        }
                        mapa1.vaciarCasilla(orgPorMover[0], orgPorMover[1]);
                        break;
                    }
                    else if (loQueComio == 2)
                    {
                        mapa1.crearAlimento();
                    }
                    
                    if (loQueComio == 3)
                    {
                        Juego.mapa1.vaciarCasilla(orgPorMover[0], orgPorMover[1]);
                    }
                    else
                    {
                        mapa1.vaciarCasilla(orgPorMover[0], orgPorMover[1]);
                        tempOrgMover.actualizarCoord(cordPorMover[0], cordPorMover[1]);
                        mapa1.actuaCordLista(orgPorMover[0], orgPorMover[1], cordPorMover);
                        if ((tempOrgMover.getBuscPosX() == tempOrgMover.getPosX()) && (tempOrgMover.getBuscPosY() == tempOrgMover.getPosY()))
                                tempOrgMover.vaciarCordBuscar(mapa1);
                    }
                }
            }
            else 
            {
                System.out.println("Felicidades, GANASTE");
                int respuesta = JOptionPane.showOptionDialog(null, "Lograste comerte los demas organismos. \n Desea salir del juego? ", " GANASTE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);
                juegoTerminado = 1;
                gui.actualizarMatriz(mapa1);
                if (respuesta == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
                break;
            }
        }

        gui.actualizarMatriz(mapa1);
        mapa1.imprimir(); 
        
    }
}
