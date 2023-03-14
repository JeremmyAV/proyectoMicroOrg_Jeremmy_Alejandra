public class Mapa {
    
    private int matriz[][];
    private int anchoM;
    private int largoM;

    public Mapa(int ancho, int largo)
    {
        anchoM = ancho;
        largoM = largo;

        matriz = new int[largoM][];

        for (int i = 0; i < largoM; i++)
        {
            int temp1[];
            temp1 = new int[anchoM];

            for (int z = 0; z < anchoM; z++)
            {
                temp1[z] = 0;
            }

            matriz[i] = temp1;
        }
    }

    public void vaciarCasilla(int posX, int posY)
    {
        matriz[posX][posY] = 0;
    }

    public void rellenarCasilla(int posX, int posY)
    {
        matriz[posX][posY] = 2;
    }

    public int getCasilla(int posX, int posY)
    {
        return matriz[posX][posY];
    }

    public void imprimir()
    {

        for (int i = 0; i < largoM; i++)
        {
            for (int z = 0; z < anchoM; z++)
            {
                System.out.print(matriz[i][z]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}
