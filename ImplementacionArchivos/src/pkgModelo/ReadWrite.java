/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Andres
 */
public class ReadWrite {

    private String rutaArchivo;
    File archivo;

    public ReadWrite() {
        rutaArchivo = "";
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String ruta) {
        rutaArchivo = ruta;
    }

    public String convertir(int entero) {
        return String.valueOf(entero);
    }

    public void guardarArchivo(Estudiante pelaito) throws IOException {
        archivo = new File(getRutaArchivo());
        BufferedWriter escribir;
        if (archivo.exists()) {
            escribir = new BufferedWriter(new FileWriter(archivo, true));
            escribir.write(pelaito.getGrado() + ":");
            escribir.write(convertir(pelaito.getIde()) + ":");
            escribir.write(pelaito.getNombre() + ":");
            escribir.write(pelaito.getSexo() + ":");
            escribir.write(convertir(pelaito.getEdad()));
            escribir.newLine();
        } else {
            escribir = new BufferedWriter(new FileWriter(archivo));
            escribir.write(pelaito.getGrado() + ":");
            escribir.write(convertir(pelaito.getIde()) + ":");
            escribir.write(pelaito.getNombre() + ":");
            escribir.write(pelaito.getSexo() + ":");
            escribir.write(convertir(pelaito.getEdad()));
            escribir.newLine();
        }
        escribir.close();
    }

    public String leerArchivo(String rutaArchivo) throws FileNotFoundException, IOException {
        String linea;
        String verDatosArchivo = "";
        Estudiante pelaito;
        FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero);
        while ((linea = leer.readLine()) != null) {
            pelaito = new Estudiante();
            StringTokenizer campo = new StringTokenizer(linea, ":");
            String curso = campo.nextToken().trim();
            pelaito.setGrado(curso);
            int ide = Integer.parseInt(campo.nextToken().trim());
            pelaito.setIde(ide);
            String nom = campo.nextToken().trim();
            pelaito.setNombre(nom);
            String sexo = campo.nextToken().trim();
            pelaito.setSexo(sexo);
            int edad = Integer.parseInt(campo.nextToken().trim());
            pelaito.setEdad(edad);

            verDatosArchivo = verDatosArchivo + String.valueOf(
                    "Curso: " + pelaito.getGrado() + " ide: " + pelaito.getIde()
                    + " Nombre: " + pelaito.getNombre() + " Edad: " + pelaito.getEdad()
                    + " Sexo: " + pelaito.getSexo() + "\n");
        }
        leer.close();
        return verDatosArchivo;
    }

    public String EstudiantesPrejardin(String rutaArchivo) throws FileNotFoundException, IOException {
        String linea;
        String verDatosArchivo = "";
        Estudiante pelaito;
        FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero);
        while ((linea = leer.readLine()) != null) {
            pelaito = new Estudiante();
            StringTokenizer campo = new StringTokenizer(linea, ":");
            String curso = campo.nextToken().trim();
            pelaito.setGrado(curso);
            int ide = Integer.parseInt(campo.nextToken().trim());
            pelaito.setIde(ide);
            String nom = campo.nextToken().trim();
            pelaito.setNombre(nom);
            String sexo = campo.nextToken().trim();
            pelaito.setSexo(sexo);
            int edad = Integer.parseInt(campo.nextToken().trim());
            pelaito.setEdad(edad);

            if (pelaito.getGrado().equalsIgnoreCase("Prejardin")) {
                verDatosArchivo = verDatosArchivo + String.valueOf(
                        "Curso: " + pelaito.getGrado() + " ide: " + pelaito.getIde()
                        + " Nombre: " + pelaito.getNombre() + " Edad: " + pelaito.getEdad()
                        + " Sexo: " + pelaito.getSexo() + "\n");
            }
        }
        leer.close();
        return verDatosArchivo;
    }

    public String EstudiantesJardin(String rutaArchivo) throws FileNotFoundException, IOException {
        String linea;
        String verDatosArchivo = "";
        Estudiante pelaito;
        FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero);
        while ((linea = leer.readLine()) != null) {
            pelaito = new Estudiante();
            StringTokenizer campo = new StringTokenizer(linea, ":");
            String curso = campo.nextToken().trim();
            pelaito.setGrado(curso);
            int ide = Integer.parseInt(campo.nextToken().trim());
            pelaito.setIde(ide);
            String nom = campo.nextToken().trim();
            pelaito.setNombre(nom);
            String sexo = campo.nextToken().trim();
            pelaito.setSexo(sexo);
            int edad = Integer.parseInt(campo.nextToken().trim());
            pelaito.setEdad(edad);

            if (pelaito.getGrado().equalsIgnoreCase("Jardin")) {
                verDatosArchivo = verDatosArchivo + String.valueOf(
                        "Curso: " + pelaito.getGrado() + " ide: " + pelaito.getIde()
                        + " Nombre: " + pelaito.getNombre() + " Edad: " + pelaito.getEdad()
                        + " Sexo: " + pelaito.getSexo() + "\n");
            }
        }
        leer.close();
        return verDatosArchivo;
    }

    public String Buscar(int dato) throws FileNotFoundException, IOException {
        String linea;
        String info = "";
        FileReader fichero = new FileReader(getRutaArchivo());
        BufferedReader leer = new BufferedReader(fichero);
        while ((linea = leer.readLine()) != null) {
            StringTokenizer campo = new StringTokenizer(linea, ":");
            String curso = campo.nextToken().trim();
            int ide = Integer.parseInt(campo.nextToken().trim());
            String nom = campo.nextToken().trim();
            String sexo = campo.nextToken().trim();
            int edad = Integer.parseInt(campo.nextToken().trim());
            if (ide==(dato)) {
                info = info + String.valueOf(
                        "Curso: " + curso + " ide: " + ide
                        + " Nombre: " + nom + " Edad: " + edad
                        + " Sexo: " + sexo + "\n");
            }
        }
        leer.close();
        return info;
    }
}
