n = int(input())
a = 1
b = 0

while n > 0:
    old_a = a
    old_b = b

    b += old_a
    a = old_b
    n -= 1

print(a, b)
