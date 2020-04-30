from typing import List, Set


def compute(size: int, end: int, used: Set[int]) -> List[List[int]]:
    if size == 1:
        return [[x] for x in range(1, end + 1) if x not in used]
    else:
        result = []
        for x in range(1, end + 1):
            if x in used:
                continue
            result.extend(
                [[x, *each] for each in compute(size - 1, end, set([*used, x]))]
            )

        return result


n, m = map(int, input().split())

for seq in compute(m, n, set()):
    print(" ".join(map(str, seq)))
