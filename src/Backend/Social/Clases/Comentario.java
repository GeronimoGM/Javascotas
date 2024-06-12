package Backend.Social.Clases;

import java.time.LocalDateTime;
import java.util.HashSet;

import Backend.Social.Interfaces.Likeable;
import Backend.Social.Interfaces.Notificadora;
import Backend.Usuarios.Clases.Usuario;

public class Comentario implements Notificadora<Comentario>, Likeable, Comparable<Comentario> {
    private Usuario usuario;
    private String texto;
    private LocalDateTime hora;
    private HashSet<Like> likes;

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
    public LocalDateTime getHora() {
        return hora;
    }
    public HashSet<Like> getLikes() {
        return likes;
    }
    //cons

    public Comentario(Usuario usuario, String texto) {
        this.usuario = usuario;
        this.texto = texto;
        hora = LocalDateTime.now();
        likes = new HashSet<>();
    }

    //methods
    public void likear(Usuario usuario) {
        likes.add(new Like(usuario));
    }

    public void unlikear(Usuario usuario) {
        likes.remove(new Like(usuario));
    }

    public int cantidadLikes() {
        return likes.size();
    }
    
    @Override
    public int compareTo(Comentario o) {
        return Integer.compare(this.cantidadLikes(), o.cantidadLikes());
    }
    
    @Override
    public Usuario notificar(Usuario usuario) {
        usuario.anadirNotificacion(new Notificacion<Comentario>(this));
        return usuario;
    }

    // TODO: arreglar bug (comentarios con mismos likes los toma como iguales)
}