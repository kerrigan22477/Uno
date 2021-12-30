import java.util.Scanner;

public class CompTurn {
    Card top;
    Hand compHand;
    Deck deck;

    public CompTurn(Card top, Hand compHand, Deck deck) {
        this.top = top;
        this.compHand = compHand;
        this.deck = deck;
    }

    public Card actualTurn() {
        // iterate through deck until find a playable card
        for (int i = 0; i < compHand.size(); i++) {
            Card curr = compHand.get(i);
            if (top.color == curr.color || top.number == curr.number) {
                System.out.println("Computer plays " + curr.color + " " + curr.number);
                compHand.draw(i);
                if (compHand.size() == 1) {
                    System.out.println("Uno!");
                }
                return curr;
            }
        }
        // can't play
        System.out.println("Computer draws");
        Card newCard = this.deck.draw(0);
        compHand.add(newCard);
        return top;
    }
}