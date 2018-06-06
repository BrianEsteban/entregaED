package Trees;

/**
 * Implementación de un nodo genérico para árboles
 * @author Brian Esteban Barreto Cardozo
 */
 public class Node 
    {
        int value;
        String sub_string;

        Node left;  //apuntador izquierdo
        Node right; //apuntador derecho

        /**
         * Constructor vacío
         */
        public Node() {}

        /**
         * Constructor con el parámetro value
         * @param value 
         */
        public Node(int value) 
        {
            this.value = value;
        }

        /**
         * Costructor con un parámetro de tipo String
         * @param sub_string 
         */
        public Node(String sub_string) 
        {
            this.sub_string = sub_string;
        }

        @Override
        public String toString() {
            return  value + " ";
        }    
    }
