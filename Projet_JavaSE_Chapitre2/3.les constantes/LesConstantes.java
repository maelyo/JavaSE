
public class LesConstantes {

	static final double TAUXTVA = 1.20;
	static final int TOTAL = 100;
	static final int DEMI = TOTAL/2;
	
	public static void main(String[] args) {
		double prixHT = 10;
		double prixTTC = prixHT * TAUXTVA;
		System.out.println("Le prix TTC est de : " + prixTTC);

		System.out.println("La constante caculée DEMI vaut " + DEMI);
	}

}
