package Frontend.Componentes;

import java.awt.Component;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Backend.Gestor.Clases.Gestor;
import Backend.Social.Clases.Comentario;

public class JComentario extends JPanel {
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
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        panelComentario = new JPanel();
        panelComentario.setLayout(new BoxLayout(panelComentario, BoxLayout.Y_AXIS)); 

        try {
            username = new JLabel(Gestor.getUsuario(comentario.getUsername()).getNombre() + "(" + comentario.getUsername() + ")");
            username.setFont(new Font("Arial", Font.BOLD, 14));
        } catch (Exception e) {
            // TODO: handle exception
        }

        textoYHora = new JPanel();
        textoYHora.setLayout(new BoxLayout(textoYHora, BoxLayout.Y_AXIS));

        texto = new JLabel(comentario.getTexto());
        texto.setFont(new Font("Arial", Font.BOLD, 14));

        hora = new JLabel(comentario.getHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        hora.setFont(new Font("Arial", Font.PLAIN, 12));

        textoYHora.add(texto);
        textoYHora.add(hora);

        cantLikes = new JLabel(Integer.toString(comentario.getCantidadLikes()));
        cantLikes.setFont(new Font("Arial", Font.BOLD, 12));

        panelComentario.add(username);
        panelComentario.add(textoYHora);
        panelComentario.add(cantLikes);

        like = new JButton("Like");
        like.setAlignmentX(Component.CENTER_ALIGNMENT);
        like.setFocusPainted(false);

        this.add(panelComentario);
        this.add(Box.createHorizontalGlue());
        this.add(like);
    }
}
