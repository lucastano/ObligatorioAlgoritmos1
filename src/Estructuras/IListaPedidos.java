/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Clases.Pedido;


/**
 *
 * @author lucas
 */
public interface IListaPedidos {
    
   

//    public Retorno vaciar();
//
//    public Retorno cantElementos();
    public Retorno esVacia();
    
    public Retorno agregarInicio(Pedido dato);

    public Retorno agregarFinal(Pedido dato);
    
    public Retorno agregarOrd(Pedido dato); 
    
    public Retorno borrarElemento(String ciCliente);
    
    public Retorno borrarFin();
    
    public Retorno borrarInicio();

//    public Retorno borrarInicio();// estas fueron copiadas y pegadas de otra interface 
//
//    public Retorno borrarFin();// estas fueron copiadas y pegadas de otra interface 
//
//    public Retorno borrarElemento(String nombre);// estas fueron copiadas y pegadas de otra interface 
//
//    public Retorno buscarelemento(String nombre);// estas fueron copiadas y pegadas de otra interface 
//    
//    public Retorno buscarProductoPorNumero(int numero);// estas fueron copiadas y pegadas de otra interface 
//    
//    public Retorno modificarStockProducto(int numero,int unidades);// estas fueron copiadas y pegadas de otra interface 
//    
}
