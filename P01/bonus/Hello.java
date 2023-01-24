import java.util.Scanner;
import java.io.*;

public class Hello {
  public static void main(String[] args) { // Function main() begins program execution

    // Type identifier = new Typ();
    Scanner scanner = new Scanner(System.in);

    System.out.print("What is your name? ");
    String name = scanner.nextLine();

    System.out.printf("Hello, %s!\n", name);
  } // end main()
} // end class
