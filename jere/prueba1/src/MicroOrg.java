public class MicroOrg {

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
    }

    public void imprimir()
    {
        System.out.println(energia);
        System.out.println(vision);
        System.out.println(velocidad);
        System.out.println(edad);
    }

    public void consAlim(int enA, int viA, int veA)
    {
        energia += enA;
        vision += viA;
        velocidad += veA;

    }

}
