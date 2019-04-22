package fr.eni.editions.classes_anonymes;

public interface Comparateur 
{ 
  /**
   * cette méthode pourra être appelée pour comparer les deux
   * objets reçus en paramètre
   * la méthode retourne un entier dont la valeur dépend
   * des règles suivantes
   * @return
   * 1 si l'instance o1 est supérieure à o2
   * 0 si les deux instances sont égales
   * -1 si l'instance o1 est inférieure à o2
   * -99 si la comparaison est impossible 
   */
  int compare(Object o1,Object o2); 
   
  public static final int INFERIEUR=-1; 
  public static final int EGAL=0; 
  public static final int SUPERIEUR=1; 
  public static final int ERREUR=-99; 
   
}

