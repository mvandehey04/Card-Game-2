package edu.cs2430.assignment5;
import java.util.*;

public class CardGroup{
    // a list of cards
    private final List<Card> cardList;

    /**
     * Constructs a new CardGroup and initializes cardList to be an empty list
     */
    public CardGroup(){
        cardList = new ArrayList<Card>();
    }

    /**
     * Copy constructor
     * Constructs a group of cards from another CardGroup
     *
     * @param otherGroup - the other card group to copy into this one
     */
    public CardGroup(CardGroup otherGroup){
        cardList = new ArrayList<Card>();
        for(int i = 0; i < otherGroup.cardList.size(); i++){
            cardList.add(otherGroup.cardList.get(i));
        }
    }

    // getters and setters

    /**
     * Returns the card at the specified index
     *
     * @param index - the index of the card to return
     * @return - the card at the specified index
     */
    public Card getCard(int index){
        return cardList.get(index);
    }

    /**
     * Returns the last card in card group
     *
     * @return - the last card in card group or null if there are no cards
     */
    public Card getLastCard(){
        if(!cardList.isEmpty()){
            return cardList.get(cardList.size() - 1);
        }
        else{
            return null;
        }
    }

    // class methods
    /**
     * Adds the given card to the cardList
     *
     * @param card - the card to add to the cardList
     */
    public void addCard(Card card){
        cardList.add(card);
    }

    /**
     * Removes the last card in the card group
     *
     * @return - card
     */
    public Card removeLastCard(){
        Card card = null;
        if(cardList.size() > 1){
            card = cardList.get(cardList.size() - 1);
            cardList.remove(card);
        }
        return card;
    }

    /**
     * Removes the card at the specified index
     *
     * @param index - the index of the card to be removed
     * @return - the card that was removed
     */
    public Card removeCard(int index){
        Card card = null;
        if(cardList.size() > 1){
            card = cardList.get(index);
            cardList.remove(card);
        }
        return card;
    }

    /**
     * Determines is the card group empty
     *
     * @return - true if the group is empty, false otherwise
     */
    public boolean isEmpty(){
        if(cardList.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns the size of the card group
     *
     * @return - the size of cardList
     */
    public int size(){
        return cardList.size();
    }

    /**
     * Shuffles the deck of cards uses the version of the Fisher-Yates algorithm
     * https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
     * For each position in the list, the random object should be called exactly once to find a random position to swap with
     *
     * @param random - the random object to use when shuffling
     */
    public void shuffle(Random random){
        for(int i = 0; i < cardList.size()-2; i++){
            int j = random.nextInt(i, cardList.size());
            Card jCard = cardList.get(j);
            Card iCard = cardList.get(i);
            cardList.set(j, iCard);
            cardList.set(i, jCard);
        }
    }

    /**
     * Sorts the card group
     */
    public void sort(){
        List<Card> cardHolder = new ArrayList<>();
        List<Card> finalList = new ArrayList<>();

        // club check
        for(int i = 0; i < cardList.size(); i++){
            if(cardList.get(i).getSuit() == Suit.CLUBS){
                cardHolder.add(cardList.get(i));
            }
        }

        // rank check of clubs
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.ACE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.TWO){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.THREE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.FOUR){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.FIVE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.SIX){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.SEVEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.EIGHT){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.NINE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.TEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.JACK){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.QUEEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.KING){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }

        // diamond check
        for(int i = 0; i < cardList.size(); i++){
            if(cardList.get(i).getSuit() == Suit.DIAMONDS){
                cardHolder.add(cardList.get(i));
            }
        }

        // rank check of diamonds
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.ACE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.TWO){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.THREE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.FOUR){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.FIVE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.SIX){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.SEVEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.EIGHT){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.NINE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.TEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.JACK){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.QUEEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.KING){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }

        // heart check
        for(int i = 0; i < cardList.size(); i++){
            if(cardList.get(i).getSuit() == Suit.HEARTS){
                cardHolder.add(cardList.get(i));
            }
        }

        // rank check of hearts
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.ACE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.TWO){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.THREE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.FOUR){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.FIVE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.SIX){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.SEVEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.EIGHT){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.NINE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.TEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.JACK){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.QUEEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.KING){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }

        // spade check
        for(int i = 0; i < cardList.size(); i++){
            if(cardList.get(i).getSuit() == Suit.SPADES){
                cardHolder.add(cardList.get(i));
            }
        }

        // rank check of spades
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.ACE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.TWO){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.THREE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.FOUR){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.FIVE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.SIX){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.SEVEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.EIGHT){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.NINE){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.TEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.JACK){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.QUEEN){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }
        for(int i = 0; i < cardHolder.size(); i++){
            if(cardHolder.get(i).getRank() == Rank.KING){
                finalList.add(cardHolder.get(i));
                cardHolder.remove(i);
            }
        }

        for(int i = 0; i < cardList.size(); i++){
            cardList.set(i, finalList.get(i));
        }
    }

    /**
     * Clears the cardArray by setting all elements to null
     */
    public void clear(){
        for(int i = (cardList.size()-1); i >= 0; i--){
            cardList.remove(cardList.get(i));
        }
    }

    /**
     * Overrides equals in class Object
     *
     * @param o - the other object to compare equality to this one
     * @return - true if the objects are equal and false if the objects are not equal
     */
    @Override
    public boolean equals(Object o){
        CardGroup temp = (CardGroup)o;
        boolean equal = false;
        if(!temp.isEmpty()){
            if(getLastCard().equals(temp.getLastCard())){
                equal = true;
            }
        }
        return equal;
    }

    /**
     * Overrides hashCode in class Object
     *
     * @return - the hashCode of this object
     */
    @Override
    public int hashCode(){
        return Objects.hash(cardList);
    }

    /**
     * Returns the string representation of the card group
     * Overrides toString in class Object
     *
     * @return - the string representation of the card group
     */
    @Override
    public String toString() {
        StringBuilder stringHolder = new StringBuilder();
        for (int i = 0; i < cardList.size(); i++) {
            stringHolder.append(cardList.get(i));
            stringHolder.append("\n");
        }
        return stringHolder.toString();
    }
}