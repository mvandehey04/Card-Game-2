package edu.cs2430.assignment5;
import java.util.HashMap;
import java.util.Map;

public class Game41Utils {
    private static Map<Rank, Integer> rankToPointMap = new HashMap<>();;

    public Game41Utils(){

    }

    /**
     * Returns the point value associated with the card rank Must use the rankToPoint map to look up the value
     *
     * Ace = 11
     * Two = 2
     * Three = 3
     * Four = 4
     * Five = 5
     * Six = 6
     * Seven = 7
     * Eight = 8
     * Nine = 9
     * Ten = 10
     * Jack = 10
     * Queen = 10
     * King = 10
     *
     * @param rank - the rank of the card
     * @return - the point value
     */
    public static int getPointValue(Rank rank){
        rankToPointMap.put(Rank.ACE, 11);
        rankToPointMap.put(Rank.TWO, 2);
        rankToPointMap.put(Rank.THREE, 3);
        rankToPointMap.put(Rank.FOUR, 4);
        rankToPointMap.put(Rank.FIVE, 5);
        rankToPointMap.put(Rank.SIX, 6);
        rankToPointMap.put(Rank.SEVEN, 7);
        rankToPointMap.put(Rank.EIGHT, 8);
        rankToPointMap.put(Rank.NINE, 9);
        rankToPointMap.put(Rank.TEN, 10);
        rankToPointMap.put(Rank.JACK, 10);
        rankToPointMap.put(Rank.QUEEN, 10);
        rankToPointMap.put(Rank.KING, 10);
        if(rankToPointMap != null && rankToPointMap.get(rank) != null){
            return rankToPointMap.get(rank);
        }
        else{
            return 0;
        }
    }

    /**
     * Calculates the value for a given hand.
     * The points for each suit are calculated, which is the sum of all ranks with that suit.
     * The points for each suit should be stored in a collection (e.g. a map)
     * The points from suits with lower point values are subtracted from the points of the suit with the highest value.
     * The final value is returned.
     * Example:
     * AC, 9D, 5D, 2S
     *
     * Clubs = 11
     * Diamonds = 9 + 5 = 14
     * Hearts = 0
     * Spades = 2
     *
     * 14 - 11 - 0 - 2 = 1
     * Final value = 1
     *
     * @param hand - the CardGroup representing a hand
     * @return - the point value for the given hand
     */
    public static int calculateHandValue(CardGroup hand){
        Map<Suit, Integer> suitValues = new HashMap<>();

        for(int i = 0; i < hand.size(); i++){
            if(hand.getCard(i) == null){
                break;
            }
            else{
                Suit currentSuit = hand.getCard(i).getSuit();
                int currentPoints = getPointValue(hand.getCard(i).getRank());
                suitValues.put(currentSuit, suitValues.getOrDefault(currentSuit, 0) + currentPoints);
            }
         }

        int maxValue = 0;

        for(int points : suitValues.values()){
            if (points > maxValue){
                maxValue = points;
            }
        }

        int totalPoints = 0;
        for(int points : suitValues.values()){
            if(points != maxValue){
                totalPoints += points;
            }
        }

        return maxValue - totalPoints;
    }

    /**
     * Determines if the hand is over.
     * If there are no more cards in the deck then the hand is over.
     * If the current turn is for a player that had knocked the previous turn then the hand is over.
     *
     * @param deck - the deck of cards
     * @param knockIndex - the index of the player who knocked. -1 if no player has knocked
     * @param currentIndex - the index of the current player
     * @return - true if the hand is over, false otherwise
     */
    public static boolean isHandOver(CardGroup deck, int knockIndex, int currentIndex){
        boolean over = false;

        if(deck.getLastCard() == null){
            over = true;
        }

        if(knockIndex != -1 && knockIndex == currentIndex){
            over = true;
        }

        return over;
    }
}