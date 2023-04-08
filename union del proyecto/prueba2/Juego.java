import java.util.Scanner;


public class Juego {
    //static Casilla[][] matriz;

    public static Mapa mapa1 = new Mapa(15, 15, 5);
    public static int filaSiguiente = 1;
    public static int columnaSiguiente = 1;
    
    public static void main(String[] args) {

        //Mapa mapa1 = new Mapa(15, 15, 5);
        mapa1.crearMicro();
        mapa1.crearVariosAlim(10);

        Jugador jugador01 = new Jugador(10, 3, 2, 1, 5, 5);
        mapa1. rellenarCasilla(jugador01.getFila(), jugador01.getColumna(), jugador01);
        
        
        mapa1.imprimir();

        Interfaz gui = new Interfaz(15 , mapa1);


        int terminarJuego = 0;

        //cambiar esto por el movimiento del jugador
        Scanner nombreObjeto = new Scanner (System.in);
        terminarJuego = nombreObjeto.nextInt();

        while (terminarJuego == 0)
        {
            //movimiento del jugador
            if ((filaSiguiente != jugador01.getFila()) && (columnaSiguiente != jugador01.getColumna()))
            {
                int tempX = jugador01.getFila();
                int tempY = jugador01.getColumna();
                
                mapa1.rellenarCasilla(filaSiguiente, columnaSiguiente, jugador01 );
                mapa1.vaciarCasilla(tempX,tempY);

                jugador01.setPosicioX(filaSiguiente);
                jugador01.setPosicionY(columnaSiguiente);
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
                    System.out.println("cordenadas a mover de microOrg");
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
                        mapa1.vaciarCasilla(orgPorMover[0], orgPorMover[1]);
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

            //cambiar esto por el movimiento del jugador
            nombreObjeto = new Scanner (System.in);
            terminarJuego = nombreObjeto.nextInt();

            
        }



    }
}
