package AccionesSemanticas;

import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;

public class AS5 extends AccionSemantica{
	//fin simbolo2: devuelve el token y verifica si es algun simbolo valido(si esta en la ts) Y RETROCEDE EL INDICE
	
	public int ejecutar(char c, AnalizadorLexico AL) {
		String buffer = AL.getBuffer();
		buffer = buffer +c;
		if (! AL.obtenerTS().perteneceTS(buffer)) { //Solo verificamos que sea error, ya que la devolucion del token la hace el GetToken
			AL.AgregarError(AL.getLinea(), "No es un simbolo valido");
		}
		AL.setBuffer(buffer);
	return 1;
	}
}
