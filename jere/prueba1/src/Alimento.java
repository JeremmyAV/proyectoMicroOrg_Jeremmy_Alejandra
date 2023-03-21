public class Alimento extends Organismo {
    
    private String tipoAlim;
    private int enerAlim;
    private int tamaAlim;

    public Alimento(String ti, int enA, int taA)
    {
        tipoAlim = ti;
        enerAlim = enA;
        tamaAlim = taA;
        tipo = "alimento";

    }


    public void Imprimir()
    {
        System.out.println(tipoAlim);
        System.out.println(enerAlim);
        System.out.println(tamaAlim);

    }


}
