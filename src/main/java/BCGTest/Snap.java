package BCGTest;

import Data.Card;
import Data.Deck;
import Data.Player;


import java.util.Stack;
import java.util.logging.Logger;

import static BCGTest.Snap.decideHand;

/**
 * Documentation
 */
public class Snap {
     private enum matchConditions {MATCH_SUIT, MATCH_VALUE, MATCH_EXACT }
     private matchConditions thisMatch = matchConditions.MATCH_SUIT;
     private static Stack<Card> winningCards = new Stack();


    private static int decideHand(Card p1, Card p2){
        //retunr 1 if player 1 wins and 2 if player 2 wins

        return 1;
    }

    private int decideWinner() {
     //check the winning card count to decide winner
     return 1;
    }

    private static void playGame(Player p1, Player p2){
        Card player1Card;
        Card player2Card;

        player1Card = p1.playCard();
        player2Card = p2.playCard();
        winningCards.push(player1Card);
        winningCards.push(player2Card);
        while(player1Card != null && player2Card != null){
            decideHand(player1Card,player2Card);
            //if player 1 wins add cards to player 1's winning hand


            player1Card = p1.playCard();
            winningCards.push(player1Card);
            decideHand(player1Card,player2Card);
            player2Card = p2.playCard();
            winningCards.push(player2Card);
        }
    }


    final static Logger logger = Logger.getLogger(Snap.class.getName());
    public static void main(String[] args) {
        Deck myInitialDeck = new Deck();
        Player player1 = new Player();
        Player player2 = new Player();


        logger.info("Program started");
        myInitialDeck.shuffle();


        for (Card dealCards: myInitialDeck.cards) {
            player1.insertDealtCard(dealCards);
            player2.insertDealtCard(dealCards);
        }

        playGame(player1, player2);








    }
}
