/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Estructuras;

import Clases.Pedido;

/**
 *
 * @author lucas
 */
public interface IListaPedidosCerrados {
    public Retorno esVacia();
    
    public Retorno agregarInicio(Pedido dato);

    public Retorno agregarFinal(Pedido dato);
    
    public Retorno agregarOrd(Pedido dato); 
    
    public Retorno borrarFin();
    
}
