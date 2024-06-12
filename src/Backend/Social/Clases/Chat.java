package Backend.Social.Clases;

import java.util.LinkedList;

import Backend.Usuarios.Clases.Usuario;

public class Chat {
    private String emisor;
    private Usuario receptor;
    private LinkedList<Mensaje> mensajes;
    // Constructores
    public Chat(String emisor, Usuario receptor) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.mensajes = new LinkedList<>();
    }
    // Getters y setters
    public String getEmisor() {
        return emisor;
    }
    public Usuario getReceptor() {
        return receptor;
    }
    public LinkedList<Mensaje> getMensajes() {
        return mensajes;
    }
    // Métodos
    public void enviarMensaje(String texto) {
        Mensaje mensaje = new Mensaje(receptor.getUsername(), texto);
        mensajes.add(mensaje);
        mensaje.notificar(receptor);
    }
}
