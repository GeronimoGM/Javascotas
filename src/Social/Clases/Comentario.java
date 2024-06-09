package Social.Clases;

import java.time.LocalDate;
import java.util.HashSet;

import Social.Interfaces.Notificadora;
import Usuarios.Clases.Usuario;

public class Comentario implements Notificadora {
    private Publicacion publicacion;
    private Usuario usuario;
    private String texto;
    private LocalDate hora;
    private HashSet <Usuario> likes;

    public Publicacion getPublicacion() {
        return publicacion;
    }
    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public LocalDate getHora() {
        return hora;
    }
    public void setHora(LocalDate hora) {
        this.hora = hora;
    }
    public HashSet<Usuario> getLikes() {
        return likes;
    }
    public void setLikes(HashSet<Usuario> likes) {
        this.likes = likes;
    }

    //cons

    public Comentario(Publicacion publicacion, Usuario usuario, String texto, LocalDate hora, HashSet<Usuario> likes) {
        this.publicacion = publicacion;
        this.usuario = usuario;
        this.texto = texto;
        this.hora = hora;
        this.likes = likes;
    }

    //methods
    
}
