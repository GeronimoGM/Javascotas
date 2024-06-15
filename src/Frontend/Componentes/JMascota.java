package Frontend.Componentes;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Backend.Mascotas.Clases.Abstracta.Mascota;

public class JMascota extends JPanel {
    public JLabel tipoMascota;
    public JLabel nombre;
    public JPanel edadYSexo;
    public JLabel edad;
    public JLabel sexo;

    public JMascota(Mascota mascota) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        tipoMascota = new JLabel(mascota.getClass().getSimpleName());
        tipoMascota.setAlignmentX(Component.CENTER_ALIGNMENT);
        tipoMascota.setFont(new Font("Arial", Font.BOLD, 16));

        nombre = new JLabel(mascota.getNombre());
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        nombre.setFont(new Font("Arial", Font.BOLD, 16));

        //  Panel edad y sexo
        edadYSexo = new JPanel();
        edadYSexo.setLayout(new BoxLayout(edadYSexo, BoxLayout.X_AXIS));
        edadYSexo.setAlignmentX(Component.CENTER_ALIGNMENT);

        edad = new JLabel("Edad: " + Integer.toString(mascota.getEdad()));
        edad.setFont(new Font("Arial", Font.BOLD, 16));

        if (mascota.getSexo() == 'm') {
            sexo = new JLabel("Sexo: masculino");
        } else {
            sexo = new JLabel("Sexo: femenino");
        }
        sexo.setFont(new Font("Arial", Font.BOLD, 16));

        edadYSexo.add(edad);
        edadYSexo.add(Box.createRigidArea(new Dimension(25, 0)));
        edadYSexo.add(sexo);

        this.add(tipoMascota);
        this.add(nombre);
        this.add(edadYSexo);
    }
}
