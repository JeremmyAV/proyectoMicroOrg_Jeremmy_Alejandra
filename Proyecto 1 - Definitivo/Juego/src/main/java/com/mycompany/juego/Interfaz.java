package com.mycompany.juego;


import static com.mycompany.juego.Juego.gui;
import static com.mycompany.juego.Juego.mapa1;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Interfaz extends JFrame {
    

    private int size;
    public static Casilla[][] matriz;
    private JTextArea textArea;
    private JTextArea textArea2;
    public Interfaz(int size, Mapa tempMapa,JTextArea textArea,JTextArea textArea2) {
        this.size = size;
        this.textArea = textArea;
        this.textArea2 = textArea2;
        matriz = new Casilla[size][size];
        // Configurar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setTitle("Juego");
        

        // Crear los paneles
        JPanel panelIzquierdo = new JPanel();
        JPanel panelDerecho = new JPanel();
        JPanel panelDerIzq = new JPanel();

        // Establecer los layout managers de los paneles
        panelIzquierdo.setLayout(new BorderLayout());
        panelDerecho.setLayout(new GridLayout(size,size));// Establecer el diseño en una cuadrícula dependiendo del tamaño

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
        // Crear un nuevo panel con un GridLayout de 2 filas y 1 columna
        JPanel panelIzquierdoDerIzq = new JPanel(new GridLayout(2, 1));
        
        // Impresion de las caracteristicas del jugador 
        // Establecer el tamaño preferido del panel izquierdo como un porcentaje del ancho total
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int preferredWidth = (int) (screenSize.width * 0.26);
        int preferredHeight = screenSize.height;
        panelIzquierdo.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

        JLabel labelEstadisticas = new JLabel("Historial del Jugador", SwingConstants.CENTER);
        labelEstadisticas.setFont(new Font("Press Start 2P", Font.BOLD, 11));
        panelIzquierdo.add(labelEstadisticas, BorderLayout.PAGE_START);
        
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.setFont(new Font("Press Start 2P", Font.BOLD, 9));
        textArea.setEditable(false);
        panelIzquierdo.add(textArea, BorderLayout.CENTER);
        textArea.setEditable(false);        
        this.setSetencesInTextArea();
        
        
        // Impresion de las caracteristicas del microorganismo
        Dimension screenSizeDerIzq = Toolkit.getDefaultToolkit().getScreenSize();
        int Width = (int) (screenSizeDerIzq.width * 0.26);
        int Height = screenSizeDerIzq.height;
        panelDerIzq.setPreferredSize(new Dimension(Width, Height));
        textArea2.setPreferredSize(new Dimension(Width,Height));
        
        JScrollPane scrollPane2 = new JScrollPane(this.textArea2);
        panelDerIzq.add(scrollPane2,BorderLayout.CENTER);  
        
        JLabel labelEstadisticasMicro = new JLabel("Historial Microorganismo", SwingConstants.CENTER);
        labelEstadisticasMicro.setFont(new Font("Press Start 2P", Font.BOLD, 10));
        panelDerIzq.add(labelEstadisticasMicro, BorderLayout.PAGE_START);     

        
        textArea2.setEditable(true);
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);

        textArea2.setFont(new Font("Press Start 2P", Font.BOLD, 9));
        textArea2.setEditable(false);
        panelDerIzq.add(textArea2, BorderLayout.CENTER);
        textArea2.setEditable(false);    
        
        JScrollPane scrollPane1 = new JScrollPane(this.textArea);
        panelIzquierdo.add(scrollPane1,BorderLayout.CENTER);

 
        // Agregar el panel izquierdo y el panel der-izq al nuevo panel
        panelIzquierdoDerIzq.add(panelIzquierdo);
        panelIzquierdoDerIzq.add(panelDerIzq);
        
        
        // Agregar los paneles a la ventana
        getContentPane().add(panelIzquierdoDerIzq, BorderLayout.LINE_START);
        getContentPane().add(panelDerecho, BorderLayout.CENTER);
        setVisible(true); // hacer visible la ventana
        
               
     
    }
        
        public void moverMicroorganismos(){
            mapa1.imprListaDeMicrorg();
            int cordPorMover[];
            for (int p = 0; p < mapa1.getMaximoMicroO(); p++){
                int[] orgPorMover = mapa1.getListaMicro(p);
                if (orgPorMover != null) {
                    Organismo tempOrgMover = mapa1.getCasilla(orgPorMover[0], orgPorMover[1]);
                    cordPorMover = tempOrgMover.mover(mapa1);
                    System.out.println("coordenadas a mover de microOrg");
                    System.out.println(cordPorMover[0]);
                    System.out.println(cordPorMover[1]);
                    int loQueComio = mapa1.rellenarCasilla(cordPorMover[0], cordPorMover[1], tempOrgMover);
                    if (loQueComio == 1){
                        System.out.println("el juego finalizo, estas murido");
                        break;}
                    else if (loQueComio == 2){
                        mapa1.crearAlimento(); }
                    if (loQueComio == 3){
                        Juego.mapa1.vaciarCasilla(orgPorMover[0], orgPorMover[1]); }
                    else {
                        mapa1.vaciarCasilla(orgPorMover[0], orgPorMover[1]);
                        tempOrgMover.actualizarCoord(cordPorMover[0], cordPorMover[1]);
                        mapa1.actuaCordLista(orgPorMover[0], orgPorMover[1], cordPorMover);
                        if ((tempOrgMover.getBuscPosX() == tempOrgMover.getPosX()) && (tempOrgMover.getBuscPosY() == tempOrgMover.getPosY()))
                                tempOrgMover.vaciarCordBuscar(mapa1); } 
                }
            }
            gui.actualizarMatriz(mapa1);
            mapa1.imprimir();  
        }
        
    public void setSetencesInTextArea() {
        
        String info;
        if (Juego.jugador.puedeMover()) {
            info = "Puede moverse " + Juego.jugador.getVelocidad() + " casillas\n";
        } 
        else {
            info = "No puede moverse porque no tiene suficiente energia\n";
        }

        ArrayList<String> oraciones = new ArrayList<>();
        String jug = "                                      Jugador \n";
        String energia = """
                         
                         +Energia ............... """ + Juego.jugador.getEnergia();
        String vision = """
                        
                        +Vision  ............... """ + Juego.jugador.getVision();
        String velocidad = """
                           
                           +Velocidad  ............ """ + Juego.jugador.getVelocidad();
        String edad = """
                      
                      +Edad .................. """ + Juego.jugador.getEdad();

        for (int i = 0; i < 1; i++) {
            oraciones.add("\n" + jug +"\n"+ energia + "\n" + vision + "\n" + velocidad + "\n" + edad + "\n" + "\n" + info);
        }

        for (String sentence : oraciones) {
            textArea.append(sentence + "\n");
            }
         
    }
    
    public void setSentencesInTextAreaMicro(String info) {
        ArrayList<String> oraciones = new ArrayList<>();
        
        for (int i = 0; i < 1; i++) {
            oraciones.add("\n"+ info);
        }
            for (String sentence : oraciones) {
                textArea2.append(sentence + "\n");
                
            }
            
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