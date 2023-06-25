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
public class ListaPedidos implements IListaPedidos {
    
    NodoPedido primero;
    NodoPedido ultimo;
    int cantidad;
    
    
    public ListaPedidos()
    {
    this.cantidad=0;
    }
public void setPrimero(NodoPedido nodo)
{
this.primero=nodo;
}

public void setUltimo(NodoPedido nodo)
{
this.ultimo=nodo;
}

public NodoPedido getPrimero()
{
return this.primero;
}

public NodoPedido getUltimo()
{
return this.ultimo;
}

public int getCantidad()
{
return this.cantidad;
}

    @Override
    public Retorno esVacia() {
        Retorno ret=new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
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
        this.cantidad++;
        }
        else
        {
            nuevoPedido.setSig(primero);
            this.primero=nuevoPedido;
            this.cantidad++;
        
        }
        ret.valorbooleano=true;
        return ret;
    }

    @Override
    public Retorno agregarFinal(Pedido dato) {
         Retorno ret=new Retorno(Retorno.Resultado.OK);
       NodoPedido nuevoPedido=new NodoPedido(dato);
       if(this.esVacia().valorbooleano)
       {
           this.setPrimero(nuevoPedido);
           this.setUltimo(nuevoPedido);
           this.cantidad++;
       
       }
       else
       {
       
           ultimo.setSig(nuevoPedido);
           ultimo=nuevoPedido;
           this.cantidad++;
           
       }
       ret.valorbooleano=true;
       return ret;
    }

    @Override
    public Retorno agregarOrd(Pedido dato) {
    Retorno ret = new Retorno(Retorno.Resultado.OK);
    ret.valorbooleano = false;
    //crea el nodo
    NodoPedido pedido = new NodoPedido(dato);
   //verifica si esta vacia, si asi lo es, inserta el nodo en inicio
    if (this.esVacia().valorbooleano) { 
        this.agregarInicio(dato);
        
        ret.valorbooleano = true;

    }
    //sino
    else 
    {

        NodoPedido actual = this.getPrimero(); 
        NodoPedido anterior = null; 
        
        while (actual != null && actual.getPedido().getCliente().getNombre().toUpperCase().compareTo(pedido.getPedido().getCliente().getNombre().toUpperCase()) < 0) {

            anterior = actual;

            actual = actual.getSig();

        }

        
        if (anterior == null) { 
            this.agregarInicio(dato);
            
            ret.valorbooleano = true;

        } else {

            pedido.setSig(actual);
            
            anterior.setSig(pedido);
                this.cantidad++;
            ret.valorbooleano = true;

        }

    }

    return ret; 
    }
    
    // funcion mostrar mejorarla para que no mueste el producto cantidad del ultimo pedido , sino de todos 
    public void mostrar()
    {
        NodoPedido nodo=this.getPrimero();
        System.out.println("LISTADO DE PEDIDOS ABIERTOS");
        while(nodo!=null)
        {
           
            System.out.println("Nombre cliente: "+nodo.getPedido().getCliente().getNombre()+" - ID PEDIDO: "+nodo.getPedido().getNumeroPedido());
            this.obtenerPedido(nodo.getPedido().getCliente().getCi());
            nodo.getPedido().mostrarProductoCantidad();
            System.out.println("\n");
            
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
    
    public Retorno tienePedidos(String ciCliente)
    {
        Retorno ret =new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        
        NodoPedido pedidoBuscado=this.obtenerPedido(ciCliente);
        if(pedidoBuscado!=null)
        {
            ret.valorbooleano=true;
            
        }
        
       return ret;
    }
    
    @Override
    public Retorno borrarElemento(String ciCliente)
    {
    
        return borrarElemento(ciCliente,this.primero);
        
    }
    
    //ver si funciona el compareto
    public Retorno borrarElemento(String ciCliente, NodoPedido nodo) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano=false;
        
        if(!this.esVacia().valorbooleano)
        {
        
            if(this.getPrimero().getPedido().getCliente().getCi().equals(ciCliente))
            {
            
                this.borrarInicio();
                ret.valorbooleano=true;
                return ret;
                
            }
            else if(this.getUltimo().getPedido().getCliente().getCi().equals(ciCliente))
            {
            
                this.borrarFin();
                ret.valorbooleano=true;
                return ret;
                
            }
            else if(nodo.getSig().getPedido().getCliente().getCi().equals(ciCliente))
            {
            
                nodo.setSig(nodo.getSig().getSig());
                ret.valorbooleano=true;
                this.cantidad--;
                return ret;
                
            }
            else
            {
                return borrarElemento(ciCliente,nodo.getSig());
            
            }
            
        }
        
       
        return ret;
        
    }
    @Override
    public Retorno borrarInicio() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if (!this.esVacia().valorbooleano) {
            if (this.primero == this.ultimo) {
                this.primero = null;
                this.ultimo = null;
                this.cantidad--;
            } else {
                this.primero = this.primero.getSig();
                this.cantidad--;
            }
            
            ret.valorbooleano = true;
        }
        return ret;
        
    }

    @Override
    public Retorno borrarFin() {
         Retorno ret = new Retorno(Retorno.Resultado.OK);
        if(!this.esVacia().valorbooleano)
        {
            if(this.primero==this.ultimo)
            {
            
                this.primero=null;
                this.ultimo=null;
                this.cantidad--;
                
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
                this.cantidad--;
                
            }
            ret.valorbooleano=true;
        
        }
        return ret;
    }

}

