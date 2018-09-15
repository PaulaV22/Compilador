package AccionesSemanticas;
import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;
import AnalizadorLexico.Simbolo;

public class AS3 extends AccionSemantica{
	//Fin ID, devuelve el caracter leido, busca en la ts (agrega sino esta) y verifica su longitud.
	@Override
	
	public int ejecutar(char c, AnalizadorLexico AL) {
		String buffer = AL.getBuffer();
		if(buffer.length() <= 25) {
			int codigo = AL.obtenerTS().obtenerSimbolo("id").getTipo(); //Busco valor de ID
			System.out.println("CODIIIIIIIIIIIIIIIIIIIIIIGO ES " + codigo);
			Simbolo sAux = new Simbolo(codigo, null); //Creo un Simbolo con el ID y su valor
			AL.AgregarSimbolo(buffer, sAux);
			AL.setBuffer(buffer);
			return 1;
		}
		else {
			AL.AgregarError(AL.getLinea(), "Error de ID: length > 25");
			AL.setBuffer(buffer);
			return 1;
		}
	}
	
	public void getNombre() {
		System.out.println("AS 3 	//Fin ID, devuelve el caracter leido, busca en la ts (agrega sino esta) y verifica su longitud ");
	}
	
}
