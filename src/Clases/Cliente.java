
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Estructuras.ColaPedidosAbiertos;
import Estructuras.ColaPedidosCerrados;
import Estructuras.ColaPedidosParaEntregar;
import Nodos.NodoPedido;


/**
 *
 * @author lucas
 */
public class Cliente {
    String nombre;
    String cedula;
    int telefono;
   public ColaPedidosAbiertos ColapedidosAbiertos;
   public ColaPedidosCerrados ColapedidosCerrados;
   public ColaPedidosParaEntregar ColapedidosListosParaRetirar;
    
    
    public Cliente(String nombre,String cedula,int telefono)
    {
    this.nombre=nombre;
    this.cedula=cedula;
    this.telefono=telefono;
    
    this.ColapedidosAbiertos=new ColaPedidosAbiertos(); 
    this.ColapedidosCerrados=new ColaPedidosCerrados();
    this.ColapedidosListosParaRetirar=new ColaPedidosParaEntregar();
    
    }

    
    public String getCi()
    {
    return this.cedula;
    }
    
    public String getNombre()
    {
    return this.nombre;
    }
    
    public int getTelefono()
    {
    return this.telefono;
    }
    //muestra la cola de pedidos abiertos del cliente 
    public void mostrarColaPedidosAbiertos()
    {
        this.ColapedidosAbiertos.mostrarCola();
        
    
    }
    public void mostrarColaPedidosCerrados()
    {
        this.ColapedidosCerrados.mostrarColaPedidosCerrados();
        
    
    }
    public void mostrarColaPedidosListosParaEntregar()
    {
        this.ColapedidosListosParaRetirar.mostrarColaPedidosListosParaEntregar();
        
    
    }
    
    public void cerrarPedidoCliente()
    {
        NodoPedido pedidoAEncolar =ColapedidosAbiertos.getFin();
        this.ColapedidosAbiertos.desencolar();
        this.ColapedidosCerrados.encolar(pedidoAEncolar);
    
    }
    
    public void procesarPedidoCliente()
    {
        NodoPedido pedidoAProcesar=ColapedidosCerrados.getFin();
        this.ColapedidosCerrados.desencolar();
        this.ColapedidosListosParaRetirar.encolar(pedidoAProcesar);
    
    }

    
    

    

           
}
