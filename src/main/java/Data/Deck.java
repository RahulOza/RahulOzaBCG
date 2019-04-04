package Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final static int DECK_SIZE = 52;

    public List<Card> cards;

    public Deck(){
       this.cards = new ArrayList<>(DECK_SIZE);
    }

    public void populateDeck(){
        for(Suit suit:Suit.values())
            for(Rank rank: Rank.values())
                cards.add(new Card(suit,rank));
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }


}
