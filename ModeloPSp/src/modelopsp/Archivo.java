/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelopsp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author ANDACAMES
 */
public class Archivo {
    
      File archivo;
    
    public String leerArchivo(String rutaArchivo) throws FileNotFoundException, IOException {
        String linea;

        String verDatosArchivo = "";
        FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero);

        while ((linea = leer.readLine()) != null) {
            verDatosArchivo = verDatosArchivo + String.valueOf(linea + "\n");
        }

        leer.close();
        return verDatosArchivo;
    }
    
     public void CargarArchivo(String rutaArchivo, Arreglo obj) throws FileNotFoundException, IOException {
        String linea;
        String Nombre,Genero;
        int Calorias,Comidas;
        int cont=0;
        String Salto = ",";  
       
        FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero);
        
        while ((linea = leer.readLine()) != null) {
           StringTokenizer token=new StringTokenizer(linea,Salto);
            Nombre=token.nextToken();
            Genero=token.nextToken();
            Calorias=Integer.parseInt(token.nextToken());
            Comidas=Integer.parseInt(token.nextToken());
            Persona nuevo=new Persona(Nombre,Genero,Calorias,Comidas);
            obj.Agregar(nuevo);
        }
           
        leer.close();
        
    }
    
}
