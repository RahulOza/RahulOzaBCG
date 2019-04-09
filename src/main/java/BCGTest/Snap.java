package BCGTest;

import Data.Card;
import Data.Deck;
import Data.Player;

import java.util.Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Documentation
 */
public class Snap {

    final static Logger logger = LogManager.getLogger(Snap.class.getName());

     private enum matchConditions {MATCH_SUIT, MATCH_VALUE, MATCH_EXACT }
     private matchConditions thisMatch = matchConditions.MATCH_SUIT;
     private static Stack<Card> winningCards = new Stack();


    private Boolean isHandWon(Card p1, Card p2){

        switch(thisMatch){
            case MATCH_SUIT:
                if(p1.cardSuit().equals(p2.cardSuit()))
                    return true;
            case MATCH_VALUE:
                if(p1.cardRank().equals(p2.cardRank()))
                    return true;
            case MATCH_EXACT:
                if(p1.cardSuit().equals(p2.cardSuit()) && p1.cardRank().equals(p2.cardRank()))
                    return true;
        }
        return false;
    }

    private int decideWinner() {
     //check the winning card count to decide winner
     return 1;
    }

    private void playGame(Player p1, Player p2){
        Card player1Card;
        Card player2Card;

        player1Card = p1.playCard();
        logger.info("Player1:" + player1Card.cardRank() + " of " + player1Card.cardSuit());
        player2Card = p2.playCard();
        logger.info("Player2:" + player2Card.cardRank() + " of " + player2Card.cardSuit());
        winningCards.push(player1Card);
        winningCards.push(player2Card);
        while(player1Card != null && player2Card != null){

            if(isHandWon(player1Card,player2Card)){
                // Player 2 has won

                logger.info("Player2: Snap!");

                int winsize = winningCards.size();

                while(!winningCards.isEmpty()){
                    p2.insertWinningCard(winningCards.pop());
                }
                logger.info("Player2: has won "+ winsize + " cards; their total is "+ p2.winningCardsCount() +" cards");

            }

                player1Card = p1.playCard();
                if(player1Card == null) {
                    logger.info("Player1 has no more cards ");
                    break;
                }


            winningCards.push(player1Card);
            logger.info("Player1:" + player1Card.cardRank() + " of " + player1Card.cardSuit());
            if(isHandWon(player1Card,player2Card)){
                // Player 1 has won

                logger.info("Player1: Snap!");

                int winsize = winningCards.size();

                while(!winningCards.isEmpty()){
                    p1.insertWinningCard(winningCards.pop());
                }

                logger.info("Player1: has won "+ winsize + " cards; their total is "+ p1.winningCardsCount() +" cards");
            }


                player2Card = p2.playCard();
                if(player2Card == null) {
                    logger.info("Player2 has no more cards ");
                    break;
                }

            winningCards.push(player2Card);
            logger.info("Player2:" + player2Card.cardRank() + " of " + player2Card.cardSuit());
        }

        if(p1.winningCardsCount() > p2.winningCardsCount()){
            //Player 1 has won
            logger.info("Player1 wins with "+p1.winningCardsCount()+" cards. Player 2 has "+p2.winningCardsCount()+" cards ");
        }
        else{
            //Player 2 has won
            logger.info("Player2 wins with "+p2.winningCardsCount()+" cards. Player 1 has "+p1.winningCardsCount()+" cards ");
        }
    }



    public static void main(String[] args) {
        Deck myInitialDeck = new Deck();
        Player player1 = new Player();
        Player player2 = new Player();
        Snap mySnapGame = new Snap();


        logger.info("snap 2 BySuit");

        myInitialDeck.populateDeck();
        myInitialDeck.shuffle();
        logger.info("Deck Shuffled");

        Boolean dealPlayer = false;

        for (Card dealCard: myInitialDeck.cards) {
            if(!dealPlayer) {
                player1.insertDealtCard(dealCard);
            }
            if(dealPlayer) {
                player2.insertDealtCard(dealCard);
            }
            dealPlayer = !dealPlayer;
        }

        logger.info("Cards dealth");

        mySnapGame.playGame(player1, player2);


    }
}
