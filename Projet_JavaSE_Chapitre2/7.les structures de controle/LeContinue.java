import java.util.Arrays;
import java.util.Random;

public class LeContinue {

	public static void main(String[] args) {
		System.out.println("Combien de nombre paires consécutifs dans un tableau trié à partir du premier élément");
		int[] nombres = new int[20];
		Random rd = new Random();
		for (int i = 0; i < nombres.length; i++) {
			nombres[i]=rd.nextInt(20);
		}
		Arrays.sort(nombres);
		System.out.println(Arrays.toString(nombres));
		int nbPaire;
		for(nbPaire=0;nbPaire<nombres.length;nbPaire++)
		{
			if(nombres[nbPaire]%2==0)
			{
				continue;
			}
			break;
		}
		System.out.println("nombre de paires : " + nbPaire);
	}

}
