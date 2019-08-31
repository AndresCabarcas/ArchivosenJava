/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;


public class Escribir {

    static void crearFichero() {
        
        /*en este metodo utiliza las calses necesarias para crear un archivo binario
        y manejamos con try catch las excepciones de los errores que puden surgir de entrada
        y salida ya que puede haber un archivo del mismo nombre o no se cuente con espacio de almacenamiento
        entre otros*/
        
        DataOutputStream dos = null;
        try {
            FileOutputStream fos = new FileOutputStream("datosbeca.bin", true);//pasamos la extencion del archivo y el nombre en este caso como se guardara en el directorio del proyecto solo dejamos el nombre con su extencion .bin para indicar que es un archivo binario
            dos = new DataOutputStream(fos);
            escribirFichero(dos);//enviamos la variable de tipo DataOutputStream al metodo escribir fichero para utilizar sus metodos y escribir en nuestro archivo
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void escribirFichero(DataOutputStream dos) throws Exception {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        String sexo, resiFamiliar;
        int edad;
        int creditos;
        int ingresos;

        System.out.println("introduce Nombre y Apellidos");
        nombre = teclado.nextLine();
        dos.writeUTF(nombre);//usando la clase DataOutputStream, tenemos el metodo writeUTF para escriibir en el archivo un String

        do {
            System.out.println("Introduce el sexo H/M");
            sexo = teclado.next();
            //sexoChar = sexo.toCharArray();

            if ((!sexo.equals("H")) && (!sexo.equals("M"))) {
                System.out.println("error caracter");
            }
        } while ((!sexo.equals("H")) && (!sexo.equals("M")));
        dos.writeUTF(sexo);

        do {
            System.out.println("introduce la edad");
            edad = teclado.nextInt();
            if ((edad < 20) || (edad > 60)) {
                System.out.println("edad erronea");
            }
        } while ((edad < 20) || (edad > 60));
        dos.writeInt(edad);//usando la clase DataOutputStream, tenemos el metodo writeINT para escriibir en el archivo un entero

        do {
            System.out.println("introduce el numero de creditos");
            creditos = teclado.nextInt();
            if ((creditos < 0) || (creditos > 4)) {
                System.out.println("créditos erronea");
            }
        } while ((creditos < 0) || (creditos > 4));
        dos.writeInt(creditos);

        do {
            System.out.println("introduce residencia familiar si/no");
            resiFamiliar = teclado.next();
            //sexoChar = sexo.toCharArray();

            if ((!resiFamiliar.equals("si")) && (!resiFamiliar.equals("no"))) {
                System.out.println("Error Caracter");
            }
        } while ((!resiFamiliar.equals("si")) && (!resiFamiliar.equals("no")));
        dos.writeUTF(resiFamiliar);

        System.out.println("Ingresos Anuales Familiar");
        ingresos = teclado.nextInt();
        dos.writeInt(ingresos);
        
        

    }

}
