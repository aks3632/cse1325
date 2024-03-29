#include "item.h"

#include <exception>
#include <iostream>
#include <sstream>
#include <string>

  // The constructor stores the name parameter into the _name private variable
  //                      & the price parameter into the _price private variable
  Item::Item(std::string name, int price) : _name{name}, _price{price} {
    if(_price < 0) { // Validate or check data NOT negative
      throw std::runtime_error("Invalid - price is negative!" + std::to_string(_price));
    }
  }

  // The default constructor delegates (or chains) to the non-default
  //    constructor, allowing "Item itcl;" declarations
  Item::Item() : Item{"",0} { }

  // Java "" + name + " " + "($" + cost + ")";
  std::string Item::to_string() {
    // Item item{"Cookies", 195};
    int dollars = (int)_price / 100;
    int cents = (int)_price % 100;

    std::string str = _name + " ($ " + std::to_string(dollars) + "." + ((cents < 10) ? "0" : "") + std::to_string(cents) +")";
    return str;
  }

  // std::string Item::_name; // Field or variable - AKS
  // int Item::_price;        // Field or variable - AKS
