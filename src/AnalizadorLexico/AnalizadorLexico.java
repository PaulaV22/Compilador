package AnalizadorLexico;

import java.util.ArrayList;
import Utilidades.Error;
import AccionesSemanticas.*;

public class AnalizadorLexico {

	private String fuente;
	private int indice;
	private AccionSemantica[][] mAS;
	private int[][] mEst;
	public TablaDeSimbolos ts;
	private int linea;
	private ArrayList<Error> errores;
	
	public AnalizadorLexico(String fuente) { //Crea el analizador lexico con el codigo fuente con ambas matrices
		this.fuente = fuente;
		this.indice = 0;
		this.mEst = CargarMatrizEstados();
		this.mAS = CargarMatrizSemantica();
		this.errores=new ArrayList<>();
		this.linea=1;
		this.ts = new TablaDeSimbolos();
	}
	
	private int [][] CargarMatrizEstados() {
		int [][] m = {
			{7,9,69,3,4,5,6,0,69,69,1,7,11,15,7,0,69},
			{2,2,-1,-1,-1,-1,-1,-1,-1,-1,14,2,-1,-1,2,-1,-1},
			{2,2,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69},
			{69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69},
			{69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69},
			{-1,-1,-1,-1,-1,-1,-1,-1,69,-1,-1,-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1,-1,-1,69,-1,-1,-1,-1,-1,-1,-1,-1},
			{7,69,69,69,69,69,69,69,69,69,7,69,69,69,69,69,69},
			{15,15,-1,-1,-1,-1,-1,15,-1,-1,-1,-1,-1,-1,-1,15,-1},
			{-1,9,-1,-1,-1,-1,-1,-1,-1,-1,10,-1,11,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,69,-1,-1},
			{-1,11,-1,-1,-1,-1,-1,-1,-1,-1,-1,12,-1,-1,-1,-1,-1},
			{69,13,69,69,69,69,69,69,69,13,69,69,69,69,69,69,13},
			{69,13,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69},
			{14,14,14,14,14,14,14,0,14,14,14,14,14,14,14,14,14}, //preguntar si en los comentarios puede venir cualquier cosa o restringimos
			{15,15,15,15,15,15,15,15,15,8,15,15,15,15,15,15,15}};
		return m;
	}

	private AccionSemantica [][] CargarMatrizSemantica() {
		AccionSemantica a1 = new AS1();
		AccionSemantica a2 = new AS2();
		AccionSemantica a3 = new AS3();
		AccionSemantica a4 = new AS4();
		AccionSemantica a5 = new AS5();
		AccionSemantica a6 = new AS6();
		AccionSemantica a7 = new AS7();
		AccionSemantica a8 = new AS8();
		AccionSemantica a9 = new AS9();
		AccionSemantica a10 = new AS10();
		AccionSemantica a11 = new AS11();
		AccionSemantica a12 = new AS12(); //
		AccionSemantica a69 = new AS69();

		AccionSemantica [][] m = {
			{a1,a1,a1,a1,a1,a1,a1,a10,a4,a4,a1,a1,a1,a1,a1,a11,a4},
			{a2,a2,a69,a69,a69,a69,a69,a69,a69,a69,a2,a69,a69,a2,a69,a69},
			{a2,a2,a3,a3,a3,a3,a3,a3,a3,a3,a3,a3,a3,a3,a3,a3,a3},
			{a5,a5,a5,a5,a5,a5,a5,a5,a4,a5,a5,a5,a5,a5,a5,a5,a5},
			{a5,a5,a5,a5,a5,a5,a5,a5,a4,a5,a5,a5,a5,a5,a5,a5,a5},
			{a69,a69,a69,a69,a69,a69,a69,a69,a4,a69,a69,a69,a69,a69,a69,a69,a69,},
			{a69,a69,a69,a69,a69,a69,a69,a69,a4,a69,a69,a69,a69,a69,a69,a69,a69,},
			{a2,a12,a12,a12,a12,a12,a12,a12,a12,a12,a2,a12,a12,a12,a12,a12,a12},
			{a8,a8,a8,a8,a8,a8,a8,a8,a8,a8,a8,a8,a8,a8,a8,a8,a8}, //preguntar que onda con el guion y el /n
			{a69,a2,a69,a69,a69,a69,a69,a69,a69,a69,a69,a2,a69,a2,a69,a69,a69,a69},
			{a69,a69,a69,a69,a69,a69,a69,a69,a69,a69,a69,a69,a69,a69,a6,a69},
			{a69,a2,a69,a69,a69,a69,a69,a69,a69,a69,a69,a2,a69,a69,a69,a69,a69},
			{a7,a2,a7,a7,a7,a7,a7,a7,a7,a2,a7,a7,a7,a7,a7,a7,a2},
			{a7,a2,a7,a7,a7,a7,a7,a7,a7,a7,a7,a7,a7,a7,a7,a7,a7},
			{a2,a2,a2,a2,a2,a2,a2,a10,a2,a2,a2,a2,a2,a2,a2,a2,a2}, //preguntar si en los comentarios puede venir cualquier cosa o restringimos
			{a2,a2,a2,a2,a2,a2,a2,a69,a2,a2,a2,a2,a2,a9,a2,a2,a2}};
		return m;
	}
	
