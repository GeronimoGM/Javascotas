package Backend.Social.Clases;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.UUID;

import Backend.Mascotas.Clases.Abstracta.Mascota;
import Backend.Social.Interfaces.Likeable;

public class Publicacion implements Likeable {
    private UUID id;
    private String username;
    private LocalDateTime hora;
    private Mascota mascota;
    private File foto;
    private String descripcion;
    private TreeSet<Comentario> comentarios;
    private HashSet<Like> likes;
    // Constructores
    public Publicacion(Usuario usuario, Mascota mascota, File foto, String descripcion) {
        id = UUID.randomUUID();
        this.username = usuario.getUsername();
        this.hora = LocalDateTime.now();
        this.mascota = mascota;
        this.foto = foto;
        this.descripcion = descripcion;
        comentarios = new TreeSet<>();
        likes = new HashSet<>();
    }
    Publicacion(UUID id) {
        this.id = id;
    }
    // Getters y setters
    public UUID getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public LocalDateTime getHora() {
        return hora;
    }
    public Mascota getMascota() {
        return mascota;
    }
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    public File getFoto() {
        return foto;
    }
    public void setFoto(File foto) {
        this.foto = foto;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public TreeSet<Comentario> getComentarios() {
        return comentarios;
    }
    public HashSet<Like> getLikes() {
        return likes;
    }
    // Métodos
    @Override
    public void likear(Usuario usuario) {
        likes.add(new Like(usuario.getUsername()));
    }
    @Override
    public void unlikear(Usuario usuario) {
        likes.remove(new Like(usuario.getUsername()));
    }
    @Override
    public int getCantidadLikes() {
        return likes.size();
    }
    
    public void comentar(Comentario comentario) {
        comentarios.add(comentario);
    }

    public Comentario getComentario(UUID id) {
        var it = comentarios.iterator();

        while (it.hasNext()) {
            Comentario aux = it.next();
            if (aux.equals(new Comentario(id))) {
                return aux;
            }
        }

        return null;
    }

    public boolean eliminarComentario(Comentario comentario) {
        if (comentarios.remove(comentario)) {
            return true;
        }
        else {
            return false;
        }
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
        Publicacion other = (Publicacion) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}