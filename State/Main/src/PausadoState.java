class PausadoState implements State {
    private ReproductorMusica context;

    public PausadoState(ReproductorMusica context) {
        this.context = context;
    }

    @Override
    public void play() {
        System.out.println("▶️  Reanudando desde pausa…");
        context.changeState(new ReproduciendoState(context));
    }

    @Override
    public void pause() {
        System.out.println("⚠️  Ya estaba en pausa.");
    }

    @Override
    public void stop() {
        System.out.println("⏹️  Deteniendo…");
        context.changeState(new DetenidoState(context));
    }

    @Override
    public void next() {
        System.out.println("⏭️  Siguiente pista (seguirá en pausa)...");
        // se mantiene en PAUSADO: no cambiamos de estado
    }
}
