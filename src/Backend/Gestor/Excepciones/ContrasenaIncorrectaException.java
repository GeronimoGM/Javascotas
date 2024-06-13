package Backend.Gestor.Excepciones;

public class ContrasenaIncorrectaException extends Exception {
    public ContrasenaIncorrectaException(String message) {
        super(message);
    }
}
