package Usuarios.Clases;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import Social.Clases.Chat;
import Social.Clases.Comentario;
import Social.Clases.Mensaje;
import Social.Clases.Notificacion;
import Social.Clases.Publicacion;
import Usuarios.Clases.Mascotas.Abstracta.Mascota;

public class Usuario {
    private String username;
    private String nombre;
    private String contrasena;
    private LocalDate fechaDeNacimiento;
    private int edad;
    private File foto;
    private char sexo;
    private LinkedHashSet <Publicacion> publicaciones;
    private ArrayList<Mascota> mascotas;
    private LinkedList<Chat> chats;
    private LinkedHashSet<Notificacion<?>> notificaciones;
    private HashSet<Usuario> bloqueados;

    // Constructores
    public Usuario(String username, String nombre, String contrasena, LocalDate fechaDeNacimiento, int edad, File foto,
            char sexo) {
        this.username = username;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.edad = edad;
        this.foto = foto;
        this.sexo = sexo;
        mascotas = new ArrayList<>();
        chats = new LinkedList<>();
        notificaciones = new LinkedHashSet<>();
        bloqueados = new HashSet<>();
    }

    // Getters y setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    // Métodos
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        Usuario other = (Usuario) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    public LinkedHashSet <Publicacion> publicar(Publicacion publicacion){

        publicaciones.add(publicacion);
        return publicaciones;
    }

    public boolean eliminarPunlicacion(Publicacion publicacion){
        boolean eliminado = false;
        Iterator <Publicacion> iterador = publicaciones.iterator();
        
        while (iterador.hasNext()) {
            if(iterador.next().equals(publicacion)){
                iterador.remove();
                eliminado = true;
            }
        }
        return eliminado;
    }

    public Publicacion comentarPublicacion(Publicacion publicacion, Comentario comentario){
        Iterator <Publicacion> iterador = publicaciones.iterator();
        Publicacion aux = iterador.next();
        while (iterador.hasNext()) {
            if (aux.equals(publicacion)){
                aux.anadirComentario(comentario);
            }else{
                aux = iterador.next();
            }
        }
        return aux;
    }
    
    public Publicacion eliminarComentario(Publicacion publicacion, Comentario comentario){
        Iterator <Publicacion> iterador = publicaciones.iterator();
        Publicacion aux = iterador.next();
        while (iterador.hasNext()) {
            if (aux.equals(publicacion)){
                iterador.remove();
            }else{
                aux = iterador.next();
            }
        }
        return aux;
    }

    
}
