package Backend.Social.Interfaces;

import Backend.Usuarios.Clases.Usuario;

public interface Notificadora<T extends Notificadora<T>> {
    public Usuario notificar(Usuario usuario);
}
