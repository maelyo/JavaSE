package fr.eni.editions.generiques;

import java.util.ArrayList; 
public class ListeGenerique <E> 
{ 
	// pour stocker les éléments de la liste 
    private ArrayList<E> liste; 
    // pointeur de position dans la liste 
    private int position; 
    // nombre d'éléments de la liste 
    private int nbElements; 
    // constructeur avec un paramètre permettant de dimensionner 
    // la liste 
    public ListeGenerique(int taille) 
    { 
     liste=new ArrayList<E>(taille); 
    } 
    public void ajout(E element) 
    { 
        liste.add(element); 
        nbElements = nbElements + 1; 
    } 

    public void insert(E element,int index) 
    { 
        // on vérifie si l'index n'est pas supérieur au nombre 
        // d'éléments ou si l'index n'est pas inférieur à 0 
        if (index >= nbElements || index < 0) 
        { 
           return; 
        } 
        liste.add(index,element); 
        // on met à jour le nombre d'éléments 
        nbElements = nbElements + 1; 
    } 
     
    public void remplace(E element,int index) 
    { 
        // on vérifie si l'index n'est pas supérieur au nombre 
        // d'éléments ou si l'index n'est pas inférieur à 0 
        if (index >= nbElements || index < 0) 
        { 
           return; 
        } 
        liste.set(index,element); 
    } 
    public void supprime(int index) 
    { 
        int i; 
        // on vérifie si l'index n'est pas supérieur au nombre 
        // d'éléments ou si l'index n'est pas inférieur à 0 
        if (index >= nbElements || index < 0) 
        { 
           return; 
        } 
        liste.remove(index); 
        // on met à jour le nombre d'éléments 
        nbElements = nbElements - 1; 
    } 
    public E getElement(int j)  
    { 
       return liste.get(j); 
    } 
    public int getNbElements() 
    { 
        return nbElements; 
    } 
    public E premier() throws Exception 
    { 
        if (nbElements == 0) 
        { 
            throw new Exception("liste vide"); 
        } 
        // on déplace le pointeur sur le premier élément 
        position = 0; 
        return liste.get(0); 
    } 
    public E dernier() throws Exception 
    { 
        if (nbElements == 0) 
        { 
            throw new Exception("liste vide"); 
        } 
        // on déplace le pointeur sur le dernier élément 
        position = nbElements - 1; 
        return liste.get(position); 
    } 
    public E suivant() throws Exception 
    { 
        if (nbElements == 0) 
        { 
            throw new Exception("liste vide"); 
        } 
        // on vérifie si on n'est pas à la fin de la liste 
        if (position == nbElements - 1) 
        { 
            throw new Exception("pas d'element suivant"); 
        } 
        // on déplace le pointeur sur l'élément suivant 
        position = position + 1; 
        return liste.get(position); 
    } 
    public E precedent() throws Exception 
    { 
        if (nbElements == 0) 
        { 
            throw new Exception("liste vide"); 
        } 
        // on vérifie si on n'est pas sur le premier élément 
        if (position == 0) 
        { 
            throw new Exception("pas d'élément précédent"); 
        } 
        // on se déplace sur l'élément précédent 
        position = position - 1; 
        return liste.get(position); 
    } 
}

