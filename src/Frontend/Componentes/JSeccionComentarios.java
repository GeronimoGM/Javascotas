package Frontend.Componentes;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Backend.Gestor.Clases.Gestor;
import Backend.Social.Clases.Comentario;

public class JSeccionComentarios extends JFrame {
    public JPublicacion parent;
    
    public JScrollPane scrollPane;

    public JPanel container;
    
    public JPanel panelComentarios;

    public JPanel panelComentar;
    public JTextField inputComentario;
    public JButton comentar;
    
    public JSeccionComentarios(JPublicacion parent) {
        super("Comentarios");
        this.parent = parent;
        
        this.setSize(400, 400);
        
        scrollPane = new JScrollPane();

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        panelComentar = new JPanel();
        panelComentar.setLayout(new BoxLayout(panelComentar, BoxLayout.X_AXIS));

        inputComentario = new JTextField();
        inputComentario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        comentar = new JButton("Comentar");
        comentar.setAlignmentX(Component.CENTER_ALIGNMENT);
        comentar.setFocusPainted(false);
        comentar.addActionListener(e -> comentar());

        panelComentarios = new JPanel();
        panelComentarios.setLayout(new BoxLayout(panelComentarios, BoxLayout.Y_AXIS));

        for (Comentario comentario : parent.publicacion.getComentarios()) {
            panelComentarios.add(new JComentario(this, comentario));
        }
        
        panelComentar.add(inputComentario);
        panelComentar.add(comentar);

        container.add(panelComentarios);

        container.add(Box.createVerticalGlue());
        container.add(panelComentar);
        
        scrollPane.setViewportView(container);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(64);

        this.add(scrollPane);
    }

    private void comentar() {
        String textoComentario = inputComentario.getText().trim();
        if (!textoComentario.isEmpty()) {
            Comentario toAdd = new Comentario(Gestor.sesionIniciada, textoComentario);
            parent.publicacion.comentar(toAdd);
            panelComentarios.add(new JComentario(this, toAdd));
            panelComentarios.revalidate();
            panelComentarios.repaint();
            inputComentario.setText("");
            toAdd.notificar(parent.parent.usuario);
            Gestor.guardar();
        }
        else {
            JOptionPane.showMessageDialog(this, "No se puede comentar un texto vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
