from bisect import bisect_right

n, k = map(int, input().split())

Ln = len(str(n))
ten_squares = [10 ** x for x in range(Ln + 1)] + [1]
lengths = [x * (ten_squares[x] - ten_squares[x - 1]) for x in range(1, Ln + 1)]
over_here = (ten_squares[Ln] - n - 1) * Ln

if sum(lengths) - over_here < k:
    print(-1)
else:
    index = bisect_right(lengths, k)
    begin = sum(lengths[:index])
    begin_value = ten_squares[index]
    digit_count = index + 1
    left = k - begin - 1
    current = begin_value + left // digit_count
    print(str(begin_value + left // digit_count)[left % digit_count])
