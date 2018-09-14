package Utilidades;

import AnalizadorLexico.AnalizadorLexico;

public class Test {
	
	public static void main (String [] args) {
	//	String fuente = this.LeerCodigoFuente();
		/*AnalizadorLexico al = new AnalizadorLexico("if Plazo >= 30\n" + 
				"thenTasa := Base + Recargo / 100\n" + 
				"elseTasa := Base");
		while (! (al.obtenerToken().getTipo()==284))
			al.obtenerToken().print();*/
		StringBuffer ax = new StringBuffer("if");
		System.out.println(ax.toString().equals(new StringBuffer("if").toString()));
		System.out.println("acabo");
	}
	
	private String LeerCodigoFuente() {
		String out ="";
		return out;
	}
}
