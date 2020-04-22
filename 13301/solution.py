n = int(input()) - 1

prev_prev = 0
prev = 1

while n > 0:
    prev_prev_prev, prev_prev, prev = prev_prev, prev, prev_prev + prev
    n -= 1

print(2 * (prev + prev_prev) + prev * 2)
