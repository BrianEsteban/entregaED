package Strings;

import LinearDataStructures.List;
import LinearDataStructures.Node;
import java.io.*;

/**
 * Representación de Strings como listas
 * @author Brian Esteban Barreto Cardozo
 */
public class StringAsList 
{
    StringNode head;
    public List string = new List();

    /**
     * Costructort para inicializar una lista
     */
    public StringAsList()
    {
        string = new List();
    }

    /**
     * Recibe una cadena de caracteres para enlistar caaracter por caracter
     * @param string_
     */
    public StringAsList(char[] string_)
    {
        string = new List();

        for(int i = 0; i < string_.length; i++)
            string.insertAtEnd(new Node( string_[i] )); //utiliza el método insertar al final para mantener la cadena en el mismo orden
    }

    /**
     * Método de separación de caracteres
     * @param regex
     * @return
     */
    public StringAsList[] split(StringAsList regex)
    {
        StringAsList[] response = null;
        return response; 
    }

    /**
     * Determina si contiene un valor
     * @param regex
     * @param value
     * @return un valor verdadero si encuentra el valor
     */
    public boolean contains(StringAsList regex, StringNode value)
    {
        while(regex.head.next != null)
        {
            if (regex.head == value) 
                return true;
        }
        return false;
    }

    /**
     * Sub-cadena desde un indice hasta el final 
     * @param beginIndex
     * @return
     */
    public StringAsList substring(int beginIndex)
    {
        StringAsList subString = new StringAsList();
        subString.string = this.string.sublist(beginIndex);
        return subString;
    }


    /**
     * Sub-cadena desde un indice inicial hasta uno final 
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public StringAsList substring(int beginIndex, int endIndex)
    {
        StringAsList subString = new StringAsList();
        subString.string = this.string.sublist(beginIndex, endIndex);
        return subString;
    }


    /**
     * Determina la posición del nodo
     * @param regex
     * @param value
     * @return
     */
    public int indexOf(StringAsList regex, StringNode value)
    {
        int count = 0;
        while(regex.head.next != null)
        {
            if (regex.head == value) 
                break;
            count ++;
        }       
        return count;
    }

    /**
     * Determina si son iguales dos cadenas
     * @param string_
     * @return
     */
    public boolean equals(StringAsList string_)
    {
        return this.string.equals( string_.string );
    }


    /**
     * Dimensión de la cadena
     * @return
     */
    public int length()
    {
        return this.string.size();
    }


    /**
     * Cadena de texto al contrario
     * @return
     */
    public StringAsList reverse()
    {
        StringAsList reverse = new StringAsList();
        reverse.string = this.string.cloneList();
        reverse.string.reverse();

        return reverse;
    }

    /**
     * Determina si es palindrome utilizando el método reverse
     * @return
     */
    public boolean isPalindrome()
    {
        return this.string.isEqual( reverse().string );
    }


    /**
     * Determina si dos cadenas son distintas
     * @param anagramCandidate
     * @return
     */
    public boolean isAnagram(StringAsList anagramCandidate)
    {
        return !this.string.isEqual(anagramCandidate.string);
    }

    /**
     * Imprime caracter por caracter
     */
    public void print()
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringNode temp = head;

        try 
        {
                while(temp != null)
                {
                        bw.write(temp.character);
                        temp = (StringNode)temp.getNext();
                }
                bw.flush();
        }
        catch (IOException ex) 
        {
                ex.printStackTrace();
        }
    }
}