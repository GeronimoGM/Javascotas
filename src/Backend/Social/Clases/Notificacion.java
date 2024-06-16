package Backend.Social.Clases;

import Backend.Social.Interfaces.Notificadora;

public class Notificacion<T extends Notificadora<T>> {
    private T notificacion;
    // Constructores
    public Notificacion(T notificacion) {
        this.notificacion = notificacion;
    }
    // Getters y setters
    public T getNotificacion() {
        return notificacion;
    }
    // Métodos
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((notificacion == null) ? 0 : notificacion.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notificacion<?> other = (Notificacion<?>) obj;
        if (notificacion == null) {
            if (other.notificacion != null)
                return false;
        } else if (!notificacion.equals(other.notificacion))
            return false;
        return true;
    }   
}
