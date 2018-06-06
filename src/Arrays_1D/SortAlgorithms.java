package Arrays_1D;

import java.io.*;
import java.util.*;

/**
 * Métodos de ordenamiento
 * @author Brian Esteban Barreto Cardozo
 */
public class SortAlgorithms 
{
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
            swap = false;   //inicializa la bandera en falso
            for (int i = 0; i < (unsorted.length - 1); i++) //iteración
            {
                if (unsorted[i] > unsorted[i+1]) //Compara elemento por elemento y realiza un cambio si se cumple la condicion de que sea mayor el que se encuentra en la posicion i al que se encuentra en la posicion i+1. 
                {
                    temp = unsorted[i];          //swap
                    unsorted[i] = unsorted[i+1]; //swap
                    unsorted[i+1] = temp;        //swap en zig zag
                    swap=true;                   //si realiza el cambio cambia su estado a verdadero
                }
            }
        }while(swap);   //mientas la bandera esté en estado verdadero continua realizando el ciclo
        return null;
    }
    
    /**
     * countingSort ordena el arreglo por conteo de apariciones de los números 
     * @param unsorted
     */
    public void countingSort(int[] unsorted)
    {     
        int max = Integer.MIN_VALUE; //MIN_VALUE nos arroja el menor valor de los enteros.
        int index = 0;

        for (int i = 0; i < unsorted.length; i++) 
        {
            if (unsorted[i] > max) 
                max = unsorted[i];
        }   
        int[] aux = new int[max + 1];   //arreglo auxiliar con un tamaño del indice mayor del arreglo unsorted
        for (int i = 0; i < unsorted.length; i++) 
        {  
           aux[ unsorted[i] ] += 1; //cada posición del nuevo arreglo coincida con cada indice de unsorted para llevar un conteo de las veces que es repetido un número
        }
        for (int i = 0; i < aux.length; i++)    
        {
            for (int j = 0; j < aux[i]; j++) //con recorrer el arreglo podemos obtener el conjunto de enteros ordenados de manera ascendente
            {
               unsorted[index] = i; 
               index += 1;
            }
        }
   }
     
    /**
     * insertionSort ordena el arreglo tomando los valores del arreglo y buscándoles su posición.
     * @param unsorted
     */
    public void insertionSort(int[] unsorted)
    {
        int temp, indexHole;
        
        for (int i = 1; i < unsorted.length; i++) //toma el valor de cada posición, iniciando en 1 y de manera ascendente
        {
            temp = unsorted[i];
            indexHole = i;
            
            while(indexHole > 0 && unsorted[indexHole - 1] > temp)  //busca la posición que le corresponda comparando con las posiciones que ya hayan sido recorridas
            {
                unsorted[indexHole] = unsorted[indexHole -1];   //iguala por un momento las dos posicicones
                indexHole -= 1;                                 
            }
            unsorted[indexHole] = temp;                         //Realiza el cambio
        }
    }
    
    /**
     * SelectionSort 
     * @param unsortedArray 
     */
    public void selectionSort(int[] unsorted)
    {
        int indexSmallest, tempSwap;

        for(int i = 0; i < unsorted.length - 1; i++) //itera para obtener la posición que cambiara con el menor
        {
            indexSmallest = i;  //inicia desde 0 y va aumentando hasta el tamaño del arreglo menos uno

            for(int j = i + 1; j < unsorted.length; j++)
                if(unsorted[j] < unsorted[indexSmallest]) //compara e intercambia posiciones de manera que el número más pequeño vaya quedando a la izquierda
                    indexSmallest = j;

            tempSwap = unsorted[i];                 //reliza el cambio (swap) entre la posición actual y el menor dentro del arreglo
            unsorted[i] = unsorted[indexSmallest];
            unsorted[indexSmallest] = tempSwap;
        }
    }
    
    /**
     * mergeSort recursivo, utilizando el paradigma divide y vencerás.
     * @param unsorted
     * @return arreglo ordenado
     */
    public int[] mergeSort(int[] unsorted)   
    { 
        int size;
        if (unsorted.length > 1)    //paso base, paso recursivo
        {
            size = unsorted.length / 2; 
            int[] left_array = new int[size];   //creación del arreglo que tendrá los valores de la izquierda
            int[] right_array = new int[unsorted.length - size]; //arreglo de la derecha, por si el arreglo es impar: unsorted.length - size
            
            for (int i = 0; i < size; i++) //recorre hasta la mitad del arreglo para llenar el arreglo de la izquierda
                left_array[i] = unsorted[i];
            
            for (int i = 0; i < unsorted.length; i++) //recorre desde la mitad y hasta el final del arreglo para llenar el arreglo de la derecha
                right_array[i] = unsorted[size + i];
            
            left_array = mergeSort(left_array); //realiza la recursión hasta tener arreglos de tamaño 1
            right_array = mergeSort(right_array);
            
            return merge(left_array, right_array); //hace el llamado al método merge
        }else
            return unsorted;
    }
    
    /**
     * método que realiza la parte de ordenamiento del arreglo
     * @param left
     * @param right
     * @return 
     */
    public int[] merge(int[] left, int[] right)
    {
        int[] temp = new int [left.length + right.length];  //creación de un nuevo arreglo 
        int indexLeft = 0, indexRight = 0, indexTemp = 0;   //se inicializan todos los índices en 0
        
        while(indexLeft < left.length && indexRight < right.length) //recorre cada posición de los arreglos
        {
            if (left[indexLeft] <= right[indexRight])  //toma la misma posición en ambos arreglo y compara para añadir al nuevo arreglo
            {
                temp[indexTemp] = left[indexLeft];
                indexLeft += 1;
            }
            else
            {
                temp[indexTemp] = right[indexRight];
                indexRight += 1;
            }
            indexTemp += 1;
        }
        
        if (indexLeft < left.length)
        {
            for (int i = indexLeft; i < left.length; i++) 
            {
                temp[indexTemp] = left[indexLeft];
                indexLeft += 1;
                indexTemp += 1;
            }
        }
        else
        {   
            for (int i = indexRight; i < right.length; i++) 
            {
                temp[indexTemp] = right[indexRight];
                indexRight += 1;
                indexTemp += 1;
            }
        }
        return temp;
    }
    
    /**
     * quickSort que con su técnica divide y vencerás utiliza un pivote para ir comparando las posiciones y distribuir en sub-arreglos.
     * @param unsorted
     * @param first
     * @param last
     * @return el arreglo de manera ascendente.
     */
    public int[] quickSort(int[] unsorted, int first, int last)
    {
        int i = first;
        int j = last;
        int pivot = (unsorted[i] + unsorted[j]) / 2; //pivot es igual a la suma del primer y último elemento del arreglo, dividido en dos
        while (i < j)
        {
            while(unsorted[i] < pivot)  //recorrido de izquierda a derecha
                i+=1;
            while(unsorted[j] > pivot)  //recorrido de derecha a izquierda
                j-=1;
            if (i <= j)
            {
                int temp = unsorted[j];     //realiza el cambio si i <= j, y posteriormente aumenta i y disminuye j
                unsorted[j] = unsorted[i];
                unsorted[i] = temp;
                i+=1; 
                j-=1;
            }
        }
        int sorted[] = new int[unsorted.length];    //creación del nuevo arreglo con la misma dimensión
        if (first < j) 
            sorted = quickSort(unsorted, first, j); //recursión con el su-arreglo de los menores
        
        if (last > i) 
            sorted = quickSort(unsorted, i, last);  //recursión con el su-arreglo de los mayores
        
        return sorted;
    }    
    
    /**
     * Merge Sort implementado de una segunda manera
     * @param unsorted
     * @return 
     */
    public int[] mergeSort2(int[] unsorted)
    {
        if (unsorted.length == 1)   //en el momento en que se tenga el arreglo de tamaño 1, comienza el proceso de ordenamiento
            return unsorted;
        else
        {
            int size = unsorted.length / 2;
            int[] left_array = new int[size];   //sub-arreglo que va desde el inicio hasta el punto medio
            int[] right_array = new int[unsorted.length - size]; //sub-arreglo que va desde el punto medio hasta el final
            int [] sortedL = new int[size];    
            int [] sortedR = new int[unsorted.length - size];  
            sortedL = mergeSort2(left_array);       //recursiones de los arreglos izquierdo y derecho
            sortedR = mergeSort2(right_array);
            return merge2(sortedL, sortedR);
        }
    }
    
    /**
     * merge2 organiza el arreglo 
     * @param A
     * @param B
     * @return 
     */
    public int[] merge2(int[] A,int[] B)
    {
        int size = A.length + B.length;
        int[] C = new int[size];
        int indexA = 0, indexB = 0, indexC = 0;
        while(indexA < A.length && indexB < B.length)
        {
            if (A[indexA] < B[indexB]) {
                C[indexC] = A[indexA];
                indexA = indexA+1;
                indexC = indexC+1;
            }
            else{
                C[indexC] = B[indexB];
                indexB = indexB+1;
                indexC = indexC+1;
            }
        }
        while(indexA < A.length)
        {
            C[indexC] = A[indexA];
            indexA = indexA+1;
            indexC = indexC+1;  
        }
        while(indexB < B.length)
        {
            C[indexC] = B[indexB];
            indexB = indexB+1;
            indexC = indexC+1;  
        }
        return C;
    }
    
    /**
     * randomQsuickSort tiene la misma lógica que QuickSort, sólo que en este caso la elección del pivote es al azar
     * @param unsorted
     * @return
     */
    public int[] randomQuickSort(int[] unsorted)
    {
        int i = 0;
        int j = unsorted.length;
        Random rd = new Random();
        int pivot = rd.nextInt(unsorted.length - 1); //pivot será un número aleatorio entre 0 y la dimensión del arreglo
        while (i < j)
        {
            while(unsorted[i] < pivot)  //recorrido de izquierda a derecha
                i+=1;
            while(unsorted[j] > pivot)  //recorrido de derecha a izquierda
                j-=1;
            if (i <= j)
            {
                int temp = unsorted[j];     //realiza el cambio si i <= j, y posteriormente aumenta i y disminuye j
                unsorted[j] = unsorted[i];
                unsorted[i] = temp;
                i+=1; 
                j-=1;
            }
        }
        int sorted[] = new int[unsorted.length];    //creación del nuevo arreglo con la misma dimensión
        if (0 < j) 
            sorted = randomQuickSort(unsorted); //recursión con el su-arreglo de los menores
        
        if (unsorted.length > i) 
            sorted = randomQuickSort(unsorted);  //recursión con el su-arreglo de los mayores
        
        return sorted;
    }


   /**
    * Lee desde un archivo, separando los números por comas.
    * @param pathFile
    * @return
    */
    public int[] readArrayFromFile(String pathFile)
    {
        try
        {
            FileReader fr = new FileReader(pathFile);       //pathFile es la dirección del documento
            BufferedReader br = new BufferedReader( fr );   //lectura del documento

            String[] numbers = br.readLine().split(",");    //separación por comas
            int[] arrayNumbers = new int[numbers.length];

            for(int i = 0; i < numbers.length; i++)
                arrayNumbers[i] = Integer.parseInt( numbers[i] );   //cada número es leido como String pero se pasa a entero con la función Integer

            br.close();

            return arrayNumbers;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }


   /**
    * Lee los números de un arreglo por consola
    * @return
    */
    public int[] readArrayFronConsole()
    {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        try
        {
            String[] numbers = br.readLine().split(",");    //lee una línea y la separación de los números es por comas
            int[] arrayNumbers = new int[numbers.length];

            for(int i = 0; i < numbers.length; i++)         //se guardan los números en en arreglo arrayNumbers
                arrayNumbers[i] = Integer.parseInt( numbers[i] );

            return arrayNumbers;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Imprime el arreglo
     * @param array
     */
    public void printArray(int[] array)
    {
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        try
        {
            for(int i = 0; i < array.length - 1; i++)   //ciclo for itera hasta llegar a la dimensión del arreglo menos uno
                bw.write(array[i] + ",");               //imprime cada posición

            bw.write(array[array.length - 1] + "\n");   
            bw.flush();
    }
        catch(Exception ex) 
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Arreglos de tamaño length aleatorios
     * @param length
     * @return arreglo con numeros aleatorios
     */
    public int[] bigArray(int length)
    {
        Random rd = new Random();       
        int[] temp = new int[length];       
        
        for (int i = 0; i < length; i++)    //se itera length veces
            temp[i] = rd.nextInt(10);       //se llena el arreglo temp con números entre 0 y 9
        
        return temp;
    }
    
   /**
    * Prueba de los métodos de ordenamiento, digitando números por consola
    * @param args
    */
    public static void main(String[] args)
    {
        SortAlgorithms sorts = new SortAlgorithms();

        int[] a = sorts.readArrayFronConsole();
        a = sorts.bubleSort(a);
        sorts.printArray(a);
    }
}
