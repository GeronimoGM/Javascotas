package Frontend;

import java.awt.CardLayout;

import javax.swing.JFrame;

import Frontend.Paginas.JPaginaPrincipal;

public class JMainFrame extends JFrame {
    // Pagina inicial (lo primero que ves al abrir)
    private JPaginaPrincipal paginaPrincipal;
    
    public JMainFrame(String title) {
        // Ventana
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new CardLayout());
        
        // Pagina principal
        paginaPrincipal = new JPaginaPrincipal(this);

        this.add(paginaPrincipal, "paginaPrincipal");

        // Mostrar ventana
        this.setVisible(true);
    }

    public void showPanel(String panelName) {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), panelName);
    }
}
