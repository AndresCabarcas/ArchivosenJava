/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelopsp;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDACAMES
 */
public class Arreglo {
    //creamos nuestro ArrayList de tipo Persona
    ArrayList<Persona> arreglo = new ArrayList<Persona>();

    //creamos el metodo para añadir nuestros objetos al Array
    public void Agregar(Persona Dato) {//el metodo recibira un objeto persona como parametro
        if (arreglo.size() < 100) {//con esto limitamos el taño de nuestro array a 100
            arreglo.add(Dato);//agregamos el objeto al Array
        } else {
            JOptionPane.showMessageDialog(null, "!Lo sentimos¡: Limite superado");//mensaje en caso de llegar a los 100 datos
        }

    }

    public int Contador() {
        return arreglo.size();//este metodo nos muestra el tamaño actual del Array
    }

    public Persona pPersona(int i) {//creamos un metodo para tomar los elementos del Array en una posicion dada
        Persona h;
        h = arreglo.get(i);//con el metodo get(i)se obtiene el objeto en la poscion "i"
        return h;
    }

}
