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
public interface IColaPedidosCerrados {
    public void encolar (NodoPedido nodo);
    public void desencolar();
    public boolean esVacia();
    public boolean esLlena();
    public int elementos();
    public NodoPedido frente();
    public void mostrarColaPedidosCerrados();
    public void mostrarREC(NodoPedido nodo);
    
}
