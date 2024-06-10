package Frontend;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    // Pagina inicial (lo primero que ves al abrir)
    private JPanel paginaPrincipal;
    private JLabel titulo;
    private JButton iniciarSesion;
    private JButton registrarse;
    
    public MainFrame(String title) {
        // Ventana
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new CardLayout());
        
        // Pagina principal
        paginaPrincipal = new JPanel();
        paginaPrincipal.setLayout(new BoxLayout(paginaPrincipal, BoxLayout.Y_AXIS));
        paginaPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT);

        titulo = new JLabel("Javascotas");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        iniciarSesion = new JButton("Iniciar sesión");
        iniciarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
        iniciarSesion.setFocusPainted(false);
        iniciarSesion.addActionListener(e -> showPanel("paginaInicioSesion"));

        registrarse = new JButton("Registrarse");
        registrarse.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarse.setFocusPainted(false);

        paginaPrincipal.add(Box.createVerticalGlue());
        paginaPrincipal.add(titulo);
        paginaPrincipal.add(Box.createRigidArea(new Dimension(0, 100)));
        paginaPrincipal.add(iniciarSesion);
        paginaPrincipal.add(Box.createRigidArea(new Dimension(0, 25)));
        paginaPrincipal.add(registrarse);
        paginaPrincipal.add(Box.createVerticalGlue());

        this.add(paginaPrincipal, "paginaPrincipal");

        // Mostrar ventana
        this.setVisible(true);
    }

    public void showPanel(String panelName) {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), panelName);
    }
}
