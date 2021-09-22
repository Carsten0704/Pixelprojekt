public class Kunde
{
	//Variablendefinition
	String name;
	double geld;
	int anzahl;
	int zeit;
	Ware warenwunsch;
	
	Kunde meinNachfolger = null;
	
	// Konstruktor
	public Kunde(String pName, double pGeld, int pAnzahl, Ware pGewuenschteWare)
	{
		name = pName;
		geld = pGeld;
		anzahl = pAnzahl;
		warenwunsch = pGewuenschteWare;
	}
	
	// get-Methoden
	public String getName()
	{
		return name;
	}
	
	public Ware getGewuenschteWare()
	{
		return warenwunsch;
	}
	
	public Kunde getNachfolger()
	{
		return meinNachfolger;
	}
	
	public boolean gibtEsEinenNachfolger()
	{
		if(meinNachfolger == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void setNachfolger(Kunde pEinzufuegenderKunde)
	{
		meinNachfolger = pEinzufuegenderKunde;
	}
	
	public void haengeAn(Kunde pAnzuhaengenderKunde)
	{
		if(this.gibtEsEinenNachfolger() == false)
		{
			this.setNachfolger(pAnzuhaengenderKunde);
		}
		else
		{
			meinNachfolger.haengeAn(pAnzuhaengenderKunde);
			// die Methode haengeAn wird innerhalb derselben Methode wieder verwendet
			// Man nennt eine solche Vorgehensweise rekursiv, oder Rekursion.
		}
	}
}
