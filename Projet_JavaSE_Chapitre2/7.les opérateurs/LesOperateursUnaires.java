
public class LesOperateursUnaires {
	public static void main(String[] args) {
			int i;
			
			//Opérateur postfixé (évalué après l'utilisation de la valeur dans l'expression)		
			i=3; 
			System.out.println("i = " + (i++));
			
			//Opérateur postfixé (évalué avant l'utilisation de la valeur dans l'expression)
			i=3;
			System.out.println("i = " + (++i));
	}
}
