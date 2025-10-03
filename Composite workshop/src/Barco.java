// Barco.java
public class Barco extends Transporte {
    // atributos específicos de Barco si se necesitan
    private Barco(Builder builder) {
        super(builder);
    }

    @Override
    public String getTipo() {
        return "Barco";
    }

    @Override
    public Transporte cloneTransport() {
        Barco copia = new Barco.Builder()
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

        public Barco build() {
            return new Barco(this);
        }
    }
}
