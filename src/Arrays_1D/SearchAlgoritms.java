package Arrays_1D;

/**
 * Métodos de búsqueda
 * @author Brian Esteban Barreto Cardozo
 */
public class SearchAlgoritms 
{
    /**
     * linealSearch es un método de búsqueda
     * @param sorted
     * @param x
     * @return posición en la cual fue encontrado el número x
     */
    public int linearSearch(int[] sorted, int x)
    {
        int index = -1;
        
        for (int i = 0; i < sorted.length; i++) //ciclo for que itera hasta la dimensión del arreglo
        {
            if (sorted[i] == x) //compara cada posicion del arreglo dentro del for
            {
                index = i;
                break;
            }
        }
        return index;   
    }
    
    /**
     * binarySearch no recursivo arroja el indice de la posición en donde se encuentra el valor buscado.
     * @param sorted
     * @param value
     * @return posicion del arreglo en donde se encuentra value, si no está, retorna -1.
     */
    public int binarySearch(int sorted[], int value)
    {
        int lowerBound = 0; //límite inferior igual a 0
        int upperBound = sorted.length - 1; //limite superior igual al tamaño del arreglo menos uno
        int index = -1;
        
        while(lowerBound < upperBound)  //realiza el ciclo hasta hallar a value
        {
            int middlePoint = (lowerBound + upperBound) / 2;    //el punto medio es el promedio del límite superior y el límite inferior
            if (value == sorted[middlePoint])   //si llegara a ser justo en el punto medio, el indice sería el promedio entre los límites
            {
                index = middlePoint;
                break;
            }
            else
            {
                if (value < middlePoint)    //va descartando la mitad del arreglo preguntando si x es mayor o menor a middlePoint
                    upperBound = middlePoint - 1;
                else
                    lowerBound = middlePoint + 1;
            }
        }
        if ((lowerBound == upperBound) && sorted[lowerBound] == value) 
            index = lowerBound;
        
        return index;
    }
    
    /**
, como es el caso del último condicional en donde se 
     * pregunta si el valor buscado es menor o mayor al punto medio del arreglo y hacer la llamada recursiva respectiva.
     * @param sorted
     * @param value
     * @param lB 
     * @param uB
     * @return posicion del arreglo en donde se encuentra value, si no está, retorna -1.
     */
    public int binarySearch_recursive(int[] sorted, int value, int lB, int uB)  //binary search recursivo tiene dos parametros adicionales que son los limites del arreglo y son necesarios para tener el paso de la finalización de la función recursiva
    {
        int middlePoint = (lB + uB)/2;  //el punto medio es el promedio del límite superior y el límite inferior
        if (lB == uB) 
        {
            if(sorted[middlePoint] == value) //si el valor buscado llegara a ser justo en el punto medio, el indice sería el promedio entre los límites
                return middlePoint;  
            else
                return -1;
        }
        else
        {
            if (sorted[middlePoint] == value) 
                return middlePoint;
            else
            {
                if (value < sorted[middlePoint]) //pregunta si el valor buscado es menor o mayor al punto medio del arreglo
                    return binarySearch_recursive(sorted, value, lB, middlePoint);
                else
                    return binarySearch_recursive(sorted, value, middlePoint +1, uB);
            }
        }
    }
    
    /**
     * Método de búsqueda con mejoras a partir de binary search
     * @param sorted
     * @param value
     * @return posicion del arreglo en donde se encuentra value
     */
    public int interpolationSearch(int[] sorted, int value)
    {
        int lowerBound = 0;
        int upperBound = sorted.length - 1;
        int index = -1;
        int middlePoint;
        
        while(lowerBound < upperBound)  //realiza el ciclo hasta hallar a value
        {
            middlePoint = lowerBound + ((upperBound - lowerBound) / sorted[upperBound]-sorted[lowerBound]) * (value - sorted[lowerBound]); // eñ punto medio ahora sigue esta fórmula
            
            if(middlePoint < lowerBound || middlePoint > upperBound)
                break;
            
            if (value == sorted[middlePoint]) 
            {
                index = middlePoint;
                break;
            }
            else
            {
                if (value < sorted[middlePoint]) 
                    upperBound = middlePoint - 1;
                else
                    lowerBound = middlePoint + 1;
            }
        }
        if ((lowerBound == upperBound) && (sorted[lowerBound] == value))
            index = lowerBound;
         
        return index;
    }
    
    /**
     * Interpolation search implementado de manera recursiva.
     * @param array
     * @param value
     * @param lB
     * @param uB
     * @return posicion del arreglo en donde se encuentra value
     */
    public int interpolationSearchRecursive(int[] array, int value, int lB, int uB)
    {
        if (array[lB] == value) 
            return lB;

        else if (lB == uB || array[lB] ==  array[uB]) 
            return -1;

        int index = lB + ((uB - lB)/(array[uB] - array[lB])) * (value - array[lB]);
        
        if (array[index] == value) 
            return index;

        else if(array[index] < value) 
            return interpolationSearchRecursive(array, value, index + 1, uB);

        else 
            return interpolationSearchRecursive(array, value, lB, index - 1);
    }
    
}
