package Backend.Social.Clases;

import java.time.LocalDateTime;

import Backend.Social.Interfaces.Notificadora;
import Backend.Usuarios.Clases.Usuario;

public class Mensaje implements Notificadora<Mensaje> {
    private String username;
    private String texto;
    private LocalDateTime hora;
    // Constructores
    public Mensaje(String username, String texto) {
        this.username = username;
        this.texto = texto;
        this.hora = LocalDateTime.now();
    }
    // Getters y setters
    public String getTexto() {
        return texto;
    }
    public String getUsername() {
        return username;
    }
    public LocalDateTime getHora() {
        return hora;
    }
    // Métodos
    @Override
    public Usuario notificar(Usuario usuario) {
        usuario.anadirNotificacion(new Notificacion<Mensaje>(this));
        return usuario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hora == null) ? 0 : hora.hashCode());
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
        Mensaje other = (Mensaje) obj;
        if (hora == null) {
            if (other.hora != null)
                return false;
        } else if (!hora.equals(other.hora))
            return false;
        return true;
    }
}
