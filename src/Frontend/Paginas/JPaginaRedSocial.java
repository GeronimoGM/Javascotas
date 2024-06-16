package Frontend.Paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Backend.Gestor.Clases.Gestor;
import Frontend.JMainFrame;

public class JPaginaRedSocial extends JPanel {
    public JPanel sidebar;
    public JButton explorar;
    public JButton chats;
    public JButton notificaciones;
    public JButton perfil;
    public JButton cerrarSesion;

    public JTabbedPane pestanas;
    public JPanel panelExplorar;
    public JPanel panelChats;
    public JPaginaNotificacion panelNotificaciones;
    public JScrollPane panelPerfil;

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
        explorar.addActionListener(e -> pestanas.setSelectedIndex(0));

        chats = new JButton("Chats");
        chats.setAlignmentX(Component.CENTER_ALIGNMENT);
        chats.setFocusPainted(false);
        chats.addActionListener(e -> pestanas.setSelectedIndex(1));

        notificaciones = new JButton("Notificaciones");
        notificaciones.setAlignmentX(Component.CENTER_ALIGNMENT);
        notificaciones.setFocusPainted(false);
        notificaciones.addActionListener(e -> pestanas.setSelectedIndex(2));

        perfil = new JButton("Perfil");
        perfil.setAlignmentX(Component.CENTER_ALIGNMENT);
        perfil.setFocusPainted(false);
        perfil.addActionListener(e -> mostrarPerfil());

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
        // TODO: borrar los labels de prueba (esto es solo para probar que funciona cambiar pestañas)
        panelExplorar = new JPanel();
        panelExplorar.add(new JLabel("Panel 1"));

        panelChats = new JPanel();
        panelChats.add(new JLabel("Panel 2"));

        panelNotificaciones = new JPaginaNotificacion(Gestor.sesionIniciada);

        panelPerfil = new JScrollPane();

        pestanas.add("panelExplorar", panelExplorar);
        pestanas.add("panelChats", panelChats);
        pestanas.add("panelNotificaciones", panelNotificaciones);
        pestanas.add("panelPerfil", panelPerfil);

        pestanas.setSelectedIndex(0);

        // Layout
        this.add(sidebar, BorderLayout.WEST);
        this.add(pestanas, BorderLayout.CENTER);
    }

    private void mostrarPerfil() {
        try {
            JPaginaPerfil perfilPanel = new JPaginaPerfil(this, Gestor.sesionIniciada);

            pestanas.setComponentAt(3, perfilPanel);
        } catch (Exception e) {
            System.out.println(e);
        }

        pestanas.revalidate();
        pestanas.repaint();

        pestanas.setSelectedIndex(3);
    }
}
