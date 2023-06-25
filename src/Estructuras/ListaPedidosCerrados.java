/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Clases.Pedido;
import Nodos.NodoPedido;


/**
 *
 * @author lucas
 */
public class ListaPedidosCerrados implements IListaPedidosCerrados {
    
    NodoPedido primero;
    NodoPedido ultimo;
    int cantidad=0;
    
    public int getCantidad()
    {
    return this.cantidad;
    }
    
    public NodoPedido getPrimero()
    {
        return this.primero;
    
    }
    public NodoPedido getUltimo()
    {
        return this.ultimo;
    
    }
    
    public void setUltimo(NodoPedido nodo)
    {
    this.ultimo=nodo;
    }
    public void setPrimero(NodoPedido nodo)
    {
    this.primero=nodo;
    }

    @Override
    public Retorno esVacia() {
        
        Retorno ret= new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano=this.primero==null;
        return ret;
    }

    @Override
    public Retorno agregarInicio(Pedido dato) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoPedido nuevoPedido= new NodoPedido(dato);
        
        if(this.esVacia().valorbooleano)
        {
        this.primero=nuevoPedido;
        this.ultimo=nuevoPedido;
        cantidad++;
        }
        else
        {
            nuevoPedido.setSig(primero);
            this.primero=nuevoPedido;
            cantidad++;
        
        }
        ret.valorbooleano=true;
        return ret;
    }

    @Override
    public Retorno agregarFinal(Pedido dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno agregarOrd(Pedido dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void mostrar()
    {
        NodoPedido nodo=this.getPrimero();
        System.out.println("LISTADO DE PEDIDOS CERRADOS");
        while(nodo!=null)
        {
            System.out.println("Nombre cliente: "+nodo.getPedido().getCliente().getNombre()+" numero pedido: "+nodo.getPedido().getNumeroPedido());
            nodo.getPedido().mostrarProductoCantidad();
           
        nodo=nodo.getSig();
        }
    
    }
    
    public NodoPedido obtenerPedido(String ciCliente) {
        NodoPedido aux = this.getPrimero();
        NodoPedido pedidoBuscado = null;
        while (aux != null && pedidoBuscado == null) {
            if (aux.getPedido().getCliente().getCi().compareTo(ciCliente) == 0) {
                pedidoBuscado = aux;
                
            }
            aux = aux.getSig();
        }
        return pedidoBuscado;
    }

    @Override
    public Retorno borrarFin() {
        
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        if(!this.esVacia().valorbooleano)
        {
            if(this.primero==this.ultimo)
            {
            
                this.primero=null;
                this.ultimo=null;
                ret.resultado=Retorno.Resultado.OK;
                ret.valorbooleano=true;
                cantidad--;
                
            }
            else
            {
            
                NodoPedido aux=this.primero;
                while(aux.getSig()!=this.ultimo)
                {
                aux=aux.getSig();
                }
                aux.setSig(null);
                this.setUltimo(aux);
                cantidad--;
                ret.resultado=Retorno.Resultado.OK;
                ret.valorbooleano=true;
                
            }
            
        
        }
        return ret;
    }
    
}
