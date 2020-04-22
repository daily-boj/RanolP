
STATE_ANY = 0
STATE_ASCENDING = 1
STATE_DESCENDING = 2

input()
numbers = list(map(int, input().split()))
prev = None
state = STATE_ANY
current_length = 0
last_any_length = 0
longest_length = 0
for i in numbers:
    if prev is None:
        prev = i
        current_length = 1
        continue
    if prev < i:
        if state == STATE_ASCENDING or state == STATE_ANY:
            current_length += 1
        else:
            longest_length = max(longest_length, current_length)
            current_length = 2 + last_any_length - 1
        last_any_length = 1
        state = STATE_ASCENDING
    elif prev > i:
        if state == STATE_DESCENDING or state == STATE_ANY:
            current_length += 1
        else:
            longest_length = max(longest_length, current_length)
            current_length = 2 + last_any_length - 1
        last_any_length = 1
        state = STATE_DESCENDING
    else:
        current_length += 1
        last_any_length += 1
    prev = i

longest_length = max(longest_length, current_length)

print(longest_length)