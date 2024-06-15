package Frontend.Paginas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Backend.Social.Clases.Usuario;

public class JPaginaPerfil extends JScrollPane {
    public JPaginaRedSocial parent;

    public JPanel container;

    public JPanel header;
    public JLabel fotoDePerfil;
    public JLabel nombre;
    public JPanel edadYSexo;
    public JLabel edad;
    public JLabel sexo;

    public JPaginaPerfil(JPaginaRedSocial parent, Usuario usuario) {
        this.parent = parent;
        
        container = new JPanel();
        container.setLayout(new BorderLayout());
        
        // Header
        header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        
        fotoDePerfil = new JLabel();
        fotoDePerfil.setIcon(new ImageIcon(new ImageIcon(usuario.getFoto().toString()).getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
        fotoDePerfil.setAlignmentX(Component.CENTER_ALIGNMENT);

        nombre = new JLabel(usuario.getNombre());
        nombre.setFont(new Font("Arial", Font.BOLD, 36));
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        //  Panel edad y sexo
        edadYSexo = new JPanel();
        edadYSexo.setLayout(new BoxLayout(edadYSexo, BoxLayout.X_AXIS));
        edadYSexo.setAlignmentX(Component.CENTER_ALIGNMENT);

        edad = new JLabel("Edad: " + Integer.toString(usuario.getEdad()));
        edad.setFont(new Font("Arial", Font.BOLD, 24));

        if (usuario.getSexo() == 'm') {
            sexo = new JLabel("Sexo: masculino");
        } else {
            sexo = new JLabel("Sexo: femenino");
        }
        sexo.setFont(new Font("Arial", Font.BOLD, 24));

        edadYSexo.add(edad);
        edadYSexo.add(Box.createRigidArea(new Dimension(25, 0)));
        edadYSexo.add(sexo);
        
        header.add(Box.createRigidArea(new Dimension(0, 25)));
        header.add(nombre);
        header.add(Box.createRigidArea(new Dimension(0, 25)));
        header.add(fotoDePerfil);
        header.add(Box.createRigidArea(new Dimension(0, 25)));
        header.add(edadYSexo);
        header.add(Box.createRigidArea(new Dimension(0, 25)));
        
        // Layout
        container.add(Box.createGlue());
        container.add(header, BorderLayout.NORTH);
        container.add(Box.createGlue());

        this.setViewportView(container);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.getVerticalScrollBar().setUnitIncrement(16);
        this.getVerticalScrollBar().setBlockIncrement(64);
    }
}
