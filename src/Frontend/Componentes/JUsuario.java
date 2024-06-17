package Frontend.Componentes;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Backend.Social.Clases.Usuario;
import Backend.Social.Enums.Sexo;
import Frontend.Paginas.JPaginaExplorar;

public class JUsuario extends JPanel {
    public JPaginaExplorar parent;

    public JLabel foto;

    public JPanel info;
    public JLabel nombre;
    public JLabel edad;
    public JLabel sexo;

    public JButton ver;

    public JUsuario(JPaginaExplorar parent, Usuario usuario) {
        this.parent = parent;

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        foto = new JLabel();
        foto.setIcon(new ImageIcon(new ImageIcon(usuario.getFoto().toString()).getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
        foto.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Info
        info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        nombre = new JLabel(usuario.getNombre() + " (" + usuario.getUsername() + ")");
        nombre.setFont(new Font("Arial", Font.BOLD, 18));
        nombre.setAlignmentX(Component.LEFT_ALIGNMENT);

        edad = new JLabel("Edad: " + usuario.getEdad());
        edad.setAlignmentX(Component.LEFT_ALIGNMENT);

        if (usuario.getSexo() == Sexo.MASCULINO) {
            sexo = new JLabel("Sexo: masculino");
        }
        else {
            sexo = new JLabel("Sexo: femenino");
        }
        sexo.setAlignmentX(Component.LEFT_ALIGNMENT);

        info.add(nombre);
        info.add(edad);
        info.add(sexo);
        
        ver = new JButton("Ver");
        ver.setAlignmentX(Component.CENTER_ALIGNMENT);
        ver.setFocusPainted(false);
        ver.addActionListener(e -> ver());

        this.add(foto);
        this.add(info);
        this.add(Box.createHorizontalGlue());
        this.add(ver);
    }

    private void ver() {

    }
}
