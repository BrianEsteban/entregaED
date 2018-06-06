package LinearDS_Problems;

import java.io.*;
import java.util.Scanner;

/*
# Contest Problem: MonkAndPrisonerOfAzkaban
# https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/monk-and-prisoner-of-azkaban/
*/

/**
 * El prisionero de Askaban nos propone un problema en el que se utilizan arreglos, se debe hallar un arreglo en donde se registren
 * los datos suministrados, otros dos en los que se registren los "x" y "y" que se hallen, y por ultimo crear el arreglo que guarde
 * la suma de los dos arreglos anteriores.
 * @author Brian Esteban Barreto Cardozo
 */
public class Askaban
{
    /**
     * Con el primer ciclo for se llena el arreglo con los datos de entrada y se define con tamaño n(también dato de entrada), el arreglo
     * llamado x[] entra a dos ciclos, el primero itera n-1 veces, ya que inicia en 1, en el segundo ciclo(while) compara una posicion con las 
     * que las que le anteceden preguntando si som mayores, con la primera que encuentre rompe, si no encuentra toma el valor -1, de manera
     * similar se llena el areglo y[], por último se imprime el arreglo con la suma de x[] y y[] posicion por posicion.
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int A[] = new int[n+2];
        int x[] = new int[n+2];
        int y[] = new int[n+2];
        int add[] = new int[n+2];
        int data = 0;
        
        //se llena el arreglo A[]
        for (int i = 1; i <= n; i++) 
        {
            data = sc.nextInt();
            A[0] = 0;
            A[i] = data;
        }
        //se llena el arreglo x[] con la idea de ir preguntando desde la posicion 1 a las posiciones que anteceden si son mayores
        for (int i = 1; i <= n; i++) 
        {
            int j = i;
            while(j>0)
            {
                if (A[j-1] > A[i]) 
                {
                    x[i] = j-1;
                    break;
                }   
                else{
                    x[i]=-1;
                }
                j--;
            }
        }
        //se llena el arreglo y[] con la idea de ir preguntando desde la posicion 1 a las posiciones que le siguen si son mayores
        for (int i = 1; i<=n; i++) 
        {
            for(int j = i; j<=n; j++)
            {
                if (A[i] < A[j+1]) 
                {
                    y[i] = j+1;
                    break;
                }   
                else{
                    y[i]=-1;
                }
            }
        }
        
        //Se suman posicion a posicion los arreglos
        for (int i = 1; i <= n; i++) {
            add[i] = x[i]+y[i];
        }
        
        //Se imprime el arreglo de la suma
        for (int i = 1; i <= n; i++) {
            System.out.print(add[i] + " ");
        }
    }
}

/*
//Entradas:
5
5 4 1 3 2
//Respuesta: -2 0 6 1 3
*/