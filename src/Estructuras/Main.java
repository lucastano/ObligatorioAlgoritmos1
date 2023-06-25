package Estructuras;




public class Main {

    public static void main(String[] args) {
        
        Sistema obligatorio=new Sistema();
        Prueba p =new Prueba();
        juegoPrueba(obligatorio,p);
        
          p.imprimirResultadosPrueba();
       
        
       
        

    }
    
   
            
   public static void juegoPrueba( Sistema ob,Prueba p) 
    {

        int maxUnidadesDePedido=4;
        //creo autoservicio
       p.ver(ob.crearSistemaDeAutoservicio(maxUnidadesDePedido).resultado, Retorno.Resultado.OK,"se creo sistema con 3 pedidos ");
//    
//     //agrego clientes  
       p.ver(ob.agregarCliente("nicolas","999",345456436).resultado,Retorno.Resultado.OK,"Se agrega cliente con mismo nombre pero diferente ci");
       p.ver(ob.agregarCliente("juan","332",2213212).resultado,Retorno.Resultado.OK," 1 se agrego a juan a la lista de clientes");
       p.ver(ob.agregarCliente("carlos","12112",345456333).resultado,Retorno.Resultado.OK,"se agrego a carlos a la lista de clientes");
       p.ver(ob.agregarCliente("alberto","344221",345456439).resultado,Retorno.Resultado.OK,"Se agrega un cliente Alberto");
       
       // agregamos cliente con una cedula ya existente en la lista 
        p.ver(ob.agregarCliente("oliver","344221",345456436).resultado,Retorno.Resultado.ERROR_1,"Se inteto agregar un cliente duplicado misma ci");
        p.ver(ob.agregarCliente("benito","332",345443236).resultado,Retorno.Resultado.ERROR_1,"Se inteto agregar un cliente duplicado misma ci");
       
      
       p.ver(ob.agregarCliente("esteban","3345",2213212).resultado,Retorno.Resultado.OK,"se agrego a juan a la lista de clientes 1");
       p.ver(ob.agregarCliente("sergio","32222",2213215).resultado,Retorno.Resultado.OK,"se agrego a juan a la lista de clientes 2");
       p.ver(ob.agregarCliente("fernando","481633",29038014).resultado,Retorno.Resultado.OK,"se agrego a juan a la lista de clientes 2");
       // se agregaron clientes con cedula que ya se encuentra en el sistema 
        p.ver(ob.agregarCliente("juan","999",2213212).resultado,Retorno.Resultado.ERROR_1,"se agrego a juan con cedula ya existente");
   
        //agrego productos
      
        
        p.ver(ob.agregarProducto("Red bull", "red bull 250ml").resultado,Retorno.Resultado.OK,"se agrego producto red bull");
        p.ver(ob.agregarProducto("Red bull", "red bull 250ml").resultado,Retorno.Resultado.ERROR_1,"se agrego producto red bull ya existente ");
        p.ver(ob.agregarProducto("Monster", "red bull 350ml").resultado,Retorno.Resultado.OK,"se agrego producto Monster");
        p.ver(ob.agregarProducto("coca cola", "coca cola de 3 l").resultado,Retorno.Resultado.OK,"se agrego producto coca cola");
        p.ver(ob.agregarProducto("doritos", "doritos 250g").resultado,Retorno.Resultado.OK,"se agrego producto doritos");
        p.ver(ob.agregarProducto("Cafe", "cafe colombia 1 kg").resultado,Retorno.Resultado.OK,"se agrego producto cafe colombia");
        p.ver(ob.agregarProducto("Pepsi", "Pepsi Max 355ml").resultado, Retorno.Resultado.OK, "Se agregó el producto Pepsi");
        p.ver(ob.agregarProducto("Fanta", "Fanta Naranja 1L").resultado, Retorno.Resultado.OK, "Se agregó el producto Fanta");
        p.ver(ob.agregarProducto("Sprite", "Sprite Zero 330ml").resultado, Retorno.Resultado.OK, "Se agregó el producto Sprite");
        p.ver(ob.agregarProducto("Agua Mineral", "Agua Mineral sin gas 500ml").resultado, Retorno.Resultado.OK, "Se agregó el producto Agua Mineral");
        p.ver(ob.agregarProducto("Galletas", "galletas dulces").resultado, Retorno.Resultado.OK, "Se agregó el producto galletas");
         
        
        
        //ingresamos producto repetido 
        p.ver(ob.agregarProducto("coca cola", "coca cola de 3 l").resultado,Retorno.Resultado.ERROR_1,"se agrego producto repetido coca cola");
       
       
       
    
       //ELIMINAR CLIENTES 
       p.ver(ob.eliminarCliente("332").resultado,Retorno.Resultado.OK,"se elimina cliente con ci 332");
       
      
       //ELIMINAR PRODUCTO 
       
      p.ver(ob.eliminarProducto("cafe").resultado,Retorno.Resultado.OK,"se ELIMINO producto cafe");
      p.ver(ob.eliminarProducto("coca cola").resultado,Retorno.Resultado.OK,"se elimino producto coca cola");
        
       // alta de stock a productos
       
       p.ver(ob.altaStockProducto(1,0 ).resultado,Retorno.Resultado.ERROR_2,"se sumo 0 productos redbull al stock DEBE FALLAR");
       p.ver(ob.altaStockProducto(1,10 ).resultado,Retorno.Resultado.OK,"se sumo 10 productos red bull al stock");
       p.ver(ob.altaStockProducto(3,10 ).resultado,Retorno.Resultado.OK,"se sumo 10 productos MONSTER al stock");
       p.ver(ob.altaStockProducto(5,11 ).resultado,Retorno.Resultado.OK,"se sumo 5 productos DORITOS al stock");
       p.ver(ob.altaStockProducto(7,10 ).resultado,Retorno.Resultado.OK,"se sumo 10 productos id 6 PEPSI");
       p.ver(ob.altaStockProducto(100,2 ).resultado,Retorno.Resultado.ERROR_1,"se sumo 2 STOCK A UN PRODUCTO QUE NO EXISTE");
       p.ver(ob.altaStockProducto(8,10 ).resultado,Retorno.Resultado.OK,"se sumo 10 productos id 8 FANTA");
       p.ver(ob.altaStockProducto(9,10 ).resultado,Retorno.Resultado.OK,"se sumo 10 productos id 9 SPRITE");
       p.ver(ob.altaStockProducto(10,100 ).resultado,Retorno.Resultado.OK,"se sumo 100 productos id 10 AGUA MINERAL");
       p.ver(ob.altaStockProducto(11,2 ).resultado,Retorno.Resultado.OK,"se sumo 2 productos id 11 Galletas");
       
       //mostramos la lista de productos antes de hacer cualquier agregado de productos o deshacer pedido 
       System.out.println("Muestra la lista de productos antes de hacer pedidos");
       ob.listaProductos.mostrar();
       //APERTURA DE PEDIDOS
       
       p.ver(ob.aperturaDePedido("999").resultado,Retorno.Resultado.OK,"se abrio pedido a cliente 999");
       p.ver(ob.aperturaDePedido("12112").resultado,Retorno.Resultado.OK,"se abrio pedido a cliente 12112");
       p.ver(ob.aperturaDePedido("344221").resultado,Retorno.Resultado.OK,"se abrio pedido a cliente 344221");
       p.ver(ob.aperturaDePedido("3345").resultado,Retorno.Resultado.OK,"se abrio pedido a cliente 3345");
       p.ver(ob.aperturaDePedido("32222").resultado,Retorno.Resultado.OK,"se abrio pedido a cliente 32222");
       
        // creamos otro pedido para el cliente con cedula 999
        p.ver(ob.aperturaDePedido("999").resultado,Retorno.Resultado.ERROR_2,"se abrio pedido a cliente 999 QUE YA TIENE 1 PEDIDO NO ABRE PEDIDO");
        
       
        
        //PEDIDO A CLIENTE QUE NO EXISTE
         p.ver(ob.aperturaDePedido("1").resultado,Retorno.Resultado.ERROR_1,"SE INTENTA ABRIR UN PEDIDO A UN CLIENTE QUE NO EXISTE");
         
        
          
         
           
           
//         //AGREGAR PRODUCTO CANTIDAD A PEDIDO  VALIDOS 
//        //CLIENTE 999 NICOLAS
         p.ver(ob.agregarProductoAPedido("999", 1, 1).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 999");
         p.ver(ob.agregarProductoAPedido("999", 5, 3).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 999");
         p.ver(ob.agregarProductoAPedido("999", 10, 3).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 999");
         p.ver(ob.agregarProductoAPedido("999", 7, 1).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 999");
         //CLIENTE 12112341234
         p.ver(ob.agregarProductoAPedido("12112", 7, 1).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 12112341234");
         p.ver(ob.agregarProductoAPedido("12112", 10, 3).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 12112341234");
         p.ver(ob.agregarProductoAPedido("12112", 5, 1).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 12112341234");
          p.ver(ob.agregarProductoAPedido("12112", 7, 3).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 12112341234");
         
         //CLIENTE 344221 ALBERTO
         p.ver(ob.agregarProductoAPedido("344221", 7, 1).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 344221");
         p.ver(ob.agregarProductoAPedido("344221", 10, 3).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 344221");
         p.ver(ob.agregarProductoAPedido("344221", 5, 1).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 344221");
         p.ver(ob.agregarProductoAPedido("344221", 1, 1).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 344221");
         p.ver(ob.agregarProductoAPedido("344221", 5, 1).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 344221");
         p.ver(ob.agregarProductoAPedido("344221", 3, 1).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 344221");         
          //DESHACER PEDIDO 1 ACCION 
         p.ver(ob.deshacerPedido("344221", 1).resultado,Retorno.Resultado.OK,"SE ELIMINA 1 PRODUCTOCANTIDAD DE PEDIDO DEL CLIENTE 344221");
         
         
//         //CLIENTE 3345
         p.ver(ob.agregarProductoAPedido("3345", 7, 2).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 3345");
         p.ver(ob.agregarProductoAPedido("3345", 10, 3).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 3345");
         p.ver(ob.agregarProductoAPedido("3345", 5, 1).resultado,Retorno.Resultado.OK,"agregamos producto cantidad a pedido de cliente ci 3345");
         p.ver(ob.deshacerPedido("3345", 3).resultado,Retorno.Resultado.OK,"SE ELIMINA 2 PRODUCTOCANTIDAD DE PEDIDO DEL CLIENTE 3345");
         System.out.println("ver que pasa si dejo productocantidad en cero");


//         //agregamos a un cliente inexistente
         p.ver(ob.agregarProductoAPedido("9", 1, 1).resultado,Retorno.Resultado.ERROR_1,"agregamos producto cantidad a pedido de cliente que no existe");
//         //agregamos un pedido con el numero de producto mal
         p.ver(ob.agregarProductoAPedido("999", 1000, 1).resultado,Retorno.Resultado.ERROR_2,"agregamos producto QUE NO EXISTE");
//         //AGREGAMOS PRODUCTO CON MAS UNIDADES DE PEDIDO QUE EL TOTAL PERMITIDO
         p.ver(ob.agregarProductoAPedido("999", 1, 10).resultado,Retorno.Resultado.ERROR_3,"MAS UNIDADES QUE EL TOTAL PERMITIDO ");
//         //AGREGAMOS UNIDADES EN 0 
         p.ver(ob.agregarProductoAPedido("999", 1, 0).resultado,Retorno.Resultado.ERROR_4,"UNIDADES DE PEDIDO EN 0");
//         //AGREGAMOS PEDIDO A UN PRODUCTO QUE LAS UNIDADES SUPERAN EL STOCK
         p.ver(ob.agregarProductoAPedido("999", 11, 3).resultado,Retorno.Resultado.ERROR_5,"UNIDADES > QUE STOCK DE PRODUCTO");
         
//         
//         
//         
//         //DESHACER AGREGADO DE PRODUCTO CANTIDAD
        
         p.ver(ob.deshacerPedido("999", 1).resultado,Retorno.Resultado.OK,"SE ELIMINA 1 PRODUCTOCANTIDAD DE PEDIDO DEL CLIENTE 999");
         
         
        // DESHACER PEDIDOS FALLAN 
         p.ver(ob.deshacerPedido("452345545", 1).resultado,Retorno.Resultado.ERROR_1,"CLIENTE NO EXISTE");
         p.ver(ob.deshacerPedido("999", 0).resultado,Retorno.Resultado.ERROR_2,"CANTIDAD DE ACCIONES = 0");
         p.ver(ob.deshacerPedido("999", 4).resultado,Retorno.Resultado.ERROR_3,"CANTIDAD DE ACCIONES > PRODUCTO CANTIDAD");
         
         //mostramos lista de pedidos para controlar stock de productos
         System.out.println("Muestra la lista de productos Despues de hacer y deshacer pedidos");
         ob.listaProductos.mostrar();



      
//       //CERRAR PEDIDO 
         
         p.ver(ob.cerrarPedido("999").resultado,Retorno.Resultado.OK,"se cierra pedido a cliente con cedula 999 nombre nicolas");
         p.ver(ob.cerrarPedido("344221").resultado,Retorno.Resultado.OK,"se cierra pedido a cliente con cedula 344221 nombre ALBERTO");
         p.ver(ob.cerrarPedido("3345").resultado,Retorno.Resultado.OK,"SE CERRO PEDIDO A CLIENTE 3345 ESTEBAN");
         p.ver(ob.cerrarPedido("12112").resultado,Retorno.Resultado.OK,"SE CERRO PEDIDO A CLIENTE 12112 ");

//       PRUEBA DE ERRORES EN CERRARPEDIDO
         p.ver(ob.cerrarPedido("164").resultado,Retorno.Resultado.ERROR_1,"se cierra pedido a cliente QUE NO EXISTE");
         p.ver(ob.cerrarPedido("32222").resultado,Retorno.Resultado.ERROR_2,"se cierra pedido a cliente sin pedidos");
         System.out.println("LISTAS");
           
         
         
         //PROCESAR PEDIDO PARA LA ENTREGA 
         p.ver(ob.procesarPedido(2).resultado,Retorno.Resultado.OK,"SE TOMA 1 PEDIDO PARA PROCESAR");
         //PROCESA PEDIDO DE LOS ULTIMOS 2 PEDIDOS EN LA LISTA DE PEDIDOS CERRADOS , VA A PROCESAR LOS PEDIDOS DE CEDULA 999 Y 344221 , VA A QUEDAR EN LISTA CERRADOS 3345
         
         //PROCESAR PEDIDOS QUE FALLAN 
         p.ver(ob.procesarPedido(0).resultado,Retorno.Resultado.ERROR_1,"CANTIDAD PEDIDOS SEA MENOR O IGUAL A 0");
         p.ver(ob.procesarPedido(4).resultado,Retorno.Resultado.ERROR_2,"CANTIDAD PEDIDOS SUPERA EL TOTAL DE PEDIDOS CERRADOS");
           
     
//       LISTA DE CLIENTES 
         p.ver(ob.listarClientes().resultado,Retorno.Resultado.OK,"Se muestra la lisrta de clientes ");
    

      
       //LISTADO DE PEDIDOS ABIERTOS
       
       p.ver(ob.listarPedidosAbiertos().resultado,Retorno.Resultado.OK,"Se muestra la lista de pedidos abiertos ");
        
        //LISTADO DE PEDIDOS CERRADOS DE CLIENTE 
        p.ver(ob.pedidosCerradosDeClientes("4").resultado,Retorno.Resultado.ERROR_1,"SE MUESTRAN LOS PEDIDOS CERRADOS DE CLIENTE NO EXISTENTE");
       
        p.ver(ob.pedidosCerradosDeClientes("999").resultado,Retorno.Resultado.OK,"SE MUESTRAN LOS PEDIDOS CERRADOS DE CLIENTE 999");
        
        p.ver(ob.pedidosCerradosDeClientes("3345").resultado,Retorno.Resultado.OK,"SE MUESTRAN LOS PEDIDOS CERRADOS DE CLIENTE 3345");
        
        //LISTAR PEDIDOS LISTOS PARA ENTREGAR RECURSIVA
       p.ver(ob.productosParaEntregar().resultado,Retorno.Resultado.OK,"SE MUESTRA LISTA DE PEDIDOS LISTOS PARA ENTREGAR");
        
       
       //LISTA DE PRODUCTOS ordenados segun como se ingreso en el sistema , al tener un id auto incrementable se tiene que ordenar en orden ascendente segun su numero
       //al momento de agregarlo en sistema, se agrego ordenado por orden alfabetico de su nombre
       p.ver(ob.listarProductos().resultado,Retorno.Resultado.OK,"LISTA DE PRODUCTOS CON SELECTSORT POR NUMERO DE PRODUCTO");

       
     

      
       p.ver(ob.reporteDePedidosSolicitadosXCliente().resultado,Retorno.Resultado.OK,"Reporte de envios de clientes ");
     System.out.println("PEDIDOS LISTOS PARA ENTREGAR");
     ob.listosParaEntregar.Mostrar();
     System.out.println("PEDIDOS CERRADOS");
     ob.listaPedidosCerrados.mostrar();


        
        
    }
     
}
