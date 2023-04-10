package com.mycompany.juego;


import static com.mycompany.juego.Juego.jugador;
import static com.mycompany.juego.Juego.mapa1;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class Interfaz extends JFrame {
    

    private int size;
    public static Casilla[][] matriz;

    public Interfaz(int size, Mapa tempMapa) {
        this.size = size;

        matriz = new Casilla[size][size];
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
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matriz[i][j] = new Casilla(i,j);
                panelDerecho.add(matriz[i][j]);
            }
        }

        /* 
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
        boolean jugadorGenerado = false;

        for (int i = 0; i < numPosiciones; i++) {
            int fila = posicionesFila[i];
            int columna = posicionesColumna[i];

            if (!jugadorGenerado) {
                matriz[fila][columna].setOrganismo(new Jugador(1, 2, 3, 4));
                matriz[fila][columna].setText("Jugador");
                matriz[fila][columna].setForeground(Color.WHITE);
                matriz[fila][columna].setBackground(Color.ORANGE);
                jugadorGenerado = true;
            } else {
                int indiceNombre = rand.nextInt(organismos.length);
                matriz[fila][columna].setOrganismo(organismos[indiceNombre]);
                matriz[fila][columna].setText(organismos[indiceNombre].getTipo());

                if ("Microorganismo".equals(organismos[indiceNombre].getTipo())) {
                    matriz[fila][columna].setForeground(Color.WHITE);
                    matriz[fila][columna].setBackground(Color.GREEN);
                }
                if ("Alimento".equals(organismos[indiceNombre].getTipo())) {
                    matriz[fila][columna].setForeground(Color.WHITE);
                    matriz[fila][columna].setBackground(Color.BLUE);
                }
            }
        }

        */

        // prueba de interpretar la matiz de organismos en la interfaz
        for (int i = 0; i < size; i++)
        {
            for (int z = 0; z < size; z++ )
            {
                if (tempMapa.getMatriz()[i][z] != null)
                {
                    if ("alimento".equals(tempMapa.getMatriz()[i][z].tipo))
                    {
                        matriz[i][z].setText("A");
                        matriz[i][z].setForeground(Color.WHITE);
                        matriz[i][z].setBackground(Color.BLUE);
                    }
                    else if ("microOrg".equals(tempMapa.getMatriz()[i][z].tipo))
                    {
                        matriz[i][z].setText("M");
                        matriz[i][z].setForeground(Color.WHITE);
                        matriz[i][z].setBackground(Color.YELLOW);
                    }
                    else
                    {
                        matriz[i][z].setText("J");
                        matriz[i][z].setForeground(Color.WHITE);
                        matriz[i][z].setBackground(Color.RED);
                    }

                }
                else
                {
                    matriz[i][z].setText("");
                    matriz[i][z].setForeground(Color.WHITE);
                    matriz[i][z].setBackground(Color.WHITE);
                }
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
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.setFont(new Font("Arial", Font.BOLD, 16));
        textArea.setEditable(false);
        panelIzquierdo.add(textArea, BorderLayout.CENTER);
        
         // Agregar el botón al panel izquierdo
        JButton botonPI = new JButton("Turno");
        botonPI.setFont(new Font("Arial", Font.BOLD, 14));
        botonPI.setBackground(Color.BLUE);
        botonPI.setForeground(Color.BLACK);
        panelIzquierdo.add(botonPI, BorderLayout.PAGE_END);

        // Agregar los paneles a la ventana
        getContentPane().add(panelIzquierdo, BorderLayout.LINE_START);
        getContentPane().add(panelDerecho, BorderLayout.CENTER);
        setVisible(true); // hacer visible la ventana
        this.setSetencesInTextArea(textArea);
        
        botonPI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           if ((Juego.filaSeleccionada != Juego.jugador.getFila()) && (Juego.filaSeleccionada != Juego.jugador.getColumna()))
            {
                int tempX = Juego.jugador.getFila();
                int tempY = Juego.jugador.getColumna();
                
                Juego.mapa1.rellenarCasilla(Juego.filaSeleccionada, Juego.columnaSeleccionada, Juego.jugador );
                Juego.mapa1.vaciarCasilla(tempX,tempY);

                jugador.setPosicionX(Juego.filaSeleccionada);
                jugador.setPosicionY(Juego.columnaSeleccionada);
            }

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

            actualizarMatriz(mapa1);
            mapa1.imprimir();

            
            
        }
        });
        
        
    }

    
        public void setSetencesInTextArea(JTextArea textArea) {
        // Create an ArrayList of sentences
        //Jugador jugador = new Jugador(1, 2, 3, 4);
        /* 
        String info;
        if (jugador.puedeMover()) {
            info = "Puede moverse " + jugador.getVelocidad() + " casillas\n";
        } 
        else {
            info = "No puede moverse porque no tiene suficiente velocidad y energia\n";
        }

        ArrayList<String> oraciones = new ArrayList<>();
        String jug = "                                      Jugador \n";
        String energia = "Energía .............................................. " + jugador.getEnergia();
        String vision = "Visión ................................................ " + jugador.getVision();
        String velocidad = "Velocidad .......................................... " + jugador.getVelocidad();
        String edad = "Edad .................................................. " + jugador.getEdad();

        for (int i = 0; i < 1; i++) {
            oraciones.add(jug + "\n" + energia + "\n" + vision + "\n" + velocidad + "\n" + edad + "\n" + "\n" + info);
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
         */
    }
   


    

    // Genera organismos aleatorios
    public Organismo[] getOrganismos() {
        Organismo[] microOrg = {
            new MicroEnergia(1, 2, 3, 4),
            new MicroEnergia(5, 6, 5, 5),
            new MicroEnergia(4, 3, 2, 1),
            new MicroEnergia(1, 4, 8, 10),
            new MicroEnergia(4, 1, 2, 7),
            new MicroEnergia(2, 3, 7, 1),
            new AlimPeque(),
            new AlimPeque(),
            new AlimPeque(),};
        return microOrg;
    }

    public void actualizarMatriz(Mapa tempMapa)
    {
        for (int i = 0; i < size; i++)
        {
            for (int z = 0; z < size; z++ )
            {
                if (tempMapa.getMatriz()[i][z] != null)
                {
                    if ("alimento".equals(tempMapa.getMatriz()[i][z].tipo))
                    {
                        matriz[i][z].setText("A");
                        matriz[i][z].setForeground(Color.WHITE);
                        matriz[i][z].setBackground(Color.BLUE);
                    }
                    else if ("jugador".equals(tempMapa.getMatriz()[i][z].tipo))
                    {
                        matriz[i][z].setText("J");
                        matriz[i][z].setForeground(Color.WHITE);
                        matriz[i][z].setBackground(Color.RED);
                    }
                    else
                    {
                        matriz[i][z].setText("M");
                        matriz[i][z].setForeground(Color.WHITE);
                        matriz[i][z].setBackground(Color.YELLOW);
                    }

                }
                else
                {
                    matriz[i][z].setText("");
                    matriz[i][z].setForeground(Color.WHITE);
                    matriz[i][z].setBackground(Color.WHITE);
                }
            }
        }
    }

}
