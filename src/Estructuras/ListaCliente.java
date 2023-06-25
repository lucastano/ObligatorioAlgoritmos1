/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;
import Clases.Cliente;

import Nodos.NodoCliente;
import Nodos.NodoPedido;


/**
 *
 * @author lucas
 */
public class ListaCliente implements IListaCliente {
    
    private NodoCliente primero;
    private NodoCliente ultimo;
    int cantidad;
    
    public ListaCliente()
    {
    this.cantidad=0;
    }
    
    public int getCantidad()
    {
    return this.cantidad;
    }

    public void setPrimero(NodoCliente nodo)
    {
    this.primero=nodo;
    }
    
    public NodoCliente getPrimero()
    {
    return this.primero;
    }
    
    public void setUltimo(NodoCliente nodo)
    {
    this.ultimo=nodo;
    }
    
    public NodoCliente getUltimo()
    {
    return ultimo;
    }
   
    
    @Override
    public Retorno esVacia() {
        Retorno ret= new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano=this.primero==null;
        return ret;
    }

    @Override
    public Retorno vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno cantElementos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno agregarInicio(Cliente dato) {
        Retorno ret=new Retorno(Retorno.Resultado.OK);
        NodoCliente clienteNuevo= new NodoCliente(dato);
        if(this.esVacia().valorbooleano)
        {
        
            this.setPrimero(clienteNuevo);
            this.setUltimo(clienteNuevo);
            this.cantidad++;
            
        }
        else
        {
        
            clienteNuevo.setSig(primero);
            this.setPrimero(clienteNuevo);
            this.cantidad++;
        
        }
        ret.valorbooleano=true;
        return ret;
    }

