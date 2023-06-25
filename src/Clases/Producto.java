/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author lucas
 */
public class Producto {
    String nombre;
    String descripcion;
    static int ultimoNumero=0;
    int numeroProducto;
    int stock;// stock por el momento va en cero ya que todavia no hay que implementar la funcionalidad de agregar stock al producto
    boolean tienePedidos;//por el momento va en false ya que todavia no hay que implementar la funcionalidad agregar pedidos 
    
    public Producto(String nombre,String descripcion)
    {
    this.nombre=nombre;
    this.descripcion=descripcion;
    this.ultimoNumero++;
    numeroProducto=ultimoNumero;
    this.stock=0;// stock por el momento va en cero ya que todavia no hay que implementar la funcionalidad de agregar stock al producto
    this.tienePedidos=false; //por el momento va en false ya que todavia no hay que implementar la funcionalidad agregar pedidos 
    }
    
    public String getNombre()
    {
    return this.nombre;
    }

    public int getNumero()
    {
    return this.numeroProducto;
    }
    
    public void setStock(int stock)
    {
    this.stock=this.stock+stock;
    }
    public void restarStock(int cantidad)
    {
        this.stock=stock-cantidad;
    
    }
   
    public int getStock()
    {
    return this.stock;
    }
}
