package Frontend;

import java.awt.CardLayout;

import javax.swing.JFrame;

import Frontend.Paginas.JPaginaInicioSesion;
import Frontend.Paginas.JPaginaPrincipal;

public class JMainFrame extends JFrame {
    private JPaginaPrincipal paginaPrincipal;
    private JPaginaInicioSesion paginaInicioSesion;    

    public JMainFrame(String title) {
        // Ventana
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new CardLayout());
        
        paginaPrincipal = new JPaginaPrincipal(this);
        paginaInicioSesion = new JPaginaInicioSesion(this);
        
        this.add(paginaPrincipal, "paginaPrincipal");
        this.add(paginaInicioSesion, "paginaInicioSesion");

        // Mostrar ventana
        this.setVisible(true);
    }

    public void showPanel(String panelName) {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), panelName);
    }
}
