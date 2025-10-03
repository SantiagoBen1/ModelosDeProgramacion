// AvionFactory.java
public class AvionFactory implements TransportFactory {
    @Override
    public Transporte crearTransporte(String modelo, String fabricante, int capacidad, double autonomia, TransporteDisplay display) {
        return new Avion.Builder()
                .modelo(modelo)
                .fabricante(fabricante)
                .capacidadPasajeros(capacidad)
                .autonomia(autonomia)
                .display(display)
                .build();
    }
}
