package Social.Interfaces;

import Usuarios.Clases.Usuario;

public interface Likeable {
    public int cantidadLikes();
    public void likear(Usuario usuario);
    public void unlikear(Usuario usuario);
}
