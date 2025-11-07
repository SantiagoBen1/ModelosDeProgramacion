public class ReproductorMusica {
    private State estado;

    public ReproductorMusica() {
        this.estado = new DetenidoState(this);
    }

    /* Permite a los estados cambiar el estado actual del contexto */
    public void changeState(State nuevoEstado) {
        this.estado = nuevoEstado;
    }

    /* Métodos públicos: delegan al estado actual */
    public void play()  { estado.play(); }
    public void pause() { estado.pause(); }
    public void stop()  { estado.stop(); }
    public void next()  { estado.next(); }
}
