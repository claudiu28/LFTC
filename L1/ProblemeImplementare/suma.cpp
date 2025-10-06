#include <iostream>

int main() {
    std :: cout << "N = :";
    int n;
    std :: cin >> n;
    int suma = 0;
    while (n > 0) {
        int x;

        std :: cin >> x;
        suma += x;
        n--;
    }
    std :: cout << "S = " << suma << "\n";
    return 0;
}
