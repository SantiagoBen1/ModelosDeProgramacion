// TransportFactory.java
public interface TransportFactory {
    Transporte crearTransporte(String modelo, String fabricante, int capacidad, double autonomia, TransporteDisplay display);
}
