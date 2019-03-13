
public class LesValeursLitteralesNumeriques {

	public static void main(String[] args) {
		//Les valeurs littérales numériques entières sont considérées comme de type int 
		int populationFrancaise = 66990000;
		//Les valeurs littérales numériques décimales sont considérées comme de type double
		double porcentageFemme = 51.649;
		
		//La ligne suivante ne compile pas.
		//Le compilateur considère 153 comme un entier de type int.
		//byte b = 153;
		
		//La ligne suivante compile: 
		//Le compilateur considère 22 comme un entier de type byte dans ce cas.
		//Le compilateur est donc capable d'évaluer la valeur intrinsèque d'un littéral entier. 
		byte b = 22;
		
		//La ligne suivante ne compile pas.
		//Le compilateur considère 10.1 comme un décimal de type double.
		//Or 10.1 fait partie de la plage d'un float.
		//Le compilateur n'est donc pas capable d'évaluer la valeur intrinsèque d'un littéral décimal.
		//float f = 10.1;
		
		//La ligne suivante compile:
		//Le suffixe F (ou f) à la valeur littérale impose au compilateur de l'interpréter comme un type float.
		float f = 10.1F;
		
		//La ligne suivante ne compile pas:
		//Le compilateur considère que la valeur littérale n'est pas un entier de type int valide. En effet, elle dépasse la valeur maximale
		// Or 10123456789 fait partie de la plage d'un long.
		//long l = 10123456789;
		
		//La ligne suivante compile:
		//Le suffixe L (ou l) à la valeur littérale impose au compilateur de l'interpréter comme un type long.
		long l = 10123456789L;
	}

}
