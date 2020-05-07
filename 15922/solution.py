from bisect import bisect_left


class Line:
    def __init__(self, begin, end):
        self.begin = begin
        self.end = end

    def extend(self, other):
        self.begin = min(self.begin, other.begin)
        self.end = max(self.end, other.end)

    def __len__(self):
        return self.end - self.begin

    def __lt__(self, value):
        return self.end < value.begin

    def __eq__(self, value):
        return self.end > value.begin or value.end > self.begin


lines = []
for _ in range(int(input())):
    b, e = map(int, input().split())
    l = Line(b, e)
    index = bisect_left(lines, l)
    if index >= len(lines):
        lines.append(l)
    elif lines[index] == l:
        lines[index].extend(l)
    else:
        lines.insert(index, l)

print(sum(map(len, lines)))
