def get_factors(dp, j, i):
    if i not in dp and i % j == 0:
        dp[i] = 1 + get_factors(dp, j, i // j)
    return dp.get(i, 0)


dp_twos = {}
dp_fives = {}

get_twos = lambda i: get_factors(dp_twos, 2, i)
get_fives = lambda i: get_factors(dp_fives, 5, i)

dp_tens = [[0, 0]]


def get_tens(i):
    if i >= len(dp_tens):
        for j in range(len(dp_tens), i + 1):
            dp_tens.append(
                [dp_tens[-1][0] + get_twos(j), dp_tens[-1][1] + get_fives(j),]
            )
    return min(*dp_tens[i])


index = 1
while 1:
    i = int(input())
    if i == 0:
        break
    print(f"Case #{index}: {get_tens(i)}")
    index += 1
