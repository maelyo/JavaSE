
public enum Dalton {
	   JOE (1.40, 52), 
	   WILLIAM (1.68, 72), 
	   JACK (1.93, 83), 
	   AVERELL (2.13, 89); 
	  
	   private final double taille;   
	   private final double poids; 
	 
	   private Dalton(double taille, double poids)  
	   { 
	      this.taille = taille; 
	      this.poids = poids; 
	   } 
	   public double taille() { return taille; } 
	   public double poids() { return poids; } 
	 
	   double imc()  
	   { 
	            
	      return poids/(taille+taille); 
	   } 
}
