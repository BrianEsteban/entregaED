package Trees;

//import LinearDataStructures.Node;
//import LinearDataStructures.Stack;

/**
 * Implementación y uso de los árboles binarios.
 * @author Brian Esteban Barreto Cardozo
 */
public class BinaryTree 
{    
    Node right = null;  //apuntador derecho en nulo
    Node left = null;   //apuntador izquierdo en nulo
    
    public Node root;
          
    /**
     * Constructor que inicializa la raiz
     */
    public void BinaryTree()
    {
        Node root = new Node();
    }
    
    /**
     * Verifica si el arbol tiene elementos o si está vacío
     * @return true si está vacío.
     */
    public boolean isEmpty()
    {
        return (root == null);
    }
    
    /**
     * Inserta un nodo en el árbol
     * @param value 
     */
    public void insert(int value)   //el parámetro es el valor entero que tomará en nodo apenas entre a la función
    {
        Node node = new Node(value);    
        
        if (root == null)   //si es el primer nodo para insertar oficiará como raiz
            root = node;
        else
        {
            Node temp = root;   //temporal es replica de la raiz
            Node parent = null;
            boolean left = false;
            while(temp != null)  //siempre y cuando temporal no sea nulo recorre
            {
                parent = temp;
                if (value < temp.value) //si el valor es menor al que se compara pasa a estar a la izquierda 
                {
                    temp = temp.left;
                    left = true;        //la bandera cambia su estado cuando se va por la izquierda
                }
                else                    //si el valor es mayor al que se compara pasa a estar a la derecha
                {
                    temp = temp.right;
                    left = false;
                }
            }
            temp = node;
            if (left) 
                parent.left = temp; //si la bandera está en verdadero enlaza a parent por medio del apuntador left con temporal(que al salir del ciclo tomó el valor del nodo a insertar)
            else
                parent.right = temp; //si la bandera está en falso enlaza a parent por medio del apuntador right con temporal(que al salir del ciclo tomó el valor del nodo a insertar)
        }   
    }
    
    /**
     * Inorder tiene la forma IND, de manera recursiva se imprime en este orden siempre y cuando parent tenga un valor.
     * @param parent 
     */
    public void print_inorder(Node parent)
    {
        if (parent != null) 
        {
            print_inorder(parent.left);
            System.out.print(parent);
            print_inorder(parent.right);
        }    
    }
    
    /**
     * Postorder tiene la forma IDN, de manera recursiva se imprime en este orden siempre y cuando parent tenga un valor.
     * @param parent 
     */
    public void print_postorder(Node parent)
    {
        if (parent != null) 
        {
            print_postorder(parent.left);
            print_postorder(parent.right);
            System.out.print(parent);
        }    
    }
    
    /**
     * Postorder que imprime el substring utilizado en el método para obtener el postorder por medio del inorder y el preorder.
     * @param parent 
     */
    public void print_postorder2(Node parent)
    {
        if (parent != null) 
        {
            print_postorder2(parent.left);
            print_postorder2(parent.right);
            System.out.print(parent.sub_string);
        }    
    }

    /**
     * Preorder tiene la forma NID, de manera recursiva se imprime en este orden siempre y cuando parent tenga un valor.
     * @param parent 
     */
    public void print_preorder(Node parent)
    {
        if (parent != null) 
        {
            System.out.print(parent);
            print_preorder(parent.left);
            print_preorder(parent.right);
        }    
    }
    
    /**
     * Preorder que imprime el substring utilizado en el método para obtener el preorder por medio del inorder y el postorder.
     * @param parent 
     */
    public void print_preorder2(Node parent)
    {
        if (parent != null) 
        {
            System.out.print(parent.sub_string);
            print_preorder2(parent.left);
            print_preorder2(parent.right);
        }    
    }
    
    /**
     * El operador ternario pregunta por los hijos de un nodo, si el hijo izquierdo existe igual que el derecho devuleve un 2,
     * si sólo existe el de la derecha o el de la izquierda retorna un 1, y si los dos son nulos retorna 0.
     * @param node
     * @return el número de hijos de node.
     */
    public int offspring(Node node)
    {
        return (node.left != null) ? (node.right != null ? 2 : 1) : (node.right != null ? 1 : 0);
    }
    
