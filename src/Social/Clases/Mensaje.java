package Social.Clases;

import java.time.LocalDate;

import Social.Interfaces.Notificadora;
import Usuarios.Clases.Usuario;

public class Mensaje implements Notificadora {
    private LocalDate hora;
    private String texto;
    private Usuario usuario;
    
    public LocalDate getHora() {
        return hora;
    }
    public void setHora(LocalDate hora) {
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

    public Mensaje(LocalDate hora, String texto, Usuario usuario) {
        this.hora = hora;
        this.texto = texto;
        this.usuario = usuario;
    }

    //methods
    
}
