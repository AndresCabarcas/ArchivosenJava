/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelopsp;

/**
 *
 * @author ANDACAMES
 */
public class Persona {
    //variables necesarias para la solucion del problema
    String Nombre;
    String Genero;
    int Calorias;
    int Comidas;
    
    //metodo constructor de la clase por parametros

    public Persona(String Nombre, String Genero, int Calorias, int Comidas) {
        this.Nombre = Nombre;
        this.Genero = Genero;
        this.Calorias = Calorias;
        this.Comidas = Comidas;
    }
//metodos set y get de las varibales 
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int getCalorias() {
        return Calorias;
    }

    public void setCalorias(int Calorias) {
        this.Calorias = Calorias;
    }

    public int getComidas() {
        return Comidas;
    }

    public void setComidas(int Comidas) {
        this.Comidas = Comidas;
    }
        
    
}
