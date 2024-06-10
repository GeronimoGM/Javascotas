package Backend.Usuarios.Clases.Mascotas.Concretas;

import java.time.LocalDate;

import javax.management.InvalidAttributeValueException;

import Backend.Usuarios.Clases.Mascotas.Abstracta.Mascota;

public class Gato extends Mascota {
    private String raza;
    private String jugueteFavorito;
    private String comidaFavorita;
    
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

    //cons

    public Gato(String nombre, LocalDate fechaNacimiento, char sexo, String raza, String jugueteFavorito,
            String comidaFavorita) throws InvalidAttributeValueException {
        super(nombre, fechaNacimiento, sexo);
        this.raza = raza;
        this.jugueteFavorito = jugueteFavorito;
        this.comidaFavorita = comidaFavorita;
    }

    //methods

    


    

}
