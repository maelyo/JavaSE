import java.util.ArrayList;

public class LInférenceDeType {

	public static void main(String[] args) {
		var chaine = "Bonjour je suis une chaine de caractères";
		var nombre = 10;
		var maListe = new ArrayList<String>();
		var nb = getNombre();
		//var uneVariable; //ne compile pas, doit être initialisée
		//var uneVariable=null; //ne compile pas, doit être initialisée avec une valeur typée
	}
	
	public static int getNombre()
	{
		return 2;
	}
}
