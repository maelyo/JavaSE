package fr.eni.editions.classes_imbriquees_statiques;

public class Externe {
	static final double TAUX=1.2;
	static class Interne
	{
		public double calculTTC(double prix)
		{
			return prix*Externe.TAUX;
		}
	}
}
