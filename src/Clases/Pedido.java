/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Estructuras.ListaProductoCantidad;
import Nodos.NodoProductoCantidad;

/**
 *
 * @author lucas
 */
public class Pedido {
    int numeroPedido;
    static int ultimoNumeroPedido=0;
    Cliente cliente;
    ListaProductoCantidad productocantidad;
    int totalProductos;
    
        
public Pedido ( Cliente cli)
{
   this.ultimoNumeroPedido++;
    this.numeroPedido=this.ultimoNumeroPedido; 
    totalProductos=0;
    this.cliente=cli;
   this.productocantidad=new ListaProductoCantidad();

}

public ListaProductoCantidad getProductoCantidad()
{
return this.productocantidad;
}

public int getCantidadProductoCantidad()
{
return this.productocantidad.getCantidad();
}

public int  getNumeroPedido()
{

    return this.numeroPedido;

}

public Cliente getCliente()
{
return this.cliente;
}

public void agregarProductoCantidad(Producto producto,int cantidad)
{
//    NodoProductoCantidad nodoPC= new NodoProductoCantidad(producto,cantidad);
   this.productocantidad.agregarInicio(producto, cantidad);
   producto.restarStock(cantidad);

}

public void mostrarProductoCantidad()
{
NodoProductoCantidad nodo=this.productocantidad.getPrimero();
while(nodo!=null)
{
    System.out.println("Producto: "+nodo.getProducto().getNombre()+"- Cantidad: "+nodo.getCantidad());
nodo=nodo.getSig();
}
System.out.println("Total de productos: "+this.productocantidad.getTotalProductos());
}

public void eliminarProductoCantidad(int cantidadAcciones)
{
    int i =1;
    while(i<=cantidadAcciones)
    {
        this.productocantidad.getPrimero().getProducto().setStock(this.productocantidad.getPrimero().getCantidad());
        this.productocantidad.borrarInicio();
    
        i++;
    }
    


}


}


