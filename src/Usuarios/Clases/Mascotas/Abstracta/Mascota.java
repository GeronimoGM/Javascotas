package Usuarios.Clases.Mascotas.Abstracta;

import java.time.LocalDate;

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
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    //cons

    public Mascota(String nombre, LocalDate fechaNacimiento, int edad, char sexo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.sexo = sexo;
    }

    //methods

   

    

}
