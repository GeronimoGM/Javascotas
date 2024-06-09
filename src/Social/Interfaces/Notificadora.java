package Social.Interfaces;

import Social.Clases.Notificacion;
import Usuarios.Clases.Usuario;

public interface Notificadora<T extends Notificadora<T>> {
    public Notificacion<T> notificar(Usuario usuario);
}
