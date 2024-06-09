package Usuarios.Clases;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import Social.Clases.Chat;
import Social.Clases.Notificacion;
import Social.Clases.Publicacion;
import Usuarios.Clases.Mascotas.Abstracta.Mascota;

public class Usuario {
    private String username;
    private String nombre;
    private String contraseña;
    private LocalDate fechaDeNacimiento;
    private int edad;
    private File foto;
    private char sexo;
    private ArrayList<Mascota> mascotas;
    private LinkedList<Chat> chats;
    private LinkedHashSet<Notificacion<?>> notificaciones; // TODO: fijarse que poner en lugar del comodín o si dejarlo así
    private HashSet<Usuario> bloqueados;
    // Constructores
    public Usuario(String username, String nombre, String contraseña, LocalDate fechaDeNacimiento, int edad, File foto,
            char sexo) {
        this.username = username;
        this.nombre = nombre;
        this.contraseña = contraseña;
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
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
    
}
