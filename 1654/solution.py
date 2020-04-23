k, n = map(int, input().split())
cable_list = [int(input()) for _ in range(k)]
lo = 1
hi = sum(cable_list) + 1
while lo < hi:
    med = (lo + hi) // 2
    count = 0
    left_cables = 0
    for cable in cable_list:
        while cable >= med:
            cable -= med
            count += 1
        left_cables += cable
    if count == n and left_cables == 0:
        hi = med + 1
        break
    elif count < n:
        hi = med
    else:
        lo = med + 1

print(hi - 1)
