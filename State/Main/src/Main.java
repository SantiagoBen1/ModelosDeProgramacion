public class Main {
    public static void main(String[] args) {
        ReproductorMusica mp3 = new ReproductorMusica();
        mp3.play();   // DETENIDO → REPRODUCIENDO
        mp3.pause();  // REPRODUCIENDO → PAUSADO
        mp3.next();   // sigue PAUSADO, cambia de pista
        mp3.play();   // PAUSADO → REPRODUCIENDO
        mp3.stop();   // REPRODUCIENDO → DETENIDO
        mp3.next();   // DETENIDO → REPRODUCIENDO
    }
}
