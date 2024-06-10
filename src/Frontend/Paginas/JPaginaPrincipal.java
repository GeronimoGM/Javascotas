package Frontend.Paginas;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Frontend.JMainFrame;

public class JPaginaPrincipal extends JPanel {
    private JLabel titulo;
    private JButton iniciarSesion;
    private JButton registrarse;

    public JPaginaPrincipal(JMainFrame parent) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);

        titulo = new JLabel("Javascotas");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        iniciarSesion = new JButton("Iniciar sesión");
        iniciarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
        iniciarSesion.setFocusPainted(false);
        iniciarSesion.addActionListener(e -> parent.showPanel("paginaInicioSesion"));

        registrarse = new JButton("Registrarse");
        registrarse.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarse.setFocusPainted(false);

        this.add(Box.createVerticalGlue());
        this.add(titulo);
        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(iniciarSesion);
        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(registrarse);
        this.add(Box.createVerticalGlue());
    }
}
