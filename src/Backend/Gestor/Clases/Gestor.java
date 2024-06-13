package Backend.Gestor.Clases;

import java.util.HashMap;

import Backend.Gestor.Excepciones.UsuarioYaExistenteException;
import Backend.Social.Clases.Usuario;

public class Gestor {
    private static HashMap<String, Usuario> usuarios = new HashMap<>();

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
}
