package Backend.Social.Clases;

import Backend.Social.Interfaces.Notificadora;

public class Like implements Notificadora<Like> {
    private Usuario usuario;
    // Constructores
    public Like(Usuario usuario) {
        this.usuario = usuario;
    }
    // Getters y setters
    public Usuario getUsuario() {
        return usuario;
    }
    // Métodos
    @Override
    public Usuario notificar(Usuario usuario) {
        usuario.anadirNotificacion(new Notificacion<Like>(this));
        return usuario;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
        Like other = (Like) obj;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        return true;
    }
}
