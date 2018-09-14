package AnalizadorLexico;

public abstract class AccionSemantica {

	public abstract int ejecutar(StringBuffer buffer, char c, AnalizadorLexico AL); // si retorna 1 hay que retroceder el cursor y si retorna 0 seguimoooo'
}
