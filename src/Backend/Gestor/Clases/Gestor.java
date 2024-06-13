package Backend.Gestor.Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Backend.Gestor.Excepciones.ContrasenaIncorrectaException;
import Backend.Gestor.Excepciones.UsuarioNoExistenteException;
import Backend.Gestor.Excepciones.UsuarioYaExistenteException;
import Backend.Social.Clases.Usuario;

public class Gestor {
    public static Usuario sesionIniciada = null;
    private static HashMap<String, Usuario> usuarios = new HashMap<>();
    private final static File jsonFile = new File("files/usuarios.json"); 

    public Gestor() throws InstantiationException{
        throw new InstantiationException("Esta clase no puede ser instanciada");
    }

    public static void registrarse(Usuario usuario) throws UsuarioYaExistenteException {
        if (!usuarios.containsKey(usuario.getUsername())) {
            usuarios.put(usuario.getUsername(), usuario);
        }
        else {
            throw new UsuarioYaExistenteException("Ya existe un usuario con el username: " + usuario.getUsername());
        }
    }

    public static void iniciarSesion(String username, String contrasena) throws UsuarioNoExistenteException, ContrasenaIncorrectaException {
        if (!usuarios.containsKey(username)) {
            throw new UsuarioNoExistenteException("No existe un usuario con el username: " + username);
        }
        else {
            Usuario porIniciar = usuarios.get(username);
            if (porIniciar.getContrasena().equals(contrasena)) {
                sesionIniciada = porIniciar;
            }
            else {
                throw new ContrasenaIncorrectaException("Contraseña incorrecta");
            }
        }
    }

    public static void cerrarSesion() { // TODO: cuando se haya hecho la función guardar hacer que después de cerrar sesión se guarde.
        sesionIniciada = null;
    }

    public static void cargar() {
        BufferedReader buffer = null;

        try {
            buffer = new BufferedReader(new FileReader(jsonFile));

            Gson gson = new Gson(); // TODO: hacer MascotaAdapter

            usuarios = gson.fromJson(buffer, new TypeToken<HashMap<String, Usuario>>(){}.getType());
        } catch (IOException e) {
            
        }
        finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        }
    }
}
