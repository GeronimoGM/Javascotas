package Social.Clases;

import java.time.LocalDateTime;

import Social.Interfaces.Notificadora;
import Usuarios.Clases.Usuario;

public class Mensaje implements Notificadora<Mensaje> {
    private LocalDateTime hora;
    private String texto;
    private Usuario usuario;
    
    public LocalDateTime getHora() {
        return hora;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //cons

    public Mensaje(String texto, Usuario usuario) {
        hora = LocalDateTime.now();
        this.texto = texto;
        this.usuario = usuario;
    }
    
    //methods
    
    @Override
    public Usuario notificar(Usuario usuario) {
        usuario.anadirNotificacion(new Notificacion<Mensaje>(this));
        return usuario;
    }
}
