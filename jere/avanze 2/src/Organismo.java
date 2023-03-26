public abstract class Organismo {
    String tipo;
    public abstract int getEnergia();
    public abstract int getVelocidad();
    public abstract int getVision() ;
    public abstract int getEdad();
    public abstract int getPosX(); 
    public abstract int getPosY(); 
    public abstract int getBuscPosX();
    public abstract int getBuscPosY();
    public abstract void vaciarCordBuscar(Mapa tempMapa);
    public abstract void consAlim(int enA, int viA, int veA);
    public abstract void cambiarBuscarCorden(int nuevoBuscPosX, int nuevoBuscPosY);
    public abstract int[] mover(Mapa temMapa);
    public abstract void actualizarCoord(int tempX, int tempY);
    public abstract void Imprimir();
}
