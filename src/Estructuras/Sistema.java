 package Estructuras;


import Clases.Cliente;
import Clases.Pedido;
import Clases.Producto;
import Nodos.NodoCliente;
import Nodos.NodoPedido;
import Nodos.NodoProducto;
import Nodos.NodoProductoCantidad;




public class Sistema implements IObligatorio {
    int maxUnidades;
    ListaCliente listaClientes;
    ListaProducto listaProductos;
    ListaPedidos listaPedidosAbiertos;
    ListaPedidosCerrados listaPedidosCerrados;
    ListaPedidosParaEntregar listosParaEntregar;
    
    @Override
    public Retorno crearSistemaDeAutoservicio(int maxUnidadesDePedido) {
        Retorno ret=new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if(maxUnidadesDePedido>3){
        this.maxUnidades=maxUnidadesDePedido;
        this.listaClientes= new ListaCliente();
        this.listaProductos=new ListaProducto();
        this.listaPedidosAbiertos= new ListaPedidos();
        this.listaPedidosCerrados= new ListaPedidosCerrados();
        this.listosParaEntregar=new ListaPedidosParaEntregar();
        ret.resultado=Retorno.Resultado.OK;
        ret.valorbooleano=true;
        
        
        }
        else
        {
        ret.resultado=Retorno.Resultado.ERROR_1;
            ret.valorbooleano=false;
        }
        
        return ret;
    }
    
     
    @Override
    public Retorno agregarCliente(String nombre, String ci, int tel) {
        
        Retorno ret=new Retorno( Retorno.Resultado.ERROR_1);
        Cliente cli=new Cliente(nombre,ci,tel);
        if(!this.listaClientes.buscarelemento(cli.getCi()).valorbooleano)
        {
        
            this.listaClientes.agregarOrd(cli);
            
            ret.resultado=Retorno.Resultado.OK;
        
        }
         else
        {
         ret.resultado=Retorno.Resultado.ERROR_1;
            
            
        }
        
        return ret;
    }

    @Override
    public Retorno eliminarCliente(String ci) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        if(this.listaClientes.buscarelemento(ci).valorbooleano)
        {
        
           this.listaClientes.borrarElemento(ci);
           ret.resultado=Retorno.Resultado.OK;
           ret.valorbooleano=true;
        }
         else
        {
         ret.resultado=Retorno.Resultado.ERROR_1;
            
            
        }
       
