/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.DataInputStream;
import java.io.FileInputStream;


public class leer {

    public static void selecionarFichero() {
        /*Metodo para leer el archivo binario utilisando las clases necesarias
        DataInputStream y FileInputStream */
        DataInputStream dis = null;
        try {
            FileInputStream fis = new FileInputStream("datosbeca.bin");//ingresamos la ruta del archivo su nombre con extension
            dis = new DataInputStream(fis);
            leerFichero(dis);//enviamos la variable de tipo DataInputStream al metodo leer fichero
        } catch (Exception e) {// manejo de excepciones puede que el archivo no exista
            System.out.println(e.getMessage());
        }
    }

    public static void leerFichero(DataInputStream dis) throws Exception {
        while (true) {
            String nombre;
            String sexo, resiFamiliar;
            int edad;
            int creditos;
            int ingresos;
            int baseFija = 1500;
            int total = 0;

            //captura de los datos del archive 
            nombre = dis.readUTF();//obtenemos los datos del archivo binario con readUTF leemos los de tipo String y lo almacenamos en una variable definida anteriormente
            sexo = dis.readUTF();
            edad = dis.readInt();////obtenemos los datos del archivo binario con readInt leemos los de tipo entero y lo almacenamos en una variable definida anteriormente
            creditos = dis.readInt();
            resiFamiliar = dis.readUTF();
            ingresos = dis.readInt();

            total = total + baseFija;

// cuantia edad
            if (edad < 23) {
                total = total + 200;
            } else {
                total = total + 0;
            }
// cuantia creditos
            if (creditos == 0) {
                total = total + 500;
            }
            if (creditos == 1) {
                total = total + 200;
            } else {
                total = total + 0;
            }
// cuantia residencia familiar
            if (resiFamiliar.equalsIgnoreCase("no")) {
                total = total + 1000;
            } else {
                total = total + 0;
            }
            if (ingresos <= 12000) {
                total = total + 500;
            } else {
                total = total + 0;
            }
            if (creditos >= 2) {
                total = 2;
                System.out.println("para:" + nombre + "no le corresponde beca" + total + "â,¬");
            } else {
                System.out.println("para:" + nombre + "tiene una cuantia de" + total + "â,¬");
            }
            // ingresos anuales
            if (ingresos <= 12000) {
                total = total + 500;
            } else {
                total = total + 0;
            }
            if (creditos >= 2) {
                total = 2;
                System.out.println("para:" + nombre + "no le corresponde beca" + total + "â,¬");
            } else {
                System.out.println("para:" + nombre + "tiene una cuantia de" + total + "â,¬");
            }
        }
    }
}



