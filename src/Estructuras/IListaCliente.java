/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;
import Clases.Cliente;
import Nodos.NodoCliente;


/**
 *
 * @author lucas
 */
public interface IListaCliente {
     public Retorno esVacia();

    public Retorno vaciar();

    public Retorno cantElementos();

    public Retorno agregarInicio(Cliente dato);

    public Retorno agregarFinal(Cliente dato);

    public Retorno borrarInicio();

    public Retorno borrarFin();

    public Retorno borrarElemento(String ci);

    public Retorno buscarelemento(String ci);

    public NodoCliente obtenerCliente(String ci);

  public Retorno agregarOrd(Cliente dato);

    public Retorno mostrar();
}
