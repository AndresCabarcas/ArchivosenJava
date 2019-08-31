/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class CearArchivos {

    public static void llenar(Estudiante pelaito) {
        String[] curso = {"Prejardin", "Jardin"};
        String[] sexo = {"Hombre", "Mujer"};
        String c = (String) JOptionPane.showInputDialog(null, "Seleccione el curso", "DATOS DEL ESTUDIANTE", JOptionPane.DEFAULT_OPTION, null, curso, curso[0]);
        int ide = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id"));
        String nomb = JOptionPane.showInputDialog(null, "Ingrese el nombre");
        String s = (String) JOptionPane.showInputDialog(null, "Seleccione el sexo", "DATOS DEL ESTUDIANTE", JOptionPane.DEFAULT_OPTION, null, sexo, sexo[0]);
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad"));
        if (edad >= 4 || edad <= 7) {
            pelaito.setGrado(c);
            pelaito.setIde(ide);
            pelaito.setNombre(nomb);
            pelaito.setSexo(s);
            pelaito.setEdad(edad);
        } else {
            JOptionPane.showMessageDialog(null, "Error!! no se guardaron los datos");
        }
    }

    public static int menu() {
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("=== IMPLEMENTACIÓN DE ARCHIVOS - OPCIÓN DEL MENÚ ===\n\n"
                    + "1. Guardar Estudiante en el Archivo \n"
                    + "2. Listar los Estudiantes del Archivo \n"
                    + "3. Listar Estudiantes de Jardin o Prejardin \n"
                    + "4. Buscar en el archivo \n"
                    + "5. Eliminar \n"
                    + "6. Informe General: Total de estudiates \n"
                    + "7. Promedio De niñas y niños \n"
                    + "8. Salir "
                    + "\n \n Seleccione una opcion del 1 al 5"));
        } while (opcion <= 0 || opcion > 8);
        return opcion;
    }

    public static void main(String[] args) throws IOException {
        int op;
        ReadWrite arch = new ReadWrite();
        arch.setRutaArchivo("listaNombres.txt");
        do {
            op = menu();
            switch (op) {
                case 1:
                    Estudiante est = new Estudiante();
                    llenar(est);
                    if (arch.Buscar(est.getIde()) == "") {
                       
                        arch.guardarArchivo(est);
                        JOptionPane.showMessageDialog(null, "Datos guardados en el archivo!!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "La id ya fué registrada");
                    }
                    break;
                case 2:
                    String datosA = arch.leerArchivo(arch.getRutaArchivo());
                    JOptionPane.showMessageDialog(null, "============IMPLEMENTACION DE ARCHIVOS============\n" + datosA);
                    break;
                case 3:
                    String[] curso = {"Prejardin", "Jardin", "Cancelar"};
                    int res = JOptionPane.showOptionDialog(null, " Que curso quieres listar?", "DATOS DEL ESTUDIANTE", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, curso, curso[0]);
                    String ests;
                    if (res == 0) {
                        ests = arch.EstudiantesPrejardin(arch.getRutaArchivo());
                        JOptionPane.showMessageDialog(null, "============IMPLEMENTACION DE ARCHIVOS============\n" + ests);
                    } else if (res == 1) {
                        ests = arch.EstudiantesJardin(arch.getRutaArchivo());
                        JOptionPane.showMessageDialog(null, "============IMPLEMENTACION DE ARCHIVOS============\n" + ests);
                    }
                    break;
                case 4:
                    int datoB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo "));
                    JOptionPane.showMessageDialog(null, ""+arch.Buscar(datoB));
                    break;
                case 8:
                    break;
            }
        } while (op != 8);

    }
}
