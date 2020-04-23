stair_count = int(input())
stair_list = [int(input()) for _ in range(stair_count)]

dp = []
prev_prev_max = None
prev = None

for stair in stair_list:
    if prev is None:
        dp.append(((stair, 1), (stair, 1)))
    elif prev_prev_max is None:
        prev_max = max(dp[-1], key=lambda x: x[0])
        dp.append(((stair + prev_max[0], prev_max[1] + 1), (stair, 1)))
    elif prev[0][1] < 2 and prev[1][1] < 2:
        prev_max = max(dp[-1], key=lambda x: x[0])
        dp.append(
            ((stair + prev_max[0], prev_max[1] + 1), (stair + prev_prev_max[0], 1))
        )
    elif prev[0][1] < 2:
        dp.append(((stair + prev[0][0], prev[0][1] + 1), (stair + prev_prev_max[0], 1)))
    elif prev[1][1] < 2:
        dp.append(((stair + prev[1][0], prev[1][1] + 1), (stair + prev_prev_max[0], 1)))
    else:
        dp.append(((stair + prev_prev_max[0], 1), (stair + prev_prev_max[0], 1)))
    if len(dp) >= 1:
        prev = dp[-1]
    if len(dp) >= 2:
        prev_prev_max = max(dp[-2], key=lambda x: x[0])

print(max(map(lambda x: x[0], dp[-1])))
