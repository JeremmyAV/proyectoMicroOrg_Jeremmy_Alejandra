import java.util.Map;

public class Alimento extends Organismo {
    
    private String tipoAlim;
    public int enerAlim;
    private int tamaAlim;
    private int visionAlim;
    private int velocAlim;

    // genera los atributos del alimento
    public Alimento(String ti, int enA, int taA, int veA, int viA)
    {
        tipoAlim = ti;
        enerAlim = enA;
        tamaAlim = taA;
        tipo = "alimento";

        visionAlim = viA;
        velocAlim = veA;

    }


    public void Imprimir()
    {
        System.out.println(tipoAlim);
        System.out.println(enerAlim);
        System.out.println(tamaAlim);

    }

    public int getEnergia()
    {
        return enerAlim;
    }

    public int getVelocidad()
    {
        return velocAlim;
    }

    public int getVision()
    {
        return visionAlim;
    }

    public int getEdad()
    {
        return 0;
    }
    public int getPosX()
    {
        return 0;
    }

    public int getPosY()
    {
        return 0;
    } 

    public int getBuscPosX()
    {
        return 0;
    }
    public int getBuscPosY()
    {
        return 0;
    }
    public void vaciarCordBuscar(Mapa tempMapa)
    {
    }

    public void consAlim(int enA, int viA, int veA)
    {
    }
    public void cambiarBuscarCorden(int nuevoBuscPosX, int nuevoBuscPosY)
    {
    }
    public void actualizarCoord(int tempX, int tempY)
    {
    }

    public int[] mover(Mapa temMapa)
    {
        int tempSalida[];
        tempSalida = new int[2];
        tempSalida[0] = 1;
        tempSalida[1] = 1;
        return tempSalida;
    }


}
