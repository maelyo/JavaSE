package fr.eni.editions.classes;

import java.time.LocalDate;
import java.util.Random;

public class Personne {
	
//Variables membres
	private String nom; 
    private String prenom; 
    private LocalDate dateDeNaissance;
    //champ privé représentant le numéro de la Personne 
    private int numero; 
    //champ statique privé représentant le compteur de Personnes 
    private static int nbInstances/*=initCompteur()*/; 

//Bloc statique exécuté au chargement de la classe
    static
    {
    	Random rd = new Random();
    	nbInstances = rd.nextInt(1000);
    }
//Accesseurs / Getters/Setters
    public String getNom() 
    { 
        return nom; 
    } 
 
    public void setNom(String n) 
    { 
        if(n!=null)
        {
            nom = n.toUpperCase(); 
        }
    } 
 
    public String getPrenom() 
    { 
        return prenom; 
    } 
 
    public void setPrenom(String p) 
    { 
        if(p!=null)
        {
            prenom = p.toLowerCase(); 
        }
    }
    
    public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
    
    // méthode d'instance permettant d'obtenir le numéro d'une Personne 
    public int getNumero() 
    { 
         return numero; 
    } 
    // methode statique permettant d'obtenir le nombre d'instances créées 
    public static int getNbInstances() 
    { 
         return nbInstances; 
    }

//Constructeurs
    public Personne() 
    { 
        setNom(""); 
        setPrenom(""); 
        dateDeNaissance=null;
        // création d'une nouvelle Personne donc incrémentation du compteur 
        nbInstances++; 
        // affectation à la nouvelle Personne de son numéro 
        numero=nbInstances; 
    } 
    public Personne(String n, String p, LocalDate d) 
    {   
        setNom(n);
        setPrenom(p);
        dateDeNaissance=d; 
        // création d'une nouvelle Personne donc incrémentation du compteur 
        nbInstances++; 
        // affectation à la nouvelle Personne de son numéro 
        numero=nbInstances; 
    }
    //Méthode statique pour initialiser le compteur
    //Peut être utilisée en remplacement du bloc statique
    private static int initCompteur()
    { 
         int cpt=0; 
         Random rd = new Random();
         cpt=nbInstances = rd.nextInt(1000);
         return cpt; 
    }

//Desctructeur
    protected void finalize() throws Throwable 
    { 
     
    }
    
    
//Méthodes
    public int calculerAge() 
    { 
    	if(dateDeNaissance!=null)
    	{
    		return dateDeNaissance.until(LocalDate.now()).getYears();
    	}
    	return 0;
    } 
 
    @Deprecated
    public void afficher() 
    { 
        System.out.println("nom : " + nom); 
        System.out.println("prénom : " + prenom); 
        System.out.println("âge : " + calculerAge()); 
    } 
    
    //Surcharge de la méthode afficher()
    public void afficher(boolean francais) 
    { 
        if (francais) 
        { 
            System.out.println("nom : " + nom); 
            System.out.println("prénom : " + prenom); 
            System.out.println("âge : " + calculerAge()); 
        } 
        else 
        { 
            System.out.println("name : " + nom); 
            System.out.println("first name : " + prenom); 
            System.out.println("age : " + calculerAge()); 
        } 
    }
    //La méthode suivante ne compile pas car il y a déjà une méthode avec cette signature : afficher(boolean)
    /*public void afficher(boolean majuscule) 
    { 
        if (majuscule) 
        { 
            System.out.println("nom : " + nom.toUpperCase()); 
            System.out.println("prénom : " + prenom.toUpperCase()); 
            System.out.println("âge : " + calculerAge()); 
        } 
        else 
        { 
            System.out.println("nom : " + nom.toLowerCase()); 
            System.out.println("prénom : " + prenom.toLowerCase()); 
            System.out.println("âge : " + calculerAge()); 
        } 
    }*/

    public void afficher(String...couleurs) 
    { 
        { 
            if (couleurs==null) 
            { 
                System.out.println("pas de couleur"); 
                return; 
            } 
            switch (couleurs.length) 
            { 
                case 1: 
                    System.out.println("une couleur"); 
                    break; 
                case 2: 
                    System.out.println("deux couleurs"); 
                    break; 
                case 3: 
                    System.out.println("trois couleurs"); 
                    break; 
                default : 
                    System.out.println("plus de trois couleurs"); 
            } 
        } 
    }


}
