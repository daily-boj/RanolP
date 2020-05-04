memo = [1]

n = int(input())

prev = 1

for i in range(1, n + 1):
    while i % 10 == 0:
        i //= 10
    while prev % 2 == 0 and i % 5 == 0:
        prev //= 2
        i //= 5
    while prev % 5 == 0 and i % 2 == 0:
        prev //= 5
        i //= 2
    prev = (prev * i) % 1000000000000

print(str(prev % 100000).zfill(5))
