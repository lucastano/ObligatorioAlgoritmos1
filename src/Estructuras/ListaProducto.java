/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Clases.Producto;

import Nodos.NodoProducto;

/**
 *
 * @author lucas
 */
public  class ListaProducto implements IListaProducto {
    
    NodoProducto primero;
    NodoProducto ultimo;
    int cantidad;
    
    public ListaProducto(){
        this.cantidad=0;
    }
    public void setPrimero(NodoProducto producto)
    {
    this.primero=producto;
    }
    public NodoProducto getPrimero()
    {
    return this.primero;
    }
    
    public void setUltimo(NodoProducto producto)
    {
    this.ultimo=producto;
    }
    public NodoProducto getUltimo()
    {
    return this.ultimo;
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
    public Retorno agregarOrd(Producto dato)
    {
    Retorno ret = new Retorno(Retorno.Resultado.OK);

    ret.valorbooleano = false;

    NodoProducto producto = new NodoProducto(dato);

    if (this.esVacia().valorbooleano) { 
        this.agregarInicio(dato);
        cantidad++;
        ret.valorbooleano = true;

    } else {

        NodoProducto actual = this.getPrimero(); 
        NodoProducto anterior = null; 
        
        while (actual != null && actual.getDato().getNombre().toUpperCase().compareTo(producto.getDato().getNombre().toUpperCase()) < 0) {

            anterior = actual;
           
            actual = actual.getSig();

        }

        
        if (anterior == null) { 
            this.agregarInicio(dato);
            cantidad++;

            ret.valorbooleano = true;

        } else {

            producto.setSig(actual);

            anterior.setSig(producto);
            cantidad++;

            ret.valorbooleano = true;

        }

    }

    return ret; 
    }

    @Override
    public Retorno agregarInicio(Producto dato) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoProducto nuevoProducto= new NodoProducto(dato);
        
        if(this.esVacia().valorbooleano)
        {
        this.primero=nuevoProducto;
        this.ultimo=nuevoProducto;
        }
        else
        {
            nuevoProducto.setSig(primero);
            this.primero=nuevoProducto;
        
        }
        ret.valorbooleano=true;
        return ret;
    }

    @Override
    public Retorno agregarFinal(Producto dato) {
       Retorno ret=new Retorno(Retorno.Resultado.OK);
       NodoProducto nuevoProducto=new NodoProducto(dato);
       if(this.esVacia().valorbooleano)
       {
           this.setPrimero(nuevoProducto);
           this.setUltimo(nuevoProducto);
       
       }
       else
       {
       
           ultimo.setSig(nuevoProducto);
           ultimo=nuevoProducto;
           
       }
       ret.valorbooleano=true;
       return ret;
    }

