package Backend.Social.Clases;

import Backend.Social.Interfaces.Notificadora;

public class Notificacion<T extends Notificadora<T>> {
    public T notificacion;
    // Constructores
    public Notificacion(T notificacion) {
        this.notificacion = notificacion;
    }
    // Getters y setters
    public T getNotificacion() {
        return notificacion;
    }
    public void setNotificacion(T notificacion) {
        this.notificacion = notificacion;
    }
}
