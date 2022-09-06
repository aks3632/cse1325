public class Clock {
  // members - *methods and properties

  // Private (encapsulated) data FIELDS
  private int hours;
  private int minutes;
  private int seconds;

  // Constructor is invoked when an object of class Clock is instanced
  public Clock (int hours, int minutes, int seconds) {
    // To this.field assign the associated parameter
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  } // end public Clock

  // Tell Java how to convert an object of this type into a String
  // The @Override helps us catch typographical errors - more later
  @Override
  public String toString() {
      return hours + ":" + minutes + ":" + seconds;
  } // end toString

} // end class Clock
