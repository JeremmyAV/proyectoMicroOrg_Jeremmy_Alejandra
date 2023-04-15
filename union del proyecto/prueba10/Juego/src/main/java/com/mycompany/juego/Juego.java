package com.mycompany.juego;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Juego {

    public static Mapa mapa1 = new Mapa(15, 15, 10);
    public static Jugador jugador = new Jugador(10, 5, 10, 1, 0, 0);
    public static Interfaz gui;
    public static int filaSeleccionada;
    public static int columnaSeleccionada;
    public static int juegoTerminado = 0;
    public Organismo organismo;
    
    
    public static void main(String[] args) {
        JTextArea textArea = new JTextArea();
        JTextArea textArea2 = new JTextArea();
        mapa1. rellenarCasilla(jugador.getFila(), jugador.getColumna(), jugador);

        mapa1.crearMicro();
        mapa1.crearVariosAlim(5);
        

        gui = new Interfaz(15, mapa1, textArea, textArea2);
        
        mapa1.imprimir();

    }

    public static void moverMicrorganismos(){

        String organismoMovido = null;
               
        mapa1.imprListaDeMicrorg();
        int cordPorMover[] = null;
        for (int p = 0; p < mapa1.getMaximoMicroO(); p++)
        {
            if (mapa1.orgRestantesLista() == 1)
            {
                int[] orgPorMover = mapa1.getListaMicro(p);

                if (orgPorMover != null)
                {
                    Organismo tempOrgMover = mapa1.getCasilla(orgPorMover[0], orgPorMover[1]);
                    organismoMovido = tempOrgMover.tipo;
                    System.out.println("antes de mover");
                    cordPorMover = tempOrgMover.mover(mapa1);
                    System.out.println("coordenadas a mover de microOrg");
                    System.out.println(cordPorMover[0]);
                    System.out.println(cordPorMover[1]);                  
                    
                    System.out.println("se movioooo un " + organismoMovido);
                    System.out.println("a la casilla (x,y) "+ cordPorMover[0]+" "+ cordPorMover[1]);
                    int loQueComio = mapa1.rellenarCasilla(cordPorMover[0], cordPorMover[1], tempOrgMover);
                    
                                      
                    if (loQueComio == 1)
                    {
                        int energiaGanador = mapa1.getCasilla(cordPorMover[0], cordPorMover[1]).getEnergia() ; 
                        int visionGanador = mapa1.getCasilla(cordPorMover[0], cordPorMover[1]).getVision(); 
                        int velocidadGanador = mapa1.getCasilla(cordPorMover[0], cordPorMover[1]).getVelocidad();
                        int edadGanador = mapa1.getCasilla(cordPorMover[0], cordPorMover[1]).getEdad();
                        int x = mapa1.getCasilla(cordPorMover[0], cordPorMover[1]).getBuscPosX();
                        int y = mapa1.getCasilla(cordPorMover[0], cordPorMover[1]).getBuscPosY();

                        String energiaG = ("Energia: "+ energiaGanador);
                        String visionG = ("Vision: "+ visionGanador);
                        String velG = ("Velocidad: "+ velocidadGanador);
                        String edadG = ("Edad: "+ edadGanador);
                       // String posicion = ("("+ x + "," + y + ")");                       
                        
                        
                        
                        System.out.println("El juego finalizo, perdiste");
                        String mensajeG =("Microorganismo ganador:\n" + energiaG + "\n" + visionG + "\n" + velG + "\n"+ edadG);
                        JOptionPane.showMessageDialog(null, "Perdiste! Un microorganismo te acaba de comer\n" + mensajeG);

                        int respuesta = JOptionPane.showOptionDialog(null, "4El juego finalizo, perdiste \n Desea salir del juego? " , " cerrar programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);
                        juegoTerminado = 1;
                        String perdiste = "PERDISTE!";
                        gui.setSentencesInTextAreaMicro(perdiste);
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
                        String texto = "    Se creo un alimento ";
                        gui.setSentencesInTextAreaMicro(texto);
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
                String Ganador = "GANASTE!";
                gui.setSentencesInTextAreaMicro(Ganador);
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
        if (cordPorMover != null)
        {
            String infoOrganismo = "    Organismo movido: " + organismoMovido + "\n" + "    Posición actual: (" + cordPorMover[0] + "," + cordPorMover[1] + ")";
            gui.setSentencesInTextAreaMicro(infoOrganismo);
        }
        gui.actualizarMatriz(mapa1);
        mapa1.imprimir(); 
        
    }
}
