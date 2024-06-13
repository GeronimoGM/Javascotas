package Backend.Social.Clases;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.UUID;

import javax.management.InvalidAttributeValueException;

import Backend.Mascotas.Clases.Abstracta.Mascota;

public class Usuario {
    private String username;
    private String nombre;
    private String contrasena;
    private LocalDate fechaDeNacimiento;
    @SuppressWarnings("unused")
    private int edad;
    private File foto;
    private char sexo;
    private LinkedHashSet<Publicacion> publicaciones;
    private ArrayList<Mascota> mascotas;
    private HashMap<String, Chat> chats;
    private LinkedHashSet<Notificacion<?>> notificaciones;
    // Constructores
    public Usuario(String username, String nombre, String contrasena, LocalDate fechaDeNacimiento, File foto,
            char sexo) throws InvalidAttributeValueException {
        this.username = username;
        this.nombre = nombre;
        this.contrasena = contrasena;
        setFechaNacimiento(fechaDeNacimiento);
        this.foto = foto;
        this.sexo = sexo;
        this.publicaciones = new LinkedHashSet<>();
        mascotas = new ArrayList<>();
        chats = new HashMap<>();
        notificaciones = new LinkedHashSet<>();
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
    public void setFechaNacimiento(LocalDate fechaDeNacimiento) throws InvalidAttributeValueException {
        this.fechaDeNacimiento = fechaDeNacimiento;
        setEdad(getEdad());
    }
    public int getEdad() {
        return LocalDate.now().getYear() - fechaDeNacimiento.getYear();
    }
    private void setEdad(int edad) throws InvalidAttributeValueException {
        if (edad < 0) {
            throw new InvalidAttributeValueException("La edad no puede ser menor a 0");
        }
        else {
            this.edad = edad;
        }
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
    public void setSexo(char sexo) throws InvalidAttributeValueException {
        sexo = Character.toLowerCase(sexo);
        if (sexo != 'f' && sexo != 'm') {
            throw new InvalidAttributeValueException("El sexo solo puede ser femenino(f) o masculino(m)");
        }
    }
    public LinkedHashSet<Publicacion> getPublicaciones() {
        return publicaciones;
    }
    // Métodos    
    public void publicar(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    public Publicacion getPublicacion(UUID id) {
        var it = publicaciones.iterator();

        while (it.hasNext()) {
            Publicacion aux = it.next();
            if (aux.equals(new Publicacion(id))) {
                return aux;
            }
        }

        return null;
    }

    public boolean eliminarPublicacion(Publicacion publicacion) {
        if (publicaciones.remove(publicacion)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void anadirMascota(Mascota mascota) throws InvalidAttributeValueException {
        mascotas.add(mascota);
    }

    public Chat abrirChat(Usuario usuario) {
        Chat chat = chats.get(usuario.getUsername());
        if (chat == null) {
            chat  = new Chat(this.getUsername(), usuario);
            chats.put(usuario.getUsername(), chat);
            usuario.abrirChat(this);
        }
        return chat;
    }

    private Chat abrirChat(String username) {
        Chat chat = chats.get(username);
        return chat;
    }

    void anadirMensajeRecibido(String username, Mensaje mensaje) {
        Chat chat = abrirChat(username);
        chat.anadirMensaje(mensaje);
    }
    
    void anadirNotificacion(Notificacion<?> notificacion) {
        notificaciones.add(notificacion);
    }

    public boolean eliminarNotificacion(Notificacion<?> notificacion) {
        if (notificaciones.remove(notificacion)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void limpiarNotificaciones() {
        notificaciones = new LinkedHashSet<>();
    }

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
}
