 #include <iostream>
 #include <sstream>

 int main(int argc, char** argv) { // function main begins program execution

   std::string name{"Person"}; // Initialize String

   std::cout << "What is your name? ";
   std::cin >> name;

   std::cout << "Hello, " << name << "!" << std::endl;

 } // end main()
