package Backend.Gestor.Excepciones;

public class UsuarioNoExistenteException extends Exception {
    public UsuarioNoExistenteException(String message) {
        super(message);
    }
}
