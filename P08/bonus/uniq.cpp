 /******************************************************************************

 * CSE 1320-001 Spring 2023
 * File: Customer.java,
 * Author:
 * Created on: April 5, 2023 2:36 PM
 .*
 * UTA Student Name:
 * UTA ID:

 *******************************************************************************/

 #include <iostream>
 #include <sstream>
 #include <vector>
 #pragma warning(disable : 4996)
 #include <bits/stdc++.h>

 // FUNCTION PROTOTYPE
 void removeDupWord(std::string str);

 /******************************************************************************
 Bonus
 *******************************************************************************/

 int main(int argc, char* argv[]) {

   // Initialization Phase:
   std::string passedValue{""};
   int i{1};

   if(argc < 3) {
     // Program name, string.txt, str1, str2 -- sequence entered in cmd prompt (argc != 3)
     printf("USAGE: ./a.out string.txt str1, str2, str#... etc. \n");
     // Gracefully terminate program with warning message
     printf("Invalid input. Closing program.\n");
     return 1;
   }

   // Input Phase: Program continued
   // https://stackoverflow.com/questions/4134992/how-to-get-stdstring-from-command-line-arguments-in-win32-application
   printf("%s\n", "Phrase entered by user: "); // Phrase entered by user

   for(; i < argc; i++) {
     passedValue.append(argv[i]).append(" "); // passedValue += argv[i];
   }

   // Output Phase 1: Original data
   // https://www.geeksforgeeks.org/g-fact-40-foreach-in-c-and-java/
   for(auto x : passedValue) {  // for-each loop C++
     std::cout << x << "";      // Phrase entered by user
   }

   puts("");                // Prints a newline
   std::cout << std::endl;  // Empty line

   // Output Phase 2: Final results
   printf("%s\n", "Duplicate word(s) removed in string: "); // Phrase entered by user
   removeDupWord(passedValue);  // Phrase entered by user
   std::cout << std::endl;

   return 0;
 } // end main()


 // FUNCTION DEFINITION
 // https://www.geeksforgeeks.org/remove-duplicaterepeated-words-string/
 void removeDupWord(std::string str)
 {
 	// Used to split string around spaces.
 	std::istringstream ss(str);

 	// To store individual visited words
 	std::unordered_set<std::string> hsh;

 	// Traverse through all words
 	do {
 		std::string word;
 		ss >> word;

 		// If current word is not seen before.
 		while (hsh.find(word) == hsh.end()) {
 			std::cout << word << " ";
 			hsh.insert(word);
 		}

 	} while (ss);
} // end function removeDupWord
