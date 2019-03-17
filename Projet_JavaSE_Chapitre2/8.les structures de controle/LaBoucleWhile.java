
public class LaBoucleWhile {

	public static void main(String[] args) {
		System.out.println("Tous les nombres de la plage [0;10]");
		int i=0;
		while(i<=10)//Condition dont le résultat peut évoluer entre 2 itérations.
		{
			System.out.println(i);
			i+=1;//Instruction permettant de faire évoluer le résutlat de la condition
		}
	}

}
