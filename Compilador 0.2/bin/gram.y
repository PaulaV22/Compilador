
%{
package Parser;
import AnalizadorLexico.AnalizadorLexico;
import AnalizadorLexico.Simbolo;
import AnalizadorLexico.Token;

%}


%token ID CTE ELSE END_IF PRINT LINTEGER DOUBLE LOOP UNTIL LET MAYIGUAL MENIGUAL IF DISTINTO ASIG MUT EOF CADENA ERROR
		
		
%left '+' '-'
%left '*' '/'


%start programa

/* Comienzo del programa */

%%

programa				: sentDec sentEjec
						; 
               
sentDec					: dVar
						| sentDec dVar
						;
						
sentEjec				: sentencia ';'
						| sentEjec sentencia ';'
						;


/* Sentencias declarativas */


dVar					: tipo listVar ','
						| LET MUT tipo listVarMut ','
						;

		

listVar					: ID  				
						| listVar ';' ID 
						;
						
listVarMut				: ID
						| listVarMut ';' ID 
						| '*' ID
						
tipo					: LINTEGER							
						| DOUBLE							
						;


/* Sentencias Ejecutables */

sentencia				: estructIf 
						| estructLoop 
						| asignacion 
						| imprimir
						;


/* Estructuras si y mientras */

estructIf				: IF '(' condicion ')' bloqueSent END_IF 					
						| IF '(' condicion ')' bloqueSent ELSE bloqueSent END_IF   
						;


 
estructLoop 			: LOOP  bloqueSent UNTIL '(' condicion ')' ','
						;


bloqueSent				: sentencia ';'
						| '{' conjSent '}'
						;

conjSent   				: sentencia ','
						| conjSent sentencia ','
						;


/* Condiciones */    
               	  
condicion				: expresion  comparador expresion
						;

comparador				: '<'			
						| '>'			
						| MENIGUAL	
						| MAYIGUAL	
						| '='			
						| DISTINTO			
						;


/* Asignacion */

asignacion 				: ID ASIG expresion
						;

/* Expresiones */

expresion 				: expresion '+' termino 
				        | expresion '-' termino 
				        | termino
						;
				       	

termino					: termino '*' factor 
						| termino '/' factor 
        				| factor
						;

factor					: ID 
						| CTE
						| '-' CTE
						;


/* Imprimir */

imprimir				: PRINT '(' CADENA ')' 
						;

%%

private AnalizadorLexico al;

public void setAL(AnalizadorLexico al){
	this.al=al;
}

public int yylex(){
	Simbolo s = this.al.getSimbolo();
	Token t = new Token (s.getLexema(), al.getLinea());
    yylval = new ParserVal(t);
	return s.getNumero();
}

public void yyerror(String e){
	System.out.println(e);

}