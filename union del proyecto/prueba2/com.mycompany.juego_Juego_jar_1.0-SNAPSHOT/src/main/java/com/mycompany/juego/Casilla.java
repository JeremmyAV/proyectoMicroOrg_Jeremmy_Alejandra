package com.mycompany.juego;

import static com.mycompany.juego.Juego.matriz;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Casilla extends JButton implements ActionListener {
    Jugador jugador = new Jugador (1,2,3,4);

    private Organismo organismo;
    //private Jugador jugador;
    private JButton ultimoBotonSeleccionado = null;
    private int fila;
    private int columna;

    public Casilla(Organismo organismo) {
        super();
        this.organismo = organismo;
        addActionListener(this); // se agrega como listener del botón
    }

    public Casilla() {
        super();

        addActionListener(this); // se agrega como listener del botón
    }
    
    
    public void MovimientoAutomaticoOrganismo(){
        // aquí iria la lógica del movimiento del organismo no jugador.
    }

    public Organismo getOrganismo() {
        return organismo;
    }

    public void setOrganismo(Organismo organismo) {
        this.organismo = organismo;
    }

    // Para ello se utiliza la distancia de Manhattan entre las dos casillas, es decir, la suma de las diferencias en sus coordenadas en valor absoluto.
    public int calcularDistancia(int x1, int y1, int x2, int y2) {
        return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

    @Override
    
    public void actionPerformed(ActionEvent e) {
        if (jugador.puedeMover()) { // en la clase jugador se valida si puede moverse segun su energia/velocidad
            JButton botonClicado = (JButton) e.getSource();
            botonClicado.setBackground(Color.orange);
            botonClicado.setText("Jugador");
            
                // Eliminar la selección anterior
            if (ultimoBotonSeleccionado != null) {
                ultimoBotonSeleccionado.setBackground(null);
                ultimoBotonSeleccionado.setText("");
            }
            // Almacenar el nuevo botón seleccionado
            ultimoBotonSeleccionado = botonClicado;

            // Obtener la posición actual del jugador
            int filaJugador = -1;
            int columnaJugador = -1;
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if(matriz[i][j] != null && matriz[i][j].getText().equals("Jugador")) {
                        filaJugador = i;
                        columnaJugador = j;
                        break;
                    }
                }
            }

            // Buscar la posición seleccionada por el usuario (boton clicado)
            int filaSeleccionada = -1;
            int columnaSeleccionada = -1;
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if (matriz[i][j] == botonClicado) {
                        filaSeleccionada = i;
                        columnaSeleccionada = j;
                        break;
                    }
                }
            }

            // Calcular la distancia entre ambas posiciones (entre la posicion actual y la del boton clicado)
            int filas = Math.abs(filaJugador - filaSeleccionada);
            int columnas = Math.abs(columnaJugador - columnaSeleccionada);
            double distancia = Math.sqrt(filas * filas + columnas * columnas);

            // Verificar si el movimiento es válido
            if (distancia <= jugador.getVelocidad()) {
                if (filas == 0) {
                // Se mueve horizontalmente
                Organismo organismoSeleccionado = matriz[filaSeleccionada][columnaSeleccionada].getOrganismo();
                if (organismoSeleccionado != null) {
                    if ("Alimento".equals(organismo.getTipo())){ // si la casilla seleccionada tiene un alimento
                        System.out.println("Es un alimento");
                        int energiaAlimento = organismo.getEnergia();
                        int velocidadAlimento = organismo.getVelocidad();
                        int visionAlimento = organismo.getVision();
                        // Come el alimento y adquiere las caracterista de vision, velo y energia
                        jugador.comerAlimento(energiaAlimento,velocidadAlimento,visionAlimento);
                        System.out.println("Energia alimento: "+ energiaAlimento);
                        System.out.println("Velocidad alimento: "+ velocidadAlimento);
                        System.out.println("Vision alimento: "+ visionAlimento);
                        // observar las actualizacion una vez comido el alimento
                        System.out.println("Energia jugador: "+ jugador.getEnergia());
                        System.out.println("Velocidad jugador: "+ jugador.getVelocidad());
                        System.out.println("Vision jugador: "+ jugador.getVision());
                        ultimoBotonSeleccionado.setBackground(Color.orange);
                        ultimoBotonSeleccionado.setText("Jugador");
                    }
                    if ("Microorganismo".equals(organismo.getTipo())){ // si la casilla seleccionada tiene un microorganismo
                        System.out.println("Es un microorganismo"); 
                        int energiaMicro = organismo.getEnergia()/2;
                        int velocidadMicro = organismo.getVelocidad()/2;
                        int visionMicro = organismo.getVision()/2;
                        // Come el alimento y adquiere las caracterista de vision, velo y energia
                        jugador.comerMicro(energiaMicro,velocidadMicro,visionMicro);
                        System.out.println("Energia micro: "+ energiaMicro);
                        System.out.println("Velocidad micro: "+ velocidadMicro);
                        System.out.println("Vision micro: "+ visionMicro);
                        // observar las actualizacion una vez comido el alimento
                        System.out.println("Energia jugador: "+ jugador.getEnergia());
                        System.out.println("Velocidad jugador: "+ jugador.getVelocidad());
                        System.out.println("Vision jugador: "+ jugador.getVision());                       
                    }
                }
                else{
                    System.out.println("Casilla vacia"); 
                }
              } else {
                // Movimiento inválido
                JOptionPane.showMessageDialog(null, "No puedes moverte a esa casilla");
                botonClicado.setBackground(null);
                botonClicado.setText("");
              }
            } else {
                // Movimiento inválido
                JOptionPane.showMessageDialog(null, "No puedes moverte a esa casilla");
                botonClicado.setBackground(null);
                botonClicado.setText("");
            }
        }


        // se muestra un JOptionPane con las características del organismo
        if (organismo != null) {
            if ("Alimento".equals(organismo.getTipo())) {
                String mensaje = "Es un " + organismo.getTipo() + "\n"
                        + "Energia: " + organismo.getEnergia() + "\n"
                        + "Vision: " + organismo.getVision() + "\n"
                        + "Velocidad: " + organismo.getVelocidad();
                JOptionPane.showMessageDialog(null, mensaje);
            }
            /*if ("Jugador".equals(organismo.getTipo())) {
                String mensaje = "Es un " + organismo.getTipo() + "\n"
                        + "Energia: " + organismo.getEnergia() + "\n"
                        + "Vision: " + organismo.getVision() + "\n"
                        + "Velocidad: " + organismo.getVelocidad() + "\n"
                        + "Edad: " + organismo.getEdad();
                JOptionPane.showMessageDialog(null, mensaje);
            }*/

            // al presionar el boton se elimina el contenido de ese boton 
            if (e.getSource() instanceof AbstractButton) {
                AbstractButton btn = (AbstractButton) e.getSource();
                btn.setBackground(null);
                btn.setText("");
                
            }
            
            

            if ("Microorganismo".equals(organismo.getTipo())) {
                String mensaje = "Es un " + organismo.getTipo() + "\n"
                        + "Energia: " + organismo.getEnergia() + "\n"
                        + "Vision: " + organismo.getVision() + "\n"
                        + "Velocidad: " + organismo.getVelocidad() + "\n"
                        + "Edad: " + organismo.getEdad();
                JOptionPane.showMessageDialog(null, mensaje);
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
