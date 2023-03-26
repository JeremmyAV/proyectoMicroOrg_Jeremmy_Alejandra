package com.mycompany.juego;

public class MicroorganismoNPC extends Organismo {
   // private String tipoAlim;
   private int enerAlim;
   private int tamaAlim;
   private int visionAlim;
   private int velAlim;

   public MicroorganismoNPC( int enA, int taA, int viA, int velA){
       super();
       enerAlim = enA;
       tamaAlim = taA;
       visionAlim = viA;
       velAlim = velA;

   }
   @Override
   public String getTipo(){
       return "microorganismo";
   }

    @Override
    public int getEnergia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEnergia(int energia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getVision() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setVision(int vision) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getVelocidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getEdad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEdad(int edad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMaxEnergia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMaxVision() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMaxVelocidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMaxEdad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMinEnergia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMinVision() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMinVelocidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMinEdad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

/*
public class MicroorganismoNPC extends Organismo {

    private int energia, vision, velocidad, edad;
    private String tipo;

    public MicroorganismoNPC(int energia, int vision, int velocidad, int edad) {
        this.setEnergia(energia);
        this.setVision(vision);
        this.setVelocidad(velocidad);
        this.setEdad(edad);
        this.setTipo(tipo);
    }
 
    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia < minEnergia) {
            this.energia = minEnergia;
        } else if (energia > maxEnergia) {
            this.energia = maxEnergia;
        } else {
            this.energia = energia;
        }
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        if (vision < minVision) {
            this.vision = minVision;
        } else if (vision > maxVision) {
            this.vision = maxVision;
        } else {
            this.vision = vision;
        }
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        if (velocidad < minVelocidad) {
            this.velocidad = minVelocidad;
        } else if (velocidad > maxVelocidad) {
            this.velocidad = maxVelocidad;
        } else {
            this.velocidad = velocidad;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < minEdad) {
            this.edad = minEdad;
        } else if (edad > maxEdad) {
            this.edad = maxEdad;
        } else {
            this.edad = edad;
        }
    }

    public int getMaxEnergia() {
        return maxEnergia;
    }

    public int getMaxVision() {
        return maxVision;
    }

    public int getMaxVelocidad() {
        return maxVelocidad;
    }

    public int getMaxEdad() {
        return maxEdad;
    }

    public int getMinEnergia() {
        return minEnergia;
    }

    public int getMinVision() {
        return minVision;
    }

    public int getMinVelocidad() {
        return minVelocidad;
    }

    public int getMinEdad() {
        return minEdad;
    }

    @Override
    public String getTipo(){
        return "micro";
    }



    public void comer(Object alimento) {
        if(alimento instanceof Alimento alim){ // si come un alimento
            energia += alim.getEnergia();
            vision += alim.getVision();
        } else if(alimento instanceof MicroOrg org){ // si come un microOrg
            energia += org.getEnergia() / 2;
        }
     }
     public void consAlim(int enA, int viA, int veA)
     {
         energia += enA;
         vision += viA;
         velocidad += veA;
 
     }
     
     // Se mueve si tiene suf energia
     public boolean puedeMoverse() {
         return energia > 0; // determinar la cantidad de pasos segun la velocidad
                             // que tenga el microOrg
     }
         // Decrementa la energía en 1 unidad 
     public void mover() { // ES NECESARIO LAS COORDENADAS DE MICROORG?
         if(puedeMoverse()){
             energia -= 1;
             velocidad -= 1; 
             System.out.println("Se modifico las caracteristicas");
             System.out.println("Energia"); System.out.println(energia);
             System.out.println("Velocidad");System.out.println(velocidad);
         }
         else{
             System.out.println("No te puedes mover,no tienes suficiente energia");
         }
     }*/

//}
