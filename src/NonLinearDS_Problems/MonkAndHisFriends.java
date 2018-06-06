package NonLinearDS_Problems;

import Trees.BinaryTree;
import java.io.*;

/**
 * //https://www.hackerearth.com/practice/data-structures/trees/binary-search-tree/practice-problems/algorithm/monk-and-his-friends/
 * @author Brian Esteban Barreto Cardozo
 */
public class MonkAndHisFriends 
{
    /**
     * Prueba del ejercicio, en donde Monk llama a lista a sus estudiantes representados por el número entero de caramelos que tienen.
     * @param args 
     */
    public static void main(String[] args) throws IOException 
    {
        BinaryTree abb = new BinaryTree();  //se utilizan métodos de Binary Tree para insertar los estudiantes y luego realizar la búsqueda
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cases = br.readLine();           //lectura del número de casos
        
        for (int i = 0; i < Integer.parseInt(cases); i++) 
        {
            String input = br.readLine();
            String[] data = input.split(" ");
            int N = Integer.parseInt(data[0]);
            int M = Integer.parseInt(data[1]);
            abb.insert(N);                      //al inicio hay sólo dos estudiantes
            abb.insert(M);                      
            for (int j = 0; j < (N+M); j++)     //el número de estudiantes es N + M 
            {
                String student = br.readLine();
                if (j > 1) 
                {
                    bw.write(abb.existStudent(Integer.parseInt(student)) + "\n");
                    bw.flush();
                }
            }
        }
    }
}

/*
Entradas:
1
2 3
3 
2 
9 
11 
2
Respuesta:
NO
NO
SI
*/
