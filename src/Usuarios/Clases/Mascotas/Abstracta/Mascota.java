package Usuarios.Clases.Mascotas.Abstracta;

import java.time.LocalDate;

import javax.management.InvalidAttributeValueException;

public abstract class Mascota {
    private String nombre;
    private LocalDate fechaNacimiento;
    private int edad;
    private char sexo;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) throws InvalidAttributeValueException {
        if (edad < 0) {
            throw new InvalidAttributeValueException("La edad no puede ser menor a 0");
        }
        else {
            this.edad = edad;
        }
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) throws InvalidAttributeValueException {
        sexo = Character.toLowerCase(sexo);
        if (sexo != 'f' && sexo != 'm') {
            throw new InvalidAttributeValueException("El sexo solo puede ser femenino(f) o masculino(m)");
        }
    }

    //cons

    public Mascota(String nombre, LocalDate fechaNacimiento, char sexo) throws InvalidAttributeValueException {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        setEdad(calcularEdad());
        setSexo(sexo);
    }

    //methods

    public int calcularEdad(){
        LocalDate hoy = LocalDate.now();
        int edad = 0;
        edad = (hoy.getYear() - (fechaNacimiento.getYear()));
        return edad;
    }

    

}
