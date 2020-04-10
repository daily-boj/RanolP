from math import ceil

half = 0
one_quarter = 0
three_quarter = 0

count = int(input())

pizzas = 0

for _ in range(count):
    curr = input()
    if curr == "1/2":
        half += 1
    elif curr == "1/4":
        one_quarter += 1
    elif curr == "3/4":
        three_quarter += 1

if three_quarter > 0:
    if one_quarter >= three_quarter:
        pizzas += three_quarter
        one_quarter -= three_quarter
    else:
        pizzas += three_quarter
        one_quarter = 0

pizzas += half // 2
if half % 2 != 0:
    pizzas += 1
    one_quarter -= 2
if one_quarter > 0:
    pizzas += ceil(one_quarter / 4)

print(pizzas)
