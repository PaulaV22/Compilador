package Utilidades;

import AnalizadorLexico.AnalizadorLexico;
import AnalizadorLexico.Simbolo;

public class Test {
	
	public static void main (String [] args) {
	//	String fuente = this.LeerCodigoFuente();
		AnalizadorLexico al = new AnalizadorLexico("__a \n 'ha-\nxd'");
		Simbolo s = new Simbolo(0, true);
		boolean termino = false;

		while (!al.isEOF()) {
			s = al.obtenerToken();
			if(s != null){
				System.out.println(s.getTipo());
			}
		}
		System.out.println("fin");
		al.ImprimirErrores();
	}

}