	public Simbolo obtenerToken(){ //devolveria el simbolo
		StringBuffer buffer = new StringBuffer();
		char c; // = fuente.charAt(indice);
		int estado = 0, estadoFuturo = 0, col = 0,retroceder=0;
		while ((( estado != -1)/*1*/ && (indice< fuente.length())/*2*/ && (estado != 666))/*3*/ ) { //-1 = error 666=estado final
			c = fuente.charAt(indice);
			col = obtenerCol(c);
			if (col != 20){ //Verificas que no sea un simbolo extraño (Si es extraño va a buscar en un rango de la matriz inexistente y se rompe todo :v
				estadoFuturo = mEst[estado][col];
				retroceder = mAS[estado][col].ejecutar(buffer, c, this); // mAS[estado] ( Si cae en un estado que no deberia, la AS tiene que agregar a la lista de errores (Linea de error, TipoError) )
				if (retroceder==1)
					indice--;
				estado = estadoFuturo;
				indice++;
			}
			else {
				indice++; //lo ignoras y agregas a lista de errores
				Error e = new Error(linea,"Caracter invalido");
				errores.add(e);
			}
			
	 	}
		if (estado == -1) { 
			/* Estas Acciones Semanticas son las que haria cuando llegue a un estado de error 
			 * AccError = devuelve un token error, y además lo agrega a una lista de errores para luego ser mostrado. 
			AccErrorDC: igual al anterior, pero además devuelve el carácter leído porque pertenece al siguiente 
						token. */
			indice--;  //(Retrocedo el puntero para que cuando me llamen nuevamente, tenerlo corregido)
			return obtenerToken(); //Me vuelvo a llamar hasta que retorne un token valido.
			
		}
		if( indice >= fuente.length()){
			return ts.obtenerSimbolo(new StringBuffer("fin de archivo")); // o algo asi jaja
		}
		//if ( estado == 666 ) Si se va del while es por 1,2,3 y como 1 y 2 ya las contemplamos si o si va a ser por 3
			//La ASF de cada tipo guarda en la TS el token ( por ejemplo cadena identifica que el token es una cadena de caracteres  y lo carga en la TS
		return ts.obtenerSimbolo(buffer);	
	}
	
/*private int obtenerCol(char c) { //devuelve la columna de la matriz de estado correspondiente al caracter 
		int aux = 20;
        switch (c) {
        case 1: if (c>= 'a' && c<= 'Z' && c!='D' && c!= 'l') aux = 0;
             break;
        case 2: if (c>= '0' && c<= '9')  aux = 1;
        break;
        case 3: if (c== '*'||  c== '{'||  c== '}'|| c== ','|| c== ';'|| c== '('|| c== ')'||  c== '&')   aux = 2;
        break;
        case 4: if (c== '>')  aux = 3;
        break;
        case 5: if (c== '<')  aux = 4;
        break;
        case 6: if (c== ':')  aux = 5;
        break;
        case 7: if (c== '!')  aux = 6;
        break;
        case 8: if (c== '\n')  aux = 7;
        break;
        case 9: if (c== '=')  aux = 8;
        break;
        case 10: if (c== '-')  aux = 9;
        break;
        case 11: if (c== '.')  aux = 10;
        break;
        case 12: if (c== 'D')  aux = 11;
        break;
        case 13: if (c== '.')  aux = 12;
        break;
        case 14: if (c == 39)  aux = 13; //comilla simple = 39
        break;
        case 15: if (c== 'l')  aux = 14;
        break;
        case 16: if (c== ' ' || c == '\t')  aux = 15;
        break;
        case 17: if (c== '+')  aux = 16;
        break;
        default:   //Si detecta un simbolo fuera de mi lenguaje (S != L,D,etc) ya lo puedo detectar aca
        }
		return aux;
	}
*/
	private int obtenerCol(char c) { //devuelve la columna de la matriz de estado correspondiente al caracter 
		int aux = 20;
		if (Character.isLetter(c) && c!='D' && c!= 'l') return 0;
        if (Character.isDigit(c)) return 1;
        if (c== '*'||  c== '{'||  c== '}'|| c== ','|| c== ';'|| c== '('|| c== ')'||  c== '&')    return 2;
        if (c== '>')   return 3;
        if (c== '<')   return 4;
        if (c== ':')   return 5;
        if (c== '!')   return 6;
        if (c== '\n')   return 7;
        if (c== '=')   return 8;
        if (c== '-')   return 9;
        if (c== '.')   return 10;
        if (c== 'D')   return 11;
        if (c== '.')   return 12;
        if (c == 39)   return 13; //comilla simple = 39
        if (c== 'l')   return 14;
        if (c== ' ' || c == '\t')   return 15;
        if (c== '+')   return 16;
        return aux;
	}
	public void AgregarSimbolo(StringBuffer buffer, Simbolo simbolo) { //Carga la tabla de simbolos manualmente (por ejemplo las palabras reservadas)
		if (!this.ts.perteneceTS(buffer)) {
			this.ts.agregarSimbolo(buffer, simbolo);
		}
	}
	public TablaDeSimbolos obtenerTS() {
		return this.ts;
	}
	public void decrementarIndice() {
		this.indice--;
	}
	
	public int getLinea() {
		return linea;
	}
	
	public void AumentarLinea() {
		linea++;
	}

	public void AgregarError(int linea, String detalle) {
		Error e = new Error(linea , detalle);
		errores.add(e);
	}
}