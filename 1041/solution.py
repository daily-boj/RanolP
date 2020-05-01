class DiceFace:
    def __init__(self, value):
        self.value = value

    def connect(self, siblings):
        self.siblings = [face.value for face in siblings]

    def two(self):
        return min(self.siblings) + self.value

    def three(self):
        return (
            min((self.siblings[i] + self.siblings[i + 1]) for i in range(-1, 3))
            + self.value
        )


class Dice:
    def __init__(self, a, b, c, d, e, f):
        self.values = [a, b, c, d, e, f]
        a = DiceFace(a)
        b = DiceFace(b)
        c = DiceFace(c)
        d = DiceFace(d)
        e = DiceFace(e)
        f = DiceFace(f)
        self.faces = [a, b, c, d, e, f]

        a.connect([c, b, d, e])
        b.connect([a, d, f, c])
        c.connect([a, b, f, e])
        d.connect([a, b, f, e])
        e.connect([a, d, f, c])
        f.connect([c, b, d, e])

    def five(self):
        return sum(self.values) - max(self.values)

    def one(self):
        return min(self.values)

    def two(self):
        return min([face.two() for face in self.faces])

    def three(self):
        return min([face.three() for face in self.faces])


n = int(input())
a, b, c, d, e, f = map(int, input().split())
dice = Dice(a, b, c, d, e, f)

if n == 1:
    print(dice.five())
else:
    corner = dice.three()
    edge = dice.two()
    side = dice.one()

    result = (
        corner * 4
        + edge * (n - 2) * 4
        + side * (n - 2) * (n - 2)
        + edge * (n - 1) * 4
        + side * 4 * (n - 2) * (n - 1)
    )
    print(result)
