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
}
