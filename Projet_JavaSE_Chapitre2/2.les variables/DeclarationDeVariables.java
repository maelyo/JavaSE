import java.util.Date;

public class DeclarationDeVariables {

	public static void main(String[] args) {
		//Déclaration
		int age;
		Date aujourdhui, hier;
		//Initialisation
		age = 41;
		//Déclaration suivi d'une initialisation pour un type valeur
		int agePremierJumeau = 25;
		int ageSecondJumeau = agePremierJumeau;
		//Déclaration suivi d'une initialisation pour un type référence
		//Vous pouvez constater que le constructeur est barré car la méthode est dépréciée
		//Ceci veut dire qu'il ne faut plus l'utiliser.
		//La javadoc indique qu'il est préférable d'utiliser la classe Calendar ou la classe GregorianCalendar pour initialiser une date.
		//Dans le cadre de l'exemple, le constructeur déprécié est utilisé par simplicité.
		Date d1 = new Date(2019, 3, 6);
		Date d2 = d1;
	}

}
