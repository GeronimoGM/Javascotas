package Frontend.Componentes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import Frontend.Paginas.JPaginaPerfil;

public class JFormMascota extends JFrame {
    public JPaginaPerfil parent;
    public JScrollPane scrollPane;

    public JPanel container;
    
    public JPanel panelTitulo;
    public JLabel titulo;

    public JPanel form;

    public JPanel panelMascota;
    public JLabel labelMascota;
    public JComboBox<String> inputMascota;

    public JPanel panelNombre;
    public JLabel labelNombre;
    public JTextField inputNombre;

    public JPanel panelNacimiento;
    public JLabel labelNacimiento;
    public DatePicker inputNacimiento;
    
    public JPanel panelSexo;
    public JLabel labelSexo;
    public JComboBox<String> inputSexo;

    public JPanel cards;

    // Perro
    public JPanel perro;
    public JPanel panelRazaPerro;
    public JLabel labelRazaPerro;
    public JTextField inputRazaPerro;

    public JPanel panelJuguetePerro;
    public JLabel labelJuguetePerro;
    public JTextField inputJuguetePerro;
    
    public JPanel panelComidaPerro;
    public JLabel labelComidaPerro;
    public JTextField inputComidaPerro;
    
    // Gato
    public JPanel gato;
    public JPanel panelRazaGato;
    public JLabel labelRazaGato;
    public JTextField inputRazaGato;

    public JPanel panelJugueteGato;
    public JLabel labelJugueteGato;
    public JTextField inputJugueteGato;
    
    public JPanel panelComidaGato;
    public JLabel labelComidaGato;
    public JTextField inputComidaGato;

    // Conejo
    public JPanel conejo;
    public JPanel panelComida;
    public JLabel labelComida;
    public JTextField inputComida;

    public JPanel panelOrejas;
    public JLabel labelOrejas;
    public JSpinner inputOrejas;

    public JButton anadirMascota;
    
