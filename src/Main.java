import java.util.*;

public class Main {
    Hand userHand;
    Hand compHand;
    Deck deck;
    Boolean playing = true;
    Boolean round = true;

    public Main() {
        // play again loop
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to play Uno? (Y/N)");
        String input = scan.nextLine();
        if (input.equals("N")) { playing = false; }
        while (playing) {
            // create/shuffle deck and hands
            this.deck = new Deck();
            this.userHand = new Hand(deck);
            this.compHand = new Hand(deck);

            // display user hands
            this.userHand.showHand();

            boolean userGoes = false;
            System.out.println("Let's flip a coin to decide who goes first. Heads or Tails? (H/T)");
            String coinFlip = scan.nextLine();
            Random rand = new Random();
            int coin = rand.nextInt(2);
            System.out.println("coin: " + coin);
            System.out.println("coinflip: " + coinFlip);
            // Heads = 1, Tails = 0
            if ((coinFlip.equals("T") && coin == 0) || (coinFlip.equals("H") && coin == 1)) {
                userGoes = true;
                System.out.println("You go first");
            }
            else {
                System.out.println("I go first");
            }

            // flip first card from deck
            Card top = this.deck.draw(0);

            while(round) {
                System.out.println("Current Top Card");
                System.out.println("----------------");
                top.showCard();
                if (userGoes) {
                    UserTurn userTurn = new UserTurn(top, this.userHand, this.deck);
                    top = userTurn.actualTurn();
                    userGoes = !userGoes;
                }
                if (!userGoes) {
                    CompTurn compTurn = new CompTurn(top, this.compHand, this.deck);
                    top = compTurn.actualTurn();
                    userGoes = !userGoes;
                }
                if (compHand.size() == 0) {
                    System.out.println("You lost");
                    round = false;
                }
                if (userHand.size() == 0) {
                    System.out.println("You win!");
                    round = false;
                }
            }

            //play again?
            System.out.println("\nWould you like to play again? (Y/N)");
            input = scan.nextLine();
            if (input.equals("N")) { playing = false; }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
