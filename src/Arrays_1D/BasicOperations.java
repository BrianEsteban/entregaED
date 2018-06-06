package Arrays_1D;

import java.io.*;

/**
 * Ejemplos de operaciones básicas con arreglos
 */
public class BasicOperations 
{
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
     * Suma cada posicion del arreglo.
     * @param array
     * @return la suma total
     */
    public int sum(int[] array)
    {
        int acum = 0;

        for(int i = 0; i < array.length; i++)   //itera el número de la dimensión del arreglo menos uno veces
            acum += array[i];                   //suma cada posición

        return acum;
    }

    /**
     * Promedio del arreglo
     * @param array
     * @return
     */
    public double average(int[] array)
    {
        return sum(array) / (double)array.length; //divide la suma del arreglo entre la dimensión del arreglo.
    }

    /**
     * Valor mínimo del arreglo
     * @param array
     * @return
     */
    public int min(int[] array)
    {
        int min = Integer.MAX_VALUE;    //inicializa la variable con el mayor número entero posible

        for(int i = 0; i < array.length; i++)   
            if(array[i] < min)          //si la posición actual es menor a min entonces será el nuevo valor menor
                min = array[i];

        return min;
    }
    
    /**
     * Valor máximo del arreglo
     * @param array
     * @return
     */
    public int max(int[] array)
    {
        int max = Integer.MIN_VALUE;    //inicializa la variable con el menor número entero posible

        for(int i = 0; i < array.length; i++)
            if(array[i] > max)          //si la posición actual es mayor a max entonces será el nuevo valor mayor
                max = array[i];

        return max;
    }

    /**
     * Arroja el índice en el arreglo de un valor específico
     * @param array
     * @param value
     * @return
     */
    public int indexOf(int[] array, int value)
    {
        int index = -1; //inicializa en menos uno por si no es encontrado el valor

        for(int i = 0; i < array.length; i++)   //realiza el recorrido
            if(array[i] == value)               //si la posición actual es igual al valor toma ese índice y sale del ciclo
            {
                index = i;
                break;
            }

        return index;
    }

    /**
     * Número de apareciones de un valor específico en el arreglo
     * @param array
     * @param value
     * @return
     */
    public int occurrencesOf(int[] array, int value)
    {
        int counter = 0;

        for(int i = 0; i < array.length; i++)   //hace el recorrido posición por posición
            if(array[i] == value)               //si la posición actual es igual al valor aumenta el contador
                counter += 1;

        return counter; 
    }

    /**
     * Recorta el arreglo desde una posición inicial a una final
     * @param array
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public int[] subarray(int[] array, int beginIndex, int endIndex)
    {
        int[] sub = null;   //creación del nuevo arreglo 

        if(beginIndex < endIndex && endIndex < array.length) 
        {
            sub = new int[endIndex - beginIndex];   //tamaño del nuevo arreglo es la resta de la posición final menos la inicial
            for(int i = 0; i < (endIndex - beginIndex); i++)    //itera tantas veces como es la dimensión del nuevo arreglo
                sub[i] = array[beginIndex + i];     //el nuevo arreglo se llena con los valores desde la posición inicial
        }
        return sub;
    }

    /**
     * Reemplazo de un número por otro en el arreglo
     * @param array
     * @param oldNumber
     * @param newNumber
     */
    public void replace(int[] array, int oldNumber, int newNumber)
    {
        for(int i = 0; i < array.length; i++)   //itera el número de la dimensión del arreglo menos uno veces
            if(array[i] == oldNumber)           //si haya el viejo número en una posición lo cambia por el nuevo número.
                array[i] = newNumber;
    }
}