package edu.cs2430.assignment5;

public class Card{
    // the rank of the card
    private Rank rank;

    // the suit of the card
    private Suit suit;

    /**
     * Constructs a card with the given rank and suit
     * Assigns the rank and suit of the other card ot the rank and suit of this card
     *
     * @param rank - the rank of the card
     * @param suit - the suit of the card
     */
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Copy constructor
     * Constructs a card with the rank and suit from the other card
     * Assigns the rank and suit of the other card to the rank and suit of this card
     *
     * @param otherCard - the other card to be copied from
     */
    public Card(Card otherCard){
        this.rank = otherCard.rank;
        this.suit = otherCard.suit;
    }

    // getters and setters
    /**
     * Returns the rank of the card
     *
     * @return rank
     */
    public Rank getRank(){
        return rank;
    }

    /**
     * Returns the suit of the card
     *
     * @return suit
     */
    public Suit getSuit(){
        return suit;
    }

    // class variables

    /**
     * Compares this card with the other card
     * Compares the suits of the two cards via the suit compareTo method.
     * If the two suits are not equal, the result of suit comparison is returned.
     * If the two suits are equal, the ranks of the two cards are compared via the rank compareTo method.
     * The result of the rank comparison is returned.
     *
     * @param otherCard - the other card to compare with this one
     * @return - int - 0 means equal
     */
    public int compareTo(Card otherCard){
        int compare = suit.compareTo(otherCard.suit);

        if(compare == 0){
            if(rank.compareTo(otherCard.rank) != 0){
                compare = rank.compareTo(otherCard.rank);
            }
        }

        return compare;
    }

    /**
     * Returns if the objects are equal and false if the objects are not equal
     *
     * @param o - the other object to compare equality to this one
     * @return - true or false
     */
    public boolean equals(Object o){
        Card temp = (Card)o;
        if(getSuit().equals(temp.getSuit()) && getRank().equals(temp.getRank())){
            return true;
        }
        else return false;
    }

    /**
     * Returns the hashcode of this object
     *
     * @Override - hashCode in class Object
     * @return - hashcode
     */
    public int hashCode(){
        return this.hashCode();
    }

    /**
     * Returns the string representation of the card
     * The String representation must match mine and should leverage Rank.toString() and Suit.toString()
     * Examples:
     * "ace of hearts"
     * "two of spades"
     *
     * @return - String
     */
    public String toString(){
        return rank.toString() + " of " + suit.toString();
    }

}
