package Social.Clases;

import java.time.LocalDateTime;
import java.util.HashSet;

import Social.Interfaces.Likeable;
import Social.Interfaces.Notificadora;
import Usuarios.Clases.Usuario;

public class Comentario implements Notificadora<Comentario>, Likeable {
    private Publicacion publicacion;
    private Usuario usuario;
    private String texto;
    private LocalDateTime hora;
    private HashSet <Like> likes;

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
    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
    public HashSet<Like> getLikes() {
        return likes;
    }
    //cons

    public Comentario(Publicacion publicacion, Usuario usuario, String texto, LocalDateTime hora) {
        this.publicacion = publicacion;
        this.usuario = usuario;
        this.texto = texto;
        this.hora = hora;
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
    public Notificacion<Comentario> notificar(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificar'");
    }
}
