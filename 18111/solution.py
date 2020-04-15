n, m, b = map(int, input().split())

d = {}
for _ in range(n):
    for i in map(int, input().split()):
        if i in d:
            d[i] += 1
        else:
            d[i] = 1
keys = sorted(d.keys())

times_used = 0

for _ in range(257):
    if len(keys) == 1:
        break
    first, last = keys[0], keys[-1]
    to_place = d[keys[0]]
    to_remove = d[keys[-1]]
    if b >= to_place and to_place <= to_remove * 2:
        b -= to_place
        times_used += to_place
        if keys[1] == first + 1:
            d[first + 1] += d[first]
            keys.pop(0)
        else:
            d[first + 1] = d[first]
            keys[0] = first + 1
        del d[first]
    else:
        b += to_remove
        times_used += to_remove * 2
        if keys[-2] == last - 1:
            d[last - 1] += d[last]
            keys.pop()
        else:
            d[last - 1] = d[last]
            keys[-1] = last - 1
        del d[last]

print(times_used, keys[0])
