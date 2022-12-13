import java.util.*;

public class deck {

    List<card> DeckOfCards = new List<card>;

    public static void deck() {
        fillDeckwithCards();
        mixupDeck(4);
    }

    public void fillDeckwithCards(){
        DeckOfCards = new List<card>;
        // red [r], blue [b], green [g], yellow [y]
        String[] colours = {"red", "blue", "green", "yellow"};
        for (int c = 0, c <= colours.length, c++){
            for (int i = 0, i <= 9, i++){
                DeckOfCards.append(new card(colours[c], i));
            }
        }
    }

    public void mixupDeck(int p){
        List<card> tempDeck = new List<card>;
        DeckOfCards.toFirst();
        while (p!= 0){
            while (DeckOfCards.hasAccess()){
                int i = round( 1 + Math.random() * 3 );
                boolean firstmove = true;
                tempDeck.toFirst();
                while (i != 0 && DeckOfCards.hasAccess()){
                    if (firstmove) {
                        tempDeck.insert(DeckOfCards.getContent());
                        firstmove = false;
                    }
                    else {
                        tempDeck.next();
                        tempDeck.insert(DeckOfCards.getContent());
                        DeckOfCards.remove()
                    }
                    i--;
                }
            }
            p--;
        }
        DeckOfCards = tempDeck;
        tempDeck = null;
    }
}