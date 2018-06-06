package LinearDS_Problems;

import java.io.*;
import java.util.Scanner;

/**
 * Where is the marble lo que busca es hallar la posicion de una o varias canicas en donde se da la cantidad de canicas y el numero
 * de busquedas que se deben hacer. Se llaman un método de ordenamiento como lo es bubleSort y un método de búsqueda como binarySearch.
 * @author Brian Esteban Barreto
 */
public class Marbles {
    
   /**
    * bubleSort es un metodo de ordenamiento tradicional. 
    * @param unsorted
    * @return arreglo ordenado
    */
    public int[] bubleSort(int[] unsorted)
    {
        boolean swap = false;
        int temp;     
        do
        {
            swap = false;   //se inicializa la bandera en falso
            for (int i = 0; i < (unsorted.length - 1); i++) 
            {
                if (unsorted[i] > unsorted[i+1]) //compara elementos y realiza un cambio(swap) si se cumple la condicion de que sea mayor el que se encuentra en la posicion i al que se encuentra en la posicion i+1. 
                {
                    temp = unsorted[i];         //cambio en zig zag
                    unsorted[i] = unsorted[i+1];
                    unsorted[i+1] = temp;
                    swap=true;                  //cambia de estado la bandera
                }
            }
        }while(swap);
        return null;
    }
    
   /**
    * binarySearch no recursivo arroja el indice de la posición en donde se encuentra el valor buscado.
    * @param sorted
    * @param x
    * @return posicion del arreglo en donde se encuentra x, si no está -1.
    */  
    public String binarySearch(int sorted[], int x)
    {
        int lowerBound = 1; //límite inferior igual a 1
        int upperBound = sorted.length; //limite superior igual al tamaño del arreglo
        String index = x + " not found" + "\n";
        
        while(lowerBound < upperBound)  //realiza el ciclo hasta hallar x
        {
            int middlePoint = (lowerBound + upperBound) / 2;    //punto medio es el promedio del límite superior y el límite inferior
            if (x == sorted[middlePoint]) //si llegara a ser justo en el punto medio, el indice sería el promedio entre los límites
            {
                index = x  + " found at "  + middlePoint;
                break;
            }
            else
            {
                if (x < middlePoint)    //va descartando la mitad del arreglo preguntando si x es mayor o menor a middlePoint
                    upperBound = middlePoint - 1;
                else
                    lowerBound = middlePoint + 1;
            }
        }
        if ((lowerBound == upperBound) && sorted[lowerBound] == x)
            index = x + " found at " + lowerBound + "\n";
        
        return index;
    }
    
   /**
 el segundo dato es el numero de consultas, con este se hace el segundo
    * ciclo for donde se llama inmediantamente el método de búsqueda binaria para que vaya hallando la posicion de cierta cantidad de casos
    * @param args
    * @throws IOException 
    */
    public static void main(String[] args) throws IOException 
    {
        Marbles marble = new Marbles();    
        
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        
        int marbles = sc.nextInt();  //lectura de número de canicas
        int queries = sc.nextInt();  //lectura de número de consultas
        
        while(marbles != 0 && queries !=0)  //Cuando sean 0 finaliza la ejecución
        {
            int[] unsorted = new int[marbles + 1];  //creación de un arreglo con dimensión del número de canicas más uno
            
            for (int i = 1; i < marbles + 1; i++)   //se realiza un ciclo para llenar el arreglo
                unsorted[i] = sc.nextInt(); //lectura del valor de la canica
        
            marble.bubleSort(unsorted); //se ordena el arreglo con bubbleSort
        
            for (int i = 0; i < queries; i++)   //itera para hacer el número de consultas dado
            {
                int x = sc.nextInt();   //lectura de la consulta
                int ncase = i+1;
                bw.write("CASE# " + ncase + ":" + "\n");
                bw.write(marble.binarySearch(unsorted, x) + "\n");  //búsqueda binaria para hallar x
                bw.flush();
            }
            marbles = sc.nextInt(); //lectura de número de canicas
            queries = sc.nextInt(); //lectura de número de consultas 
        }  
        bw.close();
    }
}

/*
//Entradas:
4 1
2 
3 
5 
1
5
Respuesta:
CASE# 1:
5 found at 4
//Entradas:
5 2
1 
3
3
3
1
2
Respuestas:
CASE# 1:
2 not found

3
CASE# 2:
3 found at 3

//Entradas:
0 0
//Fin
 */