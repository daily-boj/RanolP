n = int(input())
words = list(eval("input()," * n))
words += list(map(lambda s: s[-1::-1], words))

for (i, w) in enumerate(words):
    if words.count(w) == 2:
        print(len(w), w[len(w) // 2])
        break
