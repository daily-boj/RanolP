(n, _) = map(int, input().split())
expects = eval('"".join(map(lambda c: c*2, input())),' * n)
reals = eval("input()," * n)
print("Eyfa" if all([expects[i] == reals[i] for i in range(n)]) else "Not Eyfa")