    /**
     * Elimina un nodo del árbol
     * @param value 
     */
    public void delete(int value)
    {
        Node temp = root;
        Node parent = root;
        boolean left = false;
                
        while(temp != null) //mientras temporal sea distinto a nulo y no encuentre el valor a eliminar sigue recorriendo el árbol
        {
            if (temp.value == value) //cuando encuentra el valor sale del ciclo
                break;
            else
            {
                parent = temp;
                if (value < temp.value) //si el valor es menor al que se compara entonces el nodo estará a la izquierda 
                {
                   temp = temp.left; 
                   left = true;         //la bandera cambia su estado cuando se va por la izquierda
                }
                else                    //si el valor es mayor al que se compara entonces el nodo estará a la derecha
                {
                   temp = temp.right;
                   left = false;
                }
            }
        }

        if (temp != null) //temp es el nodo a eliminar
        {
            int counter = this.offspring(temp); //se consideran tres casos: que temporal no tenga hijos, que tenga uno o que tenga los dos
            if (counter == 0)  //en caso de que no tenga hijos desenlaza al nodo
            {
                if (left)   //verificamos si es la hoja izquierda o la derecha la que toca desenlazar con la bandera left
                    parent.left = null; 
                else
                    parent.right = null;
            }else
            {
                if (counter == 1) //en caso de tener un hijo se averigua si está a la derecha o a la izquierda para después enlazarlo por medio del apuntador right o left, respectivamente, a parent.
                {
                    if (temp.left != null) 
                    {
                        if (left) 
                            parent.left = temp.left;
                        else
                            parent.right = temp.right;
                    }
                    else
                    {
                        if (left) 
                           parent.left = temp.left;    
                        else
                           parent.right = temp.right;
                    }
                }
                else    //en caso de que tenga los dos hijos se modifica la estructura
                {                                       
                    Node less = temp.right;  //menor de los mayores desde el nodo a eliminar, en el peor de los casos tomará este
                    Node less_parent = less;

                    while(less.left != null) //si por izquierda no es nulo sigue recorriendo hacia ese costado
                    {
                        less_parent = less;
                        less = less.left;
                    }
                    if (!less_parent.equals(less)) 
                    {
                        if (less.right != null) 
                            less_parent.left = less.right;

                        less.right = temp.right;
                    }
                    less.left = temp.left;

                    if (left) 
                        parent.left = less;
                    else
                        parent.right = less;    
                }     
            }
        }
    }
    
    /**
     * Recorre el arbol preguntando si existe un valor especifico insertado.
     * @param data
     * @return un valor booleano, si existe el valor entonces true y si no false.
     */
    public boolean exist(int data) 
    {
        Node temp = root;
        boolean left = false;
        while (temp != null)    
        {
            if (data == temp.value) //si encuentra un nodo con un valor almacenado igual al buscado retorna verdadero
                return true;
            else
                if (data > temp.value)
                {
                    temp = temp.right;
                    left = false;
                }
                else
                {
                    temp = temp.left;
                    left = false;
                }
                    
        }
        return left;
      }
    
    /**
     * Recorre el arbol preguntando si hay un estudiante en el salón de clase. Método usado en MonkAndHisFriends 
     * @param student
     * @return un valor booleano, si existe el valor entonces true y si no false.
     */
    public String existStudent(int student) 
    {
        Node temp = root;
        String search = "";
        while (temp != null)    
        {
            if (student == temp.value) //si encuentra un nodo con un valor almacenado igual al buscado retorna verdadero
                return "SI";
            else
                if (student > temp.value)
                {
                    temp = temp.right;
                    search = "NO";
                }
                else
                {
                    temp = temp.left;
                    search = "NO";
                }
                    
        }
        return search;
     }
    
