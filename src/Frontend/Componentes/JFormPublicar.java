package Frontend.Componentes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import Backend.Gestor.Clases.Gestor;
import Backend.Social.Clases.Publicacion;
import Frontend.Paginas.JPaginaPerfil;

public class JFormPublicar extends JFrame {
    public JPaginaPerfil parent;
    
    public JScrollPane scrollPane;

    public JPanel container;

    public JPanel panelTitulo;
    public JLabel titulo;

    public JPanel form;

    public JPanel panelMascotas;
    public JLabel labelMascotas;
    public JComboBox<String> inputMascotas;

    public JPanel panelDescripcion;
    public JLabel labelDescripcion;
    public JTextField inputDescripcion;

    public JPanel panelFoto;
    public JLabel labelFoto;
    public JButton inputFoto;
    public File fotoPublicacion;

    public JButton publicar;

    public JFormPublicar(JPaginaPerfil parent) {
        super("Publicar");
        this.parent = parent;

        this.setSize(new Dimension(400, 400));
    
        scrollPane = new JScrollPane();

        container = new JPanel();
        container.setLayout(new BorderLayout());

        panelTitulo = new JPanel();
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.X_AXIS));

        titulo = new JLabel("Publicar");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelTitulo.add(Box.createGlue());
        panelTitulo.add(titulo);
        panelTitulo.add(Box.createGlue());
        
        // Form
        form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Mascotas
        panelMascotas = new JPanel();
        panelMascotas.setLayout(new BoxLayout(panelMascotas, BoxLayout.Y_AXIS));

        labelMascotas = new JLabel("Mascotas:");
        labelMascotas.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        String[] mascotas = new String[Gestor.sesionIniciada.getMascotas().size()];
        
        for (int i = 0; i < mascotas.length; i++) {
            mascotas[i] = Gestor.sesionIniciada.getMascotas().get(i).getNombre();
        }

        inputMascotas = new JComboBox<>(mascotas);
        inputMascotas.setMaximumSize(new Dimension(200, 25));
        inputMascotas.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelMascotas.add(labelMascotas);
        panelMascotas.add(Box.createRigidArea(new Dimension(0, 5)));
        panelMascotas.add(inputMascotas);

        panelDescripcion = new JPanel();
        panelDescripcion.setLayout(new BoxLayout(panelDescripcion, BoxLayout.Y_AXIS));
        
        labelDescripcion = new JLabel("Descripción:");
        labelDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        inputDescripcion = new JTextField();
        inputDescripcion.setMaximumSize(new Dimension(200, 25));
        inputDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panelDescripcion.add(labelDescripcion);
        panelDescripcion.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDescripcion.add(inputDescripcion);
        
        panelFoto = new JPanel();
        panelFoto.setLayout(new BoxLayout(panelFoto, BoxLayout.Y_AXIS));
        
        labelFoto = new JLabel("Foto seleccionada:");
        labelFoto.setAlignmentY(Component.CENTER_ALIGNMENT);
        labelFoto.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        inputFoto = new JButton("Seleccionar foto de publicación");
        inputFoto.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputFoto.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputFoto.setFocusPainted(false);
        inputFoto.addActionListener(e -> seleccionarFoto());
        
        panelFoto.add(labelFoto);
        panelFoto.add(Box.createRigidArea(new Dimension(0, 5)));
        panelFoto.add(inputFoto);
        
        form.add(Box.createGlue());
        form.add(panelMascotas);
        form.add(Box.createRigidArea(new Dimension(0, 50)));
        form.add(panelDescripcion);
        form.add(Box.createRigidArea(new Dimension(0, 50)));
        form.add(panelFoto);
        form.add(Box.createGlue());
        
        publicar = new JButton("Publicar");
        publicar.setAlignmentX(Component.CENTER_ALIGNMENT);
        publicar.setFocusPainted(false);
        publicar.addActionListener(e -> publicar());
        
        container.add(panelTitulo, BorderLayout.NORTH);
        container.add(form, BorderLayout.CENTER);
        container.add(publicar, BorderLayout.SOUTH); 

        scrollPane.setViewportView(container);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(64);

        this.add(scrollPane);
    }

    private void seleccionarFoto() {
        JFileChooser fileChooser = new JFileChooser();
        
        // Crear un filtro para archivos PNG y JPG
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "png", "jpg");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();

            String nombreArchivo = archivoSeleccionado.getName().toLowerCase();
            if (nombreArchivo.endsWith(".png") || nombreArchivo.endsWith(".jpg")) {
                fotoPublicacion = archivoSeleccionado;
                labelFoto.setText("Foto seleccionada: " + archivoSeleccionado.getName());
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un archivo PNG o JPG.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void publicar() {
        int index = inputMascotas.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "No se puede publicar sin ninguna mascota registrada", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String descripcion = inputDescripcion.getText().trim();

        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se puede publicar con una descripción vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (fotoPublicacion == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen para la publicación", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Publicacion publicacion = new Publicacion(
                Gestor.sesionIniciada,
                Gestor.sesionIniciada.getMascotas().get(index),
                fotoPublicacion,
                descripcion
            );
            Gestor.sesionIniciada.publicar(publicacion);
            parent.panelPublicaciones.add(new JPublicacion(parent, publicacion));
            inputDescripcion.setText("");
            labelFoto.setText("Seleccionar foto de publicación");
            fotoPublicacion = null;
            this.setVisible(false);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
