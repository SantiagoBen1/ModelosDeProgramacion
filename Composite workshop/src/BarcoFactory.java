// BarcoFactory.java
public class BarcoFactory implements TransportFactory {
    @Override
    public Transporte crearTransporte(String modelo, String fabricante, int capacidad, double autonomia, TransporteDisplay display) {
        return new Barco.Builder()
                .modelo(modelo)
                .fabricante(fabricante)
                .capacidadPasajeros(capacidad)
                .autonomia(autonomia)
                .display(display)
                .build();
    }
}
