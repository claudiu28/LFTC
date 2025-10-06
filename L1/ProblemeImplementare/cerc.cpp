#include <iomanip>
#include <iostream>

int main()
{
    std::cout << "R =";
    float raza;
    std::cin >> raza;
    const float a = 3.14 * raza * raza;
    const float p = 2 * 3.14 * raza;
    std::cout << "P = " << p << std::setprecision(2) << "\n";
    std::cout << "A =" << a << std::setprecision(2) << "\n";
    return 0;
}
