package Social.Clases;

import java.time.LocalDateTime;

import Social.Interfaces.Notificadora;
import Usuarios.Clases.Usuario;

public class Mensaje implements Notificadora {
    private LocalDateTime hora;
    private String texto;
    private Usuario usuario;
    
    public LocalDateTime getHora() {
        return hora;
    }
    public void setHora(LocalDateTime hora) {
        this.hora = hora;
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

    public Mensaje(LocalDateTime hora, String texto, Usuario usuario) {
        this.hora = hora;
        this.texto = texto;
        this.usuario = usuario;
    }

    //methods
    
}
