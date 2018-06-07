package Laberinto;

/* Ejemplo de ingreso
//altura y ancho
8 8


.......I
.|||||F|
.|......
.|......
.|||.|.|
.|...|.|
.|.|||.|
........

*/

import java.util.*;

/**
 * Implementación de la lógica de la app del laberinto
 * @author Brian Esteban Barreto Cardozo
 */
public class Laberinto 
{	
    static int labMax = 100;	//máximo número de filas y columnas del laberinto
    static char ady[][] = new char[labMax][labMax];	//laberinto

    public static class Node
    {
        int x, y, d;

        /**
         * Costructor que inicializa fila, columna y distancia
         * @param x
         * @param y
         * @param d 
         */
        public Node(int x, int y , int d)
        {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static int BFS(int x, int y, int height, int weight)
    { 	
            boolean visited[][] = new boolean[labMax][labMax];   //arreglo de estados visitados
            
            Queue<Node> queue = new LinkedList<>(); //lista implemetada como fila para guardar el booleano de cada posición
            queue.add(new Node(x, y, 0));   //Se inserta el primer nodo

            int[] dx = {0,0,1,-1};   //se aumenta x y y
            int[] dy = {1,-1,0,0};  
            int nx , ny;

            while(!queue.isEmpty())   //recorre la cola
            {  
                Node current = queue.remove();  //el primer dato insertado es el primero en salir, entonces si se elimina un elemento de la cola se puede analizar cada caracter en orden de llegada
                
                if( ady[current.x][current.y] == 'F')    //si la posición de la matriz contiene 'F' se retorna la distancia. 'F' es el destino
                    return current.d;    

                visited[current.x][current.y] = true;    //Marco como visitado dicho estado para no volver a recorrerlo

                for(int i = 0; i < 4; i++)  //itera de acuerdoo si tiene arriba, abajo, derecha o izquierda
                {	
                    nx = dx[i] + current.x;    //visita las posiciones de los costados
                    ny = dy[i] + current.y;    

                    if(nx >= 0 && nx < height && ny >= 0 && ny < weight && !visited[nx][ny] && ady[nx][ny] != '|') //si llegar a ser una pared el del costado o fuera de rango lo invalida
                        queue.add( new Node(nx ,ny ,current.d + 1)); 
                }
            }
            return -1;
    }

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) 
    {
        int height, weight, x = 0, y = 0;
        Scanner sc = new Scanner( System.in );
        height = sc.nextInt();
        weight = sc.nextInt();
        System.out.println("Ingrese el laberinto, con un solo valor inicial I, valor final sera S: ");
        String line = sc.nextLine();			//funciona igual que getline o gets de c++

        for (int i = 0; i < height; i++) 
        {
                line = sc.nextLine();

                for(int j = 0; j < weight; j++)
                {
                    ady[i][j] = line.charAt(j);

                    if(ady[i][j] == 'I')		 //obtengo coordenada de valor inicial
                        x = i; y = j;
                }
        }
        int pathMin = BFS(x, y, height, weight);

        if( pathMin == -1 ) 
            System.out.println("Imposible");
        else 
            System.out.println( "Camino más corto: " + pathMin );	
    }
}
