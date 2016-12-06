
import java.util.*;


// CtCI5 18.2
public class CardShuffler {

	private static final int DECK_SIZE = 52;
	private static final ArrayList<Card> CARD_REF = new ArrayList<Card>(DECK_SIZE);
	static {
//	Array of Cards
//	Spades		0-12	(A,2,3,..,J,Q,K)
//	Hearts		13-25	(A,2,3,..,J,Q,K)
//	Diamonds	26-38	(A,2,3,..,J,Q,K)
//	Clubs			39-51	(A,2,3,..,J,Q,K)	
	}

	private class Card {
		String suit;
		String rank;
	}

	public List<Cards> shuffleCards() {
		LinkedHashSet<Integer> cardSequenceSet = new LinkedHashSet<Integer>(DECK_SIZE);
		while (cardSequenceSet.size() < DECK_SIZE) {
			int cardIndex = randomCard();
			if (cardSequenceSet.contains(cardIndex)) {
				continue;
			}
			cardSequenceSet.add(cardIndex);
		}
		List<Card> cardsInOrder = new LinkedList<Card>(DECK_SIZE);
		for (int i : cardSequenceSet) {
			cardsInOrder.add(CARD_REF.get(i);
		}
		return cardsInOrder;
	}

	private int randomCard() {
		return new Random().nextInt(DECK_SIZE);
	}

}