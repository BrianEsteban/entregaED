package NonLinearDS_Problems;

import java.io.*;
import java.util.*;

/**
 * Contest Problem: AllDiscsConsidered  
 * //https://www.urionlinejudge.com.br/judge/en/problems/view/1669
 * @author Brian Esteban Barreto Cardozo
 */

public class AllDiscsConsidered  
{
    /**
     * Prueba del ejercicio All discs considered
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException 
    {
        for (;;){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            String[] data = input.split(" ");
            int first = Integer.parseInt(data[0]);  //lectura del la cantidad de paquetes del DVD 1 (orden ascendente: 1, 2, ..., first)
            int second = Integer.parseInt(data[1]); //lectura del último término del DVD 2
            int dependence = Integer.parseInt(data[2]); //lectura del número de dedependent

            if (first == 0 && second == 0 && dependence == 0)   //acaba la ejecución
                break;
        
            Map<Integer, Set<Integer>> dependentes = new HashMap<>();   //Dedependent entre los DVD's
            
            for (int i = 1; i <= first + second; i++)       //itera en igual número como paquetes haya 
                dependentes.put(i, new HashSet<Integer>()); //inserta a la colección
            
            for (int i = 0; i < dependence; i++)    
            {
                input = br.readLine();
                data = input.split(" ");
                dependentes.get(Integer.parseInt(data[1])).add(Integer.parseInt(data[0]));  //captura el tipo de dependencia
            }

            int min = Integer.MAX_VALUE;    //valor máximo de los enteros
            
            for (int i = 1; i < 3; i++)     //itera las dos veces
            {
                int DVD = i;
                int sol = 0;

                Map<Integer, Integer> dependent = new HashMap<>();  //Creación de la colección para guardar los dependientes
                for (int j = 1; j <= (first + second); j++)           //itera en igual número como paquetes haya 
                    dependent.put(j, 0);
                
                for (Set<Integer> deps : dependentes.values())
                    for (Integer dep : deps)
                        dependent.put(dep, dependent.get(dep) + 1);     //se le suma 1 para colocarlo en la siguiente

                TreeSet<Integer> col = new TreeSet<>();

                for (Map.Entry<Integer, Integer> pend : dependent.entrySet())   //adiciona los casos posible a la colección 
                    if (pend.getValue().equals(0))
                        col.add(pend.getKey());
                
                while ( !col.isEmpty() )    //la colección debe tener elemetos
                {
                    int prox = DVD == 1 ? col.pollFirst() : col.pollLast(); //si es el dvd 1 inserta al comienzo, y si es el segundo, lo coloca al final
                    
                    if ((DVD == 1 && prox > first) || (DVD == 2 && prox <= first))  
                    {
                        sol++;
                        DVD = DVD == 1 ? 2 : 1;     //mantiene el ciclo
                    }
                    for (Integer dependente : dependentes.get(prox))    //Itera tantas veces como prox
                    {
                        dependent.put(dependente, dependent.get(dependente) - 1);
                        if (dependent.get(dependente).equals(0))    //cuando lleguemos que no hay más dependencias podemos agregar a la colección
                            col.add(dependente);
                    }
                }
                min = Math.min(min, sol);   //minino de cambios necesarios
            }
            System.out.println(min + 2);
        }
    }
}

/*
Entradas:
3 2 1
1 2
2 2 2
1 3
4 2
2 1 1
1 3
0 0 0
Respuestas: 
3
4
3
*/
    

