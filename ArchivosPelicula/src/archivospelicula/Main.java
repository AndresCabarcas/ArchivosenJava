/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivospelicula;

import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.*;

/**
 *
 * @author ANDACAMES
 */
public class Main {

    public static String Ruta_del_Archivo() {
        return ("Pelicula.txt");
    }

    public static int Menu() {

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "============ Menu de aplicacion ============" + "\n"
                    + "0. Llene el vector Peliculas       \n"
                    + "1. Grabar la informacion en el archivo de texto     \n"
                    + "2. Mostrar el Vector     \n"
                    + "3. Leer Peliculas.txt \n"
                    + "4. Pasar texto al archivo Pelis2.txt\n"
                    + "5. Salir\n"));

        } while (opcion != 5 && opcion < 0);
        return opcion;
    }

    public static void mostrarVector(VectorPeliculas vec) {
        String datosVector = "";
        for (int i = 0; i <= vec.getTama() - 1; i++) {
            datosVector = datosVector + String.valueOf("Posición " + i + ": " + vec.getVecpelicula(i).getGenero() + vec.getVecpelicula(i).getNombre() + vec.getVecpelicula(i).getDuracion() + "\n");
        }

        JOptionPane.showMessageDialog(null, "============ ELEMENTOS DEL VECTOR  ============" + "\n" + datosVector);

    }

    public static void llenar(Pelicula obj) {
        int puntuacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite puntuacion: "));
        String nombre = JOptionPane.showInputDialog(null, "Digite el Nombre: ");
        float valor = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite el Precio: "));
        int duracion = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la duracion: "));
        String genero = JOptionPane.showInputDialog(null, "Digite el genero: ");
        obj.setDuracion(duracion);
        obj.setGenero(genero);
        obj.setPuntuacion(puntuacion);
        obj.setValor(valor);
        obj.setNombre(nombre);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        VectorPeliculas vec = new VectorPeliculas();
        Pelicula pel;
        int opc;

        do {
            opc = Menu();
            switch (opc) {
                case 0:
                    int n = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el tamaño o numeros de lineas del Vector Peliculas"));
                    vec.setTama(n);
                    vec.crearVector();
                    for (int i = 0; i < vec.getTama(); i++) {
                        pel = new Pelicula();
                        JOptionPane.showMessageDialog(null, "============ ELEMENTOS DEL VECTOR ============" + "\n \n" + "Ingresar la Informacion de la pelicula ---- " + (i + 1));
                        llenar(pel);
                        vec.setVecpelicula(i, pel);
                    }
                    break;
                case 1:
                    Archivo arc = new Archivo();
                    arc.guardarArchivo(vec);
                    JOptionPane.showMessageDialog(null, "Grabado");
                    break;
                case 2:
                    mostrarVector(vec);
                    break;
                case 3:
                    Archivo ar = new Archivo();
                    JOptionPane.showMessageDialog(null, "====== NOMBRES DEL ARCHIVO ======" + "\n" + ar.leerArchivo("Pelicula.txt"));
                    break;
                case 4:
                    BufferedReader br=null;
                    BufferedWriter bw=null;

                    try {

                        br = new BufferedReader(new FileReader("Pelicula.txt"));
                        bw = new BufferedWriter(new FileWriter("Pelis2.txt"));

                        int c;
                        while ((c = br.read()) != -1) {
                            bw.write(c);
                        }
                    } finally {

                        if (br != null) {
                            br.close();

                        }
                        if (bw != null) {
                            bw.close();
                        }

                    }

                case 5:

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR: digite una de las opciones del menú");

            }
        } while (opc != 5);

    }

}
