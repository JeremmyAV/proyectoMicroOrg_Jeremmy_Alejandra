package com.mycompany.juego;
public class MicroVelocidad extends MicroOrg{

    public MicroVelocidad(int tempX, int tempY, int tempBuscPosX, int tempBuscPosY) {
        super((int)(Math.random()*20+10), (int)(Math.random()*5+1), (int)(Math.random()*5+5), 0, tempX, tempY, tempBuscPosX, tempBuscPosY, 0);
    }

    public int[] mover(Mapa tempMapa) { 
        if(puedeMoverse()){

            if ((getBuscPosX() == tempMapa.getLargo()) && (getBuscPosY() == tempMapa.getAncho()))
            {
                Organismo porComer = null;

                for (int i = 1; i <= getVision(); i++)
                {
                    for (int k = 0; k <= i; k++)
                    {

                        if (k == 0)
                        {
                            // si se sale de la matriz
                            if ((getPosX() + i) < tempMapa.getLargo())
                            {
                                //revisa derecha
                                if (tempMapa.getMatriz()[getPosX() + i][getPosY()] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[getPosX() + i][getPosY()].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() + i][getPosY()].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX() + i][getPosY()];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() + i, getPosY());
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX() + i][getPosY()] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX() + i][getPosY()].getVision() > porComer.getVelocidad())
                                            {
                                                //verifica si lo que hay es un organismo con energia mayor a la de el
                                                if ((tempMapa.getMatriz()[getPosX() + i][getPosY()].tipo != "microOrg") || ((tempMapa.getMatriz()[getPosX() + i][getPosY()].getEnergia() < energia)))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX() + i][getPosY()];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() + i, getPosY());
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if ((getPosX() - i) >= 0)
                            {
                                //revisa izquierda
                                if (tempMapa.getMatriz()[getPosX() - i][getPosY()] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[getPosX() - i][getPosY()].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() - i][getPosY()].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX() - i][getPosY()];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() - i, getPosY());
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX() - i][getPosY()] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX() - i][getPosY()].getEnergia() > porComer.getVelocidad())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[getPosX() - i][getPosY()].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() - i][getPosY()].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX() - i][getPosY()];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() - i, getPosY());
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if ((getPosY() + i) < tempMapa.getAncho())
                            {
                                //revisa abajo
                                if (tempMapa.getMatriz()[getPosX()][getPosY() + i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[getPosX()][getPosY() + i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX()][getPosY() + i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX()][getPosY() + i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() , getPosY() + i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX()][getPosY() + i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX()][getPosY() + i].getVision() > porComer.getVelocidad())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[getPosX()][getPosY() + i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX()][getPosY() + i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX()][getPosY() + i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() , getPosY() + i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if ((getPosY() - i) >= 0)
                            {
                                //revisa arriba
                                if (tempMapa.getMatriz()[getPosX()][getPosY() - i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[getPosX()][getPosY() - i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX()][getPosY() - i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX()][getPosY() - i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() , getPosY() - i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX()][getPosY() - i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX()][getPosY() - i].getVision() > porComer.getVelocidad())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[getPosX()][getPosY() - i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX()][getPosY() - i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX()][getPosY() - i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() , getPosY() - i);
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
                            if (((getPosX() + i) <  tempMapa.getLargo()) && ((getPosY() + k) < tempMapa.getAncho()))
                            {
                                //revisa derecha abajo
                                if (tempMapa.getMatriz()[getPosX() + i][getPosY() + k] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[getPosX() + i][getPosY() + k].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() + i][getPosY() + k].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX() + i][getPosY() + k];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() + i, getPosY() + k);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX() + i][getPosY() + k] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX() + i][getPosY() + k].getVision() > porComer.getVelocidad())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[getPosX() + i][getPosY() + k].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() + i][getPosY() + k].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX() + i][getPosY() + k];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() + i, getPosY() + k);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((getPosX() + i) <  tempMapa.getLargo()) && ((getPosY() - k) >= 0))
                            {
                                //revisa derecha arriba
                                if (tempMapa.getMatriz()[getPosX() + i][getPosY() - k] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[getPosX() + i][getPosY() - k].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() + i][getPosY() - k].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX() + i][getPosY() - k];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() + i, getPosY() - k);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX() + i][getPosY() - k] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX() + i][getPosY() - k].getVision() > porComer.getVelocidad())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[getPosX() + i][getPosY() - k].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() + i][getPosY() - k].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX() + i][getPosY() - k];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() + i, getPosY() - k);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((getPosX() - i) >= 0) && ((getPosY() + k) < tempMapa.getLargo()))
                            {
                                //reviza izquierda abajo
                                if (tempMapa.getMatriz()[getPosX() - i][getPosY() + k] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[getPosX() - i][getPosY() + k].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() - i][getPosY() + k].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX() - i][getPosY() + k];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() - i, getPosY() + k);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX() - i][getPosY() + k] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX() - i][getPosY() + k].getVision() > porComer.getVelocidad())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[getPosX() - i][getPosY() + k].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() - i][getPosY() + k].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX() - i][getPosY() + k];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() - i, getPosY() + k);
                                                }
                                            }
                                        }
                                    }
                                }
                            }                               

                            // si se sale de la matriz
                            if (((getPosX() - i) >= 0) && ((getPosY() - k) >= 0))
                            {
                                //reviza izquierda arriba
                                if (tempMapa.getMatriz()[getPosX() - i][getPosY() - k] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[getPosX() - i][getPosY() - k].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() - i][getPosY() - k].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX() - i][getPosY() - k];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() - i, getPosY() - k);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX() - i][getPosY() - k] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX() - i][getPosY() - k].getVision() > porComer.getVelocidad())
                                            {
                                                //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                                if ((tempMapa.getMatriz()[getPosX() - i][getPosY() - k].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() - i][getPosY() - k].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX() - i][getPosY() - k];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() - i, getPosY() - k);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((getPosX() + k) <  tempMapa.getLargo()) && ((getPosY() + i) < tempMapa.getAncho()))
                            {
                                //revisa abajo derecha
                                if (tempMapa.getMatriz()[getPosX() + k][getPosY() + i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        //verifica si lo que hay es un microrganismo con menor energia de la que tiene
                                        if ((tempMapa.getMatriz()[getPosX() + k][getPosY() + i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() + k][getPosY() + i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX() + k][getPosY() + i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() + k, getPosY() + i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX() + k][getPosY() + i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX() + k][getPosY() + i].getVision() > porComer.getVelocidad())
                                            {
                                                if ((tempMapa.getMatriz()[getPosX() + k][getPosY() + i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() + k][getPosY() + i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX() + k][getPosY() + i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() + k, getPosY() + i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((getPosX() + k) <  tempMapa.getLargo()) && ((getPosY() - i) >= 0))
                            {
                                //revisa arriba derecha
                                if (tempMapa.getMatriz()[getPosX() + k][getPosY() - i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        if ((tempMapa.getMatriz()[getPosX() + k][getPosY() - i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() + k][getPosY() - i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX() + k][getPosY() - i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() + k, getPosY() - i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX() + k][getPosY() - i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX() + k][getPosY() - i].getVision() > porComer.getVelocidad())
                                            {
                                                if ((tempMapa.getMatriz()[getPosX() + k][getPosY() - i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() + k][getPosY() - i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX() + k][getPosY() - i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() + k, getPosY() - i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((getPosX() - k) >= 0) && ((getPosY() + i) < tempMapa.getAncho()))
                            {
                                //reviza abajo izquierda
                                if (tempMapa.getMatriz()[getPosX() - k][getPosY() + i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        if ((tempMapa.getMatriz()[getPosX() - k][getPosY() + i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() - k][getPosY() + i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX() - k][getPosY() + i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() - k, getPosY() + i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX() - k][getPosY() + i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX() - k][getPosY() + i].getVision() > porComer.getVelocidad())
                                            {
                                                if ((tempMapa.getMatriz()[getPosX() - k][getPosY() + i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() - k][getPosY() + i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX() - k][getPosY() + i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() - k, getPosY() + i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // si se sale de la matriz
                            if (((getPosX() - k) >= 0) && ((getPosY() - i) >= 0))
                            {
                                //reviza arriba izquierda
                                if (tempMapa.getMatriz()[getPosX() - k][getPosY() - i] != null)
                                {
                                    if (porComer == null)
                                    {
                                        if ((tempMapa.getMatriz()[getPosX() - k][getPosY() - i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() - k][getPosY() - i].getEnergia() < energia))
                                        {
                                            porComer = tempMapa.getMatriz()[getPosX() - k][getPosY() - i];
                                            // guarda la posicion del aliemnto que debe buscar
                                            cambiarBuscarCorden(getPosX() - k, getPosY() - i);
                                        }
                                    }
                                    else
                                    {
                                        if (tempMapa.getMatriz()[getPosX() - k][getPosY() - i] != porComer)
                                        {
                                            if (tempMapa.getMatriz()[getPosX() - k][getPosY() - i].getVision() > porComer.getVelocidad())
                                            {
                                                if ((tempMapa.getMatriz()[getPosX() - k][getPosY() - i].tipo != "microOrg") || (tempMapa.getMatriz()[getPosX() - k][getPosY() - i].getEnergia() < energia))
                                                {
                                                    porComer = tempMapa.getMatriz()[getPosX() - k][getPosY() - i];
                                                    // guarda la posicion del aliemnto que debe buscar
                                                    cambiarBuscarCorden(getPosX() - k, getPosY() - i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (((getPosX() + i) >= tempMapa.getLargo()) && ((getPosX() - i) < 0) && ((getPosY() + i) >= tempMapa.getAncho()) && ((getPosY() - i) < 0))
                    {
                        break;
                    }
                }

                if (porComer == null)
                {
                    int validDespla = 0;
                    int direccion = 0;

                    // elige una direccion aleatoria para moverse si no encontro ningun organismo comestible
                    System.out.println(getPosX() - getVelocidad());
                    System.out.println(getPosY() + getVelocidad());
                    System.out.println(getVelocidad());
                    while (validDespla == 0)
                    {
                        direccion = (int)(Math.random()*4+1);

                        // verifica si se puede mover a la izquierda
                        if (direccion == 1)
                        {
                            if ((getPosY() - getVelocidad()) >= 0)
                            {
                                validDespla = 1;
                                cambiarBuscarCorden(getPosX(), getPosY() - getVelocidad());
                            }
                        }
                        // verifica si se puede mover arriba
                        else if (direccion == 2){
                            if ((getPosX() + getVelocidad()) < tempMapa.getLargo())
                            {
                                validDespla = 1;
                                cambiarBuscarCorden(getPosX() + getVelocidad(), getPosY());
                            }
                        }
                        // verifica si se puede mover abajo
                        else if (direccion == 3){
                            if ((getPosY() + getVelocidad()) < tempMapa.getAncho())
                            {
                                validDespla = 1;
                                cambiarBuscarCorden(getPosX(), getPosY() + getVelocidad());
                            }
                        }
                        // verifica si de puede mover a la izquierda
                        else
                        {
                            if ((getPosX() - getVelocidad()) >= 0)
                            {
                                validDespla = 1;
                                cambiarBuscarCorden(getPosX() - getVelocidad(), getPosY());
                            }
                        }

                        if (((getPosY() - getVelocidad()) < 0) && ((getPosX() + getVelocidad()) >= tempMapa.getLargo()) && ((getPosY() + getVelocidad()) >= tempMapa.getAncho()) && ((getPosX() - getVelocidad()) < 0))
                        {
                            validDespla = 2;
                        }
                    }

                    if (validDespla == 1)
                    {
                        return desplazarse(tempMapa);
                    }
                    else
                    {
                        System.out.println("no se puede desplazar a su maximo alcanze en ninguna direccion.");
                        
                        if (getPosX() == 0 && getPosY() == 0)
                        {
                            cambiarBuscarCorden(tempMapa.getLargo()-1 , tempMapa.getAncho()-1);
                        }
                        else
                        {
                            cambiarBuscarCorden(0 , 0);
                        }
                        return desplazarse(tempMapa);
                    }

                }
                else
                {
                    System.out.println("es en desplazarse");
                    return desplazarse(tempMapa); 
                }
            }

            else
            {
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
    
}
    

