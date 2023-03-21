public class MicroOrg extends Organismo {

    private int energia;
    private int vision;
    private int velocidad;
    private int edad;


    public MicroOrg(int en, int vi, int ve, int ed)
    {
        this.energia = en;
        this.vision = vi;
        this.velocidad = ve;
        this.edad = ed;
        tipo = "microOrg";

    }

    public void consAlim(int enA, int viA, int veA)
    {
        energia += enA;
        vision += viA;
        velocidad += veA;

    }

    public void mover()
    {
        int y;
    }

    public void Imprimir()
    {
        System.out.println(energia);
        System.out.println(vision);
        System.out.println(velocidad);
        System.out.println(edad);

    }

}
