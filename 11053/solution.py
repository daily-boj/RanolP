input()
numbers = list(map(int, input().split()))

dp = []

for number in numbers:
    dp.append((number, max([x[1] for x in dp if x[0] < number] + [0]) + 1))

print(max([x[1] for x in dp]))
