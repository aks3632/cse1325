#include "vending_machine.h"

#pragma warning(disable : 4996)
#include <bits/stdc++.h>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <numeric>

    void Vending_Machine::add(std::string name, int price) {
      // Java - products.add(new Taxfree("Milk", 2.85));
      // https://stackoverflow.com/questions/70281393/how-to-store-an-instance-of-class-in-a-vector

      // item1, item2, itemN... etc.
      // Item item2("Cheese", 185);
      // items.push_back(item2);
      /* ================================== */
      // items.push_back(Item("Milk", 285));
      // items.push_back(Item("Cheese", 185));
      items.push_back(Item(name, price));
    }

    std::string Vending_Machine::menu() {
      // std::vector<char> vec;
      // char str[] = {items[i].to_string()};
      // vec.insert(vec.end(), str, str + sizeof(str) - 1);

      int i{0};
      std::string menu{"\n"};

      for (; i < items.size(); i++) {
        // menu += std::to_string(i) + ") " + items[i].to_string() + "\n";
        menu.append(std::to_string(i) + ") ").append(items[i].to_string()).append("\n");
        /* code */
      }

      // puts("");                // Prints a newline
      // std::cout << std::endl;  // Empty line


      try {
        // System.out.printf("Enter a choice: \n"); // Promt user
        // Option 2 | For each loop
        int i = 0; // index count for items
        for(Item itcl : items) { // HINT: derived via ArrayList | Creates Menu List
          std::cout << i << ") " << items[i].to_string() << std::endl;
          i++;
          if(i > 2) { // Menu list displayed restricts to 7 items ONLY
            break;
          } // end if
        } // end for each loop
        // Substituted above | System.out.println(items.get(0)); OR System.out.println(items.get(0).toString());
      } catch (std::runtime_error& e) {
        std::cerr << "Ending progarm: " << e.what();
        exit(-1);
      } // end try..catch

      printf("%s", "7) (q)uit?\n"); // end Menu List
      printf("%s", "\nCurrent Order"); // 2nd Porcess begins
      printf("%s", "-------------\n");


      return menu;
    }

    void Vending_Machine::buy(int index) {
      std::cout << "#### Buying " + items[index].to_string() << std::endl;
    }
