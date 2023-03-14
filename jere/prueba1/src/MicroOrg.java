public class MicroOrg {

    private int energia;
    private int vision;
    private int velocidad;
    private int edad;
    private int posicion[];


    public MicroOrg(int en, int vi, int ve, int ed, int posX, int posY)
    {
        this.energia = en;
        this.vision = vi;
        this.velocidad = ve;
        this.edad = ed;
        this.posicion = new int[2];
        this.posicion[0] = posX;
        this.posicion[1] = posY;


    }

    public void imprimir()
    {
        System.out.println(energia);
        System.out.println(vision);
        System.out.println(velocidad);
        System.out.println(edad);

        System.out.print("("); System.out.print(posicion[0]); System.out.print(","); System.out.print(posicion[1]); System.out.println(")");

    }

    public void consAlim(int enA, int viA, int veA)
    {
        energia += enA;
        vision += viA;
        velocidad += veA;

    }

}
