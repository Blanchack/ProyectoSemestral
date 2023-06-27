package GUI;

import Logica.Asiento;
import Logica.Viaje;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class AsientosGrid extends JPanel {
    Viaje viaje;
    int height;
    int width;
    int size;


    public AsientosGrid(Viaje viaje, int width, int height){
        size = viaje.getnAsientos();

        for(int i = 0; i < size; i++){
            this.add(new AsientoWrapper(viaje.getAsiento(i)));
        }
        this.setLayout(new GridLayout(height, width));
    }

}
