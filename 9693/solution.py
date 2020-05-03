dp_fives = {}


def get_fives(i):
    if i not in dp_fives and i % 5 == 0:
        dp_fives[i] = 1 + get_fives(i // 5)
    return dp_fives.get(i, 0)


dp_tens = [0]


def get_tens(i):
    if i >= len(dp_tens):
        for j in range(len(dp_tens), i + 1):
            dp_tens.append(dp_tens[-1] + get_fives(j))
    return dp_tens[i]


index = 1
while 1:
    i = int(input())
    if i == 0:
        break
    print(f"Case #{index}: {get_tens(i)}")
    index += 1
