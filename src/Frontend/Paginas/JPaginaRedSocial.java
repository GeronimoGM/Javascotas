package Frontend.Paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Frontend.JMainFrame;

public class JPaginaRedSocial extends JPanel {
    public JPanel sidebar;
    public JButton explorar;
    public JButton chats;
    public JButton notificaciones;
    public JButton perfil;
    public JButton cerrarSesion;

    public JTabbedPane pestanas;

    public JPaginaRedSocial(JMainFrame parent) {
        this.setLayout(new BorderLayout());
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Sidebar
        sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(Color.gray);
        sidebar.setMinimumSize(new Dimension(150, 0));
        sidebar.setPreferredSize(new Dimension(150, Integer.MAX_VALUE));

        explorar = new JButton("Explorar");
        explorar.setAlignmentX(Component.CENTER_ALIGNMENT);
        explorar.setFocusPainted(false);

        chats = new JButton("Chats");
        chats.setAlignmentX(Component.CENTER_ALIGNMENT);
        chats.setFocusPainted(false);

        notificaciones = new JButton("Notificaciones");
        notificaciones.setAlignmentX(Component.CENTER_ALIGNMENT);
        notificaciones.setFocusPainted(false);

        perfil = new JButton("Perfil");
        perfil.setAlignmentX(Component.CENTER_ALIGNMENT);
        perfil.setFocusPainted(false);

        cerrarSesion = new JButton("Cerrar sesión");
        cerrarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
        cerrarSesion.setFocusPainted(false);
        
        sidebar.add(Box.createRigidArea(new Dimension(0, 25)));
        sidebar.add(Box.createVerticalGlue()); 
        sidebar.add(explorar);
        sidebar.add(Box.createRigidArea(new Dimension(0, 25)));
        sidebar.add(chats);
        sidebar.add(Box.createRigidArea(new Dimension(0, 25)));
        sidebar.add(notificaciones);
        sidebar.add(Box.createRigidArea(new Dimension(0, 25)));
        sidebar.add(perfil);
        sidebar.add(Box.createVerticalGlue()); 
        sidebar.add(cerrarSesion);
        sidebar.add(Box.createRigidArea(new Dimension(0, 25)));

        // Pestañas
        pestanas = new JTabbedPane();
        pestanas.setLayout(new BoxLayout(pestanas, BoxLayout.Y_AXIS));

        // Layout
        this.add(sidebar, BorderLayout.WEST);
        this.add(pestanas, BorderLayout.CENTER);
    }
}
