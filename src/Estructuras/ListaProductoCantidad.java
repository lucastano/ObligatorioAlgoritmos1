/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Clases.Cliente;
import Clases.Producto;
import Nodos.NodoCliente;

import Nodos.NodoProductoCantidad;

/**
 *
 * @author lucas
 */
public class ListaProductoCantidad implements IListaProductoCantidad {
    
    NodoProductoCantidad primero;
    NodoProductoCantidad ultimo;
    int cantidad=0;
    int totalProductos;
    
    public ListaProductoCantidad()
    {
    this.totalProductos=0;
    }
    public void setPrimero(NodoProductoCantidad prodcant){
    
        this.primero=prodcant;
        
    }
    public void setUltimo(NodoProductoCantidad prodcant){
    
        this.ultimo=prodcant;
        
    }
    
    public NodoProductoCantidad getPrimero()
    {
    return this.primero;
    }
    
    public int getCantidad()
    {
    return this.cantidad;
    }
    
    public int getTotalProductos()
    {
    return this.totalProductos;
    }
    
    public void setTotalProductos(int cantidad)
    {
    
        this.totalProductos+=cantidad;
        
    }
    
    
    
    

    @Override
    public Retorno esVacia() {
        Retorno ret=new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
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
    
    
    //PROBAR AGREGAR ORDENADA
     @Override
    public Retorno agregarOrd(Producto prod, int cantidad) {
        
    Retorno ret = new Retorno(Retorno.Resultado.OK);

    ret.valorbooleano = false;

    NodoProductoCantidad prodcant=new NodoProductoCantidad(prod,cantidad);

    if (this.esVacia().valorbooleano) { // Si la lista está vacía, agrega el nuevo nodo al inicio
        this.agregarInicio(prod,cantidad);

        
        this.cantidad++;
        ret.valorbooleano = true;

    } else {

        NodoProductoCantidad actual = this.primero; 
        NodoProductoCantidad anterior = null; 
        
        while (actual != null && actual.getProducto().getNombre().toUpperCase().compareTo(prodcant.getProducto().getNombre().toUpperCase()) < 0) {

            anterior = actual;

            actual = actual.getSig();

        }

        
        if (anterior == null) { 
            this.agregarInicio(prod,cantidad);
            this.cantidad++;
            

            ret.valorbooleano = true;

        } else {

            prodcant.setSig(actual);

            anterior.setSig(prodcant);
            this.cantidad++;
           

            ret.valorbooleano = true;

        }

    }

    return ret; 
    }

    @Override
    public Retorno agregarInicio(Producto prod,int cantidad) {
        Retorno ret=new Retorno(Retorno.Resultado.OK);
        NodoProductoCantidad prodcant= new NodoProductoCantidad(prod,cantidad);
        if(this.esVacia().valorbooleano)
        {
        
            this.setPrimero(prodcant);
            this.setUltimo(prodcant);
            //this.setTotalProductos(cantidad);
            this.cantidad++;
            
        }
        else
        {
        
            prodcant.setSig(primero);
            this.setPrimero(prodcant);
            this.cantidad++;
            
        
        }
        this.setTotalProductos(cantidad);
        ret.valorbooleano=true;
        return ret;
    }

    @Override
    public Retorno agregarFinal(Cliente dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno borrarInicio() {
         Retorno ret = new Retorno(Retorno.Resultado.OK);
          this.totalProductos=this.totalProductos-this.primero.getCantidad();
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
         this.totalProductos=this.totalProductos-this.primero.getCantidad();
        if(!this.esVacia().valorbooleano)
        {
            if(this.primero==this.ultimo)
            {
            
                this.primero=null;
                this.ultimo=null;
                
            }
            else
            {
            
                NodoProductoCantidad aux=this.primero;
                while(aux.getSig()!=this.ultimo)
                {
                aux=aux.getSig();
                }
                aux.setSig(null);
                this.setUltimo(aux);
                
            }
            ret.valorbooleano=true;
        
        }
        return ret;
    }

    @Override
    public Retorno borrarElemento(String ci) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno buscarelemento(String ci) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
