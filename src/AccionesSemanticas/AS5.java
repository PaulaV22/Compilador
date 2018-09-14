package AccionesSemanticas;

import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;

public class AS5 extends AccionSemantica{
	//fin simbolo2: devuelve el token y verifica si es algun simbolo valido(si esta en la ts) Y RETROCEDE EL INDICE
	
	public int ejecutar(StringBuffer buffer, char c, AnalizadorLexico AL) {
		if (! AL.obtenerTS().perteneceTS(buffer.append(c))) { //Solo verificamos que sea error, ya que la devolucion del token la hace el GetToken
			AL.AgregarError(AL.getLinea(), "No es un simbolo valido");
		}
	return 1;
	}
}
