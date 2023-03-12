public class App {
    public static void main(String[] args) throws Exception {
        
        MicroOrg m1 = new MicroOrg(10,5,2,9);

        m1.imprimir();

        System.out.println("'consume alimento'");

        m1.consAlim(5,0,10);

        m1.imprimir();

        System.out.println("'estats de alimento'");

        int posA1[];
        posA1 = new int[2];
        posA1[0] = 15;
        posA1[1] = 1;

        Alimento a1 = new Alimento("vel", 8, 2, posA1);

        a1.imprimir();
    }
}
