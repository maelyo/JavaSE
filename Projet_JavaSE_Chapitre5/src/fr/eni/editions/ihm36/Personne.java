package fr.eni.editions.ihm36;

import java.time.LocalDate;
import java.util.Random;

public class Personne {
	
	private String nom; 
    private String prenom; 
    private LocalDate dateDeNaissance;

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


    public Personne(String n, String p, LocalDate d) 
    {   
        setNom(n);
        setPrenom(p);
        dateDeNaissance=d; 
    }

	@Override
	public String toString() {
		return  nom + " " + prenom;
	}
    
    
}
