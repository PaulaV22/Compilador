				package AccionesSemanticas;

import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;

public class AS4 extends AccionSemantica{
	//fin simbolo1: devuelve el token y verifica si es algun simbolo valido(si esta en la ts)
	
	//PREGUNTAR SI ESTA ACCION SEMANTICA ES NECESARIA, YA QUE SOLO SE VA A LLEGAR POR CAMINOS VALIDOS
	
	public int ejecutar(StringBuffer buffer, char c, AnalizadorLexico AL) {
		if (! AL.obtenerTS().perteneceTS(buffer.append(c))) { //Solo verificamos que sea error, ya que la devolucion del token la hace el GetToken
			AL.AgregarError(AL.getLinea(), "No es un simbolo valido");
		}
		return 0;
	}
}
