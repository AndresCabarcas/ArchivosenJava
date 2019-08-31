/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author ANDACAMES
 */
public class Main {

    static String nombreFichero;
    static String testo;

    public static String solicitarFichero() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el nombre del fichero");
        nombreFichero = teclado.nextLine();
        return nombreFichero;
    }

    public static String devolverFichero() {
        return nombreFichero;
    }

    public static String solicitarTesto() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el Testo del fichero");
        testo = teclado.nextLine();
        return testo;
    }

    public static String devolverTesto() {
        return testo;
    }

    public static void crearFichero() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(solicitarFichero() + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            escribirFichero(pw);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void escribirFichero(PrintWriter pw) throws Exception {
        pw.println(solicitarTesto());
    }

    public static void mostrarFichero() {
        FileReader fr = null;
        try {
            File fichero = new File(devolverFichero() + ".txt");
            fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            leerFichero(br);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void leerFichero(BufferedReader br) throws Exception {
    }

    public static void invertirCadena(String cadena, char[] cadenaMinusculas, char[] cadenaMaysculas) {

        char[] cadenaFinal;
        cadenaFinal = cadena.toCharArray();

        char[] cadenaChar;
        cadenaChar = cadena.toCharArray();

        for (int i = 0; i < cadenaChar.length; i++) {

            for (int j = 0; j < cadenaMinusculas.length; j++) {
                if (cadenaChar[i] == cadenaMinusculas[j]) {
                    cadenaFinal[i] = cadenaMaysculas[j];
                }
                if (cadenaChar[i] == cadenaMaysculas[j]) {
                    cadenaFinal[i] = cadenaMinusculas[j];
                }
            }
        }
        System.out.println(cadenaFinal);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        crearFichero();
        String cadena = new String(devolverTesto());
        char[] cadenaMinusculas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'q', 'l', 'm', 'n', 'ñ', 'o', 'p', 'k', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] cadenaMaysculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'Q', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'K', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        invertirCadena(cadena, cadenaMinusculas, cadenaMaysculas);
    }

}
