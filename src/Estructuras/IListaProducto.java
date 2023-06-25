/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Estructuras;

import Clases.Producto;
import Nodos.NodoProducto;


/**
 *
 * @author lucas
 */
public interface IListaProducto {
    public Retorno esVacia();

    public Retorno vaciar();

    public Retorno cantElementos();

    public Retorno agregarInicio(Producto dato);

    public Retorno agregarFinal(Producto dato);
    
    public Retorno agregarOrd(Producto dato);

    public Retorno borrarInicio();

    public Retorno borrarFin();

    public Retorno borrarElemento(String nombre);

    public Retorno buscarelemento(String nombre);
    
    public Retorno buscarProductoPorNumero(int numero);
    
    public Producto obtenerProductoPorNumero(int numero);
    
    public Retorno modificarStockProducto(int numero,int unidades);
    public Retorno mostrarRec();
    
    

  

    public Retorno mostrar();
    
}
