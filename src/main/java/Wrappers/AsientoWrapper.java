package Wrappers;

import Logica.Asiento;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsientoWrapper extends JButton {

    Asiento asiento;


    public AsientoWrapper(Asiento asiento){
        super(String.valueOf(asiento.getId()));
        this.asiento = asiento;

        setColor();

        //this.add(id);
        this.setPreferredSize(new Dimension(50, 10));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(asiento.isComprado()){return;}

                if(asiento.isSelect()){
                    asiento.deselect();
                }
                else{
                    asiento.select();
                }
                setColor();
            }
        });

        this.setVisible(true);
    }

    void setColor(){
        if(asiento.isSelect()){
            this.setBackground(Color.BLUE);
            return;
        }
        if(asiento.isComprado()){
            this.setBackground(Color.RED);
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
