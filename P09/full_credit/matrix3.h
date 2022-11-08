#ifndef __MATRIX3_UTILS_H_
#define __MATRIX3_UTILS_H_

#include <istream>
#include <ostream>
#include <iostream>
#include <vector>

/* Interface | Declarations */
class Matrix3 {
    public:
        Matrix3(int m00, int m10, int m20, int m01, int m11, int m21, int m02, int m12, int m22); /* Constructor */
        int get(int x, int y);
        Matrix3 operator+(Matrix3 rhs);

        friend std::istream& operator>>(std::istream& in, Matrix3& m);
        friend std::ostream& operator<<(std::ostream& out, Matrix3& m);

    private: // Fields
        std::vector<std::vector<int>> data;
};
#endif // MATRIX_UTILS_H_


/******************************************************************************

* CSE 1325-001 fALL 2022
* File: matrix3.h
* Author: aks3632
* Created on: November 08, 2022 8:00 AM
.*
* UTA Student Name: Ali Senkayi
* UTA ID:  1000223632

*******************************************************************************/


/******************************************************************************
full_credit P09
*******************************************************************************/
