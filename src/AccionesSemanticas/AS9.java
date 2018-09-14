package AccionesSemanticas;

import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;


public class AS9 extends AccionSemantica{
	//FinString (quito la primer comilla y omito la final
	
	public int ejecutar(StringBuffer buffer, char c, AnalizadorLexico AL) {
		String aux = buffer.substring(1, buffer.length());
		buffer = new StringBuffer(aux); 
			return 0;
	}
}