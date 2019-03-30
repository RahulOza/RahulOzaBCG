package Data;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Player {
    private Stack<Card> playingCards;
    private Stack<Card> winningCards;

    public Player(){
        playingCards = new Stack<>();
        winningCards = new Stack<>();
    }

    public void insertDealtCard(Card toInsert){
        playingCards.push(toInsert);
    }

    public void insertWinningCard(Card toInsert){
        winningCards.push(toInsert);
    }

    public Card playCard(){
        try {
            return playingCards.pop();
        }
        catch(EmptyStackException e){
            return null;
        }
    }

    public int winningCardsCount(){
        return winningCards.size();
    }


}
