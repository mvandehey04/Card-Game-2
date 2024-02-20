
package edu.cs2430.assignment5;

import java.util.Random;

/**
 * Class with game logic to run the game
 *
 * @author Doug
 */
public class Assignment5
{
	/**
	 * Variable to represent the number of players
	 */
	private static final int NUMBER_OF_PLAYERS = 4;

	/**
	 * Variable to represent the number of cards in a hand
	 */
	private static final int NUMBER_OF_CARDS_IN_HAND = 4;


	/**
	 * Creates the hands in the game
	 *
	 * @return Returns an array of CarsGroup objects representing each player's hand
	 */
	private static CardGroup[] createHands()
	{
		CardGroup[] hands = new CardGroup[NUMBER_OF_PLAYERS];

		for (int i=0; i<NUMBER_OF_PLAYERS; i++)
		{
			hands[i] = new CardGroup();
		}
		
		return hands;
	}

	
	/**
	 * Deals four cards to all players.<br>
	 * When a card is dealt to a hand, the card is removed from the deck and added to the hand
	 *
	 * @param deck The deck of cards to deal from
	 * @param hands The hands for all players
	 */
	private static void dealHands(CardGroup deck, CardGroup[] hands)
	{
		for(int i=0; i<NUMBER_OF_CARDS_IN_HAND; i++)
		{
			for (CardGroup hand : hands)
			{
				hand.addCard(deck.removeLastCard());
			}
		}

		for (CardGroup hand : hands)
		{
			hand.sort();
		}

	}
	
	/**
	 * Logic for playing the card game
	 * 
	 * @param random Random object used for generating random numbers
	 */
	public static void playGame(Random random)
	{
		CardGroup deck = DeckFactory.createStandardDeck();
		CardGroup[] hands = createHands();
		
		deck.shuffle(random);
		dealHands(deck, hands);
		
		Card discardCard = deck.removeLastCard();
		
		int currentTurnIndex = 0;
		int totalTurns = 1;
		int knockIndex = -1;
		
		while(!Game41Utils.isHandOver(deck, knockIndex, currentTurnIndex))
		{
			System.out.println("Player " + (currentTurnIndex+1) + "'s turn");
			System.out.println("Player " + (currentTurnIndex+1) + "'s cards");

			CardGroup currentHand = hands[currentTurnIndex];
			
			for(int i=0; i<currentHand.size(); i++)
			{
				System.out.println(currentHand.getCard(i));
			}
			
			System.out.println("Deck card: " + deck.getLastCard());
			System.out.println("Discard card: " + discardCard);
			
			boolean choseDiscard = chooseCard(discardCard, currentHand);
			
			Card chosenCard;
			
			if(choseDiscard)
			{
				chosenCard = discardCard;
			}
			else
			{
				chosenCard = deck.removeLastCard();
			}
			
			System.out.println("Player " + (currentTurnIndex+1) + " chooses " + chosenCard);

			currentHand.addCard(chosenCard);

			int discardIndex = chooseDiscardIndex(currentHand, discardCard);
			
			discardCard = currentHand.removeCard(discardIndex);

			currentHand.sort();
			
			System.out.println("Player " + (currentTurnIndex+1) + " discards " + discardCard);
			
			if(knockIndex == -1)
			{
				boolean knock = shouldKnock(hands[currentTurnIndex], totalTurns);
				
				if(knock)
				{
					knockIndex = currentTurnIndex;
					System.out.println("Player " + (currentTurnIndex+1) + " knocks");
				}
			}
			
			currentTurnIndex++;
			currentTurnIndex = currentTurnIndex % NUMBER_OF_PLAYERS;
			totalTurns++;
		}
		
		int highestPoints = Game41Utils.calculateHandValue(hands[0]);

		for(int i=0; i<NUMBER_OF_PLAYERS; i++)
		{
			int currentPoints = Game41Utils.calculateHandValue(hands[i]);
			System.out.println("Player " + (i+1) + " has " + currentPoints + " points");
			
			if(currentPoints > highestPoints)
			{
				highestPoints = currentPoints;
			}
		}

		for(int i=0; i<NUMBER_OF_PLAYERS; i++)
		{
			// somewhat wasteful not storing this value from the previous loop
			int currentPoints = Game41Utils.calculateHandValue(hands[i]);

			if(currentPoints == highestPoints)
			{
				System.out.println("Player " + (i+1) + " wins");
			}
		}
	}
	
	/**
	 * Simple AI for choosing between the deck card or the discard card.<br>
	 * If adding the discard to the hand improved the point value, then the discard is chosen.
	 * 
	 * @param discardCard The card number of the card in the discard pile
	 * @param hand The current player's hand
	 * @return Returns true if the discard card is chosen, false otherwise.
	 */
	private static boolean chooseCard(Card discardCard, CardGroup hand)
	{
		boolean chooseDiscard = false;
		
		CardGroup tempHand = new CardGroup(hand);
		tempHand.addCard(discardCard);

		int handValue = Game41Utils.calculateHandValue(hand);
		int handValue1 = Game41Utils.calculateHandValue(tempHand);
		
		if(handValue1 >= handValue)
		{
			chooseDiscard = true;
		}
		
		return chooseDiscard;
	}
	
	/**
	 * Simple AI to choose which card to discard.<br>
	 * Per game rules, if the discard card is chosen it cannot be discarded<br>
	 * <p>
	 * For all possible discards, a new hand with four cards is created.<br>
	 * The point value for each of these hands is calculated.<br>
	 * The discard card index which gives the highest point value in the remaining hand is chosen.
	 * 
	 * @param hand The current state of the hand with 5 cards
	 * @param discardCard The discard card (whether or not the player chose it)
	 * @return The index of the card to discard
	 */
	private static int chooseDiscardIndex(CardGroup hand, Card discardCard)
	{
		int selectedCardIndex = -1;
		
		int bestPoints = Integer.MIN_VALUE;
		
		for(int i=0; i<hand.size(); i++)
		{
			Card currentCard = hand.getCard(i);
			if(!currentCard.equals(discardCard))
			{
				CardGroup tempHand = new CardGroup();
				
				for(int j=0; j<hand.size(); j++)
				{
					if(j != i)
					{
						tempHand.addCard(hand.getCard(j));
					}
				}
				
				int points = Game41Utils.calculateHandValue(tempHand);
				
				if(points > bestPoints)
				{
					bestPoints = points;
					selectedCardIndex = i;
				}
			}
		}

		return selectedCardIndex;
	}
	
	/**
	 * Simple AI on whether a player should knock.<br>
	 * Based on the turn count, number of players, and the current hand point value.
	 * 
	 * @param hand The current player's hand
	 * @param turnCount The turn number
	 * @return True if the player should knock, false otherwise
	 */
	private static boolean shouldKnock(CardGroup hand, int turnCount)
	{
		boolean shouldKnock = false;
		
		int points = Game41Utils.calculateHandValue(hand);
		
		// just made this up for simplicity
		if(points > ((turnCount / NUMBER_OF_PLAYERS)+5)*5)
		{
			shouldKnock = true;
		}
		
		return shouldKnock;
		
	}
	
	/**
	 * Main method.  Can be used for any playing/testing.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Random random = new Random(4);
		playGame(random);
	}

}
