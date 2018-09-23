package AnalizadorLexico;
import java.util.Hashtable;

public class TablaDeSimbolos {

	private Hashtable<String, Simbolo> ts;
	
	public TablaDeSimbolos() {
		this.ts = new Hashtable<String, Simbolo>();
		ts.clear();
		cargarTabla();
	}
	
	private void cargarTabla () {
		//Carga la tabla con las palabras reservadas y los lexemas iniciales
		Simbolo sID = new Simbolo(257, false,"ID"); //no podia ser 256
		ts.put(new String("ID"), sID); 
		
		Simbolo sCTE = new Simbolo(258, false, "CTE");
		ts.put(new String("CTE"), sCTE);
		
		Simbolo sIF = new Simbolo(269, true, "IF");
		ts.put(new String("IF"), sIF);
		
		Simbolo sELSE = new Simbolo(259, true, "ELSE");
		ts.put(new String("ELSE"), sELSE);
		
		Simbolo sENDIF = new Simbolo(260,true, "END_IF");
		ts.put(new String("END_IF"), sENDIF);
		
		Simbolo sPRINT = new Simbolo(261,true, "PRINT");
		ts.put(new String("PRINT"), sPRINT);
		
		Simbolo sLINTEGER = new Simbolo(262,true, "LINTEGER");
		ts.put(new String("LINTEGER"), sLINTEGER);
		
		Simbolo sDOUBLE = new Simbolo(263,true, "DOUBLE");
		ts.put(new String("DOUBLE"), sDOUBLE);
		
		Simbolo sLOOP = new Simbolo(264,true, "LOOP");
		ts.put(new String("LOOP"), sLOOP);
		
		Simbolo sUNTIL = new Simbolo(265,true, "UNTIL");
		ts.put(new String("UNTIL"), sUNTIL);
		
		Simbolo sLET = new Simbolo(266,true, "LET");
		ts.put(new String("LET"), sLET);
		
		Simbolo sMayorIgual = new Simbolo(267,false,"MAYIGUAL");
		ts.put(new String(">="), sMayorIgual);
				
		Simbolo sMenorIgual = new Simbolo(268,false, "MENIGUAL"); ////////////PREGUNTAR
		ts.put(new String("<="), sMenorIgual);
		
		Simbolo sDISTINTO = new Simbolo(270,false, "DISTINTO");
		ts.put(new String("!="), sDISTINTO);
		
		Simbolo sASIGNACION = new Simbolo(271,false,"ASIG");
		ts.put(new String(":="), sASIGNACION);
		
		Simbolo sMUT = new Simbolo(272,true, "MUT");
		ts.put(new String("MUT"), sMUT);

		Simbolo sFin = new Simbolo(273,false, "EOF");
		ts.put(new String("EOF"), sFin);
		
		Simbolo sCADENA = new Simbolo(274,false, "CADENA");
		ts.put(new String("CADENA"), sCADENA);
	}
	
	public void agregarSimbolo(String buffer , Simbolo simb) { //agrego tokens
		ts.put(buffer, simb);
	}
	
	public Simbolo obtenerSimbolo(String buffer) { // Obtenes el token entero
		Simbolo salida = ts.get(buffer);
		return salida;
	}
	
	public boolean pertenece(String buffer){ //verificar existencia en ella
		boolean asd = ts.containsKey(buffer);
		return asd;
	}
	
	
}
