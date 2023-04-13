#include "item.h"
#include "vending_machine.h"

#include <iostream>
#include <sstream>


int main(int argc, char** argv) {

  // Item itcl
  // Item item{"Cookies", 195};

  std::cout << "======================" << std::endl;
  std::cout << "Welcome to UTA Vending" << std::endl;
  std::cout << "======================" << std::endl;

  Vending_Machine vm;

  std::cout << "This is main! " << "Item = " << vm.menu();
}
