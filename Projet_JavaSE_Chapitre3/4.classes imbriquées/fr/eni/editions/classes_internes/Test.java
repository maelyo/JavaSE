package fr.eni.editions.classes_internes;

public class Test {

	public static void main(String[] args) {
		/* NE compile pas car la classe Interne n'est pas statique:
		 * Externe.Interne objet = new Externe.Interne();
		 * System.out.println(objet.calculTTC(100));
		 */
		//Il faut d'abord une instance de la classe Externe
		Externe e;
		e = new Externe();
		Externe.Interne ci;
		ci = e.new Interne();
		System.out.println(ci.calculTTC(100));

	}

}
