/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivosobj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ClaseArchivo {

    private String rutaArchivo; //Atributo para asignar el nombre del archivo. 
    File archivo;

    public void LeerEscribirArchivo() { //Método constructor de la clase. 
        rutaArchivo = "";
    }

    public void setRutaArchivo(String nom) { //Método modificador para asignar el nombre del archivo 
        rutaArchivo = nom;
    }

    public String getRutaArchivo() { //Método para obtener el nombre del archivo. 
        return rutaArchivo;
    } //Método para guardar los datos de tipo cadena pasados como parámetro en el archivo.

    public String convertir(int dato) {
        return String.valueOf(dato);
    }

    public void guardarArchivo(Persona dato) throws IOException {
        archivo = new File(getRutaArchivo());
        BufferedWriter escribir;
        if (archivo.exists()) {
            escribir = new BufferedWriter(new FileWriter(archivo, true));
            escribir.write(dato.getNombre() + "\t");
            escribir.write(convertir(dato.getId()) + "\t");
            escribir.write(convertir(dato.getEdad()) + "\t");
            escribir.newLine();
        } else {
            escribir = new BufferedWriter(new FileWriter(archivo));
            escribir.write(dato.getNombre() + "\t");
            escribir.write(convertir(dato.getId()) + "\t");
            escribir.write(convertir(dato.getEdad()) + "\t");
            escribir.newLine();
        }
        escribir.close();
    }

    public String leerArchivo(String rutaArchivo) throws FileNotFoundException, IOException {
        String linea;
        String datosArchivo = "";
        Persona per;
        FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero);
        while ((linea = leer.readLine()) != null) {
            StringTokenizer campo = new StringTokenizer(linea, "\t");
            String nom = campo.nextToken().trim();
            String id = campo.nextToken().trim();
            String edad = campo.nextToken().trim();
            per = new Persona();
            per.setNombre(nom);
            per.setId(Integer.parseInt(id));
            per.setEdad(Integer.parseInt(edad));

            datosArchivo = datosArchivo + String.valueOf("Nombre: " + per.getNombre() + "\nId: " + per.getId() + "\nEdad: " + per.getEdad()+"\n\n");

        }
        leer.close();
        return datosArchivo;
    }

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

    public boolean buscarArchivo(String rutaArchivo, String nombre) throws FileNotFoundException, IOException {
        boolean aux = false;
        String linea;
        Persona per;
        FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero);
        linea = leer.readLine();
        while ((linea = leer.readLine()) != null) {
            StringTokenizer campo = new StringTokenizer(linea, "\t");
            String nom = campo.nextToken().trim();
            String id = campo.nextToken().trim();
            String edad = campo.nextToken().trim();
            per = new Persona();
            per.setNombre(nom);
            per.setId(Integer.parseInt(id));
            per.setEdad(Integer.parseInt(edad));
            if (per.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        leer.close();
        return aux;
    }
}
