public class App {
    public static void main(String[] args) throws Exception {
        
        MicroOrg m1 = new MicroOrg(10,3,2,9,2,3,10,10);

        MicroOrg m2 = new MicroOrg(9,2,6,2,9,1,10,10);

        //m2.Imprimir();
        //m1.Imprimir();

        //System.out.println("'consume alimento'");

        //m1.consAlim(5,0,10);

        //m1.Imprimir();

        //System.out.println("'estats de alimento'");



        //Alimento a1 = new Alimento("vel", 8, 2);

        //a1.Imprimir();

        //System.out.println("'prueba de matriz'");

        Mapa mapa1 = new Mapa(10, 10, 0);



        //System.out.println("'prueba de mover microOrg'");



        //agregar microrg a la matriz
        //for (int k = 0; k < 5; k++ )
        //{
            //int tempX = (int)(Math.random()*10+0);
            //int tempY = (int)(Math.random()*10+0);
            //int tempEner = (int)(Math.random()*20+1);
            //mapa1.rellenarCasilla(tempX, tempY, new MicroOrg(tempEner, 10, 5, 1, tempX, tempY,10,10));
        //}

        //agregar alimetnos a la matriz
        //for (int k = 0; k < 5; k++ )
        //{
            //int tempX = (int)(Math.random()*10+0);
            //int tempY = (int)(Math.random()*10+0);
            //mapa1.rellenarCasilla(tempX, tempY, new Alimento("vel", 4 , 8));
        //}

        MicroOrg m3 = new MicroOrg(111, 3, 5, 2, 4 , 4,10,10);
        mapa1.rellenarCasilla(m3.getPosX(), m3.getPosY(), m3);

        mapa1.crearMicroYAlim(50);


        //MicroOrg m4 = new MicroOrg(8, 3, 5, 2, 7 , 2,10,10);
        //mapa1.rellenarCasilla(m4.getPosX(), m4.getPosY(), m4);

        //MicroOrg m5 = new MicroOrg(9, 3, 5, 2, 4 , 1,10,10);
        //mapa1.rellenarCasilla(m5.getPosX(), m5.getPosY(), m5);

        mapa1.imprimir();

        //System.out.println(mapa1.getMatriz()[4][4].getposX());
        //System.out.println("'pruba get pos'");


        //m3.mover(mapa1);
        int cordPorMover[];
        for (int p = 0; p < 4; p++)
        {
            System.out.println("cordenadas de m3");
            System.out.println(m3.getPosX());
            System.out.println(m3.getPosY());
            cordPorMover = mapa1.getMatriz()[m3.getPosX()][m3.getPosY()].mover(mapa1);
            mapa1.rellenarCasilla(cordPorMover[0], cordPorMover[1], mapa1.getMatriz()[m3.getPosX()][m3.getPosY()]);
            mapa1.vaciarCasilla(m3.getPosX(), m3.getPosY());
            m3.actualizarCoord(cordPorMover[0], cordPorMover[1]);
            if ((m3.getBuscPosX() == m3.getBuscPosX()) && (m3.getBuscPosY() == m3.getBuscPosY()))
                    m3.vaciarCordBuscar(mapa1);
            mapa1.imprimir();
        }

        //System.out.println("se puede sacar la cordenada de la fucnion");
        //System.out.println(cordPorMover[0]);
        //System.out.println(cordPorMover[1]);
    }
}
