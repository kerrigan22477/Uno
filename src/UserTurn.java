import java.util.*;

public class UserTurn {
    Card top;
    Hand userHand;
    Deck deck;

    public UserTurn(Card top, Hand userHand, Deck deck) {
        this.top = top;
        this.userHand = userHand;
        this.deck = deck;
    }

    public Card actualTurn() {
        Scanner scan = new Scanner(System.in);

        userHand.showHand();
        System.out.println("\nWhat card would you like to play? Type the number here: ");
        System.out.println("Or, if you would like to draw from the deck, type 10");
        int cardIndex = scan.nextInt();
        if (cardIndex == 10) {
            Card newCard = this.deck.draw(0);
            userHand.add(newCard);
            return top;
        }
        Card cardPlayed = userHand.draw(cardIndex);
        while (!isLegal(cardPlayed)) {
            System.out.println("You cannot play that card.");
            System.out.println("\nWhat card would you like to play? Type the number here: ");
            cardIndex = scan.nextInt();
            if (cardIndex == 10) {
                Card newCard = this.deck.draw(0);
                userHand.add(newCard);
                return top;
            }
            cardPlayed = userHand.draw(cardIndex);
        }
        return cardPlayed;
    }

    public boolean isLegal(Card card) {
        // color or number must match.
        if (top.color != card.color && top.number != card.number) {
            System.out.println("You cannot play that card");
            return false;
        }
        return true;
    }
}
