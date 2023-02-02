import java.util.Scanner;
import java.io.*;
import java.lang.Enum;

 public class MyPets {
   public static void main(String[] args) {

     // Object
     // enum Type can be auto instnace EX) Type.DOG
     Pet ani1 = new Pet("Tommy", 14, Type.RABBIT);
     Pet ani2 = new Pet("Jim", 30, Type.PONY);
     Pet ani3 = new Pet("Bob", 21, Type.SNAKE);
     Pet ani4 = new Pet("Howard", 50, Type.DOG);

     // System.out.println(ani1);
     // System.out.println(ani2);
     // System.out.println(ani3);
     // System.out.println(ani4);

     Pet[] kingdom = {ani1, ani2, ani3, ani4};

     for( Pet i: kingdom) {
       System.out.println(i);
     }
   }
 }


 /******************************************************************************

 * CSE 1325-004 Spring 2023
 * File: MyPets.java, Type.java, Pet.java, build.xml
 * Author:
 * Created on: Jan 1, 2023 5:00 AM
 .*
 * UTA Student Name:
 * UTA ID:

 *******************************************************************************/

 /*

Hints: ~ cse1325-prof/03/code_from_slides/date3
Date.java - Bulk of program
Month.java - enum
Main.java - Interactive | Month acquired uniquely

 */

 /******************************************************************************
 Java Programming HW P02
 *******************************************************************************/
