package Frontend.Paginas;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import javax.management.InvalidAttributeValueException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import Backend.Gestor.Clases.Gestor;
import Backend.Gestor.Excepciones.UsuarioYaExistenteException;
import Backend.Social.Clases.Usuario;
import Backend.Social.Enums.Sexo;
import Frontend.JMainFrame;

public class JPaginaRegistro extends JPanel {
    public JPanel header;
    public JButton atras;
    public JLabel titulo;

    public JPanel panelUsername;
    public JLabel labelUsername;
    public JTextField inputUsername;

    public JPanel panelNombre;
    public JLabel labelNombre;
    public JTextField inputNombre;

    public JPanel panelContrasena;
    public JLabel labelContrasena;
    public JPasswordField inputContrasena;

    public JPanel panelNacimiento;
    public JLabel labelNacimiento;
    public DatePicker inputNacimiento;

    public JPanel panelFoto;
    public JLabel labelFoto;
    public JButton inputFoto;
    public File fotoDePerfil;

    public JPanel panelSexo;
    public JLabel labelSexo;
    public JComboBox<String> inputSexo;

    public JButton registrarse;

    public JPaginaRegistro(JMainFrame parent) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Header
        header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        atras = new JButton("Atrás");
        atras.setAlignmentX(Component.LEFT_ALIGNMENT);
        atras.setFocusPainted(false);
        atras.addActionListener(e -> parent.showPanel("paginaPrincipal"));

        titulo = new JLabel("Registrarse");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(Box.createRigidArea(new Dimension(25, 0)));
        header.add(atras);
        header.add(Box.createHorizontalGlue());
        header.add(titulo);
        header.add(Box.createRigidArea(new Dimension(100, 0)));
        header.add(Box.createHorizontalGlue());

        // Username
        panelUsername = new JPanel();
        panelUsername.setLayout(new BoxLayout(panelUsername, BoxLayout.Y_AXIS));

        labelUsername = new JLabel("Nombre de usuario:");
        labelUsername.setAlignmentY(Component.CENTER_ALIGNMENT);
        labelUsername.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputUsername = new JTextField();
        inputUsername.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputUsername.setMaximumSize(new Dimension(200, 25));

        panelUsername.add(labelUsername);
        panelUsername.add(Box.createRigidArea(new Dimension(0, 5)));
        panelUsername.add(inputUsername);

        // Panel nombre
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

        // Panel contrasena
        panelContrasena = new JPanel();
        panelContrasena.setLayout(new BoxLayout(panelContrasena, BoxLayout.Y_AXIS));

        labelContrasena = new JLabel("Contraseña:");
        labelContrasena.setAlignmentY(Component.CENTER_ALIGNMENT);
        labelContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputContrasena = new JPasswordField();
        inputContrasena.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputContrasena.setMaximumSize(new Dimension(200, 25));

        panelContrasena.add(labelContrasena);
        panelContrasena.add(Box.createRigidArea(new Dimension(0, 5)));
        panelContrasena.add(inputContrasena);

        // Panel nacimiento
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

        // Panel foto
        panelFoto = new JPanel();
        panelFoto.setLayout(new BoxLayout(panelFoto, BoxLayout.Y_AXIS));

        labelFoto = new JLabel("Foto seleccionada:");
        labelFoto.setAlignmentY(Component.CENTER_ALIGNMENT);
        labelFoto.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputFoto = new JButton("Seleccionar foto de perfil");
        inputFoto.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputFoto.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputFoto.setFocusPainted(false);
        inputFoto.addActionListener(e -> seleccionarFotoDePerfil());

        panelFoto.add(labelFoto);
        panelFoto.add(Box.createRigidArea(new Dimension(0, 5)));
        panelFoto.add(inputFoto);

        // Panel sexo
        panelSexo = new JPanel();
        panelSexo.setLayout(new BoxLayout(panelSexo, BoxLayout.Y_AXIS));

        labelSexo = new JLabel("Sexo:");
        labelSexo.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelSexo.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputSexo = new JComboBox<>(new String[] { "Masculino", "Femenino" });
        inputSexo.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputSexo.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputSexo.setMaximumSize(new Dimension(200, 25));

        panelSexo.add(labelSexo);
        panelSexo.add(Box.createRigidArea(new Dimension(0, 5)));
        panelSexo.add(inputSexo);

        // Boton
        registrarse = new JButton("Registrarse");
        registrarse.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarse.setFocusPainted(false);
        registrarse.addActionListener(e -> registrarse());
        


        // Layout
        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(header);
        this.add(Box.createVerticalGlue());
        this.add(panelUsername);
        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(panelNombre);
        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(panelContrasena);
        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(panelNacimiento);
        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(panelFoto);
        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(panelSexo);
        this.add(Box.createVerticalGlue());
        this.add(registrarse);
        this.add(Box.createRigidArea(new Dimension(0, 25)));
    }

    private void seleccionarFotoDePerfil() {
        JFileChooser fileChooser = new JFileChooser();

        // Crear un filtro para archivos PNG y JPG
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "png", "jpg");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();

            String nombreArchivo = archivoSeleccionado.getName().toLowerCase();
            if (nombreArchivo.endsWith(".png") || nombreArchivo.endsWith(".jpg")) {
                fotoDePerfil = archivoSeleccionado;
                labelFoto.setText("Foto seleccionada: " + archivoSeleccionado.getName());
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un archivo PNG o JPG.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void registrarse(){

        if (inputUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username sin completar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (inputNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre sin completar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        char[] passwordChars = inputContrasena.getPassword();
        String password = new String(passwordChars);

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Contraseña sin completar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        LocalDate date = inputNacimiento.getDate();
        if (inputNacimiento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento sin completar", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (fotoDePerfil==null) {
            JOptionPane.showMessageDialog(this, "Foto de perfil sin completar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int indexSexo = inputSexo.getSelectedIndex();
        Sexo sexo;

        if (indexSexo == 0) {
            sexo = Sexo.MASCULINO;
        } else {
            sexo = Sexo.FEMENINO;
        }

        try {
            Gestor.registrarse(
                    new Usuario(inputUsername.getText(), inputNombre.getText(), password, date, fotoDePerfil, sexo));
        } catch (UsuarioYaExistenteException e) {
            JOptionPane.showMessageDialog(this, "Usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }catch(InvalidAttributeValueException a){
            JOptionPane.showMessageDialog(this, "La fecha de nacimiento no puede ser futura", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Gestor.guardar();
        JOptionPane.showMessageDialog(this, "Se ha registrado exitosamente!!!", "Registro!", JOptionPane.INFORMATION_MESSAGE);
    }

}
