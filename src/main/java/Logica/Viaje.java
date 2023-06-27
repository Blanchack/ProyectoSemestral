package Logica;

import java.util.ArrayList;

public class Viaje {

    private int id;
    private int nAsientos;
    private String destino;
    private String salida;
    private int pEstandar;
    private int pSCama;
    private int pCama;

    private int pSeleccionado;

    private ArrayList<Asiento> asientos;

    public Viaje(int id, int nAsientos, String salida, String destino, int nCama, int nSemi, int pEstandar, int pSCama, int pCama){
        this.nAsientos = nAsientos;
        this.salida = salida;
        this.destino = destino;
        this.pCama = pCama;
        this.pSCama = pSCama;
        this.pEstandar = pEstandar;

        asientos = new ArrayList<Asiento>();

        for(int i = 0; i < nCama; i++){
            asientos.add(new Asiento(Asiento.TipoAsiento.SALON_CAMA));
        }
        for(int i = nCama; i < nSemi; i++){
            asientos.add(new Asiento(Asiento.TipoAsiento.SEMI_CAMA));
        }
        for(int i = nSemi+nCama; i < nAsientos; i++){
            asientos.add(new Asiento(Asiento.TipoAsiento.ESTANDAR));
        }
    }

    public void seleccionarAsiento(int id){
        asientos.get(id).select();
        pSeleccionado += getPrecioAsiento(asientos.get(id));
    }
    public void deseleccionarAsiento(int id){
        asientos.get(id).deselect();
        pSeleccionado -= getPrecioAsiento(asientos.get(id));
    }

    public int getPrecioAsiento(Asiento asiento){
        switch (asiento.getType()){

            case SALON_CAMA -> {
                return pCama;
            }
            case SEMI_CAMA -> {
                return pSCama;
            }
            case ESTANDAR -> {
                return pEstandar;
            }
        }
        return -1;
    }

    public int comprarAsientos(){
        for(int i = 0; i < nAsientos; i++){
            if(asientos.get(i).isSelect()){
                asientos.get(i).comprar();
            }
        }
        int precio = pSeleccionado;
        pSeleccionado = 0;
        return precio;
    }
}
