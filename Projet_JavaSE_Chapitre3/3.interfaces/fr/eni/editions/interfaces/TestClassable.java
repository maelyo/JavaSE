package fr.eni.editions.interfaces;

import java.time.LocalDate;
import java.util.Arrays;

public class TestClassable {

public static void main(String[] args) 
{
	Personne[] tableauNonTrie = new Personne[5]; 
	tableauNonTrie[0] = new Personne("toto2", "prenom2",LocalDate.of(1922,2,15)); 
	tableauNonTrie[1] = new Personne("toto1", "prenom1",LocalDate.of(1911,1,15)); 
	tableauNonTrie[2] = new Personne("toto5", "prenom5",LocalDate.of(1955,05,15)); 
	tableauNonTrie[3] = new Personne("toto3", "prenom3",LocalDate.of(1933,03,15)); 
	tableauNonTrie[4] = new Personne("toto4", "prenom4",LocalDate.of(1944,04,15)); 
	Personne[] tableauTrie; 
	tableauTrie=(Personne[])tri(tableauNonTrie); 
	for (int i=0;i<tableauTrie.length;i++) 
	{ 
		System.out.println(tableauTrie[i]); 
	}
	
	String[] tableauDeChaines = {"Bonjour", "tout", "le", "monde"};
	//Ne compile pas car la classe String n'implémente pas l'interface Classable
	//tri(tableauDeChaines);
}
	
public static Classable[] tri(Classable[] tablo) 
{ 
     int i,j; 
     Classable c; 
     Classable[] tabloTri;
     tabloTri = Arrays.copyOf(tablo, tablo.length);
     for (i=0;i< tabloTri.length;i++) 
     { 
        for( j = i + 1; j<tabloTri.length;j++) 
        { 
            if (tabloTri[j].compare(tabloTri[i])==Classable.INFERIEUR) 
            { 
                c = tabloTri[j]; 
                tabloTri[j] = tabloTri[i]; 
                tabloTri[i] = c; 
            } 
            else if (tabloTri[j].compare(tabloTri[i])==Classable.ERREUR) 
            { 
                 return null; 
            } 
        } 
     } 
     return tabloTri; 
}

}
