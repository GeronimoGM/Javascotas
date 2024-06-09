package Social.Clases;

import java.io.File;
import java.util.HashSet;
import java.util.TreeSet;

import Usuarios.Clases.Usuario;
import Usuarios.Clases.Mascotas.Abstracta.Mascota;

public class Publicacion {
    private Mascota mascota;
    private File foto;
    private String descripcion;
    private TreeSet <Comentario> comentarios;
    private HashSet <Usuario> like;

    
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
    public HashSet<Usuario> getLike() {
        return like;
    }
    public void setLike(HashSet<Usuario> like) {
        this.like = like;
    }

    //cons

    public Publicacion(Mascota mascota, File foto, String descripcion, TreeSet<Comentario> comentarios,
            HashSet<Usuario> like) {
        this.mascota = mascota;
        this.foto = foto;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
        this.like = like;
    }

    //methods
}
