
public class LesOperateursLogiques {
	static boolean test1;
	static boolean test2;
	public static void main(String[] args) {
		test1=true;
		test2=true;
		tester();
		
		test1=false;
		test2=false;
		tester();
		
		test1=true;
		test2=false;
		tester();

		test1=false;
		test2=true;
		tester();

	}

	private static void tester() {
		//Je lis la valeur des booléens au travers des méthodes isTest1() et isTest2() 
		//pour pouvoir mettre en évidence l'évaluation des valeurs en écrivant une trace sur la console.
		//Ca permet de mettre en évidentce le fonctionnement des opérateurs && et ||.
		System.out.println("test1 = " + test1 + " et test2 = " + test2 );
		System.out.println();
		System.out.println(" =>test1 & test2");
		System.out.println(" résultat = " + (isTest1() & isTest2()));
		System.out.println();
		System.out.println(" =>test1 | test2");
		System.out.println(" résultat = " + (isTest1() | isTest2()));
		System.out.println();
		System.out.println(" =>test1 ^ test2");
		System.out.println(" résultat = " + (isTest1() ^ isTest2()));
		System.out.println();
		System.out.println(" =>!test1");
		System.out.println(" résultat = " + (!isTest1()));
		System.out.println();
		System.out.println(" =>test1 && test2");
		System.out.println(" résultat " + (isTest1() && isTest2()));
		System.out.println();
		System.out.println(" =>test1 || test2");
		System.out.println(" résutlat = " + (isTest1() || isTest2()));
		
		System.out.println();
	}
	
	public static boolean isTest1() {
		System.out.println(" --évaluation test1 ("+test1+")--");
		return test1;
	}
	public static boolean isTest2() {
		System.out.println(" --évaluation test1 ("+test2+")--");
		return test2;
	}

}
