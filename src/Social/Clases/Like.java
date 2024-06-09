package Social.Clases;

import Social.Interfaces.Notificadora;
import Usuarios.Clases.Usuario;

public class Like implements Notificadora {
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // cons

    public Like(Usuario usuario) {
        this.usuario = usuario;
    }

    //methods

    
}
