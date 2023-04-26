#ifndef __VENDINGMACHINE_H
#define __VENDINGMACHINE_H
#include "item.h"

#include <string>
#include <vector>

class Vending_Machine {
  public:
    void add(std::string name, int price);
    std::string menu();
    void buy(int index);
  private:
    std::vector<Item> items;
 // Declaration only | Field or variable
};

#endif
