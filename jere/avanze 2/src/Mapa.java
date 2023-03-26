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
            int tempEner = (int)(Math.random()*5+1);
            rellenarCasilla(tempX, tempY, new MicroOrg(tempEner, 10, 5, 1, tempX, tempY,10,10));
            listaMicroO [contListaMO][0] = tempX;
            listaMicroO [contListaMO][1] = tempY;
        }

        //agregar alimetnos a la matriz
        for (int k = 0; k < cantAlim; k++ )
        {
            int valid = 0;   
            while (valid == 0)
            {
                int tempX = (int)(Math.random()*largoM+0);
                int tempY = (int)(Math.random()*anchoM+0);
                if (matriz[tempX][tempY] == null)
                {
                    int tempVe = (int)(Math.random()*20+5);
                    int tempVi = (int)(Math.random()*20+5);
                    int tempEner = (int)(Math.random()*20+5);
                    rellenarCasilla(tempX, tempY, new Alimento("vel", tempEner , 8, tempVe, tempVi));
                    valid = 1;
                }
            }
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
                int tempVe = (int)(Math.random()*20+5);
                int tempVi = (int)(Math.random()*20+5);
                int tempEner = (int)(Math.random()*20+5);
                rellenarCasilla(tempX, tempY, new Alimento("vel", tempEner , 8, tempVe, tempVi));
                valid = 1;
            }
        }
    }

    public void vaciarCasilla(int posX, int posY)
    {
        matriz[posX][posY] = null;
    }

    public void rellenarCasilla(int posX, int posY, Organismo oorr)
    {
        if (matriz[posX][posY] == null)
            matriz[posX][posY] = oorr;
        else
        {
            if (matriz[posX][posY].tipo == "alimento")
            {
                System.out.println("entra a consumir el alimento");
                oorr.consAlim(matriz[posX][posY].getEnergia(), matriz[posX][posY].getVision(), matriz[posX][posY].getVelocidad());
                matriz[posX][posY] = oorr;
            }
            else
            {
                //pelea entre microrganismos
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
                        System.out.print(matriz[i][z].getEnergia());
                    }
                    else{
                        System.out.print(matriz[i][z].getEnergia());
                    }
                }
                    System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}
