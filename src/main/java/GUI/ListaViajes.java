package GUI;

import Logica.Viaje;
import Wrappers.ViajeWrapper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListaViajes extends JPanel {
    JScrollPane scroll;

    public ListaViajes(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.add(new ViajeWrapper(new Viaje(1, 40, "Concepcion", "Osorno", 8, 12, 100, 200, 300, 4, 10)));
        this.add(new ViajeWrapper(new Viaje(2, 40, "Concepcion", "Santiago", 8, 12, 100, 200, 300, 4, 10)));
        this.add(new ViajeWrapper(new Viaje(3, 40, "Concepcion", "Los Angeles", 8, 12, 100, 200, 300, 4, 10)));
        this.add(new ViajeWrapper(new Viaje(4, 40, "Concepcion", "Puerto Montt", 8, 12, 100, 200, 300, 4, 10)));
        this.add(new ViajeWrapper(new Viaje(5, 40, "Santiago", "Valdivia", 8, 12, 100, 200, 300, 4, 10)));
        this.add(new ViajeWrapper(new Viaje(6, 40, "Concepcion", "Valparaiso", 8, 12, 100, 200, 300, 4, 10)));
        this.add(new ViajeWrapper(new Viaje(7, 40, "Santiago", "Concepcion", 8, 12, 100, 200, 300, 4, 10)));

        scroll = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setVisible(true);

    }
}
