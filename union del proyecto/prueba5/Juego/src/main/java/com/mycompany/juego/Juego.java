package com.mycompany.juego;

import javax.swing.JOptionPane;

public class Juego {

    public static Mapa mapa1 = new Mapa(15, 15, 5);
    public static Jugador jugador = new Jugador(10, 3, 2, 1, 5, 5);
    public static Interfaz gui;
    public static int filaSeleccionada;
    public static int columnaSeleccionada;
    public static int juegoTerminado = 0;
    public Organismo organismo;
    
    public static void main(String[] args) {

        mapa1. rellenarCasilla(jugador.getFila(), jugador.getColumna(), jugador);
        mapa1.crearMicro();
        mapa1.crearVariosAlim(10);

        gui = new Interfaz(15 , mapa1);
        
        mapa1.imprimir();

    }
    
    public static void moverMicrorganismos()
        {
        mapa1.imprListaDeMicrorg();
        int cordPorMover[];
        for (int p = 0; p < mapa1.getMaximoMicroO(); p++)
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
                    System.out.println("el juego finalizo, estas murido");
                    int respuesta = JOptionPane.showOptionDialog(null, "el juego finalizo, estas murido " , " cerrar programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);
                    juegoTerminado = 1;
                    gui.actualizarMatriz(mapa1);
                    break;
                }
                else if (loQueComio == 2)
                {
                    //mapa1.crearAlimento();
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

        gui.actualizarMatriz(mapa1);
        mapa1.imprimir(); 
        
    }
}
