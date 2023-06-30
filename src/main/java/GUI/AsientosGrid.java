package GUI;

import Logica.Viaje;
import Wrappers.AsientoWrapper;

import javax.swing.*;
import java.awt.*;

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
