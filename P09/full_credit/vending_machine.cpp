#include "vending_machine.h"

#include <iostream>
#include <sstream>
#include <string>
#include <vector>

    void Vending_Machine::add(std::string name, int price) {
      // Java - products.add(new Taxfree("Milk", 2.85));
      items.push_back(name, price); // ??
    }

    void Vending_Machine::buy(int index) {
      std::cout << "#### Buying "; // item that was purchased
    }

    std::string Vending_Machine::menu() {
      std::string str = "Test pt";
      return str;
    }
