/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Nodos.NodoPedido;

/**
 *
 * @author lucas
 */
public class ColaPedidosParaEntregar implements IColaPedidosParaEntregar {
    
    private NodoPedido inicio; 
    private NodoPedido fin;
    private int cantidad;
    
    public ColaPedidosParaEntregar()
    {
    this.cantidad=0;
    }
    
    public NodoPedido getInicio()
    {
    return this.inicio;
    }
    public NodoPedido getFin()
    {
    return this.fin;
    }
    
    public void setInicio(NodoPedido nodo)
    {
    this.inicio=nodo;
    }
    
    public void setFin(NodoPedido nodo)
    {
    this.fin=nodo;
    }
    
    public void setCantidad( int cant){
    this.cantidad=cant;
    }
    
    public int getCantidad()
    {
    
    return this.cantidad;
    }

     @Override
    public void encolar(NodoPedido nodo) {
         if(this.esVacia()) {
                this.setInicio(nodo);
                this.setFin(nodo);
                this.setCantidad(1);
            }else {
                fin.setSig(nodo);
                fin = nodo;
                cantidad++;
            }          
    }

    @Override
    public void desencolar() {
        if(!esVacia()) {
            NodoPedido borrar = inicio;
            if(cantidad == 1) {
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.getSig();
                borrar.setSig(null);
            }
            cantidad --;
        }
    }

    @Override
    public boolean esVacia() {
        return this.getCantidad() == 0;
    }

    @Override
    public boolean esLlena() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int elementos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NodoPedido frente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarColaPedidosListosParaEntregar() {
        System.out.println("COLA PEDIDOS PARA ENTREGAR");
         if(this.cantidad==0)
        {
        
        System.out.println("Cliente no tiene pedidos para retirar");
        System.out.println("\n");
        
        }
        else
        {
            
           NodoPedido mostrar = getInicio();
           System.out.println("PEDIDOS LISTOS PARA RETIRAR");
           while(mostrar != null) {
               
            System.out.println("Numero de pedido: "+mostrar.getPedido().getNumeroPedido());
            mostrar.getPedido().mostrarProductoCantidad();
            
            mostrar = mostrar.getSig();
           }
           
        }
    }

    @Override
    public void mostrarREC(NodoPedido nodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
