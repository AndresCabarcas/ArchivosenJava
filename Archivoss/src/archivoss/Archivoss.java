/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivoss;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MARIO MUÑOZ
 */
public class Archivoss {
    
    public static void Escribir(){
        File archivo;
        FileWriter escribir;
        PrintWriter linea;
        String nombre="";
        String vectorr[];
        vectorr = new String [100];
        int i=0;
    archivo = new File("nombresss.txt");
    
    if(!archivo.exists()){
            try {
                archivo.createNewFile();
                nombre=JOptionPane.showInputDialog(null,"Ingresa el nombre");
                
               
                
                escribir = new FileWriter(archivo,true);
                linea = new PrintWriter(escribir);
                // escribimos enn el archivo
                linea.println(nombre);
                linea.close();
                escribir.close();
            } 
            catch (IOException ex) {
                Logger.getLogger(Archivoss.class.getName()).log(Level.SEVERE, null, ex);
            }
    }else{
        try {
                archivo.createNewFile();
                nombre=JOptionPane.showInputDialog(null,"Ingresa el nombre");
            
                escribir = new FileWriter(archivo,true);
                linea = new PrintWriter(escribir);
                // escribimos enn el archivo
                linea.println(nombre);
                linea.close();
                escribir.close();
            } 
            catch (IOException ex) {
                Logger.getLogger(Archivoss.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    }
    
    public static void Leer(){
    
        try {
            FileReader fr=new FileReader(new File("nombresss.txt"));
            BufferedReader br=new BufferedReader(fr);
            String linea;
            while((linea=br.readLine()) !=null){
            JOptionPane.showMessageDialog(null," "+ linea);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
   
    Escribir();
     Leer();

    }
}
