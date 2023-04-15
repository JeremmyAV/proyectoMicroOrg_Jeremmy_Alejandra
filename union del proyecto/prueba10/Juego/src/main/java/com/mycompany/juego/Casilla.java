package com.mycompany.juego;

import static com.mycompany.juego.Interfaz.matriz;
import static com.mycompany.juego.Juego.gui;
import static com.mycompany.juego.Juego.juegoTerminado;
import static com.mycompany.juego.Juego.mapa1;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Casilla extends JButton implements ActionListener {


    public static JTextArea textArea;
    public Organismo organismo;
    private int fila;
    private int columna;
    private int posX = 5;
    private int posY = 5;
    
    public int filaSeleccionada;
    public int columnaSeleccionada;
    private Organismo tipo;

    public Casilla(Organismo organismo) {
        super();
        this.organismo = organismo;
        addActionListener(this); // se agrega como listener del botón
    }

    public Casilla(int i, int j) {
        super();

        fila = i;
        columna = j;

        addActionListener(this); // se agrega como listener del botón
    }
    
    public Organismo getOrganismo() {
        return organismo;
    }

    public void setOrganismo(Organismo organismo) {
        this.organismo = organismo;
    }

    @Override 
    public void actionPerformed(ActionEvent e) {

        if (Juego.juegoTerminado == 0){
            JButton botonClicado = (JButton) e.getSource();
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

            if ((fila == posX) && (columna == posY)) 
            {    
                int respuesta = JOptionPane.showOptionDialog(null, "Deseas quedarte en esta posicion?", "Confirmar movimiento", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);
                
                if (respuesta == JOptionPane.YES_OPTION) {
                    Juego.moverMicrorganismos();
                    Juego.jugador.incrementaEdad();
                }
            }
            else if ((fila == posX) || (columna == posY)){
                if(Juego.jugador.puedeMover()){
                    
                    if (distancia <= Juego.jugador.getVelocidad()){
                        if("".equals(botonClicado.getText())){ //la casilla esta vacia
                            System.out.println("se puede mover");
                            System.out.println("Distancia recorrida: " + distanciaIn);
                            System.out.println("Velocidad: "+ Juego.jugador.getVelocidad());

                            int respuesta = JOptionPane.showOptionDialog(null, "Deseas moverte " + distanciaIn + " casillas?", "Confirmar movimiento", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);

                            if (respuesta == JOptionPane.YES_OPTION) {   
                                Juego.jugador.incrementaEdad();
                            System.out.println(Juego.jugador.restarEnergia());
                            System.out.println(Juego.jugador.restarVelocidad(distanciaIn));
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

                            Juego.moverMicrorganismos();
                            gui.setSetencesInTextArea();
                            
                            
                            }
                            
                        }
                        else if("A".equals(botonClicado.getText())){ //la casilla tiene un alimento
                            System.out.println("se puede mover");
                            System.out.println("Distancia recorrida: " + distanciaIn);
                            System.out.println("Velocidad: "+ Juego.jugador.getVelocidad());

                            Organismo organismo = mapa1.getCasilla(filaSeleccionada, columnaSeleccionada);
                            if ("alimento".equals(mapa1.getCasilla(filaSeleccionada, columnaSeleccionada).tipo)){
                                System.out.println("es un alim");

                                int energiaAlim = organismo.getEnergia();
                                int visionAlim = organismo.getVision();
                                int velocidadAlim = organismo.getVelocidad();
                                String energia = ("Energia: "+ energiaAlim);
                                String vision = ("Vision: "+ visionAlim);
                                String velocidad = ("Velocidad: "+ velocidadAlim);

                                String mensaje = "¿Deseas comer este alimento?\n" + energia + "\n" + vision + "\n" + velocidad;

                                int respuesta = JOptionPane.showOptionDialog(null, mensaje, "Confirmar movimiento", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);

                                if (respuesta == JOptionPane.YES_OPTION) {                    
                                    botonClicado.setBackground(Color.RED);
                                    botonClicado.setText("J");
                                    Juego.jugador.incrementaEdad(); //incrementa la edad
                                    Juego.jugador.restarEnergia();
                                    // si come alimento entonces incrementa la vision, velocidad y energia;
                                    Juego.jugador.comerAlimento(energiaAlim, velocidadAlim, visionAlim);
                                    String energiaActual = ("Energia: "+ Juego.jugador.getEnergia());
                                    String visionActual = ("Vision: " + Juego.jugador.getVision());
                                    String velocidadActual = ("Velocidad: "+Juego.jugador.getEnergia());                                    
                                    String edadActual = ("Edad: "+Juego.jugador.getEdad());  
                                    String mensajeJugador = "Acaba de comer un alimento, ahora tiene: \n" + energiaActual + "\n" + visionActual + "\n" + velocidadActual+ "\n" + edadActual;
                                    JOptionPane.showMessageDialog(null,mensajeJugador);

                                    System.out.println("ya comio alim");
                                    System.out.println("Energia actual jugador: "+ Juego.jugador.getEnergia());
                                    System.out.println("Vision actual jugador: "+ Juego.jugador.getVision());
                                    System.out.println("Velocidad actual jugador: "+ Juego.jugador.getVelocidad());

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

                                    Juego.moverMicrorganismos();
                                    
                                    gui.setSetencesInTextArea();
                                } 
                            }                                
                        }           
                        else if("M".equals(botonClicado.getText())){ //si la casilla tiene un microorganismo
                            System.out.println("se puede mover");
                            System.out.println("Distancia recorrida: " + distanciaIn); //Cambiar x el boton anterior, toma la distancia del primer boton
                            System.out.println("Velocidad: "+ Juego.jugador.getVelocidad());

                            Organismo organismo = mapa1.getCasilla(filaSeleccionada, columnaSeleccionada);
                            if ("microOrg".equals(mapa1.getCasilla(filaSeleccionada, columnaSeleccionada).tipo)){
                                System.out.println("es un micro");

                            int energiaMicro= organismo.getEnergia();
                            int visionMicro = organismo.getVision();
                            int velocidadMicro = organismo.getVelocidad();
                            int edadMicro = organismo.getEdad();
                            String energia = ("Energia: "+ energiaMicro);
                            String vision = ("Vision: "+ visionMicro);
                            String velocidad = ("Velocidad: "+ velocidadMicro);
                            String edad = ("Edad: "+ edadMicro);
                            String mensaje = "¿Deseas comer este microorganismo?\n" + energia + "\n" + vision + "\n" + velocidad + "\n"+ edad;

                            int respuesta = JOptionPane.showOptionDialog(null, mensaje, "Confirmar movimiento", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);

                                if (respuesta == JOptionPane.YES_OPTION) {  
                                    
                                    if (mapa1.getCasilla(filaSeleccionada, columnaSeleccionada).getEnergia() > Juego.jugador.getEnergia()) // gano el micro con mas energia
                                    {
                                        int energiaGanador = mapa1.getCasilla(filaSeleccionada, columnaSeleccionada).getEnergia(); 
                                        int visionGanador = mapa1.getCasilla(filaSeleccionada, columnaSeleccionada).getVision(); 
                                        int velocidadGanador = mapa1.getCasilla(filaSeleccionada, columnaSeleccionada).getVelocidad();
                                        int edadGanador = mapa1.getCasilla(filaSeleccionada, columnaSeleccionada).getEdad();
                                        int x = mapa1.getCasilla(filaSeleccionada, columnaSeleccionada).getBuscPosX();
                                        int y = mapa1.getCasilla(filaSeleccionada, columnaSeleccionada).getBuscPosY();
                                        
                                        String energiaG = ("Energia: "+ energiaGanador);
                                        String visionG = ("Vision: "+ visionGanador);
                                        String velG = ("Velocidad: "+ velocidadGanador);
                                        String edadG = ("Edad: "+ edadGanador);
                                      //  String posicion = ("("+ x + "," + y + ")");
                                        
                                        Juego.juegoTerminado = 1;

                                        mapa1.vaciarCasilla(posX, posY);

                                        matriz[posX][posY].setText("");
                                        matriz[posX][posY].setForeground(Color.WHITE);
                                        matriz[posX][posY].setBackground(Color.WHITE);

                                        System.out.println("El juego finalizo, perdiste");
                                        
                                        
                                        String mensajeG =("Microorganismo ganador:\n" + energiaG + "\n" + visionG + "\n" + velG + "\n"+ edadG);
                                        gui.setSentencesInTextAreaMicro(mensajeG);
                                        JOptionPane.showMessageDialog(null, "Perdiste! Un microorganismo te acaba de comer\n" + mensajeG);
                                        int respuesta01 = JOptionPane.showOptionDialog(null, "El juego finalizo, perdiste \n Desea salir del juego? " , " cerrar programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);

                                        gui.actualizarMatriz(mapa1);
                                        if (respuesta01 == JOptionPane.YES_OPTION)
                                        {
                                            System.exit(0);
                                        }
                                    }
                                    else
                                    {
                                        
                                    botonClicado.setBackground(Color.RED);
                                    botonClicado.setText("J");
                                    // si come micro entonces incrementa la vision, velocidad y energia a la mitad;
                                    Juego.jugador.comerMicro(energiaMicro, velocidadMicro, visionMicro);
                                    System.out.println("ya comio micro");
                                    System.out.println("Energia actual jugador: "+ Juego.jugador.getEnergia());
                                    System.out.println("Vision actual jugador: "+ Juego.jugador.getVision());
                                    System.out.println("Velocidad actual jugador: "+ Juego.jugador.getVelocidad());

                                    String energiaActual = ("Energia: "+ Juego.jugador.getEnergia());
                                    String visionActual = ("Vision: " + Juego.jugador.getVision());
                                    String velocidadActual = ("Velocidad: "+Juego.jugador.getVelocidad());                                    
                                    String edadActual = ("Edad: "+Juego.jugador.getEdad());  
                                    String mensajeJugador = "Acaba de comer un microorganismo, ahora tiene: \n" + energiaActual + "\n" + visionActual + "\n" + velocidadActual+ "\n" + edadActual;
                                    JOptionPane.showMessageDialog(null,mensajeJugador);

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

                                    mapa1.borrarDeLista(Juego.jugador.getFila(), Juego.jugador.getColumna());
                                    Juego.moverMicrorganismos();

                                    }

                                }
                                Juego.jugador.incrementaEdad(); // la edad aumenta en cada turno y disminuye la vision
                                gui.setSetencesInTextArea();
                            }

                        } 
                    }              
                    else{
                        System.out.println("no se puede mover");
                        System.out.println("Distancia que desea recorrer: " + distanciaIn);
                        System.out.println("Velocidad: "+ Juego.jugador.getVelocidad());   

                        Organismo tempJug = Juego.jugador;
                        if ((fila <= tempJug.getPosX() + tempJug.getVision()) && (fila >= tempJug.getPosX() - tempJug.getVision()) && (columna <= tempJug.getPosY() + tempJug.getVision()) && (columna >= tempJug.getPosY() - tempJug.getVision()))
                        {
                            if (mapa1.getCasilla(filaSeleccionada, columnaSeleccionada) != null)
                            {
                                Organismo organismo = mapa1.getCasilla(filaSeleccionada, columnaSeleccionada);
                                int energiaMicro= organismo.getEnergia();
                                int visionMicro = organismo.getVision();
                                int velocidadMicro = organismo.getVelocidad();
                                int edadMicro = organismo.getVelocidad();
                                String energia = ("Energia: "+ energiaMicro);
                                String vision = ("Vision: "+ visionMicro);
                                String velocidad = ("Velocidad: "+ velocidadMicro);
                                String edad = ("Edad: "+ edadMicro);
                                String mensaje = "Informacion del organismo\n" + energia + "\n" + vision + "\n" + velocidad + "\n"+ edad;

                                JOptionPane.showMessageDialog(null, "No se puede mover " + distanciaIn + " casillas, no tiene suficiente velocidad"+ "\n" + "\n" + mensaje);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "No se puede mover " + distanciaIn + " casillas, no tiene suficiente velocidad");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No se puede mover " + distanciaIn + " casillas, no tiene suficiente velocidad");
                        }
                    }    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ha perdido! Se quedo sin energia  ");
                    System.out.println("Energia jugador: "+ Juego.jugador.getEnergia());
                    int respuesta = JOptionPane.showOptionDialog(null, "El juego finalizo, perdiste \n Desea salir del juego? " , " cerrar programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);
                    juegoTerminado = 1; 
                    if (respuesta == JOptionPane.YES_OPTION)
                    {
                        System.exit(0);
                    }
                }
            }
            else if (mapa1.getCasilla(fila, columna) != null){
                Organismo tempJug = Juego.jugador;
                if ((fila <= tempJug.getPosX() + tempJug.getVision()) && (fila >= tempJug.getPosX() - tempJug.getVision()) && (columna <= tempJug.getPosY() + tempJug.getVision()) && (columna >= tempJug.getPosY() - tempJug.getVision()))
                {
                    Organismo organismo = mapa1.getCasilla(filaSeleccionada, columnaSeleccionada);
                    int energiaMicro= organismo.getEnergia();
                    int visionMicro = organismo.getVision();
                    int velocidadMicro = organismo.getVelocidad();
                    String energia = ("Energia: "+ energiaMicro);
                    String vision = ("Vision: "+ visionMicro);
                    String velocidad = ("Velocidad: "+ velocidadMicro);

                    String mensaje = "Informacion del organismo\n" + energia + "\n" + vision + "\n" + velocidad;

                    JOptionPane.showMessageDialog(null, mensaje);
                            
                }
                else{
                    JOptionPane.showMessageDialog(null, "Este organismo se encuentra muy lejos.");
                }
            }
        }
        else{
            String perdiste = "Perdiste!";
            gui.setSentencesInTextAreaMicro(perdiste);
            JOptionPane.showMessageDialog(null, "El juego ha terminado.");
                    int respuesta = JOptionPane.showOptionDialog(null, "El juego finalizo, perdiste \n Desea salir del juego? " , " cerrar programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);
                    juegoTerminado = 1; 
                    if (respuesta == JOptionPane.YES_OPTION)
                    {
                        System.exit(0);
                    }          
        }
    }
    
    

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }



}
