d, e = map(int, input().split())

seats = set()

for i in range(d, e + 1):
    for j in range(1, i + 1):
        seats.add(j / i)
print(len(seats))