height, _ = map(int, input().split())

pos1 = None
pos2 = None

for y in range(height):
    for (x, i) in enumerate(input().split()):
        if i == "1":
            if pos1 is None:
                pos1 = (x, y)
            else:
                pos2 = (x, y)

print(abs(pos1[0] - pos2[0]) + abs(pos1[1] - pos2[1]))
