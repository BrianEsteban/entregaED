package ProgrammingBasics;

import java.io.*;

/**
 * Operaciones con métodos recursivos. Todos los ejemplos a continuación implementan funciones recursivas.
 * @author Brian Esteban Barreto Cardozo
 */
public class Recurrences 
{
    /**
     * Teniendo a x como parámetro entero, retorna el factorial de ese número.
     * @param x
     * @return el factorial de x
     */
    public int factorial(int x)
    {
        if(x==1 || x==0)                //paso base, si x llega a ser 0 o 1 empieza a devolverse en el proceso
            return 1;
        else
            return x * factorial(x-1);  //multipliza el número por el factorial del anterior.
    }
    
    /**
     * Método con el que se obtiene el numero final de la serie fibonacci del número dado. Si se toma el cero, su serie fibonacci
     * es cero, si es uno su serie fibonacci es uno, si es dos el ultimo dígito de su serie fibonacci es tambien uno.
     * @param n
     * @return el último número de la serie fibonacci de n
     */
    public int fibonacci(int n)
    {
        if(n==0)
            return 0;
        else if (n==1) 
            return 1;
        else
            return fibonacci(n-1) + fibonacci(n-2);     //Suma de los dos números anteriores de la serie
    }
    
    /**
     * La operación que se realiza es sumar 'a' tantas veces como diga 'b', manera como también se interpreta una multiplicación.
     * @param a
     * @param b
     * @return la multiplicacion entre a y b
     */
    public int multiplicar(int a, int b)
    {
        if (a < 0)                      //si a llegara a ser negativo la recursión tendría que contemplar a los dos paràmetros negativos dentro de la recursión.
            return multiplicar(-a, -b);     
        else if (a == 0)                //llegará el momento en que 'a' llegue a 0, y empezará el proceso de regreso sumando los términos tanta veces como se diga.
            return 0;
        else 
            return multiplicar(a-1, b) + b;
    }
    
    /**
     * Realiza el proceso lógico del triángulo de pascal retornando un número según su n(filas) y k(columnas).
     * @param n
     * @param k
     * @return el numero correspondiente siguiendo las instrucciones del triangulo de pascal
     */
    public static int pascal(int n, int k)
    {
        if (k==0 || k==n)  //si k=0 retorna 1 por ser la primera columna o si n=k por tratarse de la diagonal principal... 
            return 1;
        else
            return pascal(n-1, k-1) + pascal(n-1, k); //En otro caso hace la recursión
    }
    
    /**
     * usando el método pascal se obtiene el triángulo con 10 filas y 10 columnas porque así es definido en los ciclos de i y j.
     * @return el triángulo de pascal (10 filas, 10 columnas)
     */
    public String print_pascal()
    {
        String pascal_matrix = "";      //Declaración de la variable como String, útil porque el método retornará líneas separadas por tab.
            for(int i = 0; i < 10; i++)
            {
                for(int j = 0; j <= i; j++)
                    pascal_matrix += pascal(i, j) + "\t";   //uso del método pascal para 10 filas y 10 columnas 
                    pascal_matrix += "\n";
            }	
        return pascal_matrix;
    }
        
    
    /**
     * Máximo común divisor usando el algoritmo de euclides, teniendo dos numeros, 'a' mayor que 'b', se efectúa la división, si su residuo
     * no es cero, se efectúa una nueva division ahora tomando a 'b' como divisor y al residuo de la división anterior como dividendo,
     * esto se repite hasta que el residuo de cero.
     * @param a
     * @param b
     * @return el dividendo de la ultima division que debera tener residuo cero
     */
    public int mcd_euclides(int a, int b)
    {
        if(a%b == 0)    //uso del modulo entre a y b para verificar el residuo.
            return b;
        else
            return mcd_euclides(b, a%b);
    }
    
    /**
     * Recibe una cadena de caracteres los cuales va a retornar de manera inversa.
     * @param cadena
     * @return 
     */
    public String inversa_cadena(String cadena)
    {
        if(cadena.length() == 1)    //la recursión tiene su fin en el momento en que la cadena contenga sólo un caracter.
            return cadena;
        else
            return cadena.substring(cadena.length() - 1) + inversa_cadena(cadena.substring(0, cadena.length() - 1));    
            //Toma el último caracter y lo concatena con con la recursión que se realiza con la sub-cadena desde el inicio hasta el penultimo caracter
    }
    
    /**
     * Verifica si una cadena es palindrome o no. Es palindrome cuando se obtiene la misma cadena aun cuando se invierta.
     * @param cadena
     * @return true si la cadena es palíndrome, false de lo contrario.
     */
    public boolean isPalindrome(String cadena)
    {
        return cadena.equals( inversa_cadena(cadena) ) ? true : false;
        //realiza la verificación utilizando el método que invierte la cadena y corroborando su igualdad con el método equals usado en Strings
    }

    /**
     * Prueba de cada una de las funciones con el buffer y teniendo en cuenta que no son métodos estáticos se llaman por medio del objeto 'recurrencias'.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out ));   //Cración del buffer de salida
	Recurrences recurrencias = new Recurrences();   //Creación del objeto
        
        try     
        {
            bw.write(recurrencias.factorial(15) + "\n");    // output: 2004310016
            bw.write(recurrencias.fibonacci(25) + "\n");    // output: 75025
            bw.write(recurrencias.multiplicar(654, 97) + "\n"); // output: 63438
            bw.write(recurrencias.mcd_euclides(369, 1218) + "\n");  // output: 3
            bw.write(recurrencias.inversa_cadena("asdfghjkl") + "\n"); // output: lkjhgfdsa
            bw.write(recurrencias.print_pascal() + "\n");
            /*
             * 1	
             * 1	1	
             * 1	2	1	
             * 1	3	3	1	
             * 1	4	6	4	1	
             * 1	5	10	10	5	1	
             * 1	6	15	20	15	6	1	
             * 1	7	21	35	35	21	7	1	
             * 1	8	28	56	70	56	28	8	1	
             * 1	9	36	84	126	126	84	36	9	1
             */
                                
            bw.flush();
            bw.close();    
        }
        catch(Exception e)
        {
            e.printStackTrace();    //Atrapa inconsistencias que puedan presentarse en el buffer.
        }
    }
    
}
