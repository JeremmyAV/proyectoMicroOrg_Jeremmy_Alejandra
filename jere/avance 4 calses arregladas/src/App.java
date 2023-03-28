public class App {
    public static void main(String[] args) throws Exception {
        
        MicroOrg m1 = new MicroOrg(10,3,2,9,2,3,10,10,0);

        MicroOrg m2 = new MicroOrg(9,2,6,2,9,1,10,10,0);

        //m2.Imprimir();
        //m1.Imprimir();

        //System.out.println("'consume alimento'");

        //m1.consAlim(5,0,10);

        //m1.Imprimir();

        //System.out.println("'estats de alimento'");



        //Alimento a1 = new Alimento("vel", 8, 2);

        //a1.Imprimir();

        //System.out.println("'prueba de matriz'");

        Mapa mapa1 = new Mapa(15, 15, 5);



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

        MicroOrg m3 = new MicroOrg(35, 3, 5, 2, 4 , 4,mapa1.getLargo(),mapa1.getAncho(),1);
        mapa1.rellenarCasilla(m3.getPosX(), m3.getPosY(), m3);

        MicroOrg m31 = new MicroOrg(10, 3, 5, 2, 5 , 6,mapa1.getLargo(),mapa1.getAncho(),0);
        mapa1.rellenarCasilla(m31.getPosX(), m31.getPosY(), m31);

        MicroVision m32 = new MicroVision(6, 3, mapa1.getLargo(), mapa1.getAncho());
        System.out.println(m32.getPosX());
        System.out.println(m32.getPosY());
        mapa1.rellenarCasilla(m32.getPosX(), m32.getPosY(), m32);
        System.out.println("stats de m32");
        System.out.println(m32.getVision());
        System.out.println(m32.getVelocidad());
        //m32.mover(mapa1);

        mapa1.crearMicroYAlim(50);


        //MicroOrg m4 = new MicroOrg(8, 3, 5, 2, 7 , 2,10,10);
        //mapa1.rellenarCasilla(m4.getPosX(), m4.getPosY(), m4);

        //MicroOrg m5 = new MicroOrg(9, 3, 5, 2, 4 , 1,10,10);
        //mapa1.rellenarCasilla(m5.getPosX(), m5.getPosY(), m5);

        mapa1.imprimir();
        mapa1.imprListaDeMicrorg();

        //System.out.println(mapa1.getMatriz()[4][4].getposX());
        //System.out.println("'pruba get pos'");


        //m3.mover(mapa1);
        int cordPorMover[];
        for (int p = 0; p < 4; p++)
        {
            System.out.println("cordenadas de m3");
            System.out.println(m32.getPosX());
            System.out.println(m32.getPosY());
            cordPorMover = mapa1.getMatriz()[m32.getPosX()][m32.getPosY()].mover(mapa1);
            if (mapa1.rellenarCasilla(cordPorMover[0], cordPorMover[1], mapa1.getMatriz()[m32.getPosX()][m32.getPosY()]) == 1)
            {
                System.out.println("el juego finalizo, estas murido");
                break;
            }
            
            mapa1.vaciarCasilla(m32.getPosX(), m32.getPosY());
            m32.actualizarCoord(cordPorMover[0], cordPorMover[1]);
            if ((m32.getBuscPosX() == m32.getPosX()) && (m32.getBuscPosY() == m32.getPosY()))
                    m32.vaciarCordBuscar(mapa1);
            mapa1.imprimir();
        }

        //System.out.println("se puede sacar la cordenada de la fucnion");
        //System.out.println(cordPorMover[0]);
        //System.out.println(cordPorMover[1]);

        /*
        System.out.println("prueba nuemors aleatorios");
        for (int i = 0; i < 10; i++)
        {
            System.out.println((int)(Math.random()*3+1));
        }
 
        AlimPeque nuevoAlimPeque = new AlimPeque();

        System.out.println("atributos del malimpeque nuevo");
        System.out.println(nuevoAlimPeque.getEnergia());
        System.out.println(nuevoAlimPeque.getVelocidad());
        System.out.println(nuevoAlimPeque.getVision());

        AlimMediano nuevAlimMediano = new AlimMediano();

        System.out.println("atributos del malimpeque nuevo");
        System.out.println(nuevAlimMediano.getEnergia());
        System.out.println(nuevAlimMediano.getVelocidad());
        System.out.println(nuevAlimMediano.getVision());

        AlimGrande nuevAlimGrande = new AlimGrande();

        System.out.println("atributos del malimpeque nuevo");
        System.out.println(nuevAlimGrande.getEnergia());
        System.out.println(nuevAlimGrande.getVelocidad());
        System.out.println(nuevAlimGrande.getVision());
        */
    }
}
