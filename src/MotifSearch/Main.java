package MotifSearch;
import java.io.*;
/**
 * El programa descifra el patrón más repetido en una secuencia creada en la clase GenerateSequences y alojada en 
 * el documento de texto sequences.txt, además cuenta las veces que apareció ese motif.
 * @author Brian
 */
public class Main 
{
    List sequences = new List();            //creación de una nueva lista para insertar la información extraida del documento
    int max_ocurrence = Integer.MIN_VALUE;  //la variable entera toma inicialmente el menor valor posible
    String motif_winner = "";               //variable donde se almacenará el motif buscado 
    
    /**
     * Compara los motif 
     * @param motif_candidate 
     */
    public void compareMotif(String motif_candidate)
    {
        int counter = counterOcurrence(motif_candidate);    //llamado del método que hace el conteo
        if (counter > max_ocurrence) 
        {
            max_ocurrence = counter;
            motif_winner = motif_candidate;                 //elige un motif por su número de apariciones
        }
    }
    
    /**
     * Cuenta las apariciones de una cadena
     * @param motif_candidate
     * @return 
     */
    public int counterOcurrence(String motif_candidate)
    {
        int counter  = 0;
        String gen_sequence;
        
        Sequence temp = sequences.head; 
        while(temp != null)             //recorre la lista
        {
            gen_sequence = temp.sequence;
            
            for (int i = 0; i <= (gen_sequence.length() - motif_candidate.length()); i++)   //se obtienen cadenas del tamaño necesitado
            { 
                if (gen_sequence.substring(i, i + motif_candidate.length()).equals(motif_candidate));   //compara la cadena de cuatro caracteres con el motif elegido
                {
                    counter += 1;
                    i += motif_candidate.length() - 1;
                }
            }
            temp = temp.next;
        }
        return counter;
    }
    
    /**
     * Genera todas las combinaciones que se pueden dar con cuatro caracteres
     * @param subsequence
     * @param size 
     */
    public void generateCombinations(String subsequence, int size)
    {
        if (size == 1) 
        {
            compareMotif(subsequence + "C");
            compareMotif(subsequence + "A");
            compareMotif(subsequence + "G");
            compareMotif(subsequence + "T");
        }else
        {
            generateCombinations(subsequence + "A", size - 1);
            generateCombinations(subsequence + "C", size - 1);
            generateCombinations(subsequence + "G", size - 1);
            generateCombinations(subsequence + "T", size - 1);
        }
    }
    
    /**
     * Se ejecuta el programa que muestra el motif ganador
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            FileReader fr = new FileReader("C:/Motif/sequences.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String input = br.readLine();
            Main run = new Main();

            while(input != null)
            {
                String[] data = input.split(",");
                run.sequences.insertAtEnd(new Sequence(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
                
                input = br.readLine();
            }
            
            run.generateCombinations("", 4);
            System.out.println("Motif ganador: " + run.motif_winner + "\tOcurrencias: " + run.max_ocurrence);
        }
        catch(Exception ex){}
    }
    
}
