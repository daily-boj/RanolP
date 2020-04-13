n, q = map(int, input().split())

seq = list(map(int, input().split()))

while q > 0:
    [query, *args] = list(map(int, input().split()))
    if query == 1:
        [a, b] = args
        print(sum(seq[a - 1 : b]))
        tmp = seq[a - 1]
        seq[a - 1] = seq[b - 1]
        seq[b - 1] = tmp
    else:
        [a, b, c, d] = args
        print(sum(seq[a - 1 : b]) - sum(seq[c - 1 : d]))
    q -= 1
