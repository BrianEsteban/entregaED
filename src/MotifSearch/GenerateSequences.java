
package MotifSearch;

import java.io.*;
import java.util.Random;

/**
 * Se crea un archivo de texto con una secuencia(sequence) por medio de dos metodos, la restriccion es que sólo
 * podra contener las letras "A","C","G" y "T", luego el cromosoma con enteros entre el 1 y el 23, y su inicio y fin.
 *
 * @author Brian Esteban Barreto Cardozo
 */
public class GenerateSequences {
    
    /**
     * Números aleatorios entre 1 y 23
     * @return "chr" concatenado con un número al azar
     */
    public static String chromosome()
    {
       Random rd = new Random();           
       return "chr" + (rd.nextInt(23)+1);    //función random para obtener números aleatorios entre 1 y 23
    }
    
    /**
     * Caracter al azar
     * @return caracter aleatorio entre que puede ser"A","C","G" o "T"
     */
    public static String nucleotide()
    {
        Random rd = new Random();
        switch(rd.nextInt(4))
        {
            case 0: return "A"; 
            case 1: return "C"; 
            case 2: return "G"; 
            case 3: return "T"; 
            default: return "";

        }
    }
           
    /**
     * Secuencia para llenar el archivo.
     * @param length
     * @return 
     */
    public static String sequence(int length) 
    {
        if (length == 1)        
            return nucleotide();
        else
            return nucleotide() + sequence(length -1); //mientras el tamaño sea mayor a 1 sigue concatenando con el método nucleotide
        
    }

    /**
     * Guarda la secuencia en un archivo.
     */
    public static void saveSequence()
    {
        try{
            FileWriter file = new FileWriter("C:/Documents and Settings/BRIAN/Mis documentos/sequences.txt"); //dirección donde se creará el archivo
            BufferedWriter bw = new BufferedWriter(file);   //BufferedWriter escribe en el archivo
            
            Random rd = new Random();
            int length, start, datasize = 10000; //tamaño del archivo
            String experimental_read;
            
            for (int i = 0; i < datasize; i++) //Se prueba que realice bien los procesos de los mètodos
            {
                length = rd.nextInt(46) + 5;
                start = rd.nextInt(1000 + 1);
                experimental_read = sequence(length) + "," + chromosome() + "," + start + "," + (start + length -1); 
                bw.write(experimental_read + "\n") ;
            }
            bw.flush();         
            bw.close();             //ahorro de memoria
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    /**
     * Pequeña prueba de los métodos
     * @param args 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*System.out.println(sequence(100));
        System.out.println(sequence(20));
      */
        Random rd = new Random();
        int length = rd.nextInt(50)+1;
        int start = rd.nextInt(1000);
        System.out.println(sequence(length) + "," + chromosome() + "," + start + "," + (start + length -1));
        
        saveSequence();  //se llama al método estático para que se ejecute
        
    }
    
}