      return ret;
    }

    @Override
    public Retorno agregarProducto(String nombre, String descripcion) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Producto prod=new Producto(nombre,descripcion);
        if(!this.listaProductos.buscarelemento(prod.getNombre()).valorbooleano)
        {
        
           // this.listaProductos.agregarFinal(prod);
            this.listaProductos.agregarOrd(prod);
            ret.resultado=Retorno.Resultado.OK;
        
        }
         else
        {
         ret.resultado=Retorno.Resultado.ERROR_1;
            
            
        }
        return ret;
    }

    @Override
    public Retorno eliminarProducto(String nombre) {
        Retorno ret=new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        if(this.listaProductos.buscarelemento(nombre).valorbooleano)
        {
        
            this.listaProductos.borrarElemento(nombre);
            ret.resultado=Retorno.Resultado.OK;
            ret.valorbooleano=true;
        
        }
        else
        {
         ret.resultado=Retorno.Resultado.ERROR_1;
            
            
        }
        return ret;
    }

    @Override
    public Retorno altaStockProducto(int nroProducto, int unidades) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
     if(this.listaProductos.buscarProductoPorNumero(nroProducto).valorbooleano)
     {
     
        if(this.listaProductos.modificarStockProducto(nroProducto, unidades).valorbooleano)
        {
        ret.valorbooleano=true;
        ret.resultado=Retorno.Resultado.OK;
        }
        else
        {
        
            ret.resultado=Retorno.Resultado.ERROR_2;
            
        }
         
     
     }else
     {
     ret.resultado=Retorno.Resultado.ERROR_1;
     }
        return ret;
    }

    @Override
    public Retorno aperturaDePedido(String ciCliente) {
        
        Retorno ret=new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        //primero deberia buscar pedidos abiertos con ese cliente, por el momento lo dejamos
        NodoCliente nodoBuscado=this.listaClientes.obtenerCliente(ciCliente);
        if(nodoBuscado == null)
        {
        ret.resultado=Retorno.Resultado.ERROR_1;// no existe cliente 
        ret.valorbooleano=false;
        }//falta validar si cliente ya tiene un pedido abierto  COLAPEDIDOSABIERTOS
        else if(nodoBuscado.getDato().ColapedidosAbiertos.getCantidad()>0)// EL CLIENTE YA TIENE UN PEDIDO ABIERTO
        {
            ret.resultado=Retorno.Resultado.ERROR_2;
            ret.valorbooleano=false;
        
            System.out.println("Ya tiene 1 pedido abierto");
            
        
        }
        else
        {
            
            Pedido pedidoCliente=new Pedido(nodoBuscado.getDato());
            this.listaPedidosAbiertos.agregarOrd(pedidoCliente);
            //agregar a cola pedidos abiertos de cliente
            NodoPedido nodo=new NodoPedido(pedidoCliente);
            nodoBuscado.getDato().ColapedidosAbiertos.encolar(nodo);
//            nodoBuscado.getDato().pedidosAbiertos.mostrarREC(nodo);
            
            ret.resultado=Retorno.Resultado.OK;
            ret.valorbooleano=true;
        }
        
        return ret;
        
     
    }

    @Override
    public Retorno agregarProductoAPedido(String ciCliente, int nroProducto, int unidades) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        NodoPedido pedidoBuscado=this.listaPedidosAbiertos.obtenerPedido(ciCliente);
        //que pasa si le pasamos una cedula de cliente que no tiene pedidos?
        
        if(!listaClientes.buscarelemento(ciCliente).valorbooleano)
        {//si NO existe cliente en lista de clientes 
            
            ret.resultado=Retorno.Resultado.ERROR_1; // no existe cliente con esa cedula
            ret.valorbooleano=false;
            return ret;
        
        }
        if(!listaProductos.buscarProductoPorNumero(nroProducto).valorbooleano)
        {
            ret.resultado=Retorno.Resultado.ERROR_2; // no existe el numero de producto solicitado
            ret.valorbooleano=false;
             return ret;
        
        }
        if(unidades>this.maxUnidades)
        {
            ret.resultado=Retorno.Resultado.ERROR_3; // unidades superan el maximo de sistema
            ret.valorbooleano=false;
         return ret;
        }
        if(unidades<=0)
        {
            ret.resultado=Retorno.Resultado.ERROR_4; // unidades es negativo o 0 
            ret.valorbooleano=false;
         return ret;
        }
        if(listaProductos.obtenerStockProducto(nroProducto)<unidades)
        {
            ret.resultado=Retorno.Resultado.ERROR_5; // stock  
            ret.valorbooleano=false;
            return ret;
        
        }
        Producto producto=listaProductos.obtenerProductoPorNumero(nroProducto);
        NodoPedido pedidoCliente=listaPedidosAbiertos.obtenerPedido(ciCliente);
        pedidoCliente.getPedido().agregarProductoCantidad(producto, unidades);
        pedidoCliente.getPedido().mostrarProductoCantidad();
        ret.resultado=Retorno.Resultado.OK;
        ret.valorbooleano=true;
        return ret;
        
    }

   
    @Override
    public Retorno deshacerPedido(String ciCliente, int cantAccionesDeshacer) {
       Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
       ret.valorbooleano=false;
       if(!this.listaClientes.buscarelemento(ciCliente).valorbooleano)
       {
           //no existe un cliente con esa cedula
           ret.resultado=Retorno.Resultado.ERROR_1;
           ret.valorbooleano=false;
       
           return ret;
       }
       else
       {
           if(cantAccionesDeshacer<=0)
           {
               //cantidad de acciones negativo o 0 
               ret.resultado=Retorno.Resultado.ERROR_2;
               ret.valorbooleano=false;
               return ret;
           
           }
           
           NodoPedido pedido=this.listaPedidosAbiertos.obtenerPedido(ciCliente);
           
              
           if(pedido.getPedido().getCantidadProductoCantidad()<cantAccionesDeshacer)// si la cantidad de acciones supera la cantidad de inserciones de producto cantidad
           {
               ret.resultado=Retorno.Resultado.ERROR_3;
               ret.valorbooleano=false;
                    
               return ret;
           
           }
           else
               {
                   pedido.getPedido().eliminarProductoCantidad(cantAccionesDeshacer);
                   //elimina desde inicio de productocantida, cuando se agrega tambien agrega desde inicio y no ordenado 
                   //muestra producto cantidad del pedido que deshicimos 
                   // en caso de que no tenga ningun producto cantidad , solo muestra la cantidas de productos, que es cero 
                   pedido.getPedido().mostrarProductoCantidad();
                   ret.resultado=Retorno.Resultado.OK;
                   ret.valorbooleano=true;
               
               }
           
       
           
       
       }
       
       return ret;
       
    }

    @Override
    public Retorno cerrarPedido(String ciCliente) {
        Retorno ret= new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        if(!this.listaClientes.buscarelemento(ciCliente).valorbooleano)
        {
            //cliente no existe 
            ret.resultado=Retorno.Resultado.ERROR_1;
            ret.valorbooleano=false;
         
        }
        else
        {
            if(!this.listaPedidosAbiertos.tienePedidos(ciCliente).valorbooleano)
            {
            
                ret.resultado=Retorno.Resultado.ERROR_2;
                ret.valorbooleano=false;
            
            }
            else
            {
                //obtengo pedido NodoPedido
                NodoPedido pedidoACerrar=listaPedidosAbiertos.obtenerPedido(ciCliente);
                //agrego en el inicio la lista 
                this.listaPedidosCerrados.agregarInicio(pedidoACerrar.getPedido());
                this.listaPedidosAbiertos.borrarElemento(ciCliente);
                pedidoACerrar.getPedido().getCliente().cerrarPedidoCliente();
               
                
                ret.resultado=Retorno.Resultado.OK;
                ret.valorbooleano=true;
            }
        
        
        
        
        }
        return ret;
    }
    
    

    @Override
    //NOS FALTA SABER QUE ERROR PASAR EN CASO DE QUE LA LISTA DE PEDIDOS CERRADOS ESTE VACIA. 
    public Retorno procesarPedido(int cantPedidos) {
        Retorno ret= new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano=true;
        
        if(!this.listaPedidosCerrados.esVacia().valorbooleano)
        {
        
            if(cantPedidos<=0)
            {
            ret.resultado=Retorno.Resultado.ERROR_1;
            ret.valorbooleano=false;
            }
            else if(cantPedidos>this.listaPedidosCerrados.getCantidad())
            {
            ret.resultado=Retorno.Resultado.ERROR_2;
            ret.valorbooleano=false;
            }
            else
            {
                int i =1;
                while(i<=cantPedidos)
                {
                    NodoPedido pedido=this.listaPedidosCerrados.getUltimo();
                    this.listosParaEntregar.agregarInicio(pedido.getPedido());
                    this.listaPedidosCerrados.borrarFin();
                    pedido.getPedido().getCliente().procesarPedidoCliente();
                    i++;
                }
                
                ret.resultado=Retorno.Resultado.OK;
                ret.valorbooleano=true;
            
            
            
            }
        
        }
        return ret;
    }

    @Override
    public Retorno listarClientes() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        if(!this.listaClientes.esVacia().valorbooleano)
        {
          this.listaClientes.mostrar();
          ret.resultado=Retorno.Resultado.OK;
          ret.valorbooleano=true;
          
        }
        
        return ret;
        //ya funciona , lista clientes por orden alfabetico , no se utilizo ningun sort, ya que lo agregamos ordenado desde un principio 
    }

    @Override
    public Retorno listarProductos() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        this.listaProductos.seleccionSort();
        this.listaProductos.mostrarRec();
        return ret;
    }

    @Override
    public Retorno listarPedidosAbiertos() {
        Retorno ret= new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano=true;
        this.listaPedidosAbiertos.mostrar();
        return ret;
    }

    @Override
    public Retorno pedidosCerradosDeClientes(String ci) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorbooleano=false;
        
        if(!this.listaClientes.buscarelemento(ci).valorbooleano)
        {
            ret.resultado=Retorno.Resultado.ERROR_1;
            ret.valorbooleano=false;
        
        }
        else
        {
            NodoCliente cliente=this.listaClientes.obtenerCliente(ci);
            cliente.getDato().mostrarColaPedidosCerrados();
            ret.resultado=Retorno.Resultado.OK;
            ret.valorbooleano=true;
        
        }
        
        return ret;
    }

    @Override
    public Retorno productosParaEntregar() {
        Retorno ret= new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano=true;
        this.listosParaEntregar.mostrarRec();
        return ret;
    }

    @Override
    public Retorno reporteDePedidosSolicitadosXCliente() {
     Retorno ret= new Retorno(Retorno.Resultado.OK);

     int filas =0;
     int columnas =0;
     
     
     int []vClientes=new int [this.listaClientes.cantidad];
     //llenamos vector de clientes con su cedula
     NodoCliente nodo=this.listaClientes.getPrimero();
     int pos=0;
     while(nodo!=null)
     {
         int cedula=Integer.parseInt(nodo.getDato().getCi());
         vClientes[pos]=cedula;
         
     
         pos++;
     nodo=nodo.getSig();
     }
    
     int []vProductos=new int[this.listaProductos.cantidad];

     NodoProducto producto=this.listaProductos.getPrimero();
     int posProd=0;
     while(producto!=null)
     {
         vProductos[posProd]=producto.getDato().getNumero();
         
     posProd++;
     producto=producto.getSig();
     }
     
     //CREAMOS LA MATRIZ 
     
     int [][]m=new int [vClientes.length+1][vProductos.length+1];
     //llenamos filaproductos de valor cero
    for(int f=0;f<m.length;f++)
    {
        for(int c=0;c<m[0].length;c++)
         {
             m[f][c]=0;
    
    
         }
    }
     //llenamos fila 0
    for(int i=0;i<m.length+1;i++)
    {
        m[0][i+1]=vProductos[i];
    
    
    }
    //llenamos columna 0
    for (int i = 1; i < vClientes.length+1; i++) {
    m[i][0] = vClientes[i - 1];
      }
    
     //LLENAMOS LA MATRIZ, LO VOY A SOLUCIONAR CON METODOS , un METODO QUE DEVUELVE LA POSICION DE LA CEDULA DE CLIENTE 
     // EN LA FILA DE LA MATRIZ , Y OTRO QUE ME DEVUELVE LA POSICION (COLUMNA) DEL PRODUCTO
     
   NodoPedido nodop=this.listaPedidosCerrados.getPrimero();
   
   
   while(nodop!=null)
   {
        int posicionCliente=0;//aca va a ir la posicion del cliente en la matriz 
        
       int cedulacli=Integer.parseInt(nodop.getPedido().getCliente().getCi());
       //devuelve la fila en donde esta el cliente
       //si es cero no sirve
       int posicionEnFilaMatriz=this.listaClientes.buscarelementomatrizFila(m, cedulacli);
       
       if(posicionEnFilaMatriz>0)
       {
           //pude obtener la posicion del cliente en la matriz 
        posicionCliente=posicionEnFilaMatriz;
       
       }
       
       //ahora recorrer la lista de productoCantidad de ese cliente 
       
      NodoProductoCantidad nodopc= nodop.getPedido().getProductoCantidad().getPrimero();
      while(nodopc!=null)
      {
          int posicionEnMatriz=0; //aca va a ir  la posicion del producto en la matriz 
          int numeroProducto=nodopc.getProducto().getNumero();
          posicionEnMatriz=this.listaClientes.buscarelementomatrizColumna(m, numeroProducto);
          
          m[posicionCliente][posicionEnMatriz]=m[posicionCliente][posicionEnMatriz]+nodopc.getCantidad();
          
          
      
      nodopc=nodopc.getSig();
      }
       
       
       
   nodop=nodop.getSig();
   }
   
   //LISTA DE PEDIDOS LISTOS PARA ENTREGAR 
    NodoPedido nodopedido=this.listosParaEntregar.getPrimero();
   
   
   while(nodopedido!=null)
   {
        int posicionCliente=0;//aca va a ir la posicion del cliente en la matriz 
        
       int cedulacli=Integer.parseInt(nodopedido.getPedido().getCliente().getCi());
       //devuelve la fila en donde esta el cliente
       //si es cero no sirve
       int posicionEnFilaMatriz=this.listaClientes.buscarelementomatrizFila(m, cedulacli);
       
       if(posicionEnFilaMatriz>0)
       {
           //pude obtener la posicion del cliente en la matriz 
        posicionCliente=posicionEnFilaMatriz;
       
       }
       
       //ahora recorrer la lista de productoCantidad de ese cliente 
       
      NodoProductoCantidad nodoprodcant= nodopedido.getPedido().getProductoCantidad().getPrimero();
      while(nodoprodcant!=null)
      {
          int posicionEnMatriz=0; //aca va a ir  la posicion del producto en la matriz 
          int numeroProducto=nodoprodcant.getProducto().getNumero();
          posicionEnMatriz=this.listaClientes.buscarelementomatrizColumna(m, numeroProducto);
          
          m[posicionCliente][posicionEnMatriz]=m[posicionCliente][posicionEnMatriz]+nodoprodcant.getCantidad();
          
          
      
      nodoprodcant=nodoprodcant.getSig();
      }
       
       
       
   nodopedido=nodopedido.getSig();
   }
   
     
     
     
      System.out.println("MOSTRAMOS LA MATRIZ CON datos ");
     
     for (int i = 0; i < m.length; i++) {
    for (int j = 0; j < m[0].length; j++) {
        System.out.print(m[i][j] + "\t");
    }
    System.out.println();
   }
     
      return ret;
    }

    

}
