package AccionesSemanticas;

import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;


public class AS9 extends AccionSemantica{
	//FinString (quito la primer comilla y omito la final)
	
	public int ejecutar(char c, AnalizadorLexico AL) {
		String buffer = AL.getBuffer();
		String aux = buffer.substring(1, buffer.length());
		AL.setBuffer(aux);
		return 0;
	}
}