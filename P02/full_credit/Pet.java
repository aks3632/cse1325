public class Pet {

  // Constructor
  public Pet(String name, double age, Type type) {
    this.name = name;
    this.age = age;
    this.type = type;
  } // end Pet constructor

  // Tell Java how to convert an object of this type into a String
  // The @Override helps us catch typographical errors - more later
  @Override
  public String toString() {   // Special Method
    return name + age + type;
  }

  private String name;
  private double age;
  private Type type;
  // private final double humanLifespan = 80;

}
