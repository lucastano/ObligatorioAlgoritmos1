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
public class ListaPedidosParaEntregar implements IListaPedidosParaEntregar {
    NodoPedido primero;
    NodoPedido ultimo;
    int cantidad;
    
    public ListaPedidosParaEntregar()
    {
    
        this.cantidad=0;
        
    }
    public void setPrimero(NodoPedido nodo)
    {
    this.primero=nodo;
    }
    public NodoPedido getPrimero()
    {
        return this.primero;
    
    }
    
    public void setUltimo( NodoPedido nodo)
    {
    this.ultimo=nodo;
    }
    public NodoPedido getUltimo()
    {
        return this.ultimo;
    
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

            ret.valorbooleano = true;
            this.cantidad++;

        }

    }

    return ret; 
    }

    @Override
    public Retorno borrarElemento(String ciCliente) {
        return borrarElemento(ciCliente,this.primero);
    }
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
                cantidad--;
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
    public Retorno borrarFin() {
         Retorno ret = new Retorno(Retorno.Resultado.OK);
        if(!this.esVacia().valorbooleano)
        {
            if(this.primero==this.ultimo)
            {
            
                this.primero=null;
                this.ultimo=null;
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
                
            }
            ret.valorbooleano=true;
        
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
                cantidad--;
            } else {
                this.primero = this.primero.getSig();
                cantidad--;
            }
            
            ret.valorbooleano = true;
        }
        return ret;
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
    public Retorno mostrarRec() {
        System.out.println("LISTADO DE PEDIDOS LISTOS PARA ENTREGAR");
        return mostrarRec(this.getPrimero());
    
    }
    
    
    public Retorno mostrarRec(NodoPedido nodo) {
        Retorno ret=new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano=true;
        
        if(nodo==null)
        {
            return ret;
         
        }
        else
        {
        
            System.out.println("Numero de pedido: "+nodo.getPedido().getNumeroPedido()+" Nombre de Cliente: "+nodo.getPedido().getCliente().getNombre());
            return mostrarRec(nodo.getSig());
        
        }
    }
    
    public void Mostrar()
    {
    
        NodoPedido nodo=this.getPrimero();
        while(nodo!=null)
        {
        
            System.out.println("Nombre: "+nodo.getPedido().getCliente().getNombre());
            nodo.getPedido().mostrarProductoCantidad();
            
            nodo=nodo.getSig();
            
        }
    
    }
}
