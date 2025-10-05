#include <iomanip>
#include <iostream>

int main()
{
    std::cout << "R =";
    double raza;
    std::cin >> raza;
    const double a = 3.14 * raza * raza;
    const double p = 2 * 3.14 * raza;
    std::cout << "P = " << p << std::setprecision(2) << "\n";
    std::cout << "A =" << a << std::setprecision(2) << "\n";
    return 0;
}
