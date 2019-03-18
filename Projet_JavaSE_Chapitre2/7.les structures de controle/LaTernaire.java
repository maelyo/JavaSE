
public class LaTernaire {

	public static void main(String[] args) {
		int nombreChevaux = 1;
		String formatMessageNombreChevaux = "il y a %d cheva";
		//il faut déterminer la terminaison : cheval ou chevaux?
		/*if(nombreChevaux>1)
		{
			formatMessageNombreChevaux+="ux";
		}
		else
		{
			formatMessageNombreChevaux+="l";
		}*/
		formatMessageNombreChevaux+= (nombreChevaux>1?"ux":"l");
		System.out.println(String.format(formatMessageNombreChevaux, nombreChevaux));
	}

}
