#ifndef __ITEM_H
#define __ITEM_H

#include <string>
using namespace std;

class Item {
  public:
    Item(string name, int price);
    Item();
    string to_string();
  private:
    string _name; // declaration only
    int _price;   // Field or variable
};

#endif
