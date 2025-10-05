#include <iostream>

int main()
{
    int a, b;
    std :: cout << "A =" << "\n";
    std :: cin >> a;
    std :: cout << "B =" << "\n";
    std :: cin >> b;

    while (b) {
       const int r = a % b;
        a = b;
        b = r;
    }
    std :: cout << "Rez = " << a << "\n";
    return 0;
}