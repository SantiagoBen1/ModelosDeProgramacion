class DetenidoState implements State {
    private ReproductorMusica context;

    public DetenidoState(ReproductorMusica context) {
        this.context = context;
    }

    @Override
    public void play() {
        System.out.println("▶️  Iniciando reproducción…");
        context.changeState(new ReproduciendoState(context));
    }

    @Override
    public void pause() {
        System.out.println("⚠️  No se puede pausar: está detenido.");
    }

    @Override
    public void stop() {
        System.out.println("⚠️  Ya estaba detenido.");
    }

    @Override
    public void next() {
        System.out.println("⏭️  Saltar pista y reproducir.");
        context.changeState(new ReproduciendoState(context));
    }
}
