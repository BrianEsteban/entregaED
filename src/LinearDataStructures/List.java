package LinearDataStructures;
import java.io.*;

/**
 * Lista enlazada e implementación de los métodos.
 * @author Brian Esteban Barreto Cardozo
 */
public class List 
{
    Node head = null;
    
    /**
     * Determina si la lista está vacia o no
     * @return verdadero si está vacía, falso si tiene al menos un elemento
     */
    public boolean isEmpty()
    {
        return head == null ? true : false;     //Verifica si existe el nodo de la cabeza
    }
    
    /**
     * Imprime la información (menos la entera) de todos los nodos de la lista.
     */
    public void printList()
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        Node temp = head;
        try
        {
            bw.write("Grades: \n");    
            while(temp != null)            //recorre cada nodo para su posteior impresión mientras el siguiente nodo sea distinto de nulo
            {
                bw.write(temp.toString()); //Imprime la información que se haya depositado en el nodo. Para ello se hace un llamado a toString
                temp = temp.next;          //Avanza al siguiente nodo
            }
            bw.flush();                    //Necesario para que funcione el buffer
        }
        catch(Exception e)
        {
            e.printStackTrace();            
        }
    }
    
    /**
     * Imprime la información entera de todos los nodos. Se utiliza para realizar pruebas con enteros.
     */
    public void printList2()
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
        try
        {
            while(temp != null)
            {
                bw.write(temp.toString2());     //toString2 tan solo imprime valores de tipo entero
                temp = temp.next;
            }
            bw.flush();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Cuenta los nodos en la lista.
     * @return los cantidad de nodos que tiene la lista.
     */
    public int size()
    {
        int count = 1;
        if (isEmpty())                  //verifica si está vacía
            return 0;
        else
        {
            Node temp = head;
            while(temp.next != null)    //recorre la lista 
            {
                count ++;               //mientras pase por un nuevo nodo el contador irá incrementando
                temp = temp.next;
            }
            return count;
        }
    }
    
    /**
     * Inserta un nuevo nodo al inicio de la lista 
     * @param newNode 
     */
    public void insertAtBegin(Node newNode)
    {
        newNode.next = head;    //apunta al nuevo nodo a la cabeza, que si no existe entonces será apuntado a null
        head = newNode;         //asigna como cabeza al nuevo nodo.
    }
    
    /**
     * Inserta un nuevo nodo al final de la lista
     * @param newNode 
     */
    public void insertAtEnd(Node newNode)
    {
        if (isEmpty())          //primero verifica si la lista está vacía
            head = newNode;     //si la condición fue verdadera designa como la cabeza al nuevo nodo que se va a añadir
        else
        {
            Node temp = head;           //Creación de un nodo temporal
            while(temp.next != null)    //si la lista tiene elementos deberá recorrerlos todos con el ciclo while
                temp = temp.next;       
                                       //en el momento en que el nodo temporal apunte a nulo saldrà del ciclo
            temp.next = newNode;       //el último nodo apunta al nuevo nodo
        }    
    }
    
    /**
     * Inserta un nuevo nodo en una posición específica
     * @param newNode
     * @param index posición en la lista en la que se quiere insertar el nuevo nodo
     */
    public void insertAt(Node newNode, int index)
    {
        if (index == 0) //si el índice es cero se inserta al inicio
        {
            newNode.next = head;    //apunta al nuevo nodo a la cabeza, que si no existe entonces será apuntado a null
            head = newNode;         //asigna como cabeza al nuevo nodo.
        }
        else
        {
            Node temp = head;

            for (int i = 0; i < index-1; i++)  //conociendo la posición en la que se quiere insertar el nodo, se itera n veces
                temp = temp.next;           //recorre la lista deteniendose en la posición n
            
            newNode.next = temp.next;   //se apunta el nuevo nodo a un elemento de la lista que quedo luego de la iteración
            temp.next = newNode;        //se apunta al elemento de la lista al nuevo nodo. Se sigue ese orden para evitar la pérdida de información.
        }
    }
        
    /**
     * Elimina el nodo del inicial.
     */
    public void deleteAtBegin() 
    {
        if (isEmpty())  //verifica si la lista está vacía 
            System.out.println("No hay nada que eliminar"); 
        else
        {
            Node temp = head;   //duplica al nodo que oficia como cabeza
            head = head.next;   //la nueva cabeza será al que estaba apuntando esta misma
            temp = null;        //desenlaza al nodo duplicado
            System.gc();        //elimina todo lo que este por ahí volando
        }
    }
    
    /**
     * Elimina el último nodo de la lista.
     */
    public void deleteAtEnd()
    {
        if (isEmpty()) //verifica si la lista está vacía 
            System.out.println("No hay nada que eliminar"); 
        else
        {
            Node toDelete = head;           //duplica al nodo que oficie como cabeza
            Node temp = toDelete;
            while(toDelete.next != null)    //recorre la lista
            {
                temp = toDelete;            //toma el último elemento de la lista
                toDelete = toDelete.next;
            }
            temp.next = null;               //se elimina apuntándolo a null
            System.gc();  
        }    
    }
    
    /**
     * es así, o sea n es menor, entonces se hace un proceso análogo a deleteAtEnd() solo que iterando n veces, como sabemos cuántas
     * veces se debe correr un nodo la elección es el ciclo for.
     * @param n 
     */
    public void deleteAt(int n)
    {
        int count = size();
        if (n >= 0 && count > n ) //si la posición del nodo que se desea eliminar excede la dimensión de la lista el método no tiene sentido
        {
            Node temp = head;               //duplica al nodo que oficie como cabeza
            Node toDelete;                  
            
            for (int i = 0; i < n-1; i++)   //itera n-1 veces para obtener el nodo previo al que se desea eliminar
                temp = temp.next;
            
            toDelete = temp.next;           //define al nodo que será eliminado
            temp.next = toDelete.next;      //desenlaza a toDelete
            toDelete = null;                //elimina a toDelete
            System.gc();
        }
        else
            System.out.println("No es posible efectuar la eliminación" + "\n");
    }
    
    /**
     * Actualiza un nodo. Hace el reemplazo del nuevo nodo por el primero que encuentre igual a oldNode.
     * @param oldNode
     * @param newNode
     */
    public void updateFirst(Node oldNode, Node newNode)
    {
        Node temp = head;
        Node previous = head;

        while(temp != null)                 //recorre la lista 
        {
            if(temp == oldNode)             //verifica si un nodo de la lista es igual al nodo que será reemplazado
            {
                newNode.next = temp.next;   //enlaza al nuevo nodo como lo está temp
                previous.next = newNode;    //enlaza al que está apuntando a temp al nuevo nodo
                temp = null;                //elimina a temp o al nodo viejo
                System.gc();
                break;
            }

            previous = temp;
            temp = temp.next;
        }
    }
    
    /**
     * Actualiza todos los nodos. Hace el reemplazo del nuevo nodo por el todos los que encuentre iguales a oldNode.
     * @param oldNode
     * @param newNode
     */
    public void updateAll(Node oldNode, Node newNode)
    {
        Node temp = head;
        Node previous = head;

        while(temp != null)                 //recorre la lista 
        {
            if(temp == oldNode)
            {
                newNode.next = temp.next;
                previous.next = newNode;    //reemplaza el primer nodo igual a oldNode
                temp = null;                //elimina el primer oldNode
                previous = newNode;         //vuelve a darle nuevos valores a previous y temp para que siga en la la búsqueda hasta el final de la lista
                temp = newNode.next;
            }
            else
            {
                previous = temp;
                temp = temp.next;
            }
        }
    }
    
    /**
     * Realiza la búsqueda de un nodo. Se contempla que apenas encuentre el primero se quedará con ese y ya.
     * @param node
     * @return
     */
    public Node linealSearch(Node node)
    {
        Node temp = head;       //duplica al nodo que oficie como la cabeza
        Node result = null;

        while(temp != null)     //recorre la lista
            if(temp == node)    //veifica si el nodo actual es igual al nodo buscado
            {	
                result =  temp; //result será el nodo que se retornará
                break;          //garantiza que el primer nodo que se encuentre será el que se retorne
            }
            else
                temp = temp.next;

        return result;
    }
    
    /**
     * Realiza la búsqueda de un nodo. El resultado será una lista con todos los nodos iguales que encuentre.
     * @param node
     * @return
     */
    public List searchAll(Node node)
    {
        Node temp = head;           
        List results = new List();  //Creación de una nueva lista para almacenar los resultados obtenidos en la búsqueda

        while(temp != null)
        {
            if(temp == node)
                results.insertAtEnd(temp.clone());  //cada que encuentre un nodo igual lo inserta a la lista, lo inserta por valor usando clone()

            temp = temp.next;
        }

        return results;
    }
    
    /**
     * Determina si existe un valor en la lista
     * @param value
     * @return true de ser hallado el valor, false de lo contrario
     */
    public boolean searchValue(double value)
    {
        Node temp = head;
        boolean search = false;                         //Se inicializa la bandera en falso
        
        while((temp.next != null)&&(search == false))   //se recorre la lista
        {
            if (temp.value == value)
            {
                search = true;      //si coincide index con el valor del nodo la bandera cambiará su estado a verdadero
                break;              //cuando encuentra el valor puede romper el ciclo
            }
            else
                temp = temp.next;   //se siguen verificando los nodos
        }
        return search;              //valor booleano
    }
    
    /**
     * Posición del nodo buscado.
     * @param value 
     * @return index en donde está el valor buscado.
     */
    public int searchNodePosition(double value)
    {
        if (searchValue(value)) //Verifica si existe el valor buscado
        {
            Node temp = head;
            int count = 0;      //inicialización del contador
            while((temp.next != null) && (temp.value != value)) //recorre la lista con la condición adicional de que el valor buscado no sea igual al nodo actual en el recorrido.
            {
                temp = temp.next;
                count ++;       //incremento del contador
            }
            return count;       //se obtiene el conteo del valor buscado en su primera aparición
        }
        else
            return -1;          //de no existir el valor buscado en la lista se retorna un -1
    }
    
   /**
    * Ordena ascendentemente los elementos enteros de la lista.
    * @param unsorted
    * @return
    */
   public List quickSort(List unsorted)
   {
           if(unsorted.size() <= 1)     //si la dimensión no es mayor a uno no se realiza el proceso
                return unsorted;
           else
           {
                Node pivot = unsorted.head;     
                Node temp = pivot.next;

                List less_elements = new List();
                List greater_elements = new List();

                if(temp.digit < pivot.digit )   //si el elemento siguiente al pivot es menor que el pivot inserta nodos en la lista de menores
                    less_elements.insertAtEnd(temp.clone());
                else                            //si el elemento siguiente al pivot es mayor que el pivot inserta nodos en la lista de mayores
                    greater_elements.insertAtEnd(temp.clone());

                less_elements = quickSort(less_elements);   //realiza el proceso de manera recursiva con la primera sub-lista
                pivot.next = quickSort(greater_elements).head;
                less_elements.insertAtEnd(pivot);           //realiza el proceso de manera recursiva con la segunda sub-lista

                return less_elements;
           }
   }
    
    /**
     * Dada la posición da la información entera del nodo
     * @param index
     * @return 
     */
    public int infoNode(int index)
    {
        Node temp = head;
        for (int i = 0; i < index; i++)     //itera n(index) veces
            temp = temp.next;
        
        return temp.digit; 
    }
    
    /**
     * Indica la posición en que se encuentra el nodo buscado en la lista por medio del la búsqueda binaria no recursiva.
     * @param node
     * @return el índice donde se encuentra el nodo solicitado.
     */
    public int binarySearch(Node node)
    {
        int lowerBound = 0;
        int upperBound = this.size();    //el límite superior se define como el tamaño de la lista
        int index = -1;             //inicializado en -1 por si no llega a encontrar el valor 
        
        while(lowerBound < upperBound)  //el límite inferior debe ser menor al superior siempre
        {   
            int middlePoint = (lowerBound + upperBound) / 2;  //el punto medio es el promedio entre el los límites superior e inferior
            
            if (node.digit == infoNode(middlePoint))  //verifica si la información entera del nodo buscado es igual al valor del nodo de la mitad de la lista
            {
                index = middlePoint;
                break;
            }
            else
            {
                if (node.digit < infoNode(middlePoint)) //hace la verificación hacia la izquierda de la lista
                    upperBound = middlePoint - 1;
                else
                    lowerBound = middlePoint + 1;       //hacea la verificación hacia la derecha de la lista
            }
        }
        if ((lowerBound == upperBound) && infoNode(lowerBound) == node.digit) //si el nodo buscado es el prrimero
            index = lowerBound;
        
        return index;
    }
    
    /**
     * Método que genera la lista de manera inversa utilizando pilas.
     */
    public void reverse()
    {
        Stack tempStack = new Stack();  //crea una nueva pila
        Node temp = head;
        
        while(temp != null) 
        {
            tempStack.push(temp.clone());  //se agregan los elementos de la lista a la pila. Los objetos pasan es por referencia, no por valor así que para solucionarlo se utiliza el clone.
            temp = temp.next;
        }
        head = tempStack.head;
    }
    
    /**
     * Recorta la lista original desde un valor dado hasta el final.
     * @param begin
     * @return 
     */
    public List sublist(int begin)
    {
        List subList = new List();  //creación de la nueva lista

        if(begin < this.size()) //verifica que sea posible realizar la operación
        {
            Node temp = head;

            for(int i = 0; i < begin; i++)  //recorre la lista, hasta el número dado(begin)
                temp = temp.next;

            while(temp != null) //desde donde quedó el ciclo for empieza el ciclo while su recorrido
            {
                subList.insertAtEnd(temp.clone());  //inserta los nodos de la nueva lista reducida
                temp = temp.next;
            }
        }
        return subList;
    }
    
    /**
     * Recorta la lista original desde un valor dado hasta un segundo valor dado.
     * @param begin
     * @param end
     * @return
     */
    public List sublist(int begin, int end)
    {
        List subList = new List();  //creación de la nueva lista

        if(begin < this.size()) //verifica que sea posible realizar la operación
        {
            Node temp = head;

            for(int i = 0; i < begin; i++)  //recorre la lista, hasta el número dado(begin)
                temp = temp.next;

            for (int i = 0; i < end; i++)   //desde donde quedó el primer ciclo for con begin empieza el segundo que tendrá final en end, e irá insertando
            {
                subList.insertAtEnd(temp.clone());  //inserta los nodos de la nueva lista reducida
                temp = temp.next;
            }
        }
        return subList;
    }
    
    /**
     * Verifica si dos listas con identicas
     * @param list
     * @return
     */
    public boolean isEqual(List list)
    {
        boolean isEqual = true;     //inicializa la bandera con el valor verdadero, suponiendo que las listas fueran identicas
        Node tempCurrent = head;
        Node tempList = list.head;

        while(tempCurrent != null && tempList != null)  //realiza los recorridos hasta que no hayan más elementos
            if(tempCurrent == tempList)                 //realiza las verificaciones nodo por nodo
            {
                tempCurrent = tempCurrent.next;         
                tempList = tempList.next;
            }
            else
            {
                isEqual = false; //de encontrar una disparidad entre dos nodos de las listas coloca la bandera en falso y rompe el ciclo
                break;
            }

        return isEqual;
    }
    
    /**
     * Realiza una clonación de la lista
     * @return
     */
    public List cloneList()
    {
        List cloneList = new List();    //creación de la nueva lista
        Node temp = head;
        
        while(temp != null)             //recorre la lista
        {
            cloneList.insertAtEnd(temp.clone());    //inserta en la nueva lista los nodos tal cual que existen
            temp = temp.next;
        }
        
        return cloneList;
    }
    
    /**
     * Prueba de los métodos creados.
     * @paramargs 
     */    
    public static void main(String[] args) throws IOException 
    {
        List grades = new List();
        
        grades.insertAtBegin(new Node("Quiz: ", 4.2));
        grades.insertAtEnd(new Node("Parcial 3: ", 4.0));
        grades.insertAtBegin(new Node("Task 1: ", 4.5));
        grades.insertAt(new Node("Parcial 2: ", 3.8), 2);
        grades.insertAt(new Node("Parcial 1: ", 4.8), 2);
        System.out.println("size: " + grades.size());
        grades.printList();
        grades.deleteAt(2);
        System.out.println("size: " + grades.size());    

        System.out.println("reverse:");
        grades.reverse();
        grades.printList();      
    }
    
}
