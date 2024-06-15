package Frontend.Paginas;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Frontend.JMainFrame;

public class JPaginaInicioSesion extends JPanel {
    public JMainFrame parent;
    
    public JPanel header;
    public JButton atras;
    public JLabel titulo;

    public JPanel panelUsername;
    public JLabel labelUsername;
    public JTextField inputUsername;
    
    public JPanel panelContrasena;
    public JLabel labelContrasena;
    public JTextField inputContrasena;

    public JButton iniciarSesion;

    public JPaginaInicioSesion(JMainFrame parent) {
        this.parent = parent;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Header
        header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        atras = new JButton("Atrás");
        atras.setAlignmentX(Component.LEFT_ALIGNMENT);
        atras.setFocusPainted(false);
        atras.addActionListener(e -> parent.showPanel("paginaPrincipal"));

        titulo = new JLabel("Iniciar sesión");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        header.add(Box.createRigidArea(new Dimension(25, 0)));
        header.add(atras);
        header.add(Box.createHorizontalGlue());
        header.add(titulo);
        header.add(Box.createRigidArea(new Dimension(100, 0)));
        header.add(Box.createHorizontalGlue());

        // Panel username
        panelUsername = new JPanel();
        panelUsername.setLayout(new BoxLayout(panelUsername, BoxLayout.Y_AXIS));

        labelUsername = new JLabel("Nombre de usuario:");
        labelUsername.setAlignmentY(Component.CENTER_ALIGNMENT);
        labelUsername.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputUsername = new JTextField();
        inputUsername.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputUsername.setMaximumSize(new Dimension(200, 25));

        panelUsername.add(labelUsername);
        panelUsername.add(Box.createRigidArea(new Dimension(0, 5)));
        panelUsername.add(inputUsername);

        // Panel contraseña
        panelContrasena = new JPanel();
        panelContrasena.setLayout(new BoxLayout(panelContrasena, BoxLayout.Y_AXIS));

        labelContrasena = new JLabel("Contraseña:");
        labelContrasena.setAlignmentY(Component.CENTER_ALIGNMENT);
        labelContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputContrasena = new JTextField();
        inputContrasena.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputContrasena.setMaximumSize(new Dimension(200, 25));

        panelContrasena.add(labelContrasena);
        panelContrasena.add(Box.createRigidArea(new Dimension(0, 5)));
        panelContrasena.add(inputContrasena);

        // Boton
        iniciarSesion = new JButton("Iniciar sesión");
        iniciarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
        iniciarSesion.setFocusPainted(false);
        iniciarSesion.addActionListener(e -> iniciarSesion());

        // Layout
        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(header);
        this.add(Box.createVerticalGlue());
        this.add(panelUsername);
        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(panelContrasena);
        this.add(Box.createVerticalGlue());
        this.add(iniciarSesion);
        this.add(Box.createRigidArea(new Dimension(0, 25)));
    }

    private void iniciarSesion() {
        parent.paginaRedSocial = new JPaginaRedSocial(parent);
        parent.add(parent.paginaRedSocial, "paginaRedSocial");
        parent.showPanel("paginaRedSocial"); // TODO: implementar funcionalidad real
    }
}
