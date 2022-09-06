import java.util.Scanner;

public class Main { // Ref to code_from_slide Foder-03-date3
  public static void main(String[] args) { // function main begins program execution
    int hr, min, sec;
    Scanner scanner = new Scanner(System.in);

    System.out.print("Hour? "); // Prompt user hours
    hr = scanner.nextInt();

    System.out.print("Minute? "); // Prompt user minutes
    min = scanner.nextInt();

    System.out.print("Second? "); // Prompt user seconds
    sec = scanner.nextInt();

    Clock realTime = new Clock(hr, min, sec);
    System.out.println(realTime);

  } // end main()
}
