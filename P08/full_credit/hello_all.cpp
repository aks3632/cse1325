#include <iostream>

main(int argc, char** argv) {
  std::string name{""};
  std::cout << "What's your name? ";
  std::cin >> name;
  std::cout << "Hello " << name + "!" << std::endl;
  return 0;
}
