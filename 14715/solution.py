from math import ceil, log2

k = int(input())

prime_factors = 0

for i in range(2, k):
    if k < i:
        break
    while k % i == 0:
        k //= i
        prime_factors += 1

print(prime_factors and ceil(log2(prime_factors)))
