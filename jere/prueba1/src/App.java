public class App {
    public static void main(String[] args) throws Exception {
        
        MicroOrg m1 = new MicroOrg(10,5,2,9, (int)(Math.random()*50+0), (int)(Math.random()*50+0));

        m1.imprimir();

        System.out.println("'consume alimento'");

        m1.consAlim(5,0,10);

        m1.imprimir();

        System.out.println("'estats de alimento'");

        int posA1[];
        posA1 = new int[2];
        posA1[0] = 15;
        posA1[1] = 1;

        Alimento a1 = new Alimento("vel", 8, 2, posA1);

        a1.imprimir();

        System.out.println("'prueba de matriz'");

        Mapa mapa1 = new Mapa(50, 50);



        System.out.println("'prueba de mover microOrg'");

        MicroOrg listaMicroOrg[];

        listaMicroOrg = new MicroOrg[5];



        for (int k = 0; k < 5; k++ )
        {
            int tempX = (int)(Math.random()*50+0);
            int tempY = (int)(Math.random()*50+0);
            listaMicroOrg[k] = new MicroOrg(32, 10, 5, 1, tempX, tempY);
            mapa1.rellenarCasilla(tempX, tempY);
        }

        for ( int r = 0; r < 5; r++ )
        {
            System.out.print("microrganismo ");
            System.out.println(r + 1);
            listaMicroOrg[r].imprimir();
        }

        mapa1.rellenarCasilla(8, 42);
        mapa1.rellenarCasilla(28, 8);

        System.out.println(mapa1.getCasilla(8, 42));

        mapa1.vaciarCasilla(8, 42);
        mapa1.vaciarCasilla(28, 8);

        System.out.println(mapa1.getCasilla(8, 42));


        mapa1.imprimir();
    }
}
