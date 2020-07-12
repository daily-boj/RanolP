s = 0
p = 1000000007
a = 860798509
b = 198609463
base = 1

for i in range(0, p):
    s = (s + base) % p
    base = (base * a) % p
    if i % 1000000 == 0:
        print(s, "%.2f%% done" % (i / p * 100))

print((b * s) % p)
