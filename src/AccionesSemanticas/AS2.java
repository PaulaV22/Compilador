package AccionesSemanticas;
import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;

public class AS2 extends AccionSemantica{
	//Agrega caracter al string
	@Override
	public int ejecutar(StringBuffer buffer, char c, AnalizadorLexico AL) {
		buffer.append(c);
		return 0;
	}
}
