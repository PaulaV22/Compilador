package AccionesSemanticas;
import AnalizadorLexico.AccionSemantica;
import AnalizadorLexico.AnalizadorLexico;
import AnalizadorLexico.Simbolo;

public class AS12 extends AccionSemantica{
	//verifica PR
	@Override
	public int ejecutar(StringBuffer buffer, char c, AnalizadorLexico AL) {
		boolean pertenece = AL.obtenerTS().perteneceTS(buffer);
		boolean esPR = AL.obtenerTS().obtenerSimbolo(buffer).esPR();
		if( !pertenece || !esPR ) {
			AL.AgregarError(AL.getLinea(), "Error PR no encontrada");
			return 1;
		}
		return 0;
	}
}
