public class Card {

  // Contructor
  public Card( Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  @Override
  public String toString() {
    return rank + "" + suit;
  }

  // Fields
  private Rank rank;
  private Suit suit;
}
