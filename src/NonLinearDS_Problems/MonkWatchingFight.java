package NonLinearDS_Problems;
import Trees.BinaryTree;
import java.util.Scanner;

/**
 * Contest Problem: https://www.hackerearth.com/practice/data-structures/trees/binary-search-tree/practice-problems/algorithm/monk-watching-fight
 * @author Brian Esteban Barreto Cardozo
 */
public class MonkWatchingFight 
{ 
    /**
     * Prueba de la altura de un árbol binario
     * @param args 
     */
    public static void main(String[] args) 
    {
        BinaryTree abb = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        
        int nodes = sc.nextInt();  //lectura del número de nodos
        int n;
        
        for (int i = 0; i < nodes; i++) 
        {
            n = sc.nextInt();
            abb.insert(n);          //inserción de los nodos en el árbol de búsqueda binaria
        }
        
        System.out.println(abb.height(abb.root)); //se llama al método que determina la altura
    }
}

/*
Entradas:
4
2 1 3 4
Respuesta:
3
*/