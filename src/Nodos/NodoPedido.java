/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;


import Clases.Pedido;


/**
 *
 * @author lucas
 */
public class NodoPedido {
    Pedido pedido; 
    NodoPedido sig;
 
    public NodoPedido(Pedido pedido)
    {
    
        this.pedido=pedido;
        
    }
    
    public void setSig(NodoPedido nodo)
    {
    
    this.sig=nodo;
    }
    
    public NodoPedido getSig()
    {
    return this.sig;
    }
    
    public Pedido getPedido()
    {
    return this.pedido;
    }
    
}

//necesito este nodo para llenar la lista de pedidos principal, donde estan todos los pedidos de todos los clientes ,falta hacer esa lista
