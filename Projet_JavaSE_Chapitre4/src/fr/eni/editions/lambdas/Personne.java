package fr.eni.editions.lambdas;

import java.time.LocalDate;
import java.util.Random;

public class Personne
{ 
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
 
    //@Deprecated
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
        
	@Override
	public String toString() 
	{ 
	     String chaine; 
	     chaine="nom : " + this.getNom()+ ", "; 
	     chaine=chaine + "prénom : " + this.getPrenom() + ", ";
	     chaine=chaine + "date de naissance : " + this.getDateDeNaissance();
	     return chaine; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDeNaissance == null) ? 0 : dateDeNaissance.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + numero;
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (dateDeNaissance == null) {
			if (other.dateDeNaissance != null)
				return false;
		} else if (!dateDeNaissance.equals(other.dateDeNaissance))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numero != other.numero)
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
	
}

