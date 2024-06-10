package Backend.Social.Clases;

import java.util.LinkedList;

import Backend.Usuarios.Clases.Usuario;

public class Chat {
    private Usuario usuarioA;
    private Usuario usuarioB;
    private LinkedList<Mensaje> mensajes;

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
    public LinkedList<Mensaje> getMensajes() {
        return mensajes;
    }
    public void setMensajes(LinkedList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    //cons

    public Chat(Usuario usuarioA, Usuario usuarioB) {
        this.usuarioA = usuarioA;
        this.usuarioB = usuarioB;
        mensajes = new LinkedList<>();
    }

    public Chat(Usuario usuarioA, Usuario usuarioB, LinkedList<Mensaje> mensajes) {
        this.usuarioA = usuarioA;
        this.usuarioB = usuarioB;
        this.mensajes = mensajes;
    }

    //methods

    public void enviarMensaje(String mensaje) {
        mensajes.add(new Mensaje(mensaje, usuarioA));
    }

}
