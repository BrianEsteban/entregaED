package LinearDataStructures;

/**
 * Nodo generico que implementan las listas enlazadas, y las de tipo pila y cola.
 * @author Brian Esteban Barreto Cardozo
 */
public class Node 
{
    String grade;
    double value;
    int digit;

    Node next;   //Apuntador

    /**
     * Constructor vacío
     */
    public Node(){}
    
    /**
     * Sobrecarga del constructor con los dos parámetros
     * @param grade
     * @param value 
     */
    public Node(String grade, double value)
    {
        this.grade = grade;
        this.value = value;
    }

    /**
     * Sobrecarga del método con un solo parámetro entero para trabajar métodos de ordenamiento en Listas
     * @param digit 
     */
    public Node(int digit) 
    {
        this.digit = digit;
    }
    
    /**
     * Facilidad de visualizacion. Para hacer verifcaciones.
     * @return la informacion que haya en el nodo, para el caso: grade y value
     */
    public String toString()    
    { 
        return  this.grade + "\t" + this.value + "\n";
    }
    
        /**
     * Facilidad de visualizacion. Para hacer verifcaciones.
     * @return la informacion que haya en el nodo, para el caso: grade y value
     */
    public String toString2()    
    { 
        return  this.digit + " ";
    }
    /**
     * Sobrecarga del constructor que ayuda en los casos en que necesitamos la información por valor, mas no por referencia como 
     * usualmente java maneja los objetos y los arreglos también.
     * @return el nodo temp, que contiene la información inicial
     */
    public Node clone()
    {
        Node temp = new Node(this.grade, this.value);
        return temp;
    }            
}
