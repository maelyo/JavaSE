package fr.eni.editions.generiques;
/**
 * cette interface devra être implémentée par les classes 
 * pour lesquelles un classement des instances est envisagé 
 */
public interface Classable 
{
	/**
	 * cette méthode pourra être appelée pour comparer l'instance
	 * courante avec celle reçue en paramètre
	 * la méthode retourne un entier dont la valeur dépend
	 * des règles suivantes
	 * 1 si l'instance courante est supérieure à celle reçue 
	 * en paramètre
	 * 0 si les deux instances sont égales
	 * -1 si l'instance courante est inférieure à celle reçue  
	 * en paramètre 
	 * -99 si la comparaison est impossible 
	 */
  	int compare(Object o); 
  	default boolean isInferieur(Object o)
  	{
  		return false;
  	}
    default boolean isSuperieur(Object o)
    {
    	return false;
    }

   
  	public static final int INFERIEUR=-1; 
  	public static final int EGAL=0; 
  	public static final int SUPERIEUR=1; 
  	public static final int ERREUR=-99; 
}


