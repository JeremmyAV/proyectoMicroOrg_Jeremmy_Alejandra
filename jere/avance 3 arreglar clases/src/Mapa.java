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
    public void crearMicroYAlim(int cantAlim)
    {
        //agregar microrganismos
        for (int k = 0; k < maximoLista; k++ )
        {
            int tempX = (int)(Math.random()*largoM+0);
            int tempY = (int)(Math.random()*anchoM+0);
            int tempEner = (int)(Math.random()*40+10);
            rellenarCasilla(tempX, tempY, new MicroOrg(tempEner, 10, 5, 1, tempX, tempY,10,10, 0));
            listaMicroO [contListaMO][0] = tempX;
            listaMicroO [contListaMO][1] = tempY;
            contListaMO ++;
        }

        //agregar alimetnos a la matriz
        for (int k = 0; k < cantAlim; k++ )
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
                System.out.println("entra a consumir el alimento");
                oorr.consAlim(matriz[posX][posY].getEnergia(), matriz[posX][posY].getVision(), matriz[posX][posY].getVelocidad());
                matriz[posX][posY] = oorr;
                return 0;
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
                        return 0;
                    }
                    else
                    {
                        return 1;
                    }
                }
                //si el que esta tiene menor energia
                else if (matriz[posX][posY].getEnergia() < oorr.getEnergia())
                {
                    borrarDeLista(posX, posY);
                    matriz[posX][posY] = oorr;
                    //el que llego consume el que estaba
                    oorr.consAlim((matriz[posX][posY].getEnergia()/2), (matriz[posX][posY].getVision()/2), (matriz[posX][posY].getVelocidad()/2));
                    return 0;
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
                            return 0;
                        }
                        else
                        {
                            return 1;
                        }
                    }
                    //si el que esta tiene menor velocidad
                    else if (matriz[posX][posY].getVelocidad() < oorr.getVelocidad())
                    {
                        borrarDeLista(posX, posY);
                        matriz[posX][posY] = oorr;
                        //el que llego consume el que estaba
                        oorr.consAlim((matriz[posX][posY].getEnergia()/2), (matriz[posX][posY].getVision()/2), (matriz[posX][posY].getVelocidad()/2));
                        return 0;
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
                                return 0;
                            }
                            else
                            {
                                return 1;
                            }
                        }
                        //si el que esta tiene menor edad
                        else if (matriz[posX][posY].getEdad() < oorr.getEdad())
                        {
                            borrarDeLista(posX, posY);
                            matriz[posX][posY] = oorr;
                            //el que llego consume el que estaba
                            oorr.consAlim((matriz[posX][posY].getEnergia()/2), (matriz[posX][posY].getVision()/2), (matriz[posX][posY].getVelocidad()/2));
                            return 0;
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
                                    return 0;
                                }
                                else
                                {
                                    return 1;
                                }
                            }
                            else
                            {
                                borrarDeLista(posX, posY);
                                matriz[posX][posY] = oorr;
                                //el que llego consume el que estaba
                                oorr.consAlim((matriz[posX][posY].getEnergia()/2), (matriz[posX][posY].getVision()/2), (matriz[posX][posY].getVelocidad()/2));
                                return 0;
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
            if ((listaMicroO[i][0] == tempXB) && (listaMicroO[i][1] == tempYB))
            {
                listaMicroO[i] = tempCordN;
                break;
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

    public void imprListaDeMicrorg()
    {
        for (int i = 0; i < contListaMO; i++)
        {
            if (listaMicroO[i] != null)
            {
                System.out.print("Pos miroganismo ");System.out.println(i);
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
                        System.out.print(matriz[i][z].getEnergia());System.out.print("a");
                    }
                    else{
                        System.out.print(matriz[i][z].getEnergia());System.out.print("m");
                    }
                }
                    System.out.print("     ");
            }
            System.out.println(" ");
        }
    }
}
