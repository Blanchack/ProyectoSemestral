package Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViajeTest {
    private Viaje viaje;

    @BeforeEach
    void setUp(){
        viaje =  new Viaje(0, 10, "Salida", "Llegada", 1, 1, 100, 200, 300, 5, 2);
    }

    @Test
    @DisplayName("Test compra sin asiento seleccionado")
    public void testSinAsiento() throws CompraInvalidaException{
        assertThrows(CompraInvalidaException.class, () ->{
            viaje.comprarAsientos();
        });
    }
    @Test
    @DisplayName("Test compra de asiento invalido")
    public void testAsientoInvalido() throws AsientoInvalido, CompraInvalidaException {
        viaje.seleccionarAsiento(0);
        viaje.comprarAsientos();
        assertThrows(AsientoInvalido.class, () ->{
            viaje.seleccionarAsiento(0);
        });

    }
    @Test
    @DisplayName("Test compra de un asiento")
    public void testCompraAsiento() throws AsientoInvalido, CompraInvalidaException {
        viaje.seleccionarAsiento(0);
        viaje.comprarAsientos();

        assertTrue(viaje.getAsiento(0).isComprado());
    }

    @Test
    @DisplayName("Test compra de Asientos")
    public void testCompraAsientos() throws AsientoInvalido, CompraInvalidaException {
        viaje.seleccionarAsiento(0);
        viaje.seleccionarAsiento(1);
        viaje.comprarAsientos();

        assertTrue(viaje.getAsiento(0).isComprado());
        assertTrue(viaje.getAsiento(1).isComprado());
    }

    @Test
    @DisplayName("Test Seleccion y deseleccion de asientos")
    public void testSeleccion() throws AsientoInvalido {
        viaje.seleccionarAsiento(0);

        viaje.seleccionarAsiento(1);
        viaje.deseleccionarAsiento(1);

        assertTrue(viaje.getAsiento(0).isSelect());
        assertFalse(viaje.getAsiento(1).isSelect());
    }
}