package com.mycompany.juego;

public class Mapa {
    
    private Organismo matriz[][];
    private int anchoM;
    private int largoM;
    private int listaMicroO[][];
    private int contListaMO = 0;
    private int maximoLista;


    // genera los atributos del mapa
    public Mapa(int ancho, int largo,int maximoMicroO)
    {
        anchoM = ancho;
        largoM = largo;

        matriz = new Organismo[largoM][];

        listaMicroO = new int[maximoMicroO][2];
        maximoLista = maximoMicroO;

        // crea la matriz para el mapa
        for (int i = 0; i < largoM; i++)
        {
            Organismo temp1[];
            temp1 = new Organismo[anchoM];

            for (int z = 0; z < anchoM; z++)
            {
                temp1[z] = null;
            }

            matriz[i] = temp1;
        }

    }

    //rellenar la matriz con organismo
    public void crearMicro()
    {
        //agregar microrganismos

        int k = 0; 
        while ( k < maximoLista)
        {
            int tempX = (int)(Math.random()*largoM+0);
            int tempY = (int)(Math.random()*anchoM+0);

            if (matriz[tempX][tempY] == null)
            {
                int tipoMicroOrg = (int)(Math.random()*3+1);

                if (tipoMicroOrg == 1)
                {
                    rellenarCasilla(tempX, tempY, new MicroVelocidad(tempX, tempY, largoM , anchoM));
                    listaMicroO [contListaMO][0] = tempX;
                    listaMicroO [contListaMO][1] = tempY;
                }
                else if (tipoMicroOrg == 2)
                {
                    rellenarCasilla(tempX, tempY, new MicroVision(tempX, tempY, largoM , anchoM));
                    listaMicroO [contListaMO][0] = tempX;
                    listaMicroO [contListaMO][1] = tempY;
                }
                else
                {
                    rellenarCasilla(tempX, tempY, new MicroEnergia(tempX, tempY, largoM , anchoM));
                    listaMicroO [contListaMO][0] = tempX;
                    listaMicroO [contListaMO][1] = tempY;
                }
                
                contListaMO ++;
                k++;
            }
        }
    }

    public void crearVariosAlim(int cantAlim)
    {
        //agregar alimetnos a la matriz
        for (int i = 0; i < cantAlim; i++ )
        {  
            crearAlimento();
        }
    }

    //aniadir un alimento nuevo
    public void crearAlimento()
    {
        int valid = 0;   
        while (valid == 0)
        {
            int tempX = (int)(Math.random()*largoM+0);
            int tempY = (int)(Math.random()*anchoM+0);
            if (matriz[tempX][tempY] == null)
            {
                valid = 1;
                int tamaAlim = (int)(Math.random()*3+1);
                if (tamaAlim == 1)
                {
                    rellenarCasilla(tempX, tempY, new AlimPeque());
                }
                else if (tamaAlim == 2)
                {
                    rellenarCasilla(tempX, tempY, new AlimMediano());
                }
                else
                {
                    rellenarCasilla(tempX, tempY, new AlimGrande());
                }
            }
        }
    }

    public void vaciarCasilla(int posX, int posY)
    {
        matriz[posX][posY] = null;
    }

