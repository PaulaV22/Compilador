package AccionesSemanticas;
import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;

public class AS69 extends AccionSemantica{
	//error
	public int ejecutar(StringBuffer buffer, char c, AnalizadorLexico AL) {
		AL.AgregarError(AL.getLinea(), "Error: Token desconocido");
		return 1;
	}
}