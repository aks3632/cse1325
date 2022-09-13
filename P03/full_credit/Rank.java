public class Rank {

  // Range is set by constants min and max.
  public static final int min = 0; // Initialized
  public static final int max = 9; // Initialized
  // Field NOT method
  private int rank; // Field can't be accessed outside of "Rank"

  // Constructor
  public Rank(int rank) {
    this.rank = rank;
  }

  @Override
  public String toString() {
    String str = String.valueOf(rank);
    return  str;
  }

}
