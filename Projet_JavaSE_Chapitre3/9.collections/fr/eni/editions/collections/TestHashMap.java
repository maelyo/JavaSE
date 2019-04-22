package fr.eni.editions.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestHashMap {

	public static void main(String[] args) {
		Map<Integer, String> departements = new HashMap<Integer, String>();
		departements.put(35, "Ille Et Vilaine");
		departements.put(44, "Loire-Atlantique");
		departements.put(56, "Morbihan");
		departements.put(29, "Fin");
		//Correction par écrasement:
		departements.put(29, "Finistère");
		departements.put(22,"Côtes d'Armor");
		//Suppression d'une entrée
		departements.remove(22);
		
		String dep35 = departements.get(35);
		System.out.println("Le nom du département 35 est : " + dep35);
		
		System.out.println("Est-ce que le département 29 est référencé?");
		//Recherche d'un élément par la clé
		if(departements.containsKey(29))
		{
			System.out.println("oui");
		}
		else
		{
			System.out.println("non");
		}
		
		System.out.println("Est-ce que le Morbihan est référencé?");
		//Recherche d'un élément par la valeur
		if(departements.containsValue("Morbihan"))
		{
			System.out.println("oui");
		}
		else
		{
			System.out.println("non");
		}
		
		System.out.println("Liste des clés");
		//Parcourir la collection de clés (c'est un Set car chaque clé est unique)
		for(int cle:departements.keySet())
		{
			System.out.println("-"+cle);
		}
		
		System.out.println("Liste des valeurs");
		//Parcourir la collection de valeurs
		for(String valeur:departements.values())
		{
			System.out.println("-"+valeur);
		}
		
		System.out.println("Liste des entrées clé/valeur");
		//Parcourir la collection de clé/valeur (c'est un Set car chaque clé est unique)
		for(Entry<Integer, String> entree:departements.entrySet())
		{
			System.out.println(entree.getKey()+"="+entree.getValue());
		}
	}
}
