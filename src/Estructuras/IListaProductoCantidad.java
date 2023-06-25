/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Clases.Cliente;
import Clases.Producto;

/**
 *
 * @author lucas
 */
public interface IListaProductoCantidad {
     public Retorno esVacia();

    public Retorno vaciar();

    public Retorno cantElementos();

    public Retorno agregarInicio(Producto prod,int cantidad);

    public Retorno agregarFinal(Cliente dato);
    
    public Retorno agregarOrd(Producto prod,int cantidad);

    public Retorno borrarInicio();

    public Retorno borrarFin();

    public Retorno borrarElemento(String ci);

    public Retorno buscarelemento(String ci);

    public Retorno mostrar();
    
}
