
public class LaBoucleFor {

	public static void main(String[] args) {
		System.out.println("Tous les nombres de la plage [0;10]");
		for(int i=0;i<=10;i++)
		{
			System.out.println(i);
		}
		
		System.out.println("Les tables de multiplication");
		int multiplicateur; 
		for(multiplicateur=1;multiplicateur<=10;multiplicateur++) 
		{ 
		    for (int table = 1; table <= 10; table++) 
		    { 
		       System.out.print(table*multiplicateur + "\t"); 
		    } 
		    System.out.println(); 
		}
	}
}
