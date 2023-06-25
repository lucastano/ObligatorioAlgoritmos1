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
public class NodoProductoCantidad {
    Producto producto;
    int cantidad;
    NodoProductoCantidad sig;
    
    public NodoProductoCantidad (Producto producto,int cantidad)
    {
    this.producto=producto;
    this.cantidad=cantidad;
    this.sig=null;
    
    }
    
    public void setSig(NodoProductoCantidad nodo)
    {
    
        this.sig=nodo;
        
    } 
    
    public NodoProductoCantidad getSig()
    {
    return this.sig;
    }
    
    public Producto getProducto()
    {
    return this.producto;
    }
    public int getCantidad()
    {
    return this.cantidad;
    }
    
}
