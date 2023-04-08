public class MicroEnergia extends MicroOrg{
    
    public MicroEnergia(int tempX, int tempY, int tempBuscPosX, int tempBuscPosY) {
        super((int)(Math.random()*20+20), (int)(Math.random()*5+1), (int)(Math.random()*5+1), 0, tempX, tempY, tempBuscPosX, tempBuscPosY, 0);
    }
}
