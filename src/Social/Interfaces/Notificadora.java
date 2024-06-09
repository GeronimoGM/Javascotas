package Social.Interfaces;

import Usuarios.Clases.Usuario;

public interface Notificadora<T extends Notificadora<T>> {
    public Usuario notificar(Usuario usuario);
}
