public abstract class Transporte {
    protected String modelo;
    protected String fabricante;
    protected int capacidadPasajeros;
    protected double autonomia;
    protected TransporteDisplay display;

    protected Transporte(Builder<?> builder) {
        this.modelo = builder.modelo;
        this.fabricante = builder.fabricante;
        this.capacidadPasajeros = builder.capacidadPasajeros;
        this.autonomia = builder.autonomia;
        this.display = builder.display;
    }

    public abstract String getTipo();

    public void mostrarInformacion() {
        if (display != null) {
            display.mostrar(this);
        } else {
            System.out.println(this);
        }
    }

    public void setDisplay(TransporteDisplay display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return String.format("%s{modelo='%s', fabricante='%s', capacidad=%d, autonomia=%.2f}",
                getTipo(), modelo, fabricante, capacidadPasajeros, autonomia);
    }

    // Prototype: clonación (profunda en subclases según corresponda)
    public abstract Transporte cloneTransport();

    // Generic builder base
    public static abstract class Builder<T extends Builder<T>> {
        private String modelo;
        private String fabricante;
        private int capacidadPasajeros;
        private double autonomia;
        private TransporteDisplay display;

        public T modelo(String modelo) { this.modelo = modelo; return self(); }
        public T fabricante(String fabricante) { this.fabricante = fabricante; return self(); }
        public T capacidadPasajeros(int capacidadPasajeros) { this.capacidadPasajeros = capacidadPasajeros; return self(); }
        public T autonomia(double autonomia) { this.autonomia = autonomia; return self(); }
        public T display(TransporteDisplay display) { this.display = display; return self(); }

        protected abstract T self();

        // build debe ser implementado por subclases para devolver tipo concreto
    }
}
