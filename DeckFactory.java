package edu.cs2430.assignment5;

/**
 * Class to provide a factory method to create a standard deck of cards <br>
 * Extendable to more factory methods to create different card decks
 *
 * @author Doug
 */
public class DeckFactory
{
    /**
     * Factory method which creates a standard deck of cards <br>
     * The cards should be ordered by suit and then by rank
     *
     * @return Returns a card group representing a standard deck of cards
     */
    public static CardGroup createStandardDeck()
    {
        CardGroup standardDeck = new CardGroup();

        // Will need to give student a hint to use Suit.values()
        for(Suit suit : Suit.values())
        {
            for(Rank rank : Rank.values())
            {
                Card newCard = new Card(rank, suit);
                standardDeck.addCard(newCard);
            }
        }

        return standardDeck;
    }
}
