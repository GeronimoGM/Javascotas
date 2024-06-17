package Frontend.Paginas;
import java.awt.Color;
import java.awt.Component;
import java.awt.ScrollPane;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import Backend.Social.Clases.Notificacion;
import Backend.Social.Clases.Usuario;
import Frontend.Componentes.JNotificacion;

public class JPaginaNotificacion extends JScrollPane {

    public JLabel header;
    public JPanel labelNotificacion;
    public ScrollPane scroll;
    public JPanel container;
    public LinkedList <Notificacion<?>> lista;

    public JPaginaNotificacion(Usuario usuario) {
        container = new JPanel();
        header = new JLabel();
        labelNotificacion = new JPanel();
        lista = new LinkedList<>();

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        header.setText("NOTIFICACIONES");
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        Border borde = BorderFactory.createLineBorder(Color.CYAN, 3);
        header.setBorder(borde);
        labelNotificacion.setLayout(new BoxLayout(labelNotificacion, BoxLayout.Y_AXIS));

        Iterator <Notificacion<?>> iterador1 = usuario.getNotificaciones().iterator(); // pasa noti y verifica que es
        while (iterador1.hasNext()) {
            lista.add(iterador1.next());
        }

        ListIterator <Notificacion<?>> iterador2 = lista.listIterator(lista.size());
        while (iterador2.hasPrevious()) {
            JNotificacion noti = new JNotificacion(iterador2.previous());
            labelNotificacion.add(noti);
        }

        // container
        container.add(header);
        container.add(labelNotificacion);

        this.setViewportView(container);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.getVerticalScrollBar().setUnitIncrement(16);
        this.getVerticalScrollBar().setBlockIncrement(64);

    }

}
