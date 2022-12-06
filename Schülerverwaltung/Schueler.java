public class Schueler
{
    private String name;
    private String vorname;
    private int alter;
    private char geschlecht;
    private String klasse;

    private double wurf;
    private double lauf;
    private double sprung;

    public Schueler(String pvorname, String pname, int palter, char pgeschlecht, String pklasse, double pwurf, double plauf, double psprung) // Parameter für das Bauunternehmen, welches mit "new Schueler(...)" den einzelnen Schüler bauen kann
    {
        name = pname;
        vorname = pvorname;
        alter = palter;
        geschlecht = pgeschlecht;
        klasse = pklasse;
        wurf = pwurf;
        lauf = plauf;
        sprung= psprung;
    }

    public String name()
    {
        return name;
    }

    public double getWurf()
    {
        return wurf;
    }

    public double getLauf()
    {
        return lauf;
    }

    public double getSprung()
    {
        return sprung;
    }

    public void setWurf(double pWurf)
    {
        wurf = pWurf;
    }

    public void setLauf(double pLauf)
    {
        lauf = pLauf;
    }

    public void setSprung(double pSprung)
    {
        sprung = pSprung;
    }
    public String vorname()
    {
        return vorname;
    }

    public int getAlter()
    {
        return alter;
    }

    public void setAlter(int pAlter)
    {
        alter = pAlter;
    }

    public char geschlecht()
    {
        return geschlecht;
    }

    public String klasse()
    {
        return klasse;
    }

    public void setKlasse(String pKlasse)
    {
        klasse = pKlasse;
    }
}

