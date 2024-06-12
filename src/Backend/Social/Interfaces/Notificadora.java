package Backend.Social.Interfaces;

import Backend.Social.Clases.Usuario;

public interface Notificadora<T extends Notificadora<T>> {
    public Usuario notificar(Usuario usuario);
}
