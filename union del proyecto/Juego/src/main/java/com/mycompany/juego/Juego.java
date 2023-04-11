package com.mycompany.juego;


public class Juego {

    public static Mapa mapa1 = new Mapa(15, 15, 5);
    public static Jugador jugador = new Jugador(10, 3, 2, 1, 5, 5);
    public static Interfaz gui;
    public static int turno = 1;
    public static int columnaSeleccionada;
    public static int filaSeleccionada;


    public static void main(String[] args) {

        Juego juego = new Juego();
        juego.iniciarJuego(); // Primero se inicializa la GUI y la matriz
        juego.movimientoJugador(); // Se llama al método para que el jugador realice su movimiento


    }

    private void iniciarJuego() {
        mapa1.rellenarCasilla(jugador.getFila(), jugador.getColumna(), jugador);
        mapa1.crearMicro();
        mapa1.crearVariosAlim(10);
        mapa1.imprimir();
        gui = new Interfaz(15, mapa1);

    }

    private void movimientoMaquina() {
        gui.moverMicroorganismos();
    }

    public void movimientoJugador() {
        if (turno == 1) {
            if (Casilla.botonClicado != null) {
                Organismo[][] matriz = mapa1.getMatriz(); // Obtener la matriz del mapa
                    matriz[filaSeleccionada][columnaSeleccionada].moverJugador(Casilla.botonClicado);
                    turno = 2; // Cambiar el turno a la máquina
                }
        } 
        if (turno == 2) {
            movimientoMaquina(); // Hacer que la máquina realice su movimiento
            turno = 1; // Cambiar el turno de nuevo al jugador
        }
    }

}
