import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LesDatesEtLesHeures {
	public static void main(String[] args) throws ParseException 
	{
		{
			/***************************************
			 * Gestion des dates ancienne méthode: 
			 ***************************************/
			System.out.println("Gestion des dates ancienne méthode");
			System.out.println();
			
			//Création d'une date initialisée à maintenant
			Date maintenant = new Date();
			System.out.println("Aujourd'hui, nous sommes le " + maintenant.toString());
			
			//Formatage
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Aujourd'hui, nous sommes le " + sdf.format(maintenant));
			
			//Conversion chaine de caractères vers Date:
			String chaineDate = "25/12/2019";
			Date date25_12_2019 = sdf.parse(chaineDate);
			System.out.println(date25_12_2019);
			
			//Utilisation de la classe Calendar
			Calendar calendarHier = Calendar.getInstance();//initialise à aujourd'hui
			calendarHier.add(Calendar.DAY_OF_MONTH, -1);//enlève un jour
			Date hier = calendarHier.getTime();//permet d'obtenir un objet de type Date à partir d'un objet de type Calendar
			System.out.println("Hier, nous étions le " + sdf.format(hier));
			
			//Création d'un date à un jour précis:
			Date noel2019 = new GregorianCalendar(2019, 11, 25).getTime();//Mois en base 0
			System.out.println(sdf.format(noel2019));
			
			System.out.println();
		}
		{
			/***************************************
			 * Gestion des dates nouvelle méthode: 
			 ***************************************/
			System.out.println("Gestion des dates nouvelle méthode");
			System.out.println();
		
			//Création d'une date initalisée à maintenant / aujourdhui
			LocalDateTime maintenant = LocalDateTime.now();
			LocalDate aujourdhui = LocalDate.now();
			//Autre possiblité en transformant une LocalDateTime en LocalDate:
			//LocalDate aujourdhui = LocalDate.from(maintenant);
			System.out.println("Aujourd'hui, nous sommes le " + aujourdhui.toString());
			
			//Formatage
			DateTimeFormatter dtf =DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println("Aujourd'hui, nous sommes le " + dtf.format(aujourdhui));
					
			//Conversion chaine de caractères vers LocalTime
			LocalTime horloge = LocalTime.parse("22:45:03");
			System.out.println(horloge);
			LocalDate date25_12_2019 = LocalDate.parse("25/12/2019", dtf);
			System.out.println(date25_12_2019);
			
			//Changer l'heure
			LocalTime nouvelleHorloge = horloge.withHour(9);
			System.out.println(nouvelleHorloge);
			
			//Ajouter/retirer du temps
			LocalDate paques = LocalDate.of(2019, 4, 22);
			LocalDate ascension = paques.plusDays(39);
			System.out.println("En 2019, l'ascension est le " + dtf.format(ascension));
			
			//Programme permettant d'afficher le nombre de jours fériés un samedi ou un dimanche entre 2019 et 2030
			MonthDay[] fetes; 
			fetes=new MonthDay[8]; 
			fetes[0]=MonthDay.of(1,1); 
			fetes[1]=MonthDay.of(5,1); 
			fetes[2]=MonthDay.of(5,8); 
			fetes[3]=MonthDay.of(7,14); 
			fetes[4]=MonthDay.of(8,15); 
			fetes[5]=MonthDay.of(11,1); 
			fetes[6]=MonthDay.of(11,11); 
			fetes[7]=MonthDay.of(12,25); 
			         
			int nbJours; 
			int annee; 
			LocalDate jourTest; 
			for (annee=2019;annee<2030;annee++) 
			{ 
			     nbJours=0; 
			     for(MonthDay test:fetes) 
			     { 
			          jourTest=test.atYear(annee); 
			          if (jourTest.getDayOfWeek()==DayOfWeek.SATURDAY
			              ||jourTest.getDayOfWeek()==DayOfWeek.SUNDAY) 
			          { 
			               nbJours++; 
			          } 
			     } 
			     System.out.println("en " + annee + 
			                        " il y a " + nbJours + 
			                        " jour(s) ferie(s)" +
			                        " un samedi ou un dimanche"); 
			}  

			
		}
	}
}
