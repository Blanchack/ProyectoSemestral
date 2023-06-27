package Logica;

public class Asiento {

    public enum TipoAsiento {
        SALON_CAMA, SEMI_CAMA, ESTANDAR
    }

    private TipoAsiento type;
    private boolean select;
    private boolean comprado;


    public Asiento(TipoAsiento type){
        this.type = type;
        select = false;
        comprado = false;
    }

    TipoAsiento getType() { return type;}
    void select(){
        select = true;
    }
    void deselect(){
        select = false;
    }

    void comprar(){
        this.comprado = true;
        this.select = false;

    }

    boolean isSelect(){ return select;}
}
