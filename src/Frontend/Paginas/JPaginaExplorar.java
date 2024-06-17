package Frontend.Paginas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Backend.Gestor.Clases.Gestor;
import Backend.Social.Clases.Usuario;
import Frontend.Componentes.JUsuario;

public class JPaginaExplorar extends JScrollPane {
    public JPaginaRedSocial parent;
    
    public JPanel container;

    public JPanel header;
    public JLabel titulo;

    public JPanel usuarios;

    public JPaginaExplorar(JPaginaRedSocial parent) {
        this.parent = parent;
        
        container = new JPanel();
        container.setLayout(new BorderLayout());

        // Header
        header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        titulo = new JLabel("Explorar");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(Box.createGlue());
        header.add(titulo);
        header.add(Box.createGlue());

        // Panel usuarios
        usuarios = new JPanel();
        usuarios.setLayout(new BoxLayout(usuarios, BoxLayout.Y_AXIS));

        Iterator<Usuario> it = Gestor.getUsuarios();

        while (it.hasNext()) {
            Usuario aux = it.next();
            if (!aux.equals(Gestor.sesionIniciada)) {
                usuarios.add(new JUsuario(this, aux));
            }
        }

        // Layout
        container.add(header, BorderLayout.NORTH);
        container.add(usuarios, BorderLayout.CENTER);

        this.setViewportView(container);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.getVerticalScrollBar().setUnitIncrement(16);
        this.getVerticalScrollBar().setBlockIncrement(64);
    }
}
