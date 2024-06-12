package Backend.Social.Clases;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.UUID;

import Backend.Social.Interfaces.Likeable;
import Backend.Social.Interfaces.Notificadora;
import Backend.Usuarios.Clases.Usuario;

public class Comentario implements Notificadora<Comentario>, Likeable, Comparable<Comentario> {
    private UUID id;
    private Usuario usuario;
    private String texto;
    private LocalDateTime hora;
    private HashSet<Like> likes;

    public UUID getId() {
        return id;
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

    public Comentario(Usuario usuario, String texto) {
        id = UUID.randomUUID();
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Comentario other = (Comentario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    @Override
    public int compareTo(Comentario o) {
        int res = Integer.compare(this.cantidadLikes(), o.cantidadLikes());

        if (res == 0) {
            if (this.equals(o)) {
                return 0;
            }
            else {
                return 1;
            }
        }
        else {
            return res;
        }
    }
    
    @Override
    public Usuario notificar(Usuario usuario) {
        usuario.anadirNotificacion(new Notificacion<Comentario>(this));
        return usuario;
    }
}
