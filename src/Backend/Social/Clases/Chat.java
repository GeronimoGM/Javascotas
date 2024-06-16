package Backend.Social.Clases;

import java.util.LinkedList;

import Backend.Gestor.Clases.Gestor;
import Backend.Gestor.Excepciones.UsuarioNoExistenteException;

public class Chat {
    private String emisor;
    private String receptor;
    private LinkedList<Mensaje> mensajes;
    // Constructores
    public Chat(String emisor, String receptor) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.mensajes = new LinkedList<>();
    }
    // Getters y setters
    public String getEmisor() {
        return emisor;
    }
    public String getReceptor() {
        return receptor;
    }
    public LinkedList<Mensaje> getMensajes() {
        return mensajes;
    }
    // Métodos
    public void enviarMensaje(String texto) {
        Mensaje mensaje = new Mensaje(emisor, texto);
        mensajes.add(mensaje);
        Usuario usuarioReceptor = null;
        try {
            usuarioReceptor = Gestor.getUsuario(receptor);
        } catch (UsuarioNoExistenteException e) {
            // TODO: handle exception
        }
        usuarioReceptor.anadirMensajeRecibido(emisor, mensaje);
        mensaje.notificar(usuarioReceptor);
    }

    void anadirMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }
}
