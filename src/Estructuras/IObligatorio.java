package Estructuras;

import Estructuras.Retorno;


public interface IObligatorio {
    
    /*
    **************** REGISTRO DE CLIENTES Y PRODUCTOS **************************************
    */
    
    //pre:Unidad maxima de pedidos dato int , debe ser mayor a 3 unidades (no se debe ingresar vacio ningun campo vacio)
    //post: cre el sistema de auto servicio , las listas de clientes y productos
    public Retorno crearSistemaDeAutoservicio(int maxUnidadesDePedido);
     //pre: nombre de cliente y ci string tel int   (no se debe ingresar vacio ningun campo vacio) acepta espacios, cedula debe ser menor a 10 caracteres
    //post:agrega cliente a la lista despues de verificar que ya no se encuentre por ci (no se debe ingresar vacio ningun campo vacio)
    public Retorno agregarCliente(String nombre,String ci,int tel);
     //pre: recibe ci tipo de dato string (no vacio ) verifica espacios 
    //post: verifica que exista en la lista y lo elimina
    public Retorno eliminarCliente(String ci);
     //pre:recibe por parametros un nombre y una descripcion de tipo string  (no se debe ingresar vacio ningun campo vacio) se puede ingresar espacios    
    //post: despues de verificar que no se encuentre en la lista(por su nombre)lo agrega
    public Retorno agregarProducto(String nombre, String descripcion); 
     //pre:recibe nombre tipo de dato string (no vacio) nombre debe ser identicamente igual (incluyendo espacios)      
    //post:verifica que exista en la lista y lo elimina
    public Retorno eliminarProducto(String nombre);
     //pre:recibe un entero que referencia al numero autoincremental de producto y un entero con la cantidad de unidades a incrementar el stock  
    //post:RETORNA  error_1 en caso de que el producto con ese nro no exista , error_2 si las unidades son menor o igual a 0, si todo esta bien retorna OK 
    public Retorno altaStockProducto(int nroProducto, int unidades); 
    
     /*
    **************** GESTIÓN DE PEDIDOS **************************************
    */
    
     //pre:recibe un string que representa la cedula del cliente no vacio.
    //post:retorna error_1 si no existe el cliente y error_2 si el cliente ya tiene pedidos abiertos(solo puede tener 1), OK si pudo abrir el pedido
    public Retorno aperturaDePedido(String ciCliente);
     //pre:  recibe un string con cedula de cliente no vacio , nro producto y unidades de tipo int 
//    post: retorna error_1  En caso de que no exista la ci del cliente, error_2 En caso de que no exista el nro de producto
    // error_3 En caso de que, con la cantidad de unidades indicadas, se supere el máximo de unidades totales permitidas para el pedido
    // error_4 En caso de que las unidades sean <= 0 y error_5 - En caso de que no exista stock para agregar dicha cantidad de unidades. OK Si se puede agregar
    
    public Retorno agregarProductoAPedido(String ciCliente, int nroProducto, int unidades); 
     //pre: recibe un string cedula de cliente no vacio y la cantidad de acciones controla si es cero o supera la cantidad de productos agregados
    //post: si el cliente no existe retorna error_1 , si el numero de acciones es < o igual a 0 , retorna error_2, error_3 si las unidades superar la cantidad de productos agregados
    //ok si pudo deshacer todo bien 
    public Retorno deshacerPedido(String ciCliente, int cantAccionesDeshacer);
     //pre:recibe string cedula de cliente, no vacio , verifica que exciste el cliente    
    //post:retorna error_1 si el cliente no existe, error_2 si el cliente no tiene pedidos abiertos, OK SI PUEDE CERRAR PEDIDO
    //EL PEDIDO CERRADO SE MUEVE A LISTA PEDIDOS CERRADOS, EN CLIENTE, SE MUEVE A LA COLA DE PEDIDOS CERRADOS Y SE DESENCOLA DE LA COLAPEDIDOSABIERTOS
    
    public Retorno cerrarPedido(String ciCliente); 
     //pre:RECIBE un int con la cantidad de pedidos que queremos procesar, se procesa en orden de llegada a la lista 
         
    //post:retorna error_1 si la cantidad de pedidos que pasamos es cero o menor , error_2 en caso de que la cantidad supere los pedidos cerrados, 
    //ok si se puede procesar los pedidos, se toman los ultimos pedidos de la lista de pedidosCerrados, ya que los agregamos por el inicio a la lista.
    //se pasa esos pedidos a la lista de pedidos listos para entregar , en cliente se desencolan de la colapedidoscerrados y se encolan en colapedidosparaentregar
    //
    public Retorno procesarPedido(int cantPedidos); 
    
      /*
    **************** LISTADO Y REPORTES **************************************
    */
    
     //pre: en este caso no se reciben datos por parametros     
    //post: lista los datos de clientes ordenados por orden alfabetico 
    public Retorno listarClientes();
    
    //pre:  en este caso no se reciben datos por parametros   
//    post: se muestran los productos listados por como se fueron agregando , se utiliza selectsort para ordenarlo por numeroproducto(autoincremental),
    //ya que cuando los agregamos , lo hicimos ordenado por orden alfabetico segun su nombre 
    public Retorno listarProductos();
    
     //pre:  en este caso no se reciben datos por parametros   
//    post: se muestra la lista de productos abiertos, con la cantidad de productos del pedido
    public Retorno listarPedidosAbiertos();
    
     //pre:en este caso no se reciben datos por parametros      
    //post:se muestra la colade pedidos cerrados de cada cliente
    public Retorno pedidosCerradosDeClientes(String ci);
    
    //pre:  en este caso no se reciben datos por parametros   
//    post:se muestra la lista de pedidos listos para entregar, de forma recursiva
    public Retorno productosParaEntregar();
    
    //pre: en este caso no se reciben datos por parametros      
    //post:retorna una matriz donde la primera fila a partir de la posicion 1 , se muestra el id de cada producto 
    //en la primera columna a partir de la fila 1 , se muestra la cedula de identidad de cada cliente(dicha cedula debe tener menos de 10 caracteres)
    //se va llenando los campos con la cantidad de cada producto pedido por cada cliente, en caso de no hacer pedido con el producto, el valor es cero 
    public Retorno reporteDePedidosSolicitadosXCliente();
    
}
