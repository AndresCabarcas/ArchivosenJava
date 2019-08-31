/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivospelicula;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static archivospelicula.VectorPeliculas.vecpelicula;
import archivospelicula.VectorPeliculas;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDACAMES
 */
public class Archivo {

    private String rutaArchivo; 
    File archivo;

    public void LeerEscribirArchivo() { 
        rutaArchivo = "";
    }

    public void setRutaArchivo(String nom) { 
        rutaArchivo = nom;
    }

    public String getRutaArchivo() { 
        return rutaArchivo;
    } 

    public void guardarArchivo(VectorPeliculas obj) throws IOException {

        BufferedWriter escribir;
        
        archivo = new File("Pelicula.txt");
  
        if (archivo.exists()) {
            try{
            for (int i = 0; i < obj.getTama(); i++) {        
                
               
                escribir = new BufferedWriter(new FileWriter(archivo, true));

                escribir.write(obj.getVecpelicula(i).getNombre() +"***"+ obj.getVecpelicula(i).getGenero()+"***" + obj.getVecpelicula(i).getDuracion()+"***"+obj.getVecpelicula(i).getValor()+"***"+obj.getVecpelicula(i).getPuntuacion());
                escribir.newLine();
                
                escribir.close();
            }
            }catch(IOException ex){
               
                    
                    }
            
        } else {
            escribir = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i < obj.getTama(); i++) {
                escribir.write(obj.getVecpelicula(i).getNombre() +"***"+ obj.getVecpelicula(i).getGenero()+"***" + obj.getVecpelicula(i).getDuracion()+"***"+obj.getVecpelicula(i).getValor()+"***"+obj.getVecpelicula(i).getPuntuacion());
                escribir.newLine();
            }
            escribir.close();
        }
        
    }
    
    public String leerArchivo(String rutaArchivo) throws FileNotFoundException, IOException {
        String linea;

        String verDatosArchivo = "";   
        FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero);
         
        while ((linea = leer.readLine()) != null) {
            StringTokenizer campo = new StringTokenizer(linea, "***");
            verDatosArchivo = verDatosArchivo + String.valueOf(linea + "\n")+campo.nextToken();
        }
           
        leer.close();
        return verDatosArchivo;
    }
    
    public void copiar(){
    

    
    
    }

}
