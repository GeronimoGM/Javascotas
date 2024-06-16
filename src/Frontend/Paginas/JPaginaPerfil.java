package Frontend.Paginas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Backend.Gestor.Clases.Gestor;
import Backend.Mascotas.Clases.Abstracta.Mascota;
import Backend.Social.Clases.Publicacion;
import Backend.Social.Clases.Usuario;
import Backend.Social.Enums.Sexo;
import Frontend.Componentes.JFormPublicar;
import Frontend.Componentes.JMascota;
import Frontend.Componentes.JPublicacion;

public class JPaginaPerfil extends JScrollPane {
    public Usuario usuario;
    
    public JPaginaRedSocial parent;

    public JPanel container;

    public JPanel header;
    public JLabel fotoDePerfil;
    public JLabel nombre;
    public JPanel edadYSexo;
    public JLabel edad;
    public JLabel sexo;
    
    public JPanel panelOpciones;
    public JButton publicar;
    public JButton mascota;

    public JFormPublicar formPublicar;

    public JPanel panelMascotasYPublicaciones;
    public JLabel labelMascotas;
    public JPanel panelMascotas;
    public JLabel labelPublicaciones;
    public JPanel panelPublicaciones;

    public JPaginaPerfil(JPaginaRedSocial parent, Usuario usuario) {
        this.usuario = usuario;
        this.parent = parent;
        
        container = new JPanel();
        container.setLayout(new BorderLayout());
        
        // Header
        header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        
        fotoDePerfil = new JLabel();
        fotoDePerfil.setIcon(new ImageIcon(new ImageIcon(usuario.getFoto().toString()).getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
        fotoDePerfil.setAlignmentX(Component.CENTER_ALIGNMENT);

        nombre = new JLabel(usuario.getNombre());
        nombre.setFont(new Font("Arial", Font.BOLD, 36));
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        //  Panel edad y sexo
        edadYSexo = new JPanel();
        edadYSexo.setLayout(new BoxLayout(edadYSexo, BoxLayout.X_AXIS));
        edadYSexo.setAlignmentX(Component.CENTER_ALIGNMENT);

        edad = new JLabel("Edad: " + Integer.toString(usuario.getEdad()));
        edad.setFont(new Font("Arial", Font.BOLD, 24));

        if (usuario.getSexo() == Sexo.MASCULINO) {
            sexo = new JLabel("Sexo: masculino");
        } else {
            sexo = new JLabel("Sexo: femenino");
        }
        sexo.setFont(new Font("Arial", Font.BOLD, 24));

        edadYSexo.add(edad);
        edadYSexo.add(Box.createRigidArea(new Dimension(25, 0)));
        edadYSexo.add(sexo);
        
        panelOpciones = new JPanel();
        panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.X_AXIS));
        
        if (usuario.equals(Gestor.sesionIniciada)) {
           publicar = new JButton("Publicar");
           publicar.setFocusPainted(false);
           publicar.addActionListener(e -> publicar());

           mascota = new JButton("Añadir mascota");
           mascota.setFocusPainted(false);
           mascota.addActionListener(e -> anadirMascota());

           panelOpciones.add(Box.createHorizontalGlue());
           panelOpciones.add(publicar);
           panelOpciones.add(Box.createHorizontalGlue());
           panelOpciones.add(mascota);
           panelOpciones.add(Box.createHorizontalGlue());

           formPublicar = new JFormPublicar(this);
        }
        else {
           // TODO: botonMensaje
        }

        header.add(Box.createRigidArea(new Dimension(0, 25)));
        header.add(nombre);
        header.add(Box.createRigidArea(new Dimension(0, 25)));
        header.add(fotoDePerfil);
        header.add(Box.createRigidArea(new Dimension(0, 25)));
        header.add(edadYSexo);
        header.add(Box.createRigidArea(new Dimension(0, 25)));
        header.add(panelOpciones);
        header.add(Box.createRigidArea(new Dimension(0, 25)));

        // Mascotas
        panelMascotasYPublicaciones = new JPanel();
        panelMascotasYPublicaciones.setLayout(new BoxLayout(panelMascotasYPublicaciones, BoxLayout.Y_AXIS));

        panelMascotas = new JPanel();
        panelMascotas.setLayout(new BoxLayout(panelMascotas, BoxLayout.Y_AXIS));

        labelMascotas = new JLabel("Mascotas:");
        labelMascotas.setFont(new Font("Arial", Font.BOLD, 24));
        labelMascotas.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panelMascotas.add(labelMascotas);

        for (Mascota mascota : usuario.getMascotas()) {
            panelMascotas.add(new JMascota(mascota));
        }
        
        // Publicaciones
        panelPublicaciones = new JPanel();
        panelPublicaciones.setLayout(new BoxLayout(panelPublicaciones, BoxLayout.Y_AXIS));

        for (Publicacion publicacion : usuario.getPublicaciones()) {
            panelPublicaciones.add(new JPublicacion(this, publicacion));
        }

        panelMascotasYPublicaciones.add(panelMascotas);
        panelMascotas.add(Box.createRigidArea(new Dimension(0, 25)));
        panelMascotasYPublicaciones.add(panelPublicaciones);

        // Layout
        container.add(header, BorderLayout.NORTH);
        container.add(panelMascotasYPublicaciones, BorderLayout.CENTER);

        this.setViewportView(container);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.getVerticalScrollBar().setUnitIncrement(16);
        this.getVerticalScrollBar().setBlockIncrement(64);
    }

    private void publicar() {
        formPublicar.setVisible(true);
    }

    private void anadirMascota() {
        // TODO: frame form añadir mascota
    }
}
