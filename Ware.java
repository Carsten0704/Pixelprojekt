public class Ware
{
    //Variablendefinition
    String name;
    int anzahl;
    double preis;
	String warenwunsch;

    //Konstruktor
    public Ware(String pName, int pAnzahl, double pPreis)
    {
        name = pName;
        anzahl = pAnzahl;
        preis = pPreis;
    }
	
	public Ware(String pName)
	{
		warenwunsch = pName;
	}

    //get-Methoden
    public String getName()
    {
        return name;
    }
    public int getAnzahl()
    {
        return anzahl;
    }
    public double getPreis()
    {
        return preis;
    }
	
	//set-Methoden
	public void setAnzahl(int pNeueAnzahl)
	{
		anzahl = pNeueAnzahl;
	}


}
