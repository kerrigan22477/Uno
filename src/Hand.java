import java.util.*;

public class Hand {
    ArrayList<Card> hand;
    Random rand;

    public Hand(Deck deck) {
        this.hand = new ArrayList<>();
        this.rand = new Random();
        // draw 7 cards at random and add to hand
        for (int i = 0; i < 7; i++) {
            int index = rand.nextInt(deck.size());
            Card newCard = deck.draw(index);
            hand.add(newCard);
        }
    }

    public void showHand() {
        System.out.println("Here are your cards");
        System.out.println("-------------------");
        for (int i = 0; i < hand.size(); i++) {
            Card curr = hand.get(i);
            curr.showCard(i);
        }
    }

    public void add(Card card) {
        hand.add(card);
    }

    public int size() {
        return hand.size();
    }

    public Card get(int i) { return hand.get(i); }

    public Card draw(int index) {
        Card card = hand.get(index);
        hand.remove(index);
        return card;
    }
}