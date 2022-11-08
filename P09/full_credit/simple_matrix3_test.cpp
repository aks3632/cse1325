// Simple Matrix3 Test
//
// This program interactively tests just the portions of the Matrix3 class
// covered during Lecture 19 on Tuesday - the constructor and the get method.
//
// See the other tests for overloaded operators << and +.

#include "matrix3.h"

#include <algorithm>
#include <string>

// To avoid using the overloaded << operator, we use a function to print instead
void print_matrix(Matrix3 m) {
    std::cout << '\n';
    std::cout << m.get(0,0) << " " << m.get(1,0) << " " << m.get(2,0) << "\n";
    std::cout << m.get(0,1) << " " << m.get(1,1) << " " << m.get(2,1) << "\n";
    std::cout << m.get(0,2) << " " << m.get(1,2) << " " << m.get(2,2) << "\n";
    std::cout << '\n';
}

// https://stackoverflow.com/questions/21758114/how-to-initialize-2d-vector-using-constructor-in-c

Matrix3::Matrix3(int m00, int m10, int m20, int m01, int m11, int m21, int m02, int m12, int m22)
  : data
  {
      {m00, m10, m20},
      {m01, m11, m21},
      {m02, m12, m22},
  } {}



int main() {
    std::cout << "Zero matrix (default constructor):\n";
    Matrix3 m1;
    print_matrix(m1);

    std::cout << "Identity matrix (1s on major diagonal, 0s otherwise):\n";
    Matrix3 m2{1, 0, 0, 0, 1, 0, 0, 0, 1};
    print_matrix(m2);

    std::cout << "Enter your own 3x3 matrix:\n" << std::endl;
    int m00, m10, m20, m01, m11, m21, m02, m12, m22;
    std::cin >> m00 >> m10 >> m20 >> m01 >> m11 >> m21 >> m02 >> m12 >> m22;

    std::cout << "\nIt looks like this when I print it with the get method (NOT with << yet)\n";
    Matrix3 m3{m00, m10, m20, m01, m11, m21, m02, m12, m22};
    print_matrix(m3);
}
