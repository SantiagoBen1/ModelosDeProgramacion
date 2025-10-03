// WebDisplay.java
public class WebDisplay implements TransporteDisplay {
    @Override
    public void mostrar(Transporte transporte) {
        // Esta implementación es de ejemplo; en una app real construirías HTML/GUI.
        System.out.println("[WEB] " + transporte.toString());
    }
}
