package Strings;

/*
# String Node for Strings based on Lists.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/

/**
 * This class represents the behavior of a String Node for Strings based on Lists
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class StringNode  
{
    char character;
    StringNode next = null;

    public StringNode() {}
    
    public StringNode(char character) 
    {
        this.character = character;
    }

    public void setNext(StringNode node) 
    {
        this.next = node;
    }
    
    public StringNode getNext() 
    {
        return this.next;
    }


}