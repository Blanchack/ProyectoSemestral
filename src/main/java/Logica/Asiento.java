package Logica;

public class Asiento {

    public enum TipoAsiento {
        SALON_CAMA, SEMI_CAMA, ESTANDAR
    }

    private int id;
    private TipoAsiento type;
    private boolean select;
    private boolean comprado;


    public Asiento(int id, TipoAsiento type){
        this.id = id;
        this.type = type;
        select = false;
        comprado = false;
    }

    public int getId(){return id;}

    public TipoAsiento getType() { return type;}

    public void select() throws AsientoInvalido {
        if(!comprado){
            select = true;
        }
        else{
            throw new AsientoInvalido("Este Asiento ya esta comprado");
        }
    }
    public void deselect(){
        select = false;
    }

    void comprar(){
        this.comprado = true;
        this.select = false;
    }

    public boolean isSelect(){ return select;}
    public boolean isComprado() { return comprado;}
}
