// Avion.java
public class Avion extends Transporte {
    // posibles atributos específicos de Avion...
    private Avion(Builder builder) {
        super(builder);
    }

    @Override
    public String getTipo() {
        return "Avion";
    }

    @Override
    public Transporte cloneTransport() {
        // clonación simple: usando el builder copiando campos
        Avion copia = new Avion.Builder()
                .modelo(this.modelo)
                .fabricante(this.fabricante)
                .capacidadPasajeros(this.capacidadPasajeros)
                .autonomia(this.autonomia)
                .display(this.display)
                .build();
        return copia;
    }

    public static class Builder extends Transporte.Builder<Builder> {
        @Override
        protected Builder self() { return this; }

        public Avion build() {
            return new Avion(this);
        }
    }
}
