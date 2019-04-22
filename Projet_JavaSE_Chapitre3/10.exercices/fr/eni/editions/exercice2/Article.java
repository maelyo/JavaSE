package fr.eni.editions.exercice2;

public class Article  
{ 
    private int reference; 
    private String designation; 
    private double prix; 
     
    public Article() 
    { 
        super(); 
    } 
      
    public Article(int reference) 
    { 
        this(); 
        setReference(reference); 
    } 
    public Article(int reference,String designation) 
    { 
        this(reference); 
        setDesignation(designation); 
    } 
      
    public Article(int reference,String designation, 
double prix) 
    { 
        this(reference,designation); 
        setPrix(prix); 
    } 
  
    public int getReference()  
    { 
        return reference; 
    } 
  
    public void setReference(int reference)  
    { 
        this.reference = reference; 
    } 
  
    public String getDesignation()  
    { 
        return designation; 
    } 
  
    public void setDesignation(String designation)  
    { 
        this.designation = designation; 
    } 
  
    public double getPrix() { 
        return prix; 
    } 
  
    public void setPrix(double prix)  
    { 
        this.prix = prix; 
    } 
      
    public String toString() 
    { 
        return getReference() + " " + getDesignation() + 
" " + getPrix(); 
	}

}  
