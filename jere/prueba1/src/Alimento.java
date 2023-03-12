public class Alimento {
    
    private String tipoAlim;
    private int enerAlim;
    private int tamaAlim;
    private int posiAlim [];

    public Alimento(String ti, int enA, int taA, int poA[])
    {
        tipoAlim = ti;
        enerAlim = enA;
        tamaAlim = taA;
        posiAlim = poA;
    }


    public void imprimir()
    {
        System.out.println(tipoAlim);
        System.out.println(enerAlim);
        System.out.println(tamaAlim);
        
        System.out.println(posiAlim[0]);
        System.out.println(posiAlim[1]);

    }


}
