#include <iostream>
#include <sstream>


int main(int argc, char** argv) {

  // Item itcl
  Item item{"Cookies", 195};

  std::cout << "This is main!" << "Item = " << item.to_string() << std::ends;

}
