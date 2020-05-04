n, r, c = map(int, input().split())
rc = r % 2 == c % 2

for y in range(n):
    print(
        "".join(
            ["v" if (xy := x % 2 == y % 2, xy == rc)[-1] else "." for x in range(n)]
        )
    )
