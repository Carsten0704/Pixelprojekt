import java.util.*;

public class Main
{
	static Scanner mS;
	static Kunde ersterKunde = null;
	static int regalzaehler = 0;
	static Ware[] warenregal = new Ware[20]; // Anlegen eines Regals mit dem Namen "warenregal" und 20 Faechern
											 // das Regal darf nur Elemente vom Typ "Ware" enthalten
	public static void main(String[] args)
	{
		mS = new Scanner(System.in);
		System.out.println("Cafe Pixel");
		System.out.println("----------");

		while(true) //Endlosschleife
		{
			System.out.println("Wähle aus!");
			System.out.println("1. Kunde anlegen");
			System.out.println("2. Kunden anzeigen");
			System.out.println("3. Ersten Kunden loeschen");
			System.out.println("7. Ware anlegen");
			System.out.println("4. Programm beenden");
			
			int auswahl = mS.nextInt();
			
			if(auswahl == 1)
			{
				// Quelltext, dafür, dass Auswahl 1 ist
				System.out.println();
				System.out.println("Wie soll dein Kunde heissen?");
				
				String eingabeName;
				eingabeName = mS.next();
				
				System.out.println();
				System.out.println("Wie viel Geld hat dein Kunde?");
				
				double eingabeGeld;
				eingabeGeld = mS.nextDouble();
				
				System.out.println();
				System.out.println("Was moechte dein Kunde haben?");
				
				String gewuenschteWare;
				gewuenschteWare = mS.next();
				mS.reset();
				
				System.out.println();
				System.out.println("Wie viel Ware moechte dein Kunde haben?");

				int eingabeWarenmenge;
				eingabeWarenmenge = mS.nextInt();
				
				Kunde neuerKunde = new Kunde(eingabeName, eingabeGeld, eingabeWarenmenge, new Ware( gewuenschteWare ));
				
				if(ersterKunde == null)
				{
					ersterKunde = neuerKunde;
				}
				else
				{
					ersterKunde.haengeAn(neuerKunde);
				}
			}
			
			if(auswahl == 2)
			{
				if(ersterKunde == null)
				{
					System.out.println("Es gibt keine Kunden");
				}
				else
				{
					Kunde temp = ersterKunde;
					{
						while(temp != null)
						{
							System.out.println(temp.getName());
							temp = temp.getNachfolger();
						}
					}
				}
			}
			
			if(auswahl == 3)
			{
				if(ersterKunde == null)
				{
					// tue nix
				}
				else
				{
					if(ersterKunde.gibtEsEinenNachfolger())
					{
						ersterKunde = ersterKunde.getNachfolger();
					}
					else
					{
						ersterKunde = null;
					}
				}
				
			}
			
			if(auswahl == 4)
			{
				// ein Zeiger ist immer vom Typ der Elemente, die in der Datenstruktur gespeichert sind
				Kunde zeiger = ersterKunde;
				
				while(zeiger.getNachfolger().gibtEsEinenNachfolger()) // hat der Nachfolger des Zeigers einen Nachfolger?
				{
					zeiger = zeiger.getNachfolger();
				}
				zeiger.setNachfolger(null);
			}
			
			if(auswahl == 5)
			{
				System.exit(0);
			}
			
			if(auswahl == 7)
			{
				if(regalzaehler <= 19)
				{
					System.out.println("Name der Ware:");
					String eingabeNameWare = mS.next();
					mS.reset();

					System.out.println("Preis der Ware:");
					double eingabePreis = mS.nextDouble();
					mS.reset();

					System.out.println("Anzahl der Ware:");
					int anzahlWare = mS.nextInt();
					mS.reset();

					Ware neueWare = new Ware(eingabeNameWare, anzahlWare, eingabePreis);

					warenregal[regalzaehler] = neueWare;
					regalzaehler++;
				}
				else
				{
					System.out.println("Das Regal ist leider voll");
				}
			}
		}
		
		

	}
}
