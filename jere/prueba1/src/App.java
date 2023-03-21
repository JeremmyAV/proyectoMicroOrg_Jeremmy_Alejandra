public class App {
    public static void main(String[] args) throws Exception {
        
        MicroOrg m1 = new MicroOrg(10,5,2,9);

        m1.Imprimir();

        System.out.println("'consume alimento'");

        m1.consAlim(5,0,10);

        m1.Imprimir();

        System.out.println("'estats de alimento'");



        Alimento a1 = new Alimento("vel", 8, 2);

        a1.Imprimir();

        System.out.println("'prueba de matriz'");

        Mapa mapa1 = new Mapa(10, 10);



        System.out.println("'prueba de mover microOrg'");



        //agregar microrg a la matriz
        for (int k = 0; k < 5; k++ )
        {
            int tempX = (int)(Math.random()*10+0);
            int tempY = (int)(Math.random()*10+0);
            mapa1.rellenarCasilla(tempX, tempY, new MicroOrg(32, 10, 5, 1));
        }

        //agregar alimetnos a la matriz
        for (int k = 0; k < 5; k++ )
        {
            int tempX = (int)(Math.random()*10+0);
            int tempY = (int)(Math.random()*10+0);
            mapa1.rellenarCasilla(tempX, tempY, new Alimento("vel", 4 , 8));
        }

        mapa1.imprimir();
    }
}
