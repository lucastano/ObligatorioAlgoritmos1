package Estructuras;



public class Retorno {
	 enum Resultado {
//		OK,ERROR,NO_IMPLEMENTADA // CONSULTAR PARA QUE SE UTILIZA NO IMPLEMENTADA
                OK,ERROR_1,ERROR_2,ERROR_3,ERROR_4,ERROR_5,NO_IMPLEMENTADA
	};
	int valorEntero;
	String valorString;
        boolean valorbooleano;
	Resultado resultado;

    public Retorno(Resultado resultado) {

        this.resultado = resultado;
    }
        
        
        
}
