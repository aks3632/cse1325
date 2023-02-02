public class Pet {

  // Constructor
  public Pet(String name, double age, Type type) {
    this.name = name;
    this.age = age;
    this.type = type;
  } // end Pet constructor

  private String name;
  private double age;
  private Type type;

  // Tell Java how to convert an object of this type into a String
  // The @Override helps us catch typographical errors - more later
  @Override
  public String toString() {
    return " " + name + " " + "is a" + " " + type + " " + "age" + " " + age + ".";
  }
  // private final double humanLifespan = 80;

}
