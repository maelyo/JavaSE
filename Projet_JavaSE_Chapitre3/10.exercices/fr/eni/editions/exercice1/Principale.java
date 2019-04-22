package fr.eni.editions.exercice1;

public class Principale {
	public static void main(String[] args) {
		Article a1, a2;
		a1 = new Article();
		a1.setReference(100);
		a1.setDesignation("tintin au congo");
		a1.setPrix(8.5);

		a2 = new Article(110, "Le Crabe aux pinces d'or", 8.5);

		test(a1);
		System.out.println(a1.toString());

		test(a2);
		System.out.println(a2.toString());

	}

	public static void test(Article a) {
		System.out.println("reference : " + a.getReference());
		System.out.println("designation : " + a.getDesignation());
		System.out.println("prix : " + a.getPrix() + " €");
	}
}
