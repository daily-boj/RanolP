t = int(input())
input()

while t > 0:
    curr = 0
    n = int(input())
    while 1:
        try:
            i = input()
            if i.isdigit():
                curr += int(i) % n
            else:
                break
        except EOFError:
            break
    print("YES" if curr % n == 0 else "NO")

    t -= 1
