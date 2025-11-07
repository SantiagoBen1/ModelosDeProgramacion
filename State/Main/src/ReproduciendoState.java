class ReproduciendoState implements State {
    private ReproductorMusica context;

    public ReproduciendoState(ReproductorMusica context) {
        this.context = context;
    }

    @Override
    public void play() {
        System.out.println("⚠️  Ya se está reproduciendo.");
    }

    @Override
    public void pause() {
        System.out.println("⏸️  Pausando…");
        context.changeState(new PausadoState(context));
    }

    @Override
    public void stop() {
        System.out.println("⏹️  Deteniendo…");
        context.changeState(new DetenidoState(context));
    }

    @Override
    public void next() {
        System.out.println("⏭️  Siguiente pista…");
        // Sigue en REPRODUCIENDO (podrías mantener el mismo objeto o crear uno nuevo)
        context.changeState(new ReproduciendoState(context));
    }
}
