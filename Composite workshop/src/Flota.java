// Flota.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flota extends Transporte {
    private final List<Transporte> transportes = new ArrayList<>();
    private Flota(Builder builder) {
        super(builder);
    }

    @Override
    public String getTipo() {
        return "Flota";
    }

    public void agregar(Transporte t) {
        if (t != null) transportes.add(t);
    }

    public void eliminar(Transporte t) {
        transportes.remove(t);
    }

    public List<Transporte> getComponentes() {
        return Collections.unmodifiableList(transportes);
    }

    @Override
    public void mostrarInformacion() {
        // mostrar info propia
        if (display != null) display.mostrar(this);
        else System.out.println(this);
        // mostrar componentes
        for (Transporte t : transportes) {
            System.out.print("  -> ");
            t.mostrarInformacion();
        }
    }

    @Override
    public Transporte cloneTransport() {
        Flota copia = new Flota.Builder()
                .modelo(this.modelo)
                .fabricante(this.fabricante)
                .capacidadPasajeros(this.capacidadPasajeros)
                .autonomia(this.autonomia)
                .display(this.display)
                .build();

        // clonación profunda: clonar cada componente
        for (Transporte t : this.transportes) {
            copia.agregar(t.cloneTransport());
        }
        return copia;
    }

    public static class Builder extends Transporte.Builder<Builder> {
        @Override
        protected Builder self() { return this; }

        public Flota build() {
            return new Flota(this);
        }
    }
}
