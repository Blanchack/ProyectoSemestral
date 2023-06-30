package GUI;

import Logica.Asiento;
import Logica.Viaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResumenCompra extends JPanel {

    private static ResumenCompra instance;
    public Viaje viaje;


    public ResumenCompra(){
        this.setLayout(new GridLayout(0,1));

        JLabel msj = new JLabel("NO HAY VIAJE SELECCIONADO");
        this.add(msj);
        msj.setLocation(300, 300);
        msj.setSize(300, 50);

        this.setBorder(BorderFactory.createEmptyBorder(0, 100,0,100));

        this.setVisible(true);
    }

    public static ResumenCompra getInstance(){
        if(instance == null){
            instance = new ResumenCompra();
        }
        return instance;
    }

    public void updateViaje(Viaje viaje){
            this.viaje = viaje;
            updateCompra();
    }

    public void updateCompra(){
        this.removeAll();

        this.updateUI();

        JLabel estandar = new JLabel("TOTAL ESTANDAR:               $"+String.valueOf(viaje.totalPrecio(Asiento.TipoAsiento.ESTANDAR)));
        JLabel salonCama = new JLabel("TOTAL SALON CAMA:            $"+String.valueOf(viaje.totalPrecio(Asiento.TipoAsiento.SALON_CAMA)));
        JLabel semiCama = new JLabel("TOTAL SEMI-CAMA:              $"+String.valueOf(viaje.totalPrecio(Asiento.TipoAsiento.SEMI_CAMA)));

        JButton boton = new JButton("COMPRAR ASIENTOS");

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viaje.comprarAsientos();
                updateCompra();
                AsientosGrid grid = new AsientosGrid(viaje, viaje.getFilas(), viaje.getColumnas());
                MenuAsientos.getInstance(grid).changeGrid(grid, String.valueOf(viaje.getId()) + "       " + viaje.getSalida()+ "-"+ viaje.getDestino());
            }
        });

        estandar.setFont(new Font("Serif",Font.BOLD, 14));
        salonCama.setFont(new Font("Serif",Font.BOLD, 14));
        semiCama.setFont(new Font("Serif",Font.BOLD, 14));

        this.add(estandar);
        this.add(salonCama);
        this.add(semiCama);
        this.add(boton);


        this.updateUI();
        this.setVisible(true);
    }

}
