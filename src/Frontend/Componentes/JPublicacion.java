package Frontend.Componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Backend.Gestor.Clases.Gestor;
import Backend.Social.Clases.Like;
import Backend.Social.Clases.Publicacion;
import Frontend.Paginas.JPaginaPerfil;

public class JPublicacion extends JPanel {
    public JPaginaPerfil parent;
    
    public Publicacion publicacion;
    
    public JLabel nombre;
    public JLabel mascota;
    public JLabel descripcion;
    public JLabel hora;
    public JLabel foto;
    public JPanel footer;
    public JButton like;
    public JLabel cantLikes;
    public JButton comentarios;
    public JButton eliminar;

    public JSeccionComentarios seccionComentarios;
    
    public JPublicacion(JPaginaPerfil parent, Publicacion publicacion) {
        this.parent = parent;
       
        this.publicacion = publicacion;
        
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        nombre = new JLabel(parent.usuario.getNombre());
        nombre.setFont(new Font("Arial", Font.BOLD, 24));
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        mascota = new JLabel("Mascota: " + publicacion.getMascota().getNombre());
        mascota.setFont(new Font("Arial", Font.BOLD, 20));
        mascota.setAlignmentX(Component.CENTER_ALIGNMENT);

        descripcion = new JLabel(publicacion.getDescripcion());
        descripcion.setFont(new Font("Arial", Font.BOLD, 16));
        descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);

        hora = new JLabel("Hora: " + publicacion.getHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        hora.setFont(new Font("Arial", Font.PLAIN, 14));
        hora.setAlignmentX(Component.CENTER_ALIGNMENT);

        foto = new JLabel();
        foto.setIcon(new ImageIcon(new ImageIcon(publicacion.getFoto().toString()).getImage().getScaledInstance(512, 512, Image.SCALE_SMOOTH)));
        foto.setAlignmentX(Component.CENTER_ALIGNMENT);

        footer = new JPanel();
        footer.setLayout(new BoxLayout(footer, BoxLayout.X_AXIS));

        if (publicacion.getLikes().contains(new Like(Gestor.sesionIniciada.getUsername()))) {
            like = new JButton("Unlike");
        }
        else {
            like = new JButton("Like");
        }
        like.setAlignmentX(Component.CENTER_ALIGNMENT);
        like.setFocusPainted(false);
        like.addActionListener(e -> likear());

        cantLikes = new JLabel("Likes: " + Integer.toString(publicacion.getCantidadLikes()));
        cantLikes.setFont(new Font("Arial", Font.BOLD, 12));

        comentarios = new JButton("Comentarios");
        comentarios.setAlignmentX(Component.CENTER_ALIGNMENT);
        comentarios.setFocusPainted(false);
        comentarios.addActionListener(e -> abrirComentarios());

        seccionComentarios = new JSeccionComentarios(this);
        
        footer.add(Box.createGlue());
        footer.add(like);
        footer.add(Box.createGlue());
        footer.add(cantLikes);
        footer.add(Box.createGlue());
        footer.add(comentarios);
        footer.add(Box.createGlue());

        this.add(nombre);
        this.add(mascota);
        this.add(descripcion);
        this.add(hora);
        this.add(foto);
        this.add(footer);
        if(Gestor.sesionIniciada.equals(parent.usuario)){
            eliminar = new JButton ("Eliminar");
            eliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
            eliminar.setFocusPainted(false);
            eliminar.addActionListener(e->eliminarPublicacion());
            this.add(eliminar);
        }
    }

    private void abrirComentarios() {
        seccionComentarios.setVisible(true);
    }

    private void likear() {
        Like likeToAdd = new Like(Gestor.sesionIniciada.getUsername());
        if (publicacion.getLikes().contains(likeToAdd)) {
            publicacion.unlikear(Gestor.sesionIniciada);
            cantLikes.setText("Likes: " + Integer.toString(publicacion.getCantidadLikes()));
            like.setText("Like");
            likeToAdd.notificar(parent.usuario);
            Gestor.guardar();
        }
        else {
            publicacion.likear(Gestor.sesionIniciada);
            cantLikes.setText("Likes: " + Integer.toString(publicacion.getCantidadLikes()));
            like.setText("Unlike");
        }
    }
    private void eliminarPublicacion() {
        parent.eliminarPublicacion(publicacion);
        Gestor.guardar();
    }
}
