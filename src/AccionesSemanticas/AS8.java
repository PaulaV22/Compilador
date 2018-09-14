package AccionesSemanticas;

import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;


public class AS8 extends AccionSemantica{
	//Reconoce /n en 
	
	public int ejecutar(StringBuffer buffer, char c, AnalizadorLexico AL) {
		if (c == '\n' ) {
			String aux = buffer.substring(0, buffer.length()-1);
			buffer = new StringBuffer(aux);
		}
		else {
			buffer.append(c);
		}
		return 0;
	}
}
