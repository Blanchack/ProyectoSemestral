package Wrappers;

import GUI.ResumenCompra;
import Logica.Asiento;
import Logica.AsientoInvalido;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsientoWrapper extends JButton {

    Asiento asiento;

    /**
     * wrapper grafico de la clase asiento.
     * @param asiento Asiento al cual se referencia.
     */
    public AsientoWrapper(Asiento asiento){
        super(String.valueOf(asiento.getId()));
        this.asiento = asiento;

        setColor();

        //this.add(id);
        this.setPreferredSize(new Dimension(50, 10));

        AsientoWrapper este = this;

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(asiento.isSelect()){
                    asiento.deselect();
                }
                else{
                    try {
                        asiento.select();
                    } catch (AsientoInvalido ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(este, "Este Asiento ya esta comprado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                setColor();
                ResumenCompra.getInstance().updateCompra();
            }
        });

        this.setVisible(true);
    }

    /**
     * Cambia el color de la representacion grafica dependiendo del estado del asiento.
     */
    void setColor(){
        if(asiento.isSelect()){
            this.setBackground(Color.BLUE);
            return;
        }
        if(asiento.isComprado()){
            this.setBackground(Color.RED);
            return;
        }
        switch (asiento.getType()){

            case SALON_CAMA -> {
                this.setBackground(Color.YELLOW);
            }
            case SEMI_CAMA -> {
                this.setBackground(Color.MAGENTA);
            }
            case ESTANDAR -> {
                this.setBackground(Color.GREEN);
            }
        }
    }
}
