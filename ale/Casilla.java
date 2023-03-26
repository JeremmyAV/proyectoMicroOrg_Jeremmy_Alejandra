package com.mycompany.juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Casilla extends JButton implements ActionListener {

    private Organismo organismo;

    public Casilla(Organismo organismo) {
        super();
        this.organismo= organismo;
        addActionListener(this); // se agrega como listener del botón
    }

    public Casilla() {
        super();
        addActionListener(this); // se agrega como listener del botón
    }

    public Organismo getOrganismo() {
        return organismo;
    }

    public void setOrganismo(Organismo organismo) {
        this.organismo = organismo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // se muestra un JOptionPane con el nombre del pato
        JOptionPane.showMessageDialog(null, "Es un " + organismo.getTipo());
    }

}
