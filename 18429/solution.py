dp = {}


def key(array):
    return ",".join(map(str, array))


def solve(array, curr, k):
    if len(array) == 0:
        return 0
    elif len(array) == 1:
        return 0 if curr - k + array[0] < 500 else 1
    result = 0
    for index in range(len(array)):
        if curr - k + array[index] < 500:
            continue
        subarray = array[:index] + array[index + 1 :]
        dpkey = key(subarray)
        if dpkey not in dp:
            dp[dpkey] = solve(subarray, curr - k + array[index], k)
        result += dp[dpkey]
    return result


n, k = map(int, input().split())
arr = sorted(list(map(int, input().split())))

print(solve(arr, 500, k))
