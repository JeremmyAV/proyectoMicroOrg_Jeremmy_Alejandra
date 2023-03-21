public class Mapa {
    
    private Organismo matriz[][];
    private int anchoM;
    private int largoM;

    public Mapa(int ancho, int largo)
    {
        anchoM = ancho;
        largoM = largo;

        matriz = new Organismo[largoM][];

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

    public void vaciarCasilla(int posX, int posY)
    {
        matriz[posX][posY] = null;
    }

    public void rellenarCasilla(int posX, int posY, Organismo oorr)
    {
        matriz[posX][posY] = oorr;
    }

    public Organismo getCasilla(int posX, int posY)
    {
        return matriz[posX][posY];
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
                        System.out.print("a");
                    }
                    else{
                        System.out.print("m");
                    }
                }
                    System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}
