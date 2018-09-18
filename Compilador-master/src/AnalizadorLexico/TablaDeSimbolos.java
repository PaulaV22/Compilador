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
		Simbolo sID = new Simbolo(282, false); //no podia ser 256
		ts.put(new String("id"), sID); 
		
		Simbolo sCTE = new Simbolo(257, false);
		ts.put(new String("cte"), sCTE);
		
		Simbolo sIF = new Simbolo(258, true);
		ts.put(new String("if"), sIF);
		
		Simbolo sELSE = new Simbolo(259, true);
		ts.put(new String("else"), sELSE);
		
		Simbolo sENDIF = new Simbolo(260,true);
		ts.put(new String("end_if"), sENDIF);
		
		Simbolo sPRINT = new Simbolo(261,true);
		ts.put(new String("print"), sPRINT);
		
		Simbolo sLINTEGER = new Simbolo(262,true);
		ts.put(new String("linteger"), sLINTEGER);
		
		Simbolo sDOUBLE = new Simbolo(263,true);
		ts.put(new String("double"), sDOUBLE);
		
		Simbolo sLOOP = new Simbolo(264,true);
		ts.put(new String("loop"), sLOOP);
		
		Simbolo sUNTIL = new Simbolo(265,true);
		ts.put(new String("until"), sUNTIL);
		
		Simbolo sLET = new Simbolo(266,true);
		ts.put(new String("let"), sLET);
		
		Simbolo sMayorIgual = new Simbolo(267,false);
		ts.put(new String(">="), sMayorIgual);
				
		Simbolo sMenorIgual = new Simbolo(268,false);
		ts.put(new String("<="), sMenorIgual);
		
		Simbolo sMAYOR = new Simbolo(269,false);
		ts.put(new String(">"), sMAYOR);
		
		Simbolo sMENOR = new Simbolo(270,false);
		ts.put(new String("<"), sMENOR);
		
		Simbolo sIGUAL = new Simbolo(271,false);
		ts.put(new String("="), sIGUAL);
		
		Simbolo sDISTINTO = new Simbolo(272,false);
		ts.put(new String("=!"), sDISTINTO);
		
		Simbolo sASIGNACION = new Simbolo(273,false);
		ts.put(new String(":="), sASIGNACION);
		
		Simbolo sPARENTESIS1 = new Simbolo(274,false);
		ts.put(new String("("), sPARENTESIS1);
		
		Simbolo sPARENTESIS2 = new Simbolo(275,false);
		ts.put(new String(")"), sPARENTESIS2);
		
		Simbolo sLLAVE1 = new Simbolo(276,false);
		ts.put(new String("{"), sLLAVE1);
		
		Simbolo sLLAVE2 = new Simbolo(277,false);
		ts.put(new String("}"), sLLAVE2);
		
		Simbolo sPUNTOCOMA = new Simbolo(278,false);
		ts.put(new String(";"), sPUNTOCOMA);
		
		Simbolo sCOMA = new Simbolo(279,false);
		ts.put(new String(","), sCOMA);
		
		Simbolo sMENOS = new Simbolo(278,false);
		ts.put(new String("-"), sMENOS);
		
		Simbolo sPOR = new Simbolo(279,false);
		ts.put(new String("*"), sPOR);
		
		Simbolo sDIV = new Simbolo(280,false);
		ts.put(new String("/"), sDIV);
		
		Simbolo sMAS = new Simbolo(281,false);
		ts.put(new String("+"), sMAS);
		
		Simbolo sMUT = new Simbolo(284,true);
		ts.put(new String("mut"), sMUT);

		Simbolo sFin = new Simbolo(283,false);
		ts.put(new String("fin de archivo"), sFin);
		
		Simbolo sCADENA = new Simbolo(285,false);
		ts.put(new String("cadena"), sCADENA);
	}
	
	public void agregarSimbolo(String buffer , Simbolo simb) { //agrego tokens
		ts.put(buffer, simb);
	}
	
	public Simbolo obtenerSimbolo(String buffer) { // Obtenes el token entero
		Simbolo salida = ts.get(buffer);
		return salida;
	}
	
	public boolean perteneceTS(String buffer){ //verificar existencia en ella
		boolean asd = ts.containsKey(buffer);
		return asd;
	}
	
}