    public int rellenarCasilla(int posX, int posY, Organismo oorr)
    {
        // is esta vacia la rellena con el organismo
        if (matriz[posX][posY] == null)
        {
            matriz[posX][posY] = oorr;
            return 0;
        }
        // si esta ocupada
        else
        {
            // si lo que hay un alimento
            if (matriz[posX][posY].tipo == "alimento")
            {
                oorr.consAlim(matriz[posX][posY].getEnergia(), matriz[posX][posY].getVision(), matriz[posX][posY].getVelocidad());
                matriz[posX][posY] = oorr;
                //crearAlimento();
                return 2;
            }
            // si lo que hay es un microrganismo
            else
            {
                //si el que esta tiene mayor energia
                if (matriz[posX][posY].getEnergia() > oorr.getEnergia())
                {
                    if (oorr.valEsJug() != 1)
                    {
                        borrarDeLista(oorr.getPosX(), oorr.getPosY());
                        System.out.println("el microOrg fue comido por el que ya estaba en esa casilla");
                        //el que esta consume al que llego
                        matriz[posX][posY].consAlim((oorr.getEnergia()/2), (oorr.getVision()/2), (oorr.getVelocidad()/2));
                        return 3;
                    }
                    else
                    {
                        return 1;
                    }
                }
                //si el que esta tiene menor energia
                else if (matriz[posX][posY].getEnergia() < oorr.getEnergia())
                {
                    int valComioJugador = 0;
                    if (matriz[posX][posY].tipo == "jugador")
                        valComioJugador = 1;
                    borrarDeLista(posX, posY);
                    matriz[posX][posY] = oorr;
                    //el que llego consume el que estaba
                    oorr.consAlim((matriz[posX][posY].getEnergia()/2), (matriz[posX][posY].getVision()/2), (matriz[posX][posY].getVelocidad()/2));
                    
                    if (valComioJugador == 0)
                    {
                        return 0;
                    }
                    else
                    {
                        return 1;
                    }
                }
                // si la energia de ambos es igual
                else
                {
                    //revisa la velocidad de ambos
                    if (matriz[posX][posY].getVelocidad() > oorr.getVelocidad())
                    {
                        if (oorr.valEsJug() != 1)
                        {
                            borrarDeLista(oorr.getPosX(), oorr.getPosY());
                            System.out.println("el microOrg fue comido por el que ya estaba en esa casilla");
                            //el que esta consume al que llego
                            matriz[posX][posY].consAlim((oorr.getEnergia()/2), (oorr.getVision()/2), (oorr.getVelocidad()/2));
                            return 3;
                        }
                        else
                        {
                            return 1;
                        }
                    }
                    //si el que esta tiene menor velocidad
                    else if (matriz[posX][posY].getVelocidad() < oorr.getVelocidad())
                    {
                        int valComioJugador = 0;
                        if (matriz[posX][posY].tipo == "jugador")
                            valComioJugador = 1;

                        borrarDeLista(posX, posY);
                        matriz[posX][posY] = oorr;
                        //el que llego consume el que estaba
                        oorr.consAlim((matriz[posX][posY].getEnergia()/2), (matriz[posX][posY].getVision()/2), (matriz[posX][posY].getVelocidad()/2));
                        
                        if (valComioJugador == 0)
                        {
                            return 0;
                        }
                        else
                        {
                            return 1;
                        }
                    }
                    // si la velocidad de ambos es igual
                    else
                    {
                        // revisa la edad de ambos
                        if (matriz[posX][posY].getEdad() > oorr.getEdad())
                        {
                            if (oorr.valEsJug() != 1)
                            {
                                borrarDeLista(oorr.getPosX(), oorr.getPosY());
                                System.out.println("el microOrg fue comido por el que ya estaba en esa casilla");
                                //el que esta consume al que llego
                                matriz[posX][posY].consAlim((oorr.getEnergia()/2), (oorr.getVision()/2), (oorr.getVelocidad()/2));
                                return 3;
                            }
                            else
                            {
                                return 1;
                            }
                        }
                        //si el que esta tiene menor edad
                        else if (matriz[posX][posY].getEdad() < oorr.getEdad())
                        {
                            int valComioJugador = 0;
                            if (matriz[posX][posY].tipo == "jugador")
                                valComioJugador = 1;

                            borrarDeLista(posX, posY);
                            matriz[posX][posY] = oorr;
                            //el que llego consume el que estaba
                            oorr.consAlim((matriz[posX][posY].getEnergia()/2), (matriz[posX][posY].getVision()/2), (matriz[posX][posY].getVelocidad()/2));
                            
                            if (valComioJugador == 0)
                            {
                                return 0;
                            }
                            else
                            {
                                return 1;
                            }
                        }
                        // si la edad de ambos es igual
                        else
                        {
                            int eleccionAleat;
                            eleccionAleat = (int)(Math.random()*1+0);
                            if (eleccionAleat == 0)
                            {
                                if (oorr.valEsJug() != 1)
                                {
                                    borrarDeLista(oorr.getPosX(), oorr.getPosY());
                                    System.out.println("el microOrg fue comido por el que ya estaba en esa casilla");
                                    //el que esta consume al que llego
                                    matriz[posX][posY].consAlim((oorr.getEnergia()/2), (oorr.getVision()/2), (oorr.getVelocidad()/2));
                                    return 3;
                                }
                                else
                                {
                                    return 1;
                                }
                            }
                            else
                            {
                                int valComioJugador = 0;
                                if (matriz[posX][posY].tipo == "jugador")
                                    valComioJugador = 1;

                                borrarDeLista(posX, posY);
                                matriz[posX][posY] = oorr;
                                //el que llego consume el que estaba
                                oorr.consAlim((matriz[posX][posY].getEnergia()/2), (matriz[posX][posY].getVision()/2), (matriz[posX][posY].getVelocidad()/2));
                                
                                if (valComioJugador == 0)
                                {
                                    return 0;
                                }
                                else
                                {
                                    return 1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void actuaCordLista(int tempXB, int tempYB, int[] tempCordN)
    {
        for (int i = 0; i < contListaMO; i++)
        {
            if (listaMicroO[i] != null)
            {
                if ((listaMicroO[i][0] == tempXB) && (listaMicroO[i][1] == tempYB))
                {
                    listaMicroO[i] = tempCordN;
                    break;
                }
            }
        }
    }

    public void borrarDeLista(int tempX, int tempY)
    {
        for (int i = 0; i < contListaMO; i++)
        {
            if (listaMicroO[i] != null)
            {
                if ((listaMicroO[i][0] == tempX) && (listaMicroO[i][1] == tempY))
                {
                    listaMicroO[i] = null;
                    break;
                }
            }
        }
    }

    public Organismo getCasilla(int posX, int posY)
    {
        return matriz[posX][posY];
    }

    public int getAncho()
    {
        return anchoM;
    }

    public int getLargo()
    {
        return largoM;
    }

    public Organismo[][] getMatriz()
    {
        return matriz;
    }

    public int getMaximoMicroO()
    {
        return maximoLista;
    }

    public int[] getListaMicro(int num)
    {
        return listaMicroO[num];
    }


    public void imprListaDeMicrorg()
    {
        for (int i = 0; i < contListaMO; i++)
        {
            if (listaMicroO[i] != null)
            {
                System.out.print("Pos miroganismo ");System.out.print(matriz[listaMicroO[i][0]][listaMicroO[i][1]].getEnergia());System.out.print("E");
                System.out.print(matriz[listaMicroO[i][0]][listaMicroO[i][1]].getVision());System.out.print("Vi");
                System.out.print(matriz[listaMicroO[i][0]][listaMicroO[i][1]].getVelocidad());System.out.println("Ve");
                System.out.println(listaMicroO[i][0]);
                System.out.println(listaMicroO[i][1]);
            }
        }
    }

    public void imprimir()
    {

        for (int i = 0; i < largoM; i++)
        {
            for (int z = 0; z < anchoM; z++)
            {
                if (matriz[i][z] == null){
                    System.out.print("o");
                }
                else{
                    if (matriz[i][z].tipo == "alimento" ){
                        /*
                        System.out.print(matriz[i][z].getEnergia());System.out.print("a");
                        System.out.print(matriz[i][z].getVision());System.out.print("Vi");
                        System.out.print(matriz[i][z].getVelocidad());System.out.print("Ve");
                        */
                        final String ANSI_BLUE = "\u001B[34m";
                        final String ANSI_RESET = "\u001B[0m";
                        System. out. print(ANSI_BLUE + "A" + ANSI_RESET);
                    }
                    else if (matriz[i][z].tipo == "microOrg" ){
                        /*
                        System.out.print("Mi");System.out.print(matriz[i][z].getEnergia());System.out.print("E");
                        System.out.print(matriz[i][z].getVision());System.out.print("Vi");
                        System.out.print(matriz[i][z].getVelocidad());System.out.print("Ve");
                        */
                        final String ANSI_RED = "\u001B[31m";
                        final String ANSI_RESET = "\u001B[0m";
                        System. out. print(ANSI_RED + "M" + ANSI_RESET);
                    }
                    else
                    {
                        final String ANSI_RED = "\u001B[31m";
                        final String ANSI_RESET = "\u001B[0m";
                        System. out. print(ANSI_RED + "Ju" + ANSI_RESET);
                    }

                }
                    System.out.print("     ");
            }
            System.out.println(" ");
        }
    }
}