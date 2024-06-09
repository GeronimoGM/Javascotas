package Usuarios.Clases.Mascotas.Concretas;

import java.time.LocalDate;

import Usuarios.Clases.Mascotas.Abstracta.Mascota;

public class Conejo extends Mascota {
    private String comidaFavorita;
    private double tamanioOrejas;
    
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

    //cons

    public Conejo(String nombre, LocalDate fechaNacimiento, char sexo, String comidaFavorita,
            double tamanioOrejas) {
        super(nombre, fechaNacimiento, sexo);
        this.comidaFavorita = comidaFavorita;
        this.tamanioOrejas = tamanioOrejas;
    }

    //methods

  

    

}
