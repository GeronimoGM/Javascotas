package Frontend.Componentes;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Backend.Social.Clases.Comentario;
import Backend.Social.Clases.Like;
import Backend.Social.Clases.Mensaje;
import Backend.Social.Clases.Notificacion;

public class JNotificacion extends JPanel {

    public JLabel labelNoti;
    public JPanel container;

    public JNotificacion(Notificacion<?> noti) {

        // label notificacion

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        Border borde = BorderFactory.createLineBorder(Color.CYAN, 3);
        labelNoti = new JLabel();
        labelNoti.setBorder(borde);

        var aux2 = noti.getNotificacion();
        JLabel notiLabel = new JLabel();
        if (aux2 instanceof Like) {
            notiLabel.setText("Te ha likeado: " + ((Like) aux2).getUsername());
        } else if (aux2 instanceof Mensaje) {
            notiLabel.setText("Te ha enviado un mensaje: " + ((Mensaje) aux2).getUsername());
        } else {
            notiLabel.setText("Te ha comentado: " + ((Comentario) aux2).getUsername());
        }

        // container

        container.add(notiLabel);
        this.add(container);

    }
}
