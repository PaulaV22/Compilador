package AccionesSemanticas;
import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;
import AnalizadorLexico.Simbolo;

public class AS3 extends AccionSemantica{
	//Fin ID, devuelve el caracter leido, busca en la ts (agrega sino esta) y verifica su longitud.
	@Override
	
	public int ejecutar(StringBuffer buffer, char c, AnalizadorLexico AL) {
		if(buffer.length() <= 25) {
			int codigo = AL.obtenerTS().obtenerSimbolo(new StringBuffer("id")).getTipo(); //Busco valor de ID
			Simbolo sAux = new Simbolo(codigo, null); //Creo un Simbolo con el ID y su valor
			AL.AgregarSimbolo(buffer, sAux);
			return 1;
		}
		else {
			AL.AgregarError(AL.getLinea(), "Error de ID: length > 25");
			return 1;
		}
	}
}
