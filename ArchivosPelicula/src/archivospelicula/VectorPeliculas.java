/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivospelicula;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDACAMES
 */
public class VectorPeliculas {
    
    public static Pelicula[] vecpelicula;
    int tam;
 
    public VectorPeliculas(){
    
        vecpelicula=null;
        tam=0;
        
    }
    
    public void crearVector() {
        vecpelicula = new Pelicula[tam];
    }
    
    public void setTama(int ta){
    tam=ta;
    }
    
    public int getTama(){
    return tam;
    }

    public Pelicula getVecpelicula(int p) {
        return vecpelicula[p];
    }

    public void setVecpelicula(int p, Pelicula dato) {
         vecpelicula[p]=dato;
    }
    
    
}
