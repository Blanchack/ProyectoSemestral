package GUI;

import javax.swing.*;
import java.awt.*;

public class MenuAsientos extends JPanel {

    private static MenuAsientos instance;
    private JLabel titulo;
    private AsientosGrid grid;

    /**
     * Representacion grafica de los asientos en un viaje.
     *
     * @param agrid Grid de asientos a dibujar en la interfaz.
     */
    private MenuAsientos(AsientosGrid agrid){
        grid = agrid;
        this.setLayout(new BorderLayout());
        this.add(agrid, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(300, 100));

        titulo = new JLabel("Seleccione un viaje");
        this.add(titulo, BorderLayout.NORTH);

        this.setBorder(BorderFactory.createEmptyBorder(0, 150,0,150));

        this.setVisible(true);

        ResumenCompra.getInstance();

    }

    /**
     * Cambiar la grilla de asientos visible.
     * @param asientosGrid Nueva Grilla.
     * @param str   Titulo superior.
     */
    public void changeGrid(AsientosGrid asientosGrid, String str){
        this.remove(grid);
        this.remove(titulo);

        titulo = new JLabel(str);

        this.add(titulo, BorderLayout.NORTH);
        this.add(asientosGrid, BorderLayout.CENTER);
        grid = asientosGrid;

        this.updateUI();

        this.setVisible(true);
    }

    public static MenuAsientos getInstance(AsientosGrid asientosGrid){
        if(instance == null){
            instance = new MenuAsientos(asientosGrid);
        }
        return instance;
    }
}
