package Trees;

/**
 * Implementación de árboles AVL
 * @author Brian Esteban Barreto Cardozo
 */
public class TreeAVL 
{
    public Node root;   //nodo raíz
    
    Node left = null;
    Node right = null;
    Node parent = null;
 
    public class Node 
    {
        int value;      //valor dentro del nodo
        int height;     //atura del árbol

        Node left;      //apuntador izquierdo
        Node right;     //apuntadore derecho    
        Node parent;    //nodo padre

        public Node() {}

        /**
         * Constructor con atributo entero
         * @param value 
         */
        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + " ";
        } 
    }
         
    public void TreeAVL()
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
        balancear();
    }

    /**
     * El operador ternario pregunta por los hijos de un nodo, si el hijo izquierdo existe igual que el derecho devuleve un 2,
     * si sólo existe el de la derecha o el de la izquierda retorna un 1, y si los dos son nulos retorna 0.
     * @param node
     * @return el numero de hijos de node.
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
        balancear();
    }
    
    /**
     * Función que obtiene la áltura del árbol con el llamado al auxiliar.
     * @return altura del árbol
     */
    public int heightTree() 
    {
        return aux_heightTree(root);    //se le pasa como parámetro a la raíz
    }
    
    /**
     * Auxiliar que retorna la altura del nodo que se le pase como parámetro
     * @param raiz
     * @return 
     */
    int aux_heightTree(Node raiz) 
    {
        return raiz == null ? -1 : raiz.height;
    }
    
    /**
     * Estructura el árbol para que quede lo más simétrico posible
     * @return 
     */
    public Node balancear() 
    {
        Node temp = root;
        int heightL = aux_heightTree(temp.left);    //indaga por la altura del sub-árbol izquierdo
        int heightR = aux_heightTree(temp.right);   //indaga por la altura del sub-árbol derecho
        temp.height = Math.max(heightL, heightR)+1;

        //si ya está balanceado no ingresa a ningún condicional
        if (heightL-heightR == 2)       //si el sub-árbol derecho tiene menos altura que el sub-árbol izquierdo
        {
            if (aux_heightTree(temp.left.left) < aux_heightTree(temp.left.right))   
                temp.left = leftRotate(temp.left);      

            temp = rightRotate(temp);   //aplica la rotación derecha
        }
        else if (heightL-heightR == -2) {   //si el sub-árbol izquierdo tiene menos altura que el sub-árbol derecho
            if (aux_heightTree(temp.right.right) < aux_heightTree(temp.right.left))
                temp.right = rightRotate(temp.right);   

            temp = leftRotate(temp);    //aplica la rotación izquierda
        }
        return temp;
    }
    
    /**
     * Rotación hacia la izquierda que balancea el árbol.
     * @param r
     * @return 
     */
    Node rightRotate(Node r) 
    {
        Node aux = r.left;          //rota el árbol hacia el sentido del sub-arbol derecho
        aux.parent = r.parent;
        r.left = aux.right;
        aux.right = r;
        r.parent = aux;

        if (r.left != null)
            r.left.parent = r;

        actualizarNodes(r, aux);    //actualiza al nodo que realizó cambio
        return aux;
    }
     
    /**
     * Rotación hacia la derecha que balancea el árbol, análogo a la rotación hacia la izquierda.
     * @param r
     * @return 
     */
    Node leftRotate(Node r) 
    {
        Node aux = r.right;        //rota el árbol hacia el sentido del sub-arbol izquierdo
        aux.parent = r.parent;
        r.right = aux.left;
        aux.left = r;
        r.parent = aux;

        if (r.right != null)
           r.right.parent = r;

        actualizarNodes(r, aux);    //actualiza al nodo que realizó cambio
        return aux;
    }
    
    /**
     * Cada que se hagan cambios de estructura actualiza los enlaces nodo padre y actualiza la altura.
     * @param raiz
     * @param aux 
     */
    void actualizarNodes(Node raiz, Node aux) 
    {
        if (aux.parent != null)     //mientras el nodo padre exista
        {
            if (aux.parent.right == raiz)   //analiza el caso del nodo auxiliar para enlazarlo a la derecha o a la izquierda
                aux.parent.right = aux;
            else
                aux.parent.left = aux;
        }
        raiz.height = Math.max(aux_heightTree(raiz.left), aux_heightTree(raiz.right))+1;    //cambia la altura del aárbol
        aux.height = Math.max(aux_heightTree(aux.left), aux_heightTree(aux.right))+1; 
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
     * Prueba de los métodos creados.
     * @param args 
     */
    public static void main(String[] args) 
    {
        TreeAVL avl = new TreeAVL();
        avl.insert(52);
        avl.insert(74);
        avl.insert(60);
        avl.insert(87);
        avl.insert(83);
        avl.insert(100);
        avl.insert(85);
        avl.print_inorder(avl.root);

    }
}
