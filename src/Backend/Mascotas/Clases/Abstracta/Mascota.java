package Backend.Mascotas.Clases.Abstracta;

import java.time.LocalDate;

import javax.management.InvalidAttributeValueException;

import Backend.Social.Enums.Sexo;

public abstract class Mascota {
    private String nombre;
    private LocalDate fechaDeNacimiento;
    @SuppressWarnings("unused")
    private int edad;
    private Sexo sexo;
    // Constructores
    public Mascota(String nombre, LocalDate fechaDeNacimiento, Sexo sexo) throws InvalidAttributeValueException {
        this.nombre = nombre;
        setFechaDeNacimiento(fechaDeNacimiento);
        setSexo(sexo);
    }
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) throws InvalidAttributeValueException {
        this.fechaDeNacimiento = fechaDeNacimiento;
        setEdad(getEdad());
    }
    public int getEdad() {
        return LocalDate.now().getYear() - fechaDeNacimiento.getYear();
    }
    private void setEdad(int edad) throws InvalidAttributeValueException {
        if (edad < 0) {
            throw new InvalidAttributeValueException("La edad no puede ser menor a 0");
        }
        else {
            this.edad = edad;
        }
    }
    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo){
        this.sexo = sexo;
    }
}
