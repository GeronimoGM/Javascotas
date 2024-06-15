package Frontend;

import java.awt.CardLayout;

import javax.swing.JFrame;

import Frontend.Paginas.JPaginaInicioSesion;
import Frontend.Paginas.JPaginaPrincipal;
import Frontend.Paginas.JPaginaRedSocial;
import Frontend.Paginas.JPaginaRegistro;

public class JMainFrame extends JFrame {
    public JPaginaPrincipal paginaPrincipal;
    public JPaginaInicioSesion paginaInicioSesion;
    public JPaginaRegistro paginaRegistro;
    public JPaginaRedSocial paginaRedSocial;

    public JMainFrame(String title) {
        // Ventana
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new CardLayout());
        
        paginaPrincipal = new JPaginaPrincipal(this);
        paginaInicioSesion = new JPaginaInicioSesion(this);
        paginaRegistro = new JPaginaRegistro(this);
        paginaRedSocial = new JPaginaRedSocial(this);
        
        this.add(paginaPrincipal, "paginaPrincipal");
        this.add(paginaInicioSesion, "paginaInicioSesion");
        this.add(paginaRegistro, "paginaRegistro");
        this.add(paginaRedSocial, "paginaRedSocial");

        // Mostrar ventana
        this.setVisible(true);
    }

    public void showPanel(String panelName) {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), panelName);
    }
}