    /**
     * Metodo recursivo para obtener la altura del árbol binario
     * @param temp
     * @return 
     */
    public int height(Node temp)
    {
        if (temp == null) 
            return 0;
        else
        {
            int heigthLeft = height(temp.left) ;  //altura del nodo por izquierda hasta que no tenga hijos y empiece la recurisividad
            int heigthRight = height(temp.right);//altura del nodo por derecha hasta que no tenga hijos y empiece la recurisividad
            int greatestHeight = Math.max(heigthLeft, heigthRight); //elige la altura máxima entre los sub-árboles
            return greatestHeight + 1;
        }   
    }
    
    /**
     * Busca un nodo en el árbol con cierto valor
     * @param value
     * @return el nodo que contiene al valor buscado
     */
    public Node search(int value)
    {
        if(exist(value))    //primero verifica que el valor exista en el árbol
        {    
            Node temp = root;
            Node parent = root;
            boolean left = false;

            while(temp != null) //mientras temporal sea distinto a nulo y no encuentre el valor buscado sigue recorriendo el árbol
            {
                if (temp.value == value) 
                    break;
                else
                    parent = temp;

                    if (value < temp.value) 
                    {
                       temp = temp.left; 
                       left = true;         //si se va por la izquierda la bander cambia su estado a verdadero
                    }
                    else
                    {
                       temp = temp.right;
                       left = false;
                    }
            }
            return temp;
        }   
        else 
            return null;
    }
    
    /**
     * Teniendo el inorder y el preorder de un árbol se imprime el postorder. 
     * @param inorder
     * @param preorder
     * @return postorder
     */
    public String inorder_preorder(String inorder, String preorder)
    {
        BinaryTree recovery = new BinaryTree();
        recovery = recovery_subtree(inorder, preorder);
        recovery.print_postorder2(recovery.root);
        return "";
    }
    
    /**
     * Teniendo el inorder y el preorder de un árbol se imprime el postorder. 
     * @param sub_inorder
     * @param preorder
     * @return postorder
     */
    public BinaryTree recovery_subtree(String sub_inorder, String preorder)
    {
        System.out.println(sub_inorder); //se imprime el String que llegue como parámetro del método inorder_preorder(st, st) que nos muestra la divisíón de la cadena inorder
        
        if (sub_inorder.length() == 0)  //si el tamaño de la cadena llega a ser cero retorna un nuevo árbol
            return new BinaryTree();    
        else
        {
            BinaryTree temp = new BinaryTree();
            if (sub_inorder.length() == 1)  //si la dimensión de la cadena es igual a 1, se estaría diciendo que el caracter oficiaria como la raíz
                temp.root = new Node(sub_inorder);
            else
            {
                int[] indexes = new int[sub_inorder.length()];  //creación del arreglo con la dimensión de inorder
                
                for (int i = 0; i < sub_inorder.length(); i++) 
                    indexes[i] = preorder.indexOf( sub_inorder.substring(i, i+1) ); //se halla el índice de cada elemento de preorder en base a inorder
                
                int less = Integer.MAX_VALUE, index = -1;
                for (int i = 0; i < indexes.length; i++) 
                {
                    if (indexes[i] < less) 
                    {
                        index = i;
                        less = indexes[i];
                    }
                }
                temp.root = new Node( sub_inorder.substring(index, index + 1) );                         //Guarda en el nodo raiz el indice menor
                temp.root.left = recovery_subtree(sub_inorder.substring(0, index), preorder).root;       //sub arbol izquierdo entra a la recursividad
                temp.root.right = recovery_subtree(sub_inorder.substring(index + 1), preorder).root;     //sub arbol derecho entra a la recursividad
            }
        return temp;
        }
    }
    
    /**
     * Teniendo el inorder y el preorder de un árbol imprimir el postorder. 
     * @param inorder
     * @param postorder
     * @return 
     */
    public String inorder_postorder(String inorder, String postorder)
    {
        BinaryTree recovery = new BinaryTree();
        recovery = recovery_subtree2(inorder, postorder);
        recovery.print_postorder2(recovery.root);
        return "";
    }
    
