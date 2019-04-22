package fr.eni.editions.classes;

public class Client extends Personne {
	//La signature doit être identique à une méthode de la classe mère
	//Si ce n'est pas le cas, il y a une erreur de compilation
	@Override
	public int calculerAge() {
		return 0;
	}
	
	//La méthode suivante ne compile pas avec @Override car ne respecte pas la signature d'une méthode de la classe mère.
	//Pour qu'elle compile, il faut commenter l'annotation. La méthode devient ainsi une surcharge.
	//@Override 
    public int calculerAge(int unite) 
    {
		return 0;
    }
}
