#include "item.h"
#include "vending_machine.h"

#include <iostream>
#include <sstream>


int main(int argc, char** argv) {

  // Item itcl
  // Item item{"Cookies", 195};

  /*  File vend.cpp contains our main function, in which you should
      • Instance a Vending_machine.
      • Add two Item objects to it.
      • Print the menu to the console.
      • Buy one of the items (the index may be hard-coded).  */

  std::cout << "======================" << std::endl;
  std::cout << "Welcome to UTA Vending" << std::endl;
  std::cout << "======================" << std::endl;

  Vending_Machine vm;     // Instance a Vending_machine.
  vm.add("Milk", 285);    // Add two Item objects to it.
  vm.add("Cheese", 185);
  std::cout << vm.menu(); // Call Menu
  vm.buy(0);              // set Buy
}
