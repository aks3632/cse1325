#include "vending_machine.h"

#include <iostream>
#include <sstream>
#include <string>
#include <vector>

    void Vending_Machine::add(std::string name, int price) {
      // Java - products.add(new Taxfree("Milk", 2.85));
      // https://stackoverflow.com/questions/70281393/how-to-store-an-instance-of-class-in-a-vector

      //item1, item2, itemN... etc.
      //Item item2("Cheese", 185);
      //items.push_back(item2);

      items.push_back(Item("Milk", 285));
      items.push_back(Item("Cheese", 185));
      // items.push_back(Item());

    }

    void Vending_Machine::buy(int index) {
      Item item;
      std::cout << "#### Buying " << item.to_string()[index] << std::ends; // item that was purchased
    }

    std::string Vending_Machine::menu() {
      std::string str = " Testpt\n";
      return str;
    }