    @Override
    public Retorno borrarInicio() {
        Retorno ret=new Retorno(Retorno.Resultado.ERROR_1);
        ret.valorbooleano=false;
        if(!this.esVacia().valorbooleano)
        {
        
            if(this.primero==this.ultimo)
            {
            
                this.primero=null;
                this.ultimo=null;
                
            }
            else
            {
            this.primero=this.primero.getSig();
                ret.valorbooleano=true;
                
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
                
            }
            else
            {
            
                NodoProducto aux=this.primero;
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
    public Retorno borrarElemento(String nombre)
    {
    
        return borrarElemento(nombre,this.primero);
        
    }
    
    public Retorno borrarElemento(String nombre, NodoProducto nodo) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano=false;
        
        if(!this.esVacia().valorbooleano)
        {
        
            if(this.getPrimero().getDato().getNombre().toUpperCase().equals(nombre.toUpperCase()))
            {
            
                this.borrarInicio();
                cantidad--;
                ret.valorbooleano=true;
                return ret;
                
            }
            else if(this.getUltimo().getDato().getNombre().toUpperCase().equals(nombre.toUpperCase()))
            {
            
                this.borrarFin();
                cantidad--;
                ret.valorbooleano=true;
                return ret;
                
            }
            else if(nodo.getSig().getDato().getNombre().toUpperCase().equals(nombre.toUpperCase()))
            {
            
                nodo.setSig(nodo.getSig().getSig());
                cantidad--;
                ret.valorbooleano=true;
                return ret;
                
            }
            else
            {
                return borrarElemento(nombre,nodo.getSig());
            
            }
            
        }
        
       
        return ret;
        
    }

     @Override
    public Retorno buscarelemento(String nombre ) {
     return buscarElementoRec(nombre,this.getPrimero());
    }
    
    public Retorno buscarElementoRec(String nombre, NodoProducto nodo)
    {
    Retorno ret = new Retorno(Retorno.Resultado.OK);
    ret.valorbooleano=false;
    if(nodo!=null){
    
    if(nodo.getDato().getNombre().toUpperCase().equals(nombre.toUpperCase()))
    {
    
        
        ret.valorbooleano=true;
        return ret;
    }
    else
    {
    
        return buscarElementoRec(nombre, nodo.getSig());
        
    }
    
    }
    return ret;
      
    }

   
    @Override
    public Retorno mostrar() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        NodoProducto aux = this.getPrimero();
        
        while(aux!=null)
        {
            System.out.println("Numero producto: "+aux.getDato().getNumero()+" Nombre: "+aux.getDato().getNombre()+" Stock: "+aux.getDato().getStock());
        
            
            
        aux=aux.getSig();
        }
        
        return ret;
    }
    
    
    @Override
    public Retorno mostrarRec()
    {
        
        return mostrarRec(this.getPrimero());
        
    
    }
    
    public Retorno mostrarRec( NodoProducto producto)
    {
        Retorno ret=new Retorno(Retorno.Resultado.OK);
        if(producto==null)
        {
        return ret;
        }
        else
        {
        
            System.out.println("ID: "+producto.getDato().getNumero()+"  Nombre: "+producto.getDato().getNombre()+"  Stock: "+producto.getDato().getStock());
            return mostrarRec(producto.getSig());
            
        }
        
    
    }

    

    @Override
    public Retorno buscarProductoPorNumero(int numero) {
        
        return buscarProductoPorNumero(numero,this.getPrimero());
        
    }
    //AGREGAR A INTERFACE IListaProducto
   
    
    public Retorno buscarProductoPorNumero(int numero,NodoProducto nodo)
    {
        Retorno ret=new Retorno(Retorno.Resultado.ERROR_1);
        ret.valorbooleano=false;
        if(nodo!=null)
        {
        
            if(nodo.getDato().getNumero()==numero)
            {
            ret.resultado=Retorno.Resultado.OK;
            ret.valorbooleano=true;
            }
            else
            {
            
                return buscarProductoPorNumero(numero,nodo.getSig());
                
            }
        
        
        }
    
    
        return ret;
    } 
    @Override
    public Producto obtenerProductoPorNumero(int numero)
    {
        Producto prod=null;
        NodoProducto nodo=this.getPrimero();
        while(nodo!=null)
        {
            if(nodo.getDato().getNumero()==numero)
            {
            prod=nodo.getDato();
            }
            nodo=nodo.getSig();
        
        }
        return prod;
    
    }

    @Override
    
    public Retorno modificarStockProducto(int numero, int unidades) {
        return modificarStockProducto(numero,unidades,this.getPrimero());
    }
    public Retorno modificarStockProducto(int numero, int unidades, NodoProducto nodo) {
        Retorno ret=new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        
       if(nodo!=null)
       {
       
           if(nodo.getDato().getNumero()==numero)
           {
           
               if(unidades<=0)
               {
                   
                   ret.resultado=Retorno.Resultado.ERROR_2;
                   return ret;
               
               }else
               {
                   nodo.getDato().setStock(unidades);
                   ret.valorbooleano=true;
                   ret.resultado=Retorno.Resultado.OK;
               
               }
               
           }
           else
           {
           return modificarStockProducto(numero,unidades,nodo.getSig());
           }
       
       }
       
       return ret;
        
    }
    
    // agregar a la interface IListaProducto
    public int obtenerStockProducto(int numero)
    {
        int stock=-1;
        NodoProducto nodo=this.getPrimero();
        boolean esta=false;
        while(nodo!=null &&!esta)
        {
           if(nodo.getDato().getNumero()==numero) 
           {
               
           esta=true;
           stock= nodo.getDato().getStock();
           
           }
            
        nodo=nodo.getSig();
        }
    return stock;
    }
    
    
    public void mostrarDetallesProducto()
    {
        NodoProducto nodo=this.getPrimero();
        
        while(nodo!=null)
        {
           
            System.out.println(nodo.getDato().getNumero()+"-"+nodo.getDato().getNombre()+"-stock: "+nodo.getDato().getStock());
            nodo=nodo.getSig();
        
        }
    
    
    }
    
    public void seleccionSort()
    {
    
        NodoProducto indice= this.primero;
        NodoProducto hasta = this.ultimo;
        while(indice !=null)
        {
        
            //obtiene el minimo
            NodoProducto minimo= minimoLista(indice,hasta);
            
            //se guarda el dato de la primera posicion
            Producto datoAux= indice.getDato();
            //a la primera posicion le setea el dato del minimo
            indice.setDato(minimo.getDato());
            //al minimo le setea el dato aux 
            minimo.setDato(datoAux);
            //aumenta indice
            indice=indice.getSig();
            
        
        }
    
    }
    
    public NodoProducto minimoLista(NodoProducto desde, NodoProducto hasta)
    {
    
        NodoProducto aux=desde;
        NodoProducto minimo=desde;
        int valorminimo=Integer.MAX_VALUE;
        
        while(aux!=null)
        {
        
            if(aux.getDato().getNumero()<valorminimo)
            {
                valorminimo=aux.getDato().getNumero();
                minimo=aux;
            
            }
            aux=aux.getSig();
        
        }
        
        
        
        return minimo;
        
    }
    
    

   
    
    
    
    
}
