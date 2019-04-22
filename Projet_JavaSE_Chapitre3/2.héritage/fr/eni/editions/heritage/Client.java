package fr.eni.editions.heritage;

import java.time.LocalDate;

public class Client extends Personne {
//Variables membres
	private TypeClient type;

//Accessseurs	
	public TypeClient getType() {
		return type;
	}

	public void setType(TypeClient t) {
		type = t;
	}

//Constructeurs
	public Client() {
		super();
	}
	public Client(String nom, String prenom, LocalDate dateDeNaissance, TypeClient type) {
		super(nom, prenom, dateDeNaissance);
		this.type = type;
	}
	
//Méthodes	
	@Override
	public void afficher() {
		/*System.out.println("nom : " + getNom()); 
        System.out.println("prénom : " + getPrenom()); 
        System.out.println("âge : " + calculerAge());*/
		//afficher();//StackOverflowError
		super.afficher();
	    switch (type) 
	    { 
	    	case PARTICULIER: 
	            System.out.println("type de client : Particulier"); 
	            break; 
	    	case ENTREPRISE: 
	    		System.out.println("type de client : Entreprise"); 
	    		break; 
	    	case ADMINISTRATION: 
	    		System.out.println("type de client : Administration"); 
	    		break; 
	     } 
	}
	
	@Override
	public boolean equals(Object obj) 
	{ 
	     Client c; 
	     // vérification si obj est null ou référence une instance 
	     // d'une autre classe 
	     if (obj ==null || obj.getClass()!=this.getClass()) 
	     { 
	          return false; 
	     } 
	     else        
	     { 
	          c=(Client)obj; 
	          // vérification des critères d'égalité sur 
	          // - le nom 
	          // - le prénom 
	          // - la date de naissance 
	          // - le type de client 
	          if (c.getNom().equals(this.getNom())&& 
	                    c.getPrenom().equals(this.getPrenom()) && 
	                    c.getDateDeNaissance().equals(this.getDateDeNaissance()) && 
	                    c.getType().equals(this.getType())) 
	          { 
	               return true; 
	          } 
	          else 
	          { 
	               return false; 
	          } 
	     } 
	}
	
	public int hashCode() 
	{ 
	     return this.getNom().hashCode()+ 
	            this.getPrenom().hashCode() + 
	            this.getDateDeNaissance().hashCode()+ 
	            this.getType().hashCode(); 
	}


}





































