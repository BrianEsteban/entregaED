package NonLinearDS_Problems;

import java.io.*;
import java.util.Scanner;

/**
 * Contest Problem: //https://www.urionlinejudge.com.br/judge/en/problems/view/2688
 * @author Brian Esteban Barreto Cardozo
 */
public class ChoosingAPlace 
{
    /**
     * Prueba del ejercicio de la cafetería
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        
        int height = 3;
        int width = 3;
        int matriz [][] = new int[width][height];
        int WBJ = sc.nextInt();

        for (int i = 0; i < height; i++)
        {
            String input = br.readLine();
            String[] data = input.split(" ");

            for (int j = 0; j < width; j++) 
                matriz[i][j] = Integer.parseInt(data[j]);
        }
        
        for (int i = 0; i < height; i++)
        { 
            System.out.println("");
            for (int j = 0; j < width; j++) 
                if (matriz[i][j] == 00)
                {
                    if ((matriz[i-1][j-1]+matriz[i-1][j])/2 < WBJ ) 
                        System.out.println(i + "" + j);
                    
                }
        }
    }
}
