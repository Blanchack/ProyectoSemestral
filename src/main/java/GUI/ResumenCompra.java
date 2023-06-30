package GUI;

import Logica.Asiento;
import Logica.CompraInvalidaException;
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

        JLabel estandar = new JLabel("TOTAL ESTANDAR:               $"+String.valueOf(viaje.totalAsientos(Asiento.TipoAsiento.ESTANDAR)*viaje.getpEstandar()));
        JLabel salonCama = new JLabel("TOTAL SALON CAMA:            $"+String.valueOf(viaje.totalAsientos(Asiento.TipoAsiento.SALON_CAMA)*viaje.getpCama()));
        JLabel semiCama = new JLabel("TOTAL SEMI-CAMA:              $"+String.valueOf(viaje.totalAsientos(Asiento.TipoAsiento.SEMI_CAMA)*viaje.getpSCama()));
        JLabel total = new JLabel("TOTAL :                          $"+String.valueOf(viaje.totalAsientos(Asiento.TipoAsiento.SEMI_CAMA)*viaje.getpSCama() + viaje.totalAsientos(Asiento.TipoAsiento.SALON_CAMA)*viaje.getpCama() + viaje.totalAsientos(Asiento.TipoAsiento.ESTANDAR)*viaje.getpEstandar()));

        JButton boton = new JButton("COMPRAR ASIENTOS");

        ResumenCompra este = this;

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    viaje.comprarAsientos();
                    JOptionPane.showMessageDialog(este, "Compra realizada correctamente.", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                } catch (CompraInvalidaException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(este, "No hay ningun asiento seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
        this.add(total);
        this.add(boton);


        this.updateUI();
        this.setVisible(true);
    }

}
