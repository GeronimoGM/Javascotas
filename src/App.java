import Backend.Gestor.Clases.Gestor;
import Frontend.JMainFrame;

public class App {
    public static void main(String[] args) throws Exception {
        Gestor.cargar();
        new JMainFrame("Javascotas");
    }
}
