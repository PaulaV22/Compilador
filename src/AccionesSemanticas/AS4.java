				package AccionesSemanticas;

import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;

public class AS4 extends AccionSemantica{
	//fin simbolo1: devuelve el token y verifica si es algun simbolo valido(si esta en la ts)
	
	//PREGUNTAR SI ESTA ACCION SEMANTICA ES NECESARIA, YA QUE SOLO SE VA A LLEGAR POR CAMINOS VALIDOS
	
	public int ejecutar(char c, AnalizadorLexico AL) {
		String buffer = AL.getBuffer();
		buffer = buffer +c;
		if (! AL.obtenerTS().perteneceTS(buffer)) { //Solo verificamos que sea error, ya que la devolucion del token la hace el GetToken
			AL.AgregarError(AL.getLinea(), "No es un simbolo valido");
		}
		AL.setBuffer(buffer);
		return 0;
	}
}
