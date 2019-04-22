package fr.eni.editions.classes_internes;

public class Externe {
	final double TAUX=1.2;
	class Interne
	{
		public double calculTTC(double prix)
		{
			return prix*TAUX;
		}
	}
}