    /**
     * De la misma manera que recovery_subtree(St,St) solamente que ya no va preorder sino inorder.
     * @param sub_inorder
     * @param postorder
     * @return 
     */
    public BinaryTree recovery_subtree2(String sub_inorder, String postorder)
    {
        System.out.println(sub_inorder);
        
        if (sub_inorder.length() == 0)
            return new BinaryTree();
        else
        {
            BinaryTree temp = new BinaryTree();
            if (sub_inorder.length() == 1)
                temp.root = new Node(sub_inorder);
            else
            {
                int[] indexes = new int[sub_inorder.length()];
                
                for (int i = 0; i < sub_inorder.length(); i++) 
                    indexes[i] = postorder.indexOf( sub_inorder.substring(i, i+1) ); //se halla el índice de cada elemento de preorder en base a inorder
                
                int great = Integer.MIN_VALUE, index = -1;  //great toma el valor menor de los enteros
                for (int i = 0; i < indexes.length; i++) 
                {
                    if (indexes[i] > great)  //se requieren los mayores
                    {
                        index = i;
                        great = indexes[i];
                    }
                }
                temp.root = new Node( sub_inorder.substring(index, index + 1) );                         //Guarda en el nodo raiz el indice menor
                temp.root.left = recovery_subtree(sub_inorder.substring(0, index), postorder).root;       //sub arbol izquierdo entra a la recursividad
                temp.root.right = recovery_subtree(sub_inorder.substring(index + 1), postorder).root;     //sub arbol derecho entra a la recursividad
            }
        return temp;
        }
    }
    
    /**
     * Nodo con el menor valor
     * @return el mínimo valor insertado en el árbol.
     */
    public int minValue()
    {
        Node temp = root;
        while( temp.left != null )  //siempre y cuando exista un nodo a la izquierda toma ese valor hasta que un nodo deje de tener hijos hacia ese costado.
        {
            temp = temp.left;
        }
        return temp.value;
    }
    
    /**
     * Nodo con el valor mayor
     * @return el máximo valor insertado en el árbol.
     */
    public int maxValue()
    {
        Node temp = root;
        while( temp.right != null ) //siempre y cuando exista un nodo a la derecha toma ese valor hasta que un nodo deje de tener hijos hacia ese costado.
        {
            temp = temp.right;
        }
        return temp.value; 
    }
    
    /*
    public void BFS() 
    { 
        Stack s = new Stack(); 
        
        s.push(this.root); 
        root.PROP; 
        printNode(root); 
        while(!s.isEmpty()) 
        { 
            Node n = (Node)s.peek(); 
            Node child=getUnvisitedChildNode(n); 
            if(child!=null) 
            { 
                child.visited=true; 
                printNode(child); 
                s.push(child); 
            } 
            else 
            { 
                s.pop(); 
            } 
        } 
        clearNodes(); 
    }
    */
    /**
     * Prueba de los métodos creados.
     * @param args 
     */
    public static void main(String[] args) 
    {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(52);
        binaryTree.insert(74);
        binaryTree.insert(60);
        binaryTree.insert(87);
        binaryTree.insert(83);
        binaryTree.insert(100);
        binaryTree.insert(85);
        System.out.println(binaryTree.maxValue());
        System.out.println(binaryTree.minValue());
        System.out.println(" Inorder:");
        binaryTree.print_inorder(binaryTree.root);
        System.out.println("\n Postorder:");
        binaryTree.print_postorder(binaryTree.root);
        System.out.println("\n Preorder:");
        binaryTree.print_preorder(binaryTree.root);
        System.out.println("\n Eliminar el 87");
        binaryTree.delete(87);
        System.out.println(" Inorder:");
        binaryTree.print_inorder(binaryTree.root);
        System.out.println("Postorder teniendo inorder y preorder:");
        System.out.println(binaryTree.inorder_preorder("ABCDEFG","DBACEGF"));
        System.out.println("Preorder teniendo inorder y postorder:");
        System.out.println(binaryTree.inorder_postorder("ABCDEFG", "ACBFGED"));
    }
}
