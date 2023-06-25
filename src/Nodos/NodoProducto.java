/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;
import Clases.Producto;
/**
 *
 * @author lucas
 */
public class NodoProducto {
    
    Producto dato;
    NodoProducto sig;
    
    public NodoProducto(Producto dato)
    {
    this.dato=dato;
    this.sig=null;
    
    }
    
    public void setDato( Producto dato)
    {
    this.dato=dato;
    
    } 
    public Producto getDato()
    {
    return this.dato;
    }
    
    public void setSig(NodoProducto prox)
    {
    this.sig=prox;
    }
    
    public NodoProducto getSig()
    {
    return this.sig;
    }
    
    
}
