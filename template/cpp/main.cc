#include <cstdlib>
#include <iostream>

using i64 = long long;
using u64 = unsigned long long;

#define newl '\n';

void real_main();

int main()
{
    std::cin.tie(nullptr);
    std::ios_base::sync_with_stdio(false);

    real_main();

    std::cout.flush();
    return EXIT_SUCCESS;
}

#define main real_main

void main()
{
}
