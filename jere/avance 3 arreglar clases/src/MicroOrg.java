public class MicroOrg extends Organismo {

    public int energia;
    private int vision;
    private int velocidad;
    private int edad;
    private int posX;
    private int posY;
    private int BuscPosX;
    private int BuscPosY;

    private int esJug;

    // genera los atributos del microOrganismo
    public MicroOrg(int en, int vi, int ve, int ed , int tempX, int tempY, int tempBuscPosX, int tempBuscPosY, int tempEsJug)
    {
        this.energia = en;
        this.vision = vi;
        this.velocidad = ve;
        this.edad = ed;
        tipo = "microOrg";
        posX = tempX;
        posY = tempY;
        BuscPosX = tempBuscPosX;
        BuscPosY = tempBuscPosY;

        esJug = tempEsJug;

    }

    //modifica los atributos cuando come un alimento
    public void consAlim(int enA, int viA, int veA)
    {
        energia += enA;
        vision += viA;
        velocidad += veA;
    }

    public void cambiarBuscarCorden(int nuevoBuscPosX, int nuevoBuscPosY)
    {
        BuscPosX = nuevoBuscPosX;
        BuscPosY = nuevoBuscPosY;
    }

    // Se mueve si tiene suf energia
    public boolean puedeMoverse() {
        return energia > 0; // determinar la cantidad de pasos segun la velocidad                   
                            // que tenga el microOrg
    }
        // Decrementa la energía en 1 unidad 
    public int[] mover(Mapa tempMapa) { // ES NECESARIO LAS COORDENADAS DE MICROORG?  J: si
        if(puedeMoverse()){
            //energia -= 1;
            //velocidad -= 1; 
            //System.out.println("Se modifico las caracteristicas");
            //System.out.println("Energia"); System.out.println(energia);
            //System.out.println("Velocidad");System.out.println(velocidad);

            if ((BuscPosX == tempMapa.getLargo()) && (BuscPosY == tempMapa.getAncho()))
            {
                Organismo porComer = null;

                for (int i = 1; i <= vision; i++)
                {
                    //System.out.print("i = ");System.out.println(i);
                    for (int k = 0; k <= i; k++)
                    {
                        //System.out.print("k = ");System.out.println(k);
                        //System.out.println("cordenada");System.out.print(posX + i);System.out.println(" ");System.out.println(posY + k);

                        if (k == 0)
                        {
                            // si se sale de la matriz
                            if ((posX + i) < tempMapa.getLargo())
                            {
                                //revisa derecha
                                if (tempMapa.getMatriz()[posX + i][posY] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[posX + i][posY].tipo != "microOrg") || (tempMapa.getMatriz()[posX + i][posY].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX + i][posY];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX + i, posY);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX + i][posY] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX + i][posY].getEnergia() > porComer.getEnergia())
                                            {
                                                //verifica si lo que hay es un organismo con energia mayor a la de el
                                                if ((tempMapa.getMatriz()[posX + i][posY].tipo != "microOrg") || ((tempMapa.getMatriz()[posX + i][posY].getEnergia() < energia)))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX + i][posY];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX + i, posY);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if ((posX - i) >= 0)
                            {
                                //revisa izquierda
                                if (tempMapa.getMatriz()[posX - i][posY] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[posX - i][posY].tipo != "microOrg") || (tempMapa.getMatriz()[posX - i][posY].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX - i][posY];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX - i, posY);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX - i][posY] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX - i][posY].getEnergia() > porComer.getEnergia())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[posX - i][posY].tipo != "microOrg") || (tempMapa.getMatriz()[posX - i][posY].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX - i][posY];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX - i, posY);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if ((posY + i) < tempMapa.getAncho())
                            {
                                //revisa abajo
                                if (tempMapa.getMatriz()[posX][posY + i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[posX][posY + i].tipo != "microOrg") || (tempMapa.getMatriz()[posX][posY + i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX][posY + i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX , posY + i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX][posY + i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX][posY + i].getEnergia() > porComer.getEnergia())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[posX][posY + i].tipo != "microOrg") || (tempMapa.getMatriz()[posX][posY + i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX][posY + i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX , posY + i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if ((posY - i) >= 0)
                            {
                                //revisa arriba
                                if (tempMapa.getMatriz()[posX][posY - i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[posX][posY - i].tipo != "microOrg") || (tempMapa.getMatriz()[posX][posY - i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX][posY - i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX , posY - i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX][posY - i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX][posY - i].getEnergia() > porComer.getEnergia())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[posX][posY - i].tipo != "microOrg") || (tempMapa.getMatriz()[posX][posY - i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX][posY - i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX , posY - i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else
                        {
                            // si se sale de la matriz
                            if (((posX + i) <  tempMapa.getLargo()) && ((posY + k) < tempMapa.getAncho()))
                            {
                                //revisa derecha abajo
                                if (tempMapa.getMatriz()[posX + i][posY + k] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[posX + i][posY + k].tipo != "microOrg") || (tempMapa.getMatriz()[posX + i][posY + k].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX + i][posY + k];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX + i, posY + k);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX + i][posY + k] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX + i][posY + k].getEnergia() > porComer.getEnergia())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[posX + i][posY + k].tipo != "microOrg") || (tempMapa.getMatriz()[posX + i][posY + k].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX + i][posY + k];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX + i, posY + k);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((posX + i) <  tempMapa.getLargo()) && ((posY - k) >= 0))
                            {
                                //revisa derecha arriba
                                if (tempMapa.getMatriz()[posX + i][posY - k] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[posX + i][posY - k].tipo != "microOrg") || (tempMapa.getMatriz()[posX + i][posY - k].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX + i][posY - k];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX + i, posY - k);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX + i][posY - k] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX + i][posY - k].getEnergia() > porComer.getEnergia())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[posX + i][posY - k].tipo != "microOrg") || (tempMapa.getMatriz()[posX + i][posY - k].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX + i][posY - k];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX + i, posY - k);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((posX - i) >= 0) && ((posY + k) < tempMapa.getLargo()))
                            {
                                //reviza izquierda abajo
                                if (tempMapa.getMatriz()[posX - i][posY + k] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[posX - i][posY + k].tipo != "microOrg") || (tempMapa.getMatriz()[posX - i][posY + k].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX - i][posY + k];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX - i, posY + k);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX - i][posY + k] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX - i][posY + k].getEnergia() > porComer.getEnergia())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[posX - i][posY + k].tipo != "microOrg") || (tempMapa.getMatriz()[posX - i][posY + k].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX - i][posY + k];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX - i, posY + k);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((posX - i) >= 0) && ((posY - k) >= 0))
                            {
                                //reviza izquierda arriba
                                if (tempMapa.getMatriz()[posX - i][posY - k] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[posX - i][posY - k].tipo != "microOrg") || (tempMapa.getMatriz()[posX - i][posY - k].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX - i][posY - k];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX - i, posY - k);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX - i][posY - k] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX - i][posY - k].getEnergia() > porComer.getEnergia())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[posX - i][posY - k].tipo != "microOrg") || (tempMapa.getMatriz()[posX - i][posY - k].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX - i][posY - k];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX - i, posY - k);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((posX + k) <  tempMapa.getLargo()) && ((posY + i) < tempMapa.getAncho()))
                            {
                                //revisa abajo derecha
                                if (tempMapa.getMatriz()[posX + k][posY + i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[posX + k][posY + i].tipo != "microOrg") || (tempMapa.getMatriz()[posX + k][posY + i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX + k][posY + i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX + k, posY + i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX + k][posY + i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX + k][posY + i].getEnergia() > porComer.getEnergia())
                                            {
                                                if ((tempMapa.getMatriz()[posX + k][posY + i].tipo != "microOrg") || (tempMapa.getMatriz()[posX + k][posY + i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX + k][posY + i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX + k, posY + i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((posX + k) <  tempMapa.getLargo()) && ((posY - i) >= 0))
                            {
                                //revisa arriba derecha
                                if (tempMapa.getMatriz()[posX + k][posY - i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        if ((tempMapa.getMatriz()[posX + k][posY - i].tipo != "microOrg") || (tempMapa.getMatriz()[posX + k][posY - i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX + k][posY - i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX + k, posY - i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX + k][posY - i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX + k][posY - i].getEnergia() > porComer.getEnergia())
                                            {
                                                if ((tempMapa.getMatriz()[posX + k][posY - i].tipo != "microOrg") || (tempMapa.getMatriz()[posX + k][posY - i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX + k][posY - i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX + k, posY - i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((posX - k) >= 0) && ((posY + i) < tempMapa.getAncho()))
                            {
                                //reviza abajo izquierda
                                if (tempMapa.getMatriz()[posX - k][posY + i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        if ((tempMapa.getMatriz()[posX - k][posY + i].tipo != "microOrg") || (tempMapa.getMatriz()[posX - k][posY + i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX - k][posY + i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX - k, posY + i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX - k][posY + i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX - k][posY + i].getEnergia() > porComer.getEnergia())
                                            {
                                                if ((tempMapa.getMatriz()[posX - k][posY + i].tipo != "microOrg") || (tempMapa.getMatriz()[posX - k][posY + i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX - k][posY + i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX - k, posY + i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((posX - k) >= 0) && ((posY - i) >= 0))
                            {
                                //reviza arriba izquierda
                                if (tempMapa.getMatriz()[posX - k][posY - i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        if ((tempMapa.getMatriz()[posX - k][posY - i].tipo != "microOrg") || (tempMapa.getMatriz()[posX - k][posY - i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[posX - k][posY - i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(posX - k, posY - i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[posX - k][posY - i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[posX - k][posY - i].getEnergia() > porComer.getEnergia())
                                            {
                                                if ((tempMapa.getMatriz()[posX - k][posY - i].tipo != "microOrg") || (tempMapa.getMatriz()[posX - k][posY - i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[posX - k][posY - i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(posX - k, posY - i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        //if (((posX + i) >= tempMapa.getLargo()) && ((posX - i) < 0) && ((posY + i) >= tempMapa.getAncho()) && ((posY - i) < 0))
                        //{
                            //System.out.println("se salio de los parametros");
                            //break;
                        //}
                    }
                    if (((posX + i) >= tempMapa.getLargo()) && ((posX - i) < 0) && ((posY + i) >= tempMapa.getAncho()) && ((posY - i) < 0))
                    {
                        //System.out.println("se salio de los parametros");
                        break;
                    }
                }

                if (porComer == null)
                {
                    System.out.println("no encontro ningun organismo");

                    int validDespla = 0;
                    int direccion = 0;

                    // elige una direccion aleatoria para moverse si no encontro ningun organismo comestible
                    System.out.println(posX - velocidad);
                    System.out.println(posY + velocidad);
                    System.out.println(velocidad);
                    while (validDespla == 0)
                    {
                        direccion = (int)(Math.random()*4+1);

                        // verifica si se puede mover a la izquierda
                        if (direccion == 1)
                        {
                            if ((posY - velocidad) >= 0)
                                validDespla = 1;
                                BuscPosX = posX;
                                BuscPosY = posY - velocidad;
                        }
                        // verifica si se puede mover arriba
                        else if (direccion == 2){
                            if ((posX + velocidad) < tempMapa.getLargo())
                                validDespla = 1;
                                BuscPosX = posX + velocidad;
                                BuscPosY = posY;
                        }
                        // verifica si se puede mover abajo
                        else if (direccion == 3){
                            if ((posY + velocidad) < tempMapa.getAncho())
                                validDespla = 1;
                                BuscPosX = posX;
                                BuscPosY = posY + velocidad;
                        }
                        // verifica si de puede mover a la izquierda
                        else
                        {
                            if ((posX - velocidad) >= 0)
                                validDespla = 1;
                                BuscPosX = posX - velocidad;
                                BuscPosY = posY;
                        }

                        if (((posY - velocidad) < 0) && ((posX + velocidad) >= tempMapa.getLargo()) && ((posY + velocidad) >= tempMapa.getAncho()) && ((posX - velocidad) < 0))
                        {
                            validDespla = 2;
                        }
                    }

                    if (validDespla == 1)
                    {
                        System.out.println("porcomer");
                        if (porComer != null)
                            System.out.println(porComer.getEnergia());
                        else{
                            System.out.println("null");
                        }
                        System.out.println(BuscPosX);
                        System.out.println(BuscPosY);
                        return desplazarse(tempMapa);
                    }
                    else
                    {
                        System.out.println("no se puede desplazar a su maximo alcanze en ninguna direccion.");
                        int tempSalida[];
                        tempSalida = new int[2];
                        tempSalida[0] = tempMapa.getLargo();
                        tempSalida[1] = tempMapa.getAncho();
                        return tempSalida;
                    }

                }
                else
                {
                    System.out.println("porcomer");
                    System.out.println(porComer.getEnergia());
                    System.out.println(BuscPosX);
                    System.out.println(BuscPosY);

                    return desplazarse(tempMapa); 
                }
            }

            else
            {
                System.out.println("porcomer");
                System.out.println(BuscPosX);
                System.out.println(BuscPosY);
                //si ya tiene cordenada
                return desplazarse(tempMapa); 
            }
        }
        else{
            System.out.println("No te puedes mover,no tienes suficiente energia");
            int tempSalida[];
            tempSalida = new int[2];
            tempSalida[0] = tempMapa.getLargo();
            tempSalida[1] = tempMapa.getAncho();
            return tempSalida;
        }
    }

    //se mueve a la posicion de las cordenadas a buscar
    public int[] desplazarse(Mapa tempMapa)
    {
        //cordenas para moverse en el siguiente turno
        int tempPosX;
        int tempPosY;

        // verifica si se tiene que desplazar a la izquierda
        if (posX > BuscPosX)
        {
            // verifica si tiene moverse a la izquierda
            if (posY > BuscPosY)
            {
                int direcTemp = (int)(Math.random()*2+1);
                //se desplaza arriba
                if (direcTemp == 1)
                {
                    if ((posX - velocidad) > BuscPosX)
                    {
                        tempPosX = posX - velocidad;
                    }
                    else
                    {
                        tempPosX = BuscPosX;
                    }
                    tempPosY = posY;
                }
                //se desplaza hacia un lado
                else
                {
                    if ((posY - velocidad) > BuscPosY)
                    {
                        tempPosY = posY - velocidad;
                    }
                    else
                    {
                        tempPosY = BuscPosY;
                    }
                    tempPosX = posX;
                }
            }
            // verifica si que moverse a la derecha
            else if (posY < BuscPosY)
            {
                int direcTemp = (int)(Math.random()*2+1);
                //se desplaza arriba
                if (direcTemp == 1)
                {
                    if ((posX - velocidad) > BuscPosX)
                    {
                        tempPosX = posX - velocidad;
                    }
                    else
                    {
                        tempPosX = BuscPosX;
                    }
                    tempPosY = posY;
                }
                //se desplaza hacia un un lado
                else
                {
                    if ((posY + velocidad) < BuscPosY)
                    {
                        tempPosY = posY + velocidad;
                    }
                    else
                    {
                        tempPosY = BuscPosY;
                    }
                    tempPosX = posX;
                }
            }
            // ya no se tiene que mover hacia los lados
            else
            {
                if ((posX - velocidad) > BuscPosX)
                {
                    tempPosX = posX - velocidad;
                }
                else
                {
                    tempPosX = BuscPosX;
                }
                tempPosY = posY;
            }
        }
        // verifica si tiene que desplazarse a abajo
        else if (posX < BuscPosX)
        {
            //verifica si tiene que moverse a la izquierda
            if (posY > BuscPosY)
            {
                int direcTemp = (int)(Math.random()*2+1);
                //se desplaza hacia abajo
                if (direcTemp == 1)
                {
                    if ((posX + velocidad) < BuscPosX)
                    {
                        tempPosX = posX + velocidad;
                    }
                    else
                    {
                        tempPosX = BuscPosX;
                    }
                    tempPosY = posY;
                }
                //se desplaza hacia un lado
                else
                {
                    if ((posY - velocidad) > BuscPosY)
                    {
                        tempPosY = posY - velocidad;
                    }
                    else
                    {
                        tempPosY = BuscPosY;
                    }
                    tempPosX = posX;
                }
            }
            // verifica si que moverse a la derecha
            else if (posY < BuscPosY)
            {
                int direcTemp = (int)(Math.random()*2+1);
                //se desplaza abajo
                if (direcTemp == 1)
                {
                    if ((posX + velocidad) < BuscPosX)
                    {
                        tempPosX = posX + velocidad;
                    }
                    else
                    {
                        tempPosX = BuscPosX;
                    }
                    tempPosY = posY;
                }
                //se desplaza hacia un un lado
                else
                {
                    if ((posY + velocidad) < BuscPosY)
                    {
                        tempPosY = posY + velocidad;
                    }
                    else
                    {
                        tempPosY = BuscPosY;
                    }
                    tempPosX = posX;
                }
            }
            // ya no se tiene que mover hacia los lados
            else
            {
                if ((posX + velocidad) < BuscPosX)
                {
                    tempPosX = posX + velocidad;
                }
                else
                {
                    tempPosX = BuscPosX;
                }
                tempPosY = posY;
            }
        }
        // solo tiene que moverse a los lados
        else
        {
            //verifica si se tiene que mover a la izquierda
            if (posY > BuscPosY)
            {
                if ((posY - velocidad) > BuscPosY)
                {
                    tempPosY = posY - velocidad;
                }
                else
                {
                    tempPosY = BuscPosY;
                }
                tempPosX = posX;
            }
            //se tiene que mover a la derecha
            else
            {
                if ((posY + velocidad) < BuscPosY)
                {
                    tempPosY = posY + velocidad;
                }
                else
                {
                    tempPosY = BuscPosY;
                }
                tempPosX = posX;
            }
        }

        System.out.println("posicion a moverse");
        System.out.println(tempPosX);
        System.out.println(tempPosY);
        int tempSalida[];
        tempSalida = new int[2];
        tempSalida[0] = tempPosX;
        tempSalida[1] = tempPosY;

        energia--;
        return tempSalida;

    }

    public void actualizarCoord(int tempX, int tempY)
    {
        posX = tempX;
        posY = tempY;
    }

    public void vaciarCordBuscar(Mapa tempMapa)
    {
        BuscPosX = tempMapa.getLargo();
        BuscPosY = tempMapa.getAncho();
    }

    //gets para todos los atributos
    public int getEnergia() { return energia; }
    public int getVelocidad() { return velocidad; }
    public int getVision() { return vision; }
    public int getEdad() { return edad; }
    public int getPosX() { return posX; }
    public int getPosY() { return posY; }
    public int getBuscPosX() { return BuscPosX; }
    public int getBuscPosY() { return BuscPosY; }
    

    public void Imprimir()
    {
        System.out.println(energia);
        System.out.println(vision);
        System.out.println(velocidad);
        System.out.println(edad);

    }

    public int valEsJug()
    {
        return esJug;
    }

    // maximos y minimos

    public void setEnergia(int energia) {
        if (energia < minEnergia) {
            this.energia = minEnergia;
        } else if (energia > maxEnergia) {
            this.energia = maxEnergia;
        } else {
            this.energia = energia;
        }
    }

    public void setVision(int vision) {
        if (vision < minVision) {
            this.vision = minVision;
        } else if (vision > maxVision) {
            this.vision = maxVision;
        } else {
            this.vision = vision;
        }
    }

    public void setVelocidad(int velocidad) {
        if (velocidad < minVelocidad) {
            this.velocidad = minVelocidad;
        } else if (velocidad > maxVelocidad) {
            this.velocidad = maxVelocidad;
        } else {
            this.velocidad = velocidad;
        }
    }

    public void setEdad(int edad) {
        if (edad < minEdad) {
            this.edad = minEdad;
        } else if (edad > maxEdad) {
            this.edad = maxEdad;
        } else {
            this.edad = edad;
        }
    }
    public int getMaxEnergia() {
        return maxEnergia;
    }
    public int getMaxVision() {
        return maxVision;
    }
    public int getMaxVelocidad() {
        return maxVelocidad;
    }
    public int getMaxEdad() {
        return maxEdad;
    }
    public int getMinEnergia() {
        return minEnergia;
    }
    public int getMinVision() {
        return minVision;
    }
    public int getMinVelocidad() {
        return minVelocidad;
    }
    public int getMinEdad() {
        return minEdad;
    }
    public String getTipo(){
        return "micro";
    }

}
