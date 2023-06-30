package Wrappers;

import GUI.AsientosGrid;
import GUI.MenuAsientos;
import GUI.ResumenCompra;
import Logica.Viaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViajeWrapper extends JPanel {
    Viaje viaje;
    JButton boton;

    public ViajeWrapper(Viaje viaje){
        boton = new JButton(String.valueOf(viaje.getId()) + "       " + viaje.getSalida()+ "-"+ viaje.getDestino());
        add(boton);

        this.setPreferredSize(new Dimension(250, 100));
        boton.setPreferredSize(new Dimension(250, 100));

        this.viaje = viaje;

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AsientosGrid grid = new AsientosGrid(viaje, viaje.getFilas(), viaje.getColumnas());
                MenuAsientos menu = MenuAsientos.getInstance(grid);
                menu.changeGrid(grid ,String.valueOf(viaje.getId()) + "       " + viaje.getSalida()+ "-"+ viaje.getDestino());
                ResumenCompra.getInstance().updateViaje(viaje);
            }
        });

        this.setVisible(true);
    }


}
