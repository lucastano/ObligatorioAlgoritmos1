/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Estructuras;

import Nodos.NodoPedido;

/**
 *
 * @author lucas
 */
public interface IColaPedidosParaEntregar {
    public void encolar (NodoPedido nodo);
    public void desencolar();
    public boolean esVacia();
    public boolean esLlena();
    public int elementos();
    public NodoPedido frente();
    public void mostrarColaPedidosListosParaEntregar();
    public void mostrarREC(NodoPedido nodo);
    
}
