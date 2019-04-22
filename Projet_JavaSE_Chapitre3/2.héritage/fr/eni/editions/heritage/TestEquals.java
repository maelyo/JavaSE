package fr.eni.editions.heritage;

import java.time.LocalDate;

public class TestEquals {
	public static void main(String[] args) {
		Client c1,c2; 
		c1=new Client("ENI",
				      "",
				      LocalDate.of(1981,05,15),
				      TypeClient.ENTREPRISE); 
		c2=new Client("ENI",
				      "",
				      LocalDate.of(1981,05,15),
				      TypeClient.ENTREPRISE); 
		if (c1.equals(c2)) 
		{ 
		     System.out.println("les deux clients sont identiques"); 
		} 
		else 
		{ 
		     System.out.println("les deux clients sont différents"); 
		}
	}
}
