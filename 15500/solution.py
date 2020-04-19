count = int(input())
first = list(map(int, input().split()))
second = []

biggest_to_smallest = sorted(first, reverse=True)

popping_first = True
move_count = 0

buf = []


def process(this, this_id, other, other_id):
    popped = this.pop()
    if biggest_to_smallest[0] == popped:
        biggest_to_smallest.pop(0)
        if len(biggest_to_smallest) > 0:
            global popping_first
            popping_first = biggest_to_smallest[0] in first
        buf.append(f"{this_id} 3")
    else:
        other.append(popped)
        buf.append(f"{this_id} {other_id}")


while len(biggest_to_smallest) > 0:
    if popping_first:
        process(first, "1", second, "2")
    else:
        process(second, "2", first, "1")
    move_count += 1

print(move_count)
print("\n".join(buf))
