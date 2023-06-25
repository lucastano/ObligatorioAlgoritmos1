/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;
import Clases.Cliente;

/**
 *
 * @author lucas
 */
public class NodoCliente {
    
    Cliente dato;
    NodoCliente sig;
    
    public NodoCliente(Cliente dato)
    {
    this.dato=dato;
    this.sig=null;
    }
    
    public void setSig(NodoCliente prox)
    {
    this.sig=prox;
    }
    public NodoCliente getSig()
    {
    return this.sig;
    }
    public void setDato(Cliente dato)
    {
    this.dato=dato;
    }
    public Cliente getDato()
    {
    return this.dato;
    }
    
    
}
