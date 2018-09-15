package Utilidades;

import AnalizadorLexico.AnalizadorLexico;
import AnalizadorLexico.Simbolo;

public class Test {
	
	public static void main (String [] args) {
	//	String fuente = this.LeerCodigoFuente();
//		AnalizadorLexico al = new AnalizadorLexico("if _plazo >= 30\n" + 
//				"then _Tasa := _Base + _Recargo / 100\n" + 
//				"else _Tasa := _Base");
		AnalizadorLexico al = new AnalizadorLexico("_hoa _paula");
		Simbolo s = new Simbolo(0, true);
		boolean termino = false;

		while ((!termino)) {
			s = al.obtenerToken();
			if (s == null) {
				termino = true;
			} else {
				System.out.println("OBTUVOOOOOOOO EL TOKENNNNNN :D");
				System.out.println(s.getTipo());
			}
		}
		
		
		
		
		System.out.println("fin");
	}
	
	private void LeerCodigoFuente(String buffer,char c) {
		String b = "";
		b=buffer+c;
		buffer =b;
	}
}
