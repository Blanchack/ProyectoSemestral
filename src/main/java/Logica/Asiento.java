package Logica;


/**
  * Representa un asiento dentro de un viaje.
 */
public class Asiento {

    public enum TipoAsiento {
        SALON_CAMA, SEMI_CAMA, ESTANDAR
    }

    private int id;
    private TipoAsiento type;
    private boolean select;
    private boolean comprado;

    /***
     *
     * @param id numero de asiento
     * @param type Tipo de asiento
     */
    public Asiento(int id, TipoAsiento type){
        this.id = id;
        this.type = type;
        select = false;
        comprado = false;
    }

    public int getId(){return id;}

    public TipoAsiento getType() { return type;}

    /***
     * Selecciona el asiento
     * @throws AsientoInvalido si el asiento esta comprado.
     */
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
