package Backend.Social.Clases;

import Backend.Social.Interfaces.Notificadora;

public class Like implements Notificadora<Like> {
    private String username;
    // Constructores
    public Like(String username) {
        this.username = username;
    }
    // Getters y setters
    public String getUsername() {
        return username;
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
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }
}
