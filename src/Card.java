public class Card {
    String color;
    int number;

    public Card(String colour, int num) {
        this.color = colour;
        this.number = num;
    }

    public void showCard() {
        System.out.println(this.color + " " + this.number);
    }

    public void showCard(int index) {
        System.out.println(index + ") " + this.color + " " + this.number);
    }
}