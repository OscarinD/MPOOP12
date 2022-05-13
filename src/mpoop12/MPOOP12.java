/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mpoop12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class MPOOP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Vamos a crear un archivo
        File archivo = new File("archivo.txt");//importar paquete
        System.out.println(archivo.exists());//false, no hemos creado el objeto
        try {
            //archivo.createNewFile();//si lo pongo solo, me marca advertencia, elegir sorround(2)
            boolean seCreo = archivo.createNewFile();//hasta aquì se crea el archivo
            System.out.println("se creò = "+seCreo);
            System.out.println(archivo.exists());
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("############## FileWriter #####################");//buffer, estructura que almacena informaciòn momentànea
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriba el texto para el archivo");
            String texto = br.readLine();
            
            FileWriter fw = new FileWriter("fw.csv");//si no existe el archivo, lo crea
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.println(texto);
            for (int i = 0; i < 10; i++) {
                salida.println("linea del for "+i);
            }
            salida.close();
            
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("########### FileReader #################");
        try {
            
            FileReader fr = new FileReader("fw.csv");//abrir con textEdit
            BufferedReader br = new BufferedReader(fr);
            System.out.println("El texto del archivo es");
            String linea = br.readLine();
            while (linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);//ver extensiones de archivos en windows
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);//pestaña vista, ver, ocultar de archivos escondidos
        }
        //utf-8
        //para proyecto
        System.out.println("########### StringTokenizer #####################");
        Platillo platillo = new Platillo();
        float temp = 0;//no se inicializan desde el constructor
        String textoTemporal;
        String linea = "Enchiladas,50.44,Pollo/crema/queso";
        StringTokenizer tokenizador = new StringTokenizer(linea,",");//token, mìnimo de algo
        while(tokenizador.hasMoreTokens()){
            textoTemporal = tokenizador.nextToken();
            if(temp == 0)
                platillo.setNombre(textoTemporal);
            else if(temp == 1)
                platillo.setPrecio(Double.parseDouble(textoTemporal));
            else if(temp == 2)
                platillo.setIngredientes(textoTemporal);
            System.out.println(textoTemporal);
            temp++;
            //System.out.println(tokenizador.nextToken());           
        }
        System.out.println(platillo);
        //preguntar 10 platillos, escribir 10 platillos a mano en un archivo y despuès leerlos y guardarlos en 10 objetos platillo, usar tokenizer
        //hacer arreglo de platillos
    }
    
}
