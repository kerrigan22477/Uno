public class Card {
    String color;
    int number;
    String special;

    public Card(String colour, int num, String special) {
        this.color = colour;
        this.number = num;
        this.special = special;
    }

    public void showCard() {
        if (this.special != "num") {
            System.out.println(this.color + " " + this.special);
        }
        else { System.out.println(this.color + " " + this.number); }
    }

    public void showCard(int index) {
        System.out.println(index + ") " + this.color + " " + this.number);
        if (this.special != "num") {
            System.out.println(index + ") " + this.color + " " + this.special);
        }
        else { System.out.println(index + ") " + this.color + " " + this.number); }
    }
}