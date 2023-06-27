package GUI;

import Logica.Asiento;
import Logica.Viaje;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    Ventana(){
        this.setLayout(new BorderLayout());

        Viaje viaje = new Viaje(1, 40, "conce", "santiaog", 10, 10, 100, 200, 300);
        AsientosGrid grid = new AsientosGrid(viaje, 4, 10);

        this.add(grid, BorderLayout.WEST);

        this.setTitle("Reserva Viajes 3000");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setVisible(true);
    }
}
