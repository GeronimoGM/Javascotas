package Social.Clases;

import java.time.LocalDateTime;
import java.util.HashSet;

import Social.Interfaces.Likeable;
import Social.Interfaces.Notificadora;
import Usuarios.Clases.Usuario;

public class Comentario implements Notificadora<Comentario>, Likeable, Comparable<Comentario> {
    private Publicacion publicacion;
    private Usuario usuario;
    private String texto;
    private LocalDateTime hora;
    private HashSet<Like> likes;

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
    public LocalDateTime getHora() {
        return hora;
    }
    public HashSet<Like> getLikes() {
        return likes;
    }
    //cons

    public Comentario(Publicacion publicacion, Usuario usuario, String texto) {
        this.publicacion = publicacion;
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
    public Notificacion<Comentario> notificar(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificar'");
    }
}
