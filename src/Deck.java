import java.util.*;

public class Deck {
    // 20 of each color
    // 2 of all nums 0-9
    // 80 total
    ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            // same num for all 4 cards
            int currNum = i / 4;
            Card curr = new Card("Broken", 0);
            // reset num count back to 0 after 9
            if (currNum >= 10) {
                currNum = currNum % 10;
            }
            // 0, 4, 8,
            if (i % 4 == 0) {
                curr = new Card("Blue", currNum);
            }
            // 1, 5, 9
            if (i % 4 == 1) {
                curr = new Card("Red", currNum);
            }
            // 2, 6, 10
            if (i % 4 == 2) {
                curr = new Card("Green", currNum);
            }
            // 3, 7, 11
            if (i % 4 == 3) {
                curr = new Card("Yellow", currNum);
            }
            deck.add(curr);
        }
        Collections.shuffle(this.deck);
    }

    public int size() {
        return deck.size();
    }

    public Card draw(int index) {
        Card card = deck.get(index);
        deck.remove(index);
        return card;
    }
}
