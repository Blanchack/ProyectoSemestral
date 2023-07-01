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

    /**
     * Grilla de asientos para un viaje en especifico.
     * @param viaje Viaje al cual generar la grilla.
     * @param height Numero de filas.
     * @param width Numero de columnas.
     */
    public AsientosGrid(Viaje viaje, int height, int width){
        size = viaje.getnAsientos();

        for(int i = 0; i < size; i++){
            this.add(new AsientoWrapper(viaje.getAsiento(i)));
        }
        this.setLayout(new GridLayout(width, height));
    }

}