    public JFormMascota(JPaginaPerfil parent) {
        super("Añadir mascota");
        this.parent = parent;

        this.setSize(new Dimension(400, 400));
    
        scrollPane = new JScrollPane();

        container = new JPanel();
        container.setLayout(new BorderLayout());

        panelTitulo = new JPanel();
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.X_AXIS));

        titulo = new JLabel("Añadir mascota");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelTitulo.add(Box.createGlue());
        panelTitulo.add(titulo);
        panelTitulo.add(Box.createGlue());

        // Form
        form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        // Mascota
        panelMascota = new JPanel();
        panelMascota.setLayout(new BoxLayout(panelMascota, BoxLayout.Y_AXIS));

        labelMascota = new JLabel("Tipo de mascota:");
        labelMascota.setAlignmentY(Component.CENTER_ALIGNMENT);
        labelMascota.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputMascota = new JComboBox<>(new String[] {"Perro", "Gato", "Conejo"});
        inputMascota.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputMascota.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputMascota.setMaximumSize(new Dimension(200, 25));
        inputMascota.addActionListener(e -> showCard((String) inputMascota.getSelectedItem()));

        panelMascota.add(labelMascota);
        panelMascota.add(Box.createRigidArea(new Dimension(0, 5)));
        panelMascota.add(inputMascota);

        // Nombre
        panelNombre = new JPanel();
        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.Y_AXIS));

        labelNombre = new JLabel("Nombre:");
        labelNombre.setAlignmentY(Component.CENTER_ALIGNMENT);
        labelNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputNombre = new JTextField();
        inputNombre.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputNombre.setMaximumSize(new Dimension(200, 25));

        panelNombre.add(labelNombre);
        panelNombre.add(Box.createRigidArea(new Dimension(0, 5)));
        panelNombre.add(inputNombre);

        // Nacimiento
        panelNacimiento = new JPanel();
        panelNacimiento.setLayout(new BoxLayout(panelNacimiento, BoxLayout.Y_AXIS));

        labelNacimiento = new JLabel("Fecha de nacimiento:");
        labelNacimiento.setAlignmentY(Component.CENTER_ALIGNMENT);
        labelNacimiento.setAlignmentX(Component.CENTER_ALIGNMENT);

        DatePickerSettings dateSettings = new DatePickerSettings();
        inputNacimiento = new DatePicker(dateSettings);
        inputNacimiento.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputNacimiento.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputNacimiento.setMaximumSize(new Dimension(200, 25));
        
        panelNacimiento.add(labelNacimiento);
        panelNacimiento.add(Box.createRigidArea(new Dimension(0, 5)));
        panelNacimiento.add(inputNacimiento);

        // Sexo
        panelSexo = new JPanel();
        panelSexo.setLayout(new BoxLayout(panelSexo, BoxLayout.Y_AXIS));

        labelSexo = new JLabel("Sexo:");
        labelSexo.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelSexo.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputSexo = new JComboBox<>(new String[] {"Masculino", "Femenino"});
        inputSexo.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputSexo.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputSexo.setMaximumSize(new Dimension(200, 25));

        panelSexo.add(labelSexo);
        panelSexo.add(Box.createRigidArea(new Dimension(0, 5)));
        panelSexo.add(inputSexo);

        // Cards
        cards = new JPanel();
        cards.setLayout(new CardLayout());

        // Perro
        perro = new JPanel();
        perro.setLayout(new BoxLayout(perro, BoxLayout.Y_AXIS));
        perro.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelRazaPerro = new JPanel();
        panelRazaPerro.setLayout(new BoxLayout(panelRazaPerro, BoxLayout.Y_AXIS));

        labelRazaPerro = new JLabel("Raza:");
        labelRazaPerro.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelRazaPerro.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputRazaPerro = new JTextField();
        inputRazaPerro.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputRazaPerro.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputRazaPerro.setMaximumSize(new Dimension(200, 25));

        panelRazaPerro.add(labelRazaPerro);
        panelRazaPerro.add(Box.createRigidArea(new Dimension(0, 5)));
        panelRazaPerro.add(inputRazaPerro);

        panelJuguetePerro = new JPanel();
        panelJuguetePerro.setLayout(new BoxLayout(panelJuguetePerro, BoxLayout.Y_AXIS));

        labelJuguetePerro = new JLabel("Juguete favorito:");
        labelJuguetePerro.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelJuguetePerro.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputJuguetePerro = new JTextField();
        inputJuguetePerro.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputJuguetePerro.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputJuguetePerro.setMaximumSize(new Dimension(200, 25));

        panelJuguetePerro.add(labelJuguetePerro);
        panelJuguetePerro.add(Box.createRigidArea(new Dimension(0, 5)));
        panelJuguetePerro.add(inputJuguetePerro);

        panelComidaPerro = new JPanel();
        panelComidaPerro.setLayout(new BoxLayout(panelComidaPerro, BoxLayout.Y_AXIS));

        labelComidaPerro = new JLabel("Comida favorita:");
        labelComidaPerro.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelComidaPerro.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputComidaPerro = new JTextField();
        inputComidaPerro.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputComidaPerro.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputComidaPerro.setMaximumSize(new Dimension(200, 25));

        panelComidaPerro.add(labelComidaPerro);
        panelComidaPerro.add(Box.createRigidArea(new Dimension(0, 5)));
        panelComidaPerro.add(inputComidaPerro);

        perro.add(panelRazaPerro);
        perro.add(Box.createRigidArea(new Dimension(0, 25)));
        perro.add(panelJuguetePerro);
        perro.add(Box.createRigidArea(new Dimension(0, 25)));
        perro.add(panelComidaPerro);

        cards.add(perro, "Perro");

        // Gato
        gato = new JPanel();
        gato.setLayout(new BoxLayout(gato, BoxLayout.Y_AXIS));
        gato.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelRazaGato = new JPanel();
        panelRazaGato.setLayout(new BoxLayout(panelRazaGato, BoxLayout.Y_AXIS));

        labelRazaGato = new JLabel("Raza:");
        labelRazaGato.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelRazaGato.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputRazaGato = new JTextField();
        inputRazaGato.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputRazaGato.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputRazaGato.setMaximumSize(new Dimension(200, 25));

        panelRazaGato.add(labelRazaGato);
        panelRazaGato.add(Box.createRigidArea(new Dimension(0, 5)));
        panelRazaGato.add(inputRazaGato);

        panelJugueteGato = new JPanel();
        panelJugueteGato.setLayout(new BoxLayout(panelJugueteGato, BoxLayout.Y_AXIS));

        labelJugueteGato = new JLabel("Juguete favorito:");
        labelJugueteGato.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelJugueteGato.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputJugueteGato = new JTextField();
        inputJugueteGato.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputJugueteGato.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputJugueteGato.setMaximumSize(new Dimension(200, 25));

        panelJugueteGato.add(labelJugueteGato);
        panelJugueteGato.add(Box.createRigidArea(new Dimension(0, 5)));
        panelJugueteGato.add(inputJugueteGato);

        panelComidaGato = new JPanel();
        panelComidaGato.setLayout(new BoxLayout(panelComidaGato, BoxLayout.Y_AXIS));

        labelComidaGato = new JLabel("Comida favorita:");
        labelComidaGato.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelComidaGato.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputComidaGato = new JTextField();
        inputComidaGato.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputComidaGato.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputComidaGato.setMaximumSize(new Dimension(200, 25));

        panelComidaGato.add(labelComidaGato);
        panelComidaGato.add(Box.createRigidArea(new Dimension(0, 5)));
        panelComidaGato.add(inputComidaGato);

        gato.add(panelRazaGato);
        gato.add(Box.createRigidArea(new Dimension(0, 25)));
        gato.add(panelJugueteGato);
        gato.add(Box.createRigidArea(new Dimension(0, 25)));
        gato.add(panelComidaGato);

        cards.add(gato, "Gato");

        // Conejo
        conejo = new JPanel();
        conejo.setLayout(new BoxLayout(conejo, BoxLayout.Y_AXIS));
        conejo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelComida = new JPanel();
        panelComida.setLayout(new BoxLayout(panelComida, BoxLayout.Y_AXIS));

        labelComida = new JLabel("Comida favorita:");
        labelComida.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelComida.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputComida = new JTextField();
        inputComida.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputComida.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputComida.setMaximumSize(new Dimension(200, 25));

        panelComida.add(labelComida);
        panelComida.add(Box.createRigidArea(new Dimension(0, 5)));
        panelComida.add(inputComida);

        panelOrejas = new JPanel();
        panelOrejas.setLayout(new BoxLayout(panelOrejas, BoxLayout.Y_AXIS));

        labelOrejas = new JLabel("Tamaño de orejas:");
        labelOrejas.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelOrejas.setAlignmentY(Component.CENTER_ALIGNMENT);

        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        inputOrejas = new JSpinner(model);
        inputOrejas.setMaximumSize(new Dimension(200, 25));
        
        panelOrejas.add(labelOrejas);
        panelOrejas.add(Box.createRigidArea(new Dimension(0, 5)));
        panelOrejas.add(inputOrejas);

        conejo.add(panelComida);
        conejo.add(Box.createRigidArea(new Dimension(0, 25)));
        conejo.add(panelOrejas);

        cards.add(conejo, "Conejo");

        form.add(Box.createGlue());
        form.add(panelMascota);
        form.add(Box.createRigidArea(new Dimension(0, 25)));
        form.add(panelNombre);
        form.add(Box.createRigidArea(new Dimension(0, 25)));
        form.add(panelNacimiento);
        form.add(Box.createRigidArea(new Dimension(0, 25)));
        form.add(panelSexo);
        form.add(Box.createRigidArea(new Dimension(0, 25)));
        form.add(cards);
        form.add(Box.createGlue());

        anadirMascota = new JButton("Añadir mascota");
        anadirMascota.setFocusPainted(false);

        container.add(panelTitulo, BorderLayout.NORTH);
        container.add(form, BorderLayout.CENTER);
        container.add(anadirMascota, BorderLayout.SOUTH); 

        scrollPane.setViewportView(container);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(64);

        this.add(scrollPane);
    }

    private void showCard(String cardName) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, cardName);
    }

    
}
