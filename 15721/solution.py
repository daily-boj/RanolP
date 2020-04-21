people = int(input())
t = int(input())
bbeon_degi_type = int(input())

lap = 0
index = 0
while t > 0:
    for element in [0, 1, 0, 1] + [0] * (2 + lap) + [1] * (2 + lap):
        if element == bbeon_degi_type:
            t -= 1
        if t <= 0:
            break
        index += 1
    lap += 1

print(index % people)
