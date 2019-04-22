package fr.eni.editions.heritage;

public class TestGetClass {

	public static void main(String[] args) {
		Client c = new Client();
		infoClasse(c);
	}
	
public static void infoClasse(Object o) 
{ 
     Class c; 
     c=o.getClass(); 
     System.out.println("nom de la classe : " + c.getName()); 
     System.out.println("elle est dans le package : " +  
    		 			c.getPackage().getName()); 
     System.out.println("elle hérite de la classe  : " +  
    		 			c.getSuperclass().getName()); 
     System.out.println("elle possède les champs : "); 
     for (int i=0;i<c.getFields().length;i++) 
     { 
          System.out.print("\t" + c.getFields()[i].getName()); 
          System.out.println(" de type :" +  
        		  		c.getFields()[i].getType().getName()); 
     } 
     System.out.println("elle possède les méthodes : "); 
     for (int i=0;i<c.getMethods().length;i++) 
     { 
          System.out.print("\t" + c.getMethods()[i].getName()); 
          System.out.print(" qui attend comme paramètre ("); 
          for (int j=0;j<c.getMethods()[i]
        		          .getParameterTypes()
        		          .length;j++) 
          {
        	  System.out.print(c.getMethods()[i]
        			            .getParameterTypes()[j]+ " "); 
          } 
          System.out.println(")"); 
     } 
}


}
