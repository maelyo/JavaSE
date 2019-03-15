
public class LesValeursParDefaut {

	//Les variables d'instance et de classe ont une valeur par défaut
	int maVariableDInstance;
	static int maVariableDeClasse;
	public static void main(String[] args) {
		//Affichage de la valeur par défaut de la variable d'instance
		//Pour cela, il est nécessaire de créer une instance de la classe LesValeursParDefaut
		//La méthode main étant static, il n'existe pour le moment aucune instance donc il n'est pas possible d'accéder à cette variable
		//Pour plus d'informations, veuillez consulter le chapitre suivant sur la programmation objet.
		LesValeursParDefaut lvpd = new LesValeursParDefaut();
		System.out.println("La valeur par défaut de maVariableDInstance est : " + lvpd.maVariableDInstance);
				
		// Affichage de la valeur par défaut de la variable de classe
		System.out.println("La valeur par défaut de maVariableDeClasse est : " + maVariableDeClasse);
		
		// Les variables locales n'ont pas de valeur par défaut
		int maVariableLocale;
		//La ligne suivante ne compile pas car maVariableLocale n'est pas initialisée.
		//System.out.println("La valeur par défaut de maVariableLocal est :" + maVariableLocale);
	}
}
