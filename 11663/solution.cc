#include <cstdlib>
#include <iostream>

using u64 = unsigned long long;

#define newl '\n';

#include <vector>
#include <algorithm>

void real_main()
{

    u64 n, m;

    std::cin >> n >> m;
    std::vector<u64> points;

    u64 tmp;

    while (n-- > 0)
    {
        std::cin >> tmp;
        points.emplace_back(tmp);
    }

    std::sort(points.begin(), points.end());

    u64 start, end;

    while (m-- > 0)
    {
        std::cin >> start >> end;
        std::cout << std::upper_bound(points.begin(), points.end(), end) - std::lower_bound(points.begin(), points.end(), start) << newl;
    }
}

int main()
{
    std::cin.tie(nullptr);
    std::ios_base::sync_with_stdio(false);

    real_main();

    std::cout.flush();
    return EXIT_SUCCESS;
}