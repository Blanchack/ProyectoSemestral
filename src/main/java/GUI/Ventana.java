package GUI;

import Logica.Asiento;
import Logica.Viaje;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    Ventana(){
        this.setLayout(new BorderLayout());

        Viaje viaje = new Viaje(0, 0, " ", "", 0, 0, 0,0 , 0, 0, 0);
        AsientosGrid grid = new AsientosGrid(viaje, 4, 10);
        ListaViajes viajes = new ListaViajes();

        MenuAsientos menuAsientos = MenuAsientos.getInstance(grid);

        this.add(menuAsientos, BorderLayout.CENTER);

        JScrollPane scrollPanel = new JScrollPane(viajes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPanel, BorderLayout.WEST);

        ResumenCompra resumenCompra = ResumenCompra.getInstance();

        this.add(resumenCompra, BorderLayout.EAST);

        this.setTitle("Reserva Viajes 3000");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setVisible(true);
    }
}
