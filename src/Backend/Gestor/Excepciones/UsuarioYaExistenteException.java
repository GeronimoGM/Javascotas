package Backend.Gestor.Excepciones;

public class UsuarioYaExistenteException extends Exception {
    public UsuarioYaExistenteException(String message) {
        super(message);
    }
}
