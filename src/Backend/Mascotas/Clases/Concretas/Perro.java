package Backend.Mascotas.Clases.Concretas;

import java.time.LocalDate;

import javax.management.InvalidAttributeValueException;

import Backend.Mascotas.Clases.Abstracta.Mascota;
import Backend.Social.Enums.Sexo;

public class Perro extends Mascota {
    private String raza;
    private String jugueteFavorito;
    private String comidaFavorita;
    // Constructores
    public Perro(String nombre, LocalDate fechaNacimiento, Sexo sexo, String raza, String jugueteFavorito,
            String comidaFavorita) throws InvalidAttributeValueException {
        super(nombre, fechaNacimiento, sexo);
        this.raza = raza;
        this.jugueteFavorito = jugueteFavorito;
        this.comidaFavorita = comidaFavorita;
    }
    // Getters y setters
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public String getJugueteFavorito() {
        return jugueteFavorito;
    }
    public void setJugueteFavorito(String jugueteFavorito) {
        this.jugueteFavorito = jugueteFavorito;
    }
    public String getComidaFavorita() {
        return comidaFavorita;
    }
    public void setComidaFavorita(String comidaFavorita) {
        this.comidaFavorita = comidaFavorita;
    }
}
