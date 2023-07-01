package Logica;

import java.util.ArrayList;

/**
 * Representa un viaje
 */
public class Viaje {

    private int id;
    private int nAsientos;
    private String destino;
    private String salida;
    private int pEstandar;
    private int pSCama;
    private int pCama;
    private int filas;
    private int columnas;

    private int pSeleccionado;

    private ArrayList<Asiento> asientos;

    /**
     *
     * @param id Numero de viaje
     * @param nAsientos Cantidad de Asientos
     * @param salida Terminal de salida
     * @param destino Terminal de destino
     * @param nCama Numero de asiento Salon Cama
     * @param nSemi Numero de asientos Semi Cama
     * @param pEstandar Precio del asiento estandar
     * @param pSCama    precio del asiento Semi Cama
     * @param pCama     Precio del asiento Salon Cama
     * @param filas     Filas dentro del bus
     * @param columnas  Columnas dentro del bus
     */
    public Viaje(int id, int nAsientos, String salida, String destino, int nCama, int nSemi, int pEstandar, int pSCama, int pCama, int filas, int columnas){
        this.id = id;
        this.nAsientos = nAsientos;
        this.salida = salida;
        this.destino = destino;
        this.pCama = pCama;
        this.pSCama = pSCama;
        this.pEstandar = pEstandar;
        this.columnas = columnas;
        this.filas = filas;

        asientos = new ArrayList<Asiento>();

        for(int i = 0; i < nCama; i++){
            asientos.add(new Asiento(i, Asiento.TipoAsiento.SALON_CAMA));
            //System.out.println(i);
        }
        for(int i = nCama; i < nSemi+nCama; i++){
            asientos.add(new Asiento(i, Asiento.TipoAsiento.SEMI_CAMA));
            System.out.println(i);
        }
        for(int i = nSemi+nCama; i < nAsientos; i++){
            asientos.add(new Asiento(i, Asiento.TipoAsiento.ESTANDAR));
            //System.out.println(i);
        }
    }

    public Asiento getAsiento(int id) {return asientos.get(id);};

    public int getnAsientos() { return nAsientos;}

    public void seleccionarAsiento(int id) throws AsientoInvalido {
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

    /**
     * Compra todos los asientos seleccionados.
     * @return El precio de todos los asientos seleccionados
     * @throws CompraInvalidaException Si no hay ningun asiento seleccionado.
     */
    public int comprarAsientos() throws CompraInvalidaException {
        boolean flag = false;
        for(int i = 0; i < nAsientos; i++){
            if(asientos.get(i).isSelect()){
                asientos.get(i).comprar();
                flag = true;
            }
        }
        int precio = pSeleccionado;
        pSeleccionado = 0;

        if(!flag){
            throw new CompraInvalidaException("No hay asientos seleccionados.");
        }

        return precio;
    }

    public int getId() {return id;}
    public String getSalida() {return salida;}
    public String getDestino() {return destino;}

    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }

    /**
     *
     * @param type Tipo de asiento a contar.
     * @return El numero de asientos seleccionados de cierto tipo.
     */
    public int totalAsientos(Asiento.TipoAsiento type){
        int total = 0;
        for(int i = 0; i < nAsientos; i++){
            if(asientos.get(i).getType() == type && asientos.get(i).isSelect()){
                total++;
            }
        }
        return total;
    }

    public int getpEstandar() {
        return pEstandar;
    }

    public int getpSCama() {
        return pSCama;
    }

    public int getpCama() {
        return pCama;
    }
}
