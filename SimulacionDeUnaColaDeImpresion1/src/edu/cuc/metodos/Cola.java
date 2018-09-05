/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.metodos;

import java.util.Iterator;

/**
 *
 * @author CARLOS
 */
public class Cola <E>{
    private Nodo top,end;
    private int size;
    public Cola(){
        top=end=null;
        size=0;              
    }
    
    public void enqueue(E valor){
        Nodo <E> nodo = new Nodo(valor);
        if (top == null){ // Cola está vacía?
          top= end = nodo; 
         
        }else{
          this.end.setLink(nodo);
          this.end=nodo;
        }        
        this.size++;
    }
    
    public Nodo<E> dequeue(){
         if (top == null) // Cola está vacía?
             return null;
         else {
             Nodo<E> nodo = this.top;
             this.top = this.top.getLink();
             this.size --;
             return nodo;
         }    
    }
    
    public Nodo<E> peek(){        
        return this.top;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public boolean isEmpty(){    
     return top == null;
    }
    
    
    public Nodo<E> getEnd(){
       return this.end;
    }
    
    public Iterator recorrido() {
        Iterator<E> recorrido = new Iterator() {
            Nodo<E> primerNodo = top;

            @Override
            public boolean hasNext() {
                return primerNodo != null;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E variable = primerNodo.getValor();
                    primerNodo = primerNodo.getLink();
                    return variable;
                } else {
                    throw new NullPointerException("No hay un siguiente nodo");
                }
            }
        };
        return recorrido;
    }
    
     public void display(){
       Nodo<E> nodo =this.top;
       System.out.println("La Cola de tamaño "+this.getSize()+ " es la siguiente:");
       while (nodo != null){
           System.out.println(nodo.getValor().toString());
           nodo=nodo.getLink();
       }
    } 
}
