package com.mycompany.juego;
import javax.swing.*;

import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interfaz extends JFrame {
    

    private Casilla[][] matriz;
    private int size;

    public Interfaz(int size) {
        this.size = size;
        // Configurar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setTitle("Juego");

        // Crear los paneles
        JPanel panelIzquierdo = new JPanel();
        JPanel panelDerecho = new JPanel();

        // Establecer los layout managers de los paneles
        panelIzquierdo.setLayout(new BorderLayout());
        panelDerecho.setLayout(new GridLayout(size, size));// Establecer el diseño en una cuadrícula dependiendo del tamaño

        // establecer el tamaño de la ventana
        setSize(getMaximumSize());

        //hacer que la ventana ocupe toda la pantalla
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Crear la matriz de botones y agregarlos al panel
        matriz = new Casilla[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matriz[i][j] = new Casilla();
                panelDerecho.add(matriz[i][j]);
            }
        }

        // Generar 10 posiciones aleatorias
        Random rand = new Random();
        int numPosiciones = 10;
        int[] posicionesFila = new int[numPosiciones];
        int[] posicionesColumna = new int[numPosiciones];
        for (int i = 0; i < numPosiciones; i++) {
            posicionesFila[i] = rand.nextInt(size);
            posicionesColumna[i] = rand.nextInt(size);
        }
        // Agregar tipo de organismo en posiciones aleatorias
        Organismo[] organismos = getOrganismos();
        for (int i = 0; i < numPosiciones; i++) {
            int fila = posicionesFila[i];
            int columna = posicionesColumna[i];
            int indiceNombre = rand.nextInt(organismos.length);
            matriz[fila][columna].setOrganismo(organismos[indiceNombre]);
            matriz[fila][columna].setText(organismos[indiceNombre].getTipo());
            if (organismos[indiceNombre].getTipo() == "Jugador") {
                matriz[fila][columna].setForeground(Color.WHITE); // cambiar el color de fuente a blanco
                matriz[fila][columna].setBackground(Color.ORANGE);
            }
        }
        // Establecer el tamaño preferido del panel izquierdo como un porcentaje del ancho total
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int preferredWidth = (int) (screenSize.width * 0.35);
        int preferredHeight = screenSize.height;
        panelIzquierdo.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

        // Agregar un título en negrita al panel izquierdo
        JLabel labelEstadisticas = new JLabel("Historial del juego", SwingConstants.CENTER);
        labelEstadisticas.setFont(new Font("Arial", Font.BOLD, 16));
        panelIzquierdo.add(labelEstadisticas, BorderLayout.PAGE_START);

        // Agregar un TextArea al panel izquierdo que ocupe todo el espacio disponible
        JTextArea textArea = new JTextArea();
        // Create a JTextArea and set its properties
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.setFont(new Font("Arial", Font.BOLD, 16));
        textArea.setEditable(false);
        panelIzquierdo.add(textArea, BorderLayout.CENTER);

        // Agregar los paneles a la ventana
        getContentPane().add(panelIzquierdo, BorderLayout.LINE_START);
        getContentPane().add(panelDerecho, BorderLayout.CENTER);
        setVisible(true); // hacer visible la ventana
        this.setSetencesInTextArea(textArea);
        }

        public void setSetencesInTextArea(JTextArea textArea) {
        // Create an ArrayList of sentences
        ArrayList<String> oraciones = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            oraciones.add("El mensaje número  ============================> " + (i + 1));
        }

        // Fill the text area with random sentences, with a 1.5-second pause between each line
        for (String sentence : oraciones) {
            textArea.append(sentence + "\n");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }


       // Genera organismos aleatorios
        
        public Organismo[] getOrganismos() {
            Organismo[] microOrg = {
                new MicroorganismoNPC(1,2,3,4),
                new MicroorganismoNPC(5,6,5,5),
                new MicroorganismoNPC(4,3,2,1),
                new MicroorganismoNPC(1,4,8,10),
                new MicroorganismoNPC(4,1,2,7),
                new MicroorganismoNPC(2,3,7,1),
                new Alimento(1, 3,4, 5),
                new Alimento(2, 4,6, 8),
                new Alimento(1, 1,1, 5),
            };
            return microOrg;
        }

}

       