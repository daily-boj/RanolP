prev_prev = 0
prev = 1
n = int(input())
while n > 0:
    temp = prev + prev_prev
    prev_prev = prev % 15746
    prev = temp % 15746
    n -= 1

print(prev)
