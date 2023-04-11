package com.mycompany.juego;

import static com.mycompany.juego.Interfaz.matriz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Casilla extends JButton implements ActionListener {

    public Organismo organismo;
    public static int fila;
    public static int columna;
    public static JButton botonClicado;
    public static int posX = 5;
    public static int posY = 5;
    public static int filaSeleccionada;
    public static int columnaSeleccionada;    

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
    }
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

}
