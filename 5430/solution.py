T = int(input())
for _ in range(T):
    p = input()
    input()
    array = eval(input())
    error = False
    is_reversed = False
    for c in p:
        if c == "R":
            is_reversed = not is_reversed
        elif c == "D":
            if len(array) == 0:
                error = True
                break
            if is_reversed:
                array.pop()
            else:
                array.pop(0)
    if error:
        print("error")
    else:
        print("[" + ",".join(map(str, reversed(array) if is_reversed else array)) + "]")
