/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivosobj;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ArchivosObj {

    public static void llenar(Persona per) {
        String nombre = JOptionPane.showInputDialog(null, "Digite el NOMBRE: ");
        per.setNombre(nombre);
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Id"));
        per.setId(id);
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
        per.setEdad(edad);
    }

    public static int menu() {
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("=== IMPLEMENTACIÓN DE ARCHIVOS - OPCIÓN DEL MENÚ ===\n\n"
                    + "1. Guardar Nombres en el Archivo \n"
                    + "2. Listar los Nombres del Archivo \n"
                    + "3. Cantidad de Nombres Guardados\n"
                    + "4. Informacion General del Archivo \n"
                    + "5. Buscar nombre \n"
                    + "6. Salir"
                    + "\n \n Seleccione una opcion del 1 al 6"));
        } while (opcion <= 0 || opcion > 6);
        return opcion;
    }  

    public static void informeArchivo(ClaseArchivo arch) {
        File inf = new File(arch.getRutaArchivo());
        JOptionPane.showMessageDialog(null, "====== INFORMACÓN DEL ARCHIVO ======" + "\n"
                + "\n Ubicación: " + inf.getAbsolutePath() + "\n Tamaño: " + inf.length());
    }

    public static void main(String[] args) throws IOException {
        int opcion;
        ClaseArchivo arch = new ClaseArchivo();
        arch.setRutaArchivo("personas3.txt");
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    Persona per = new Persona();
                    llenar(per);
                    arch.guardarArchivo(per);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,arch.leerArchivo(arch.getRutaArchivo()));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "====== NOMBRES DEL ARCHIVO ======" + "\n" + "\n"
                            + "Se han registrado: " + arch.cantidadLineasArchivo() + " Nombres \n\n");
                    break;
                case 4:
                    informeArchivo(arch);
                    break;
                case 5:
                    String nom = JOptionPane.showInputDialog("Ingrese Nombre A Buscar");
                    if (!arch.buscarArchivo(arch.getRutaArchivo(), nom)) {
                        JOptionPane.showMessageDialog(null, "El nombre no se encontró en el archivo");
                    } else {
                        JOptionPane.showMessageDialog(null, "El nombre " + nom + " se encontró en la lista");
                    }
                    break;
                case 6:
                    break;

            }
        } while (opcion != 6);
    }

}
