package Backend.Social.Clases;

import java.io.File;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.UUID;

import Backend.Social.Interfaces.Likeable;
import Backend.Usuarios.Clases.Usuario;
import Backend.Usuarios.Clases.Mascotas.Abstracta.Mascota;

public class Publicacion implements Likeable {
    private UUID id;
    private Mascota mascota;
    private File foto;
    private String descripcion;
    private TreeSet<Comentario> comentarios;
    private HashSet<Like> likes;
    // Constructores
    public Publicacion(Mascota mascota, File foto, String descripcion) {
        id = UUID.randomUUID();
        this.mascota = mascota;
        this.foto = foto;
        this.descripcion = descripcion;
        comentarios = new TreeSet<>();
        likes = new HashSet<>();
    }
    // Getters y setters
    public UUID getId() {
        return id;
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
    public void setComentarios(TreeSet<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    public HashSet<Like> getLikes() {
        return likes;
    }
    public void setLike(HashSet<Like> likes) {
        this.likes = likes;
    }
    // Métodos
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

    @Override
    public void likear(Usuario usuario) {
        likes.add(new Like(usuario));
    }
    @Override
    public void unlikear(Usuario usuario) {
        likes.remove(new Like(usuario));
    }
    @Override
    public int cantidadLikes() {
        return likes.size();
    }
    
    public void anadirComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public boolean eliminarComentario(Comentario comentario) {
        if (comentarios.remove(comentario)) {
            return true;
        }
        else {
            return false;
        }
    }
}