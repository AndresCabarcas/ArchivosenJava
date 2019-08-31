/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivosguia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ANDACAMES
 */
public class LeerEscribirArchivo {

    private String rutaArchivo; //Atributo para asignar el nombre del archivo.    
    File archivo;

    public void LeerEscribirArchivo() {
//Método constructor de la clase.     
        rutaArchivo = "";
    }

    public void setRutaArchivo(String nom) {
//Método modificador para asignar el nombre del archivo.    
        rutaArchivo = nom;

    }

    public String getRutaArchivo() {
//Método para obtener el nombre del archivo.   
        return rutaArchivo;
    }

//Método para guardar los datos de tipo cadena pasados como parámetro en el archivo.     
    public void guardarArchivo(String dato) throws IOException {
//Se crea un objeto de la clase File llamado archivo y se pasa como parámetro al constructor de la 
//clase File el nombre o ruta del archivo.      
        archivo = new File(getRutaArchivo());
        BufferedWriter escribir; //Se declara un objeto de la clase BufferedWriter llamado escribir.    
        if (archivo.exists()) { //Si el archivo existe, se agrega el dato después de la última línea. 
            //Se crea el objeto de la clase BufferedWriter y se pasa a su constructor el objeto de la clase File.
            //Si se quiere añadir al final de un fichero ya existente, simplemente se poner true 
            //como segundo parámetro del constructor de FileWriter.        
            escribir = new BufferedWriter(new FileWriter(archivo, true));
            escribir.write(dato); //Se escribe el dato pasado como parámetro con el método write.
            escribir.newLine(); //Para asignar una nueva línea en el archivo.          
        } else { //Si el archivo no existe, se crea y se le asigna el primer dato en el archivo.     
            escribir = new BufferedWriter(new FileWriter(archivo));
            escribir.write(dato);
            escribir.newLine();
        }
        escribir.close();
    }

//Implementación del método que permite abrir el archivo para leer línea a línea los datos. 
    public String leerArchivo(String rutaArchivo) throws FileNotFoundException, IOException {
        String linea;
        //variable para asignar cada línea del archivo.     
        String verDatosArchivo = ""; //Variable par air almacenado toda la información del archive.
        //Se crea un objeto de la clase FileReader para pasarlo como parámetro al constructor del objeto
        //que se crea de la clase BufferedReader (leer).     
        FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero); //Mientras que se pueda leer la línea, se va almacenado la información leída en cada línea, en la 
        //variable verDatosArchivo para posteriormente mostrarlos.     
        while ((linea = leer.readLine()) != null) {
            verDatosArchivo = verDatosArchivo + String.valueOf(linea + "\n");
        }
        leer.close();
        return verDatosArchivo;
    } //Método para contabilizar el número de líneas almacenadas en el archivo.   

    public int cantidadLineasArchivo() throws FileNotFoundException, IOException {
        int numeroLineas = 0;
        String linea;
        FileReader fichero = new FileReader(getRutaArchivo());
        BufferedReader leer = new BufferedReader(fichero);
        while ((linea = leer.readLine()) != null) {
            numeroLineas++;
        }
        leer.close();
        return numeroLineas;
    }

}
