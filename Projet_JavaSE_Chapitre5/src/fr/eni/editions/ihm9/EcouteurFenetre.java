package fr.eni.editions.ihm9; 
 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
 
public class EcouteurFenetre extends WindowAdapter 
{ 
      public void windowClosing(WindowEvent arg0) 
      { 
           System.exit(0); 
      } 
} 