    @Override
    public Retorno agregarFinal(Cliente dato) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoCliente clienteNuevo=new NodoCliente(dato);
        if(this.esVacia().valorbooleano)
        {
        this.setPrimero(clienteNuevo);
        this.setUltimo(clienteNuevo);
        this.cantidad++;
        }
        else
        {
        ultimo.setSig(clienteNuevo);
        ultimo=clienteNuevo;
        this.cantidad++;
        }
        ret.valorbooleano = true; // revisar 
        return ret;
    }

    @Override
    public Retorno agregarOrd(Cliente dato)
    {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

    ret.valorbooleano = false;

    NodoCliente producto = new NodoCliente(dato);

    if (this.esVacia().valorbooleano) { // Si la lista está vacía, agrega el nuevo nodo al inicio
        this.agregarInicio(dato);

        ret.valorbooleano = true;

    } else {

        NodoCliente actual = this.getPrimero(); 
        NodoCliente anterior = null; 
        
        while (actual != null && actual.getDato().getNombre().toUpperCase().compareTo(producto.getDato().getNombre().toUpperCase()) < 0) {

            anterior = actual;

            actual = actual.getSig();

        }

        
        if (anterior == null) { 
            this.agregarInicio(dato);

            ret.valorbooleano = true;

        } else {

            producto.setSig(actual);

            anterior.setSig(producto);
            this.cantidad++;

            ret.valorbooleano = true;

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
            
                NodoCliente aux=this.primero;
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

     @Override
     public Retorno borrarElemento(String ci)
     {
         
     return borrarElementoRec(ci,this.primero);
             
     }
     
    public Retorno borrarElementoRec(String  ci,NodoCliente nodo) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano=false;
       
        if(!this.esVacia().valorbooleano)
        {
            if(this.getPrimero().getDato().getCi().equals(ci))
            {
            
                this.borrarInicio();
                return ret;
            }
            else if (this.getUltimo().getDato().getCi().equals(ci))
            {
            
                this.borrarFin();
            return ret;
            }
            else if(nodo.getSig().getDato().getCi().equals(ci))
            {
            
                nodo.setSig(nodo.getSig().getSig());
                ret.valorbooleano=true;
                this.cantidad--;
                return ret;
            }
            else
            {
            return borrarElementoRec(ci,nodo.getSig());
            }
            
            
        
        }
        return ret;
    }

    // retorna si esta el elemento buscado , comparetu lo modificamos, dentro parsea el dato de string a int 
    @Override
    public Retorno buscarelemento(String ci) {

    return buscarElementoRec(ci,this.getPrimero());
    
    }
    @Override
   public NodoCliente obtenerCliente(String ci)
   {
       NodoCliente aux = this.getPrimero();
        NodoCliente nodoBuscado = null;
        while (aux != null && nodoBuscado == null) {
            if (aux.getDato().getCi().compareTo(ci) == 0) {
                nodoBuscado = aux;
            }
            aux = aux.getSig();
        }
        return nodoBuscado;
   
   }
    public Retorno buscarElementoRec(String ci, NodoCliente nodo)
    {
    
        Retorno ret= new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano=false;
        
        if(!this.esVacia().valorbooleano)
        {
            if(nodo!=null){
        
            if(nodo.getDato().getCi().equals(ci))
            {
            
                ret.valorbooleano=true;
                return ret;
                
            }
            else
            {
            
                return buscarElementoRec(ci,nodo.getSig());
                
            }
            
            }
            
        }
        return ret;
        
    }

    

    @Override
    public Retorno mostrar() {
        Retorno ret=new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        
        if(this.esVacia().valorbooleano)
        {
            return ret;
        
        }
          else{
            ret.resultado=Retorno.Resultado.OK;
            ret.valorbooleano=true;
            
            NodoCliente aux=this.getPrimero();
            System.out.println("LISTADO DE CLIENTES");
            while(aux!=null)
             {
            
            System.out.println("Nombre: "+aux.getDato().getNombre()+" - Cedula: "+aux.getDato().getCi()+" - Telefono: "+aux.getDato().getTelefono());
           
        
            aux=aux.getSig();
             }
        
        
        
        return ret;
        
        }
        
        
        
    }
    
    
     public void mostrarClientesColas() {
        
        NodoCliente aux = this.getPrimero();
        
        while (aux != null) {
            System.out.println("CLIENTE "+aux.getDato().getNombre());
            aux.getDato().mostrarColaPedidosAbiertos();
            aux.getDato().mostrarColaPedidosCerrados();//muestra la cola de pedidos cerrados
            aux.getDato().mostrarColaPedidosListosParaEntregar();
            
            aux = aux.getSig();
        }
       
       
    }
     
     public int MaxCantidadProductosParaEntregar()//este metodo me devuelve el maximo de columnas que tengo que crear 
    {
    
        int maxCantidad=0;
        NodoCliente aux=this.getPrimero();
        
       while(aux!=null)
       {
           NodoPedido nodo=aux.getDato().ColapedidosListosParaRetirar.getInicio();
           while(nodo!=null)
           {
              int cant= nodo.getPedido().getCantidadProductoCantidad();//columnas max 
              if(cant>maxCantidad)
              {
              maxCantidad=cant;
              }
           
           nodo=nodo.getSig();
           }
           
       
       
       aux=aux.getSig();
       }
       
       return maxCantidad;
        
    }
     
     public int MaxCantidadProductosPedidosCerrados()//este metodo me devuelve el maximo de columnas que tengo que crear 
    {
    
        int maxCantidad=0;
        NodoCliente aux=this.getPrimero();
        
       while(aux!=null)
       {
           NodoPedido nodo=aux.getDato().ColapedidosCerrados.getInicio();
           while(nodo!=null)
           {
              int cant= nodo.getPedido().getCantidadProductoCantidad();//columnas max 
              if(cant>maxCantidad)
              {
              maxCantidad=cant;
              }
           
           nodo=nodo.getSig();
           }
           
       
       
       aux=aux.getSig();
       }
       
       return maxCantidad;
        
    }
     
 public  int buscarelementomatrizFila(int m[][], int elemento)
{
    
    int posFila=0;
    for(int f=0;f<m.length;f++)
    {
        if(elemento==m[f][0])
        {
            
        posFila=f;
        
        }
    
    }
    
   
    
    
    return posFila;
}
 
  public  int buscarelementomatrizColumna(int m[][], int elemento)
{
    
    int posCol=0;
    for(int c=0;c<m[0].length;c++)
    {
        if(elemento==m[0][c])
        {
            
        posCol=c;
        
        }
    
    }
    
   
    
    
    return posCol;
}
  
  
    
  
   
    
}
