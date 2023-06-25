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
public class ColaPedidosAbiertos implements IColaPedidosAbiertos {
    
    private NodoPedido inicio; 
    private NodoPedido fin;
    private int cantidad;
    
    
   
    public ColaPedidosAbiertos()
    {
     this.cantidad=0;
    }
    
    public void setInicio(NodoPedido nodo)
    {
    
        this.inicio=nodo;
    
    }
    public void setFin(NodoPedido nodo)
    {
    
        this.fin=nodo;
    
    }
    public void setCantidad(int cantidad)
    {
    this.cantidad=cantidad;
    // verificar 
    }
    
    public int getCantidad()
    {
    return this.cantidad;
    }
    
    public NodoPedido getInicio()
    {
    return this.inicio;
    }
    
    public NodoPedido getFin()
    {
    return this.fin;
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
        if(!this.esVacia()){
            return this.getInicio();
        }
        return null;
    }

    @Override
    public void mostrarCola() {
        
       
        
            System.out.println("COLA PEDIDOS ABIERTOS");
           NodoPedido mostrar = getInicio();
           while(mostrar != null) {
               System.out.println("Pedido abierto");
            System.out.println("Numero de pedido: "+mostrar.getPedido().getNumeroPedido());
            mostrar.getPedido().mostrarProductoCantidad();
            
            mostrar = mostrar.getSig();
           }
           
        
    }

    @Override
    public void mostrarREC(NodoPedido nodo) {
         if(nodo!=null){
             System.out.println("pedido de cliente:");
            System.out.println(nodo.getPedido().getCliente().getNombre());
            mostrarREC(nodo.getSig());
        }
    }
    
    
}
