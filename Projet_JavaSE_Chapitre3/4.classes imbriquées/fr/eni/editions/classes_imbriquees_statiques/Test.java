package fr.eni.editions.classes_imbriquees_statiques;

public class Test {

	public static void main(String[] args) {
		Externe.Interne objet = new Externe.Interne();
		System.out.println(objet.calculTTC(100));
	}

}
