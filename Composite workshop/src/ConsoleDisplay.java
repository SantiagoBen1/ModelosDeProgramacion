// ConsoleDisplay.java
public class ConsoleDisplay implements TransporteDisplay {
    @Override
    public void mostrar(Transporte transporte) {
        System.out.println(transporte.toString());
    }
}
