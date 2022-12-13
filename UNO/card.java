public class card
{
    private String colour;
    private int character;
    
    public card(String pcolour, int pcharacter) // Parameter für das Bauunternehmen, welches mit "new Schueler(...)" den einzelnen Schüler bauen kann
    {
        colour = pcolour;
        character = pcharacter;
    }

    public String getColour(){
        return colour;
    }

    public int getCharacter(){
        return character;
    }
}

