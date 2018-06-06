package HashTable;

/**
 * Representación de una tabla hash con los métodos insertar, buscar, imprimirla.
 * @author Brian Esteban Barreto Cardozo
 */
public class HashTable 
{
    int value = 10; //se inicializa la cantidad
    Node[] entries = new Node[value];   //el nodo será un arreglo de entradas
    
     public static class Node 
    {
        String name;    //atributo de tipo String
        String value;   //atributo entero
        
        Node next; //apuntador

        /**
         * Constructor vacío
         */
        public Node() {}

        /**
         * Constructor del nodo con sus dos parámetros
         * @param name
         * @param value 
         */
        public Node(String name, String value) 
        {
            this.name = name;
            this.value = value;
        }

        /**
         * Visualización de cada posición del arreglo que tiene una lista enlazada
         * @return 
         */
        @Override
        public String toString() {
            return "[" + name + ", " + value + "]";
        }
    }
    
    /**
     * Inserta un elemento en la tabla
     * @param name
     * @param value 
     */
    public void insert(String name, String value) 
    {
        int hash = getHash(name);   //se obtiene la tabla correspondiente al nombre
        Node newEntry = new Node(name, value);
        
        if(entries[hash] == null)   //si no tiene nada ingresado en la tabla actual inserta al inicio
            entries[hash] = newEntry;
        else                        //si la tabla tiene elementos enlaza la nueva entrada a la lista 
        {
            Node temp = entries[hash]; 
            while(temp.next != null) //recorre la tabla
                temp = temp.next;
            
            temp.next = newEntry;
        }
    }

    /**
     * Busca un elemento dentro de la tabla
     * @param name 
     * @return true si lo halla, null si no lo encuentra
     */
    public String search(String name) 
    {
        int hash = getHash(name);   //se obtiene la tabla correspondiente al nombre
        
        if(entries[hash] != null)   //verifica que existan elementos en el parámetro dado
        {
            Node temp = entries[hash]; //entrada temporal 

            while( !temp.name.equals(name)&& temp.next != null ) //recorre la lista hasta terminar mientras el valor no coincida 
                temp = temp.next;
            
            return temp.value;
        }

        return null;
    }
    
    /**
     * Determina la tabla según el nombre
     * @param name
     * @return la tabla del valor dado
     */
    public int getHash(String name) 
    {
        return name.hashCode() % value;
    }

   /**
    * Imprime la estructura de la tabla
    * @return las listas enlazadas para cada posición del arreglo
    */
    public String printTable() 
    {
        int position = 0;
        StringBuilder hashTableStr = new StringBuilder();
        
        for (Node node : entries)   //recorre todas las entradas de los nodos
        {
            hashTableStr.append("\n").append(position).append(" = ").append(node.toString());   //según la posición del arreglo obtiene su lista
            position++;
            Node temp = node.next;
            
            while(temp != null) //recorre cada lista enlazada
            {
                hashTableStr.append(" > ");  //denotamos que un nodo enlaza a otro con este simbolo
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString(); //la estructura de la tabla
    }
    

    /**
     * Prueba de la tabla
     * @param args 
     */
    public static void main(String[] args) 
    {
        HashTable hashTable = new HashTable();
        
        for(int i = 0; i < 15; i++)     //la tabla va a contener 15 entradas desde el 0 y ordenadas ascendentemente 
        {
            String name = String.valueOf(i);
            hashTable.insert(name, name);   //se toma la misma entrada tanto para el nombre como para el valor
        }

        System.out.println(hashTable.printTable());
    }
}