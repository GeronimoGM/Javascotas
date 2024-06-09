package Social.Clases;

import java.util.LinkedHashSet;

import Usuarios.Clases.Usuario;

public class Chat {
    private Usuario usuarioA;
    private Usuario usuarioB;
    private LinkedHashSet <Mensaje> mensajes;

    public Usuario getUsuarioA() {
        return usuarioA;
    }
    public void setUsuarioA(Usuario usuarioA) {
        this.usuarioA = usuarioA;
    }
    public Usuario getUsuarioB() {
        return usuarioB;
    }
    public void setUsuarioB(Usuario usuarioB) {
        this.usuarioB = usuarioB;
    }
    public LinkedHashSet<Mensaje> getMensajes() {
        return mensajes;
    }
    public void setMensajes(LinkedHashSet<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    //cons

    public Chat(Usuario usuarioA, Usuario usuarioB, LinkedHashSet<Mensaje> mensajes) {
        this.usuarioA = usuarioA;
        this.usuarioB = usuarioB;
        this.mensajes = mensajes;
    }

    //methods
    
}
