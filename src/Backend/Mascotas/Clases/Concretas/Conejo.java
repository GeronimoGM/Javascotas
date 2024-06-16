package Backend.Mascotas.Clases.Concretas;

import java.time.LocalDate;

import javax.management.InvalidAttributeValueException;

import Backend.Mascotas.Clases.Abstracta.Mascota;
import Backend.Social.Enums.Sexo;

public class Conejo extends Mascota {
    private String comidaFavorita;
    private double tamanioOrejas;
    // Constructores
    public Conejo(String nombre, LocalDate fechaNacimiento, Sexo sexo, String comidaFavorita,
            double tamanioOrejas) throws InvalidAttributeValueException {
        super(nombre, fechaNacimiento, sexo);
        this.comidaFavorita = comidaFavorita;
        this.tamanioOrejas = tamanioOrejas;
    }
    // Getters y setters
    public String getComidaFavorita() {
        return comidaFavorita;
    }
    public void setComidaFavorita(String comidaFavorita) {
        this.comidaFavorita = comidaFavorita;
    }
    public double getTamanioOrejas() {
        return tamanioOrejas;
    }
    public void setTamanioOrejas(double tamanioOrejas) {
        this.tamanioOrejas = tamanioOrejas;
    }
}
