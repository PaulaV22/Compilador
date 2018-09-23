package AccionesSemanticas;

import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;
import AnalizadorLexico.Simbolo;


public class AS9 extends AccionSemantica{
	//FinString (quito la primer comilla y omito la final)
	
	public int ejecutar(char c, AnalizadorLexico AL) {
		String buffer = AL.getBuffer();
		String aux = buffer.substring(1, buffer.length());
		Simbolo s = new Simbolo(285,false);
		AL.AgregarSimbolo(aux, s);
		AL.setBuffer(aux);
		System.out.println(aux);
		return 0;
	}
}