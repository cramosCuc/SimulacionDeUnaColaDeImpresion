
package edu.cuc.metodos;

public class Nodo<E> {
    private E valor;
    private Nodo link;
    
    public Nodo() {};

    public Nodo(E valor) {//firma del método
        this.valor = valor;
        this.link = null;
    }

    public E getValor() {
        return valor;
    }

    public void setValor(E valor) {
        this.valor = valor;
    }

    public Nodo getLink() {
        return link;
    }

    public void setLink(Nodo link) {
        this.link = link;
    }

    
    
    
}
