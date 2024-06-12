import java.time.LocalDate;

import Backend.Usuarios.Clases.Usuario;
import Frontend.JMainFrame;

public class App {
    public static void main(String[] args) throws Exception {
        // new JMainFrame("Javascotas");
        Usuario u1 = new Usuario("germi32", "Gerónimo", "1234", LocalDate.of(2004, 9, 14), null, 'm');
        Usuario u2 = new Usuario("emmavelis", "Emma", "5678", LocalDate.of(2005, 6, 7), null, 'f');

        var chat = u1.abrirChat(u2);

        chat.enviarMensaje("Hola");

        var chatU2 = u2.chats.get(u1.getUsername());

        System.out.println(chatU2.getMensajes());
    }
}
