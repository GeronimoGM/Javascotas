package Frontend.Componentes;

import java.awt.Component;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Backend.Gestor.Clases.Gestor;
import Backend.Social.Clases.Comentario;
import Backend.Social.Clases.Like;

public class JComentario extends JPanel {
    public JSeccionComentarios parent;
    
    private Comentario comentario;
    
    public JPanel panelComentario;
    public JLabel username;
    public JPanel textoYHora;
    //
    public JLabel texto;
    public JLabel hora;
    //
    public JLabel cantLikes;

    public JButton like;

    public JComentario(JSeccionComentarios parent, Comentario comentario) {
        this.parent = parent;
        
        this.comentario = comentario;
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        panelComentario = new JPanel();
        panelComentario.setLayout(new BoxLayout(panelComentario, BoxLayout.Y_AXIS)); 

        try {
            username = new JLabel(Gestor.getUsuario(comentario.getUsername()).getNombre() + " (" + comentario.getUsername() + ")");
            username.setFont(new Font("Arial", Font.BOLD, 14));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Este usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }

        textoYHora = new JPanel();
        textoYHora.setLayout(new BoxLayout(textoYHora, BoxLayout.Y_AXIS));

        texto = new JLabel(comentario.getTexto());
        texto.setFont(new Font("Arial", Font.BOLD, 14));

        hora = new JLabel(comentario.getHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        hora.setFont(new Font("Arial", Font.PLAIN, 12));

        textoYHora.add(texto);
        textoYHora.add(hora);

        cantLikes = new JLabel("Likes: " + Integer.toString(comentario.getCantidadLikes()));
        cantLikes.setFont(new Font("Arial", Font.BOLD, 12));

        panelComentario.add(username);
        panelComentario.add(textoYHora);
        panelComentario.add(cantLikes);

        if (comentario.getLikes().contains(new Like(Gestor.sesionIniciada.getUsername()))) {
            like = new JButton("Unlike");
        }
        else {
            like = new JButton("Like");
        }
        like.setAlignmentX(Component.CENTER_ALIGNMENT);
        like.setFocusPainted(false);
        like.addActionListener(e -> likear());

        this.add(panelComentario);
        this.add(Box.createHorizontalGlue());
        this.add(like);
    }

    private void likear() {
        Like likeToAdd = new Like(Gestor.sesionIniciada.getUsername());
        if (comentario.getLikes().contains(likeToAdd)) {
            comentario.unlikear(Gestor.sesionIniciada);
            cantLikes.setText("Likes: " + Integer.toString(comentario.getCantidadLikes()));
            like.setText("Like");
            likeToAdd.notificar(parent.parent.parent.usuario);
            Gestor.guardar();
        }
        else {
            comentario.likear(Gestor.sesionIniciada);
            cantLikes.setText("Likes: " + Integer.toString(comentario.getCantidadLikes()));
            like.setText("Unlike");
        }
    }
}
