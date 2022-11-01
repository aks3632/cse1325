#include <algorithm>
#include <string>
#include <iostream>

#define MAX_SZ 64

// FUNCTION PROTOTYPE
void ptr_phase (std::string phrase);

main(int argc, char** argv) {

  // Initialization Phase:
  std::string phrase{""};

  // Input Phase:
  std::cout << "Enter a phrase: ";
  std::getline(std::cin, phrase);

  // Process Phase
  ptr_phase(phrase);                            // Before - Invoke function call
  std::reverse(phrase.begin(), phrase.end());   // Reverse any collection
  ptr_phase(phrase);                            // After - Invoke function call
  return 0;
} // end main()

// FUNCTION DEFINITION
void ptr_phase (std::string phrase)
{
  // For-each loop | Autotyping uses auto instead of var:
  for(auto nmrv : phrase) {
    std::cout << nmrv;
  }
  std::cout << std::endl;
} // end function ptr_phase
