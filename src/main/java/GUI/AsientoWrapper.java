package GUI;

import Logica.Asiento;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AsientoWrapper extends JButton {

    Asiento asiento;


    AsientoWrapper(Asiento asiento){
        super(String.valueOf(asiento.getId()));
        this.asiento = asiento;

        setColor(asiento);

        //this.add(id);
        this.setPreferredSize(new Dimension(50, 10));

        this.setVisible(true);
    }

    void setColor(Asiento asiento){
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
