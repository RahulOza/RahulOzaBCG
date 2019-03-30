package Data;

public class Card {
    private Suit suit;
    private Rank rank;

    Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit cardSuit(){
        return suit;
    }

    public Rank cardRank(){
        return rank;
    }

}
