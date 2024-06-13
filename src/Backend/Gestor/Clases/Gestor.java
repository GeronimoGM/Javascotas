package Backend.Gestor.Clases;

import java.util.HashMap;

import Backend.Gestor.Excepciones.UsuarioYaExistenteException;
import Backend.Social.Clases.Usuario;

public class Gestor {
    private static HashMap<String, Usuario> usuarios = new HashMap<>();

    public Gestor() {
        throw new RuntimeException();
    }

    public static void registrarse(Usuario usuario) throws UsuarioYaExistenteException {
        if (!usuarios.containsKey(usuario.getUsername())) {
            usuarios.put(usuario.getUsername(), usuario);
        }
        else {
            throw new UsuarioYaExistenteException("Ya existe un usuario con el username: " + usuario.getUsername());
        }
    }
}
