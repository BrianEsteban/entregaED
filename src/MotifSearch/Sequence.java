package MotifSearch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Implementación del nodo: secuencia 
 * @author Brian Esteban Barreto Cardozo
 */
public class Sequence 
{
    String sequence;    //secuencia con las letras correspondientes "A","C","G" y "T"
    String chromosome;  //cromosoma de la forma "chr" concatenado con un número aleatorio
    int start;          //desde donde va
    int end;            //hasta donde va
    
    Sequence next;      //Apuntador

    /**
     *Constructor vacio
     */
    public Sequence(){}
    
    /**
     * Constructor con los cuatro parámetros 
     * @param sequence
     * @param chromosome
     * @param start
     * @param end 
     */
    public Sequence(String sequence, String chromosome, int start, int end) 
    {
        this.sequence = sequence;
        this.chromosome = chromosome;
        this.start = start;
        this.end = end;
    }
     
    /**
     * Para visualizar la información del nodo.
     * @return 
     */
    public String toString(){  //Facilidad de visualizacion. Para hacer verifcaciones.
        return "Sequence: " + this.sequence + "\t" + "Chromosome" + this.chromosome + "\t" + "Start: " + this.start + "\t"  + "Emd: " + this.end + "\n";
    }
    
    /**
     * Necesario para pasar por valor
     * @return 
     */
    public Sequence clone()
    {
        Sequence temp = new Sequence(this.sequence, this.chromosome, this.start, this.end);
        return temp;
    }
    
}
