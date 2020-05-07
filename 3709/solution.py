LEFT = 0
UP = 1
RIGHT = 2
DOWN = 3

vectors = [(-1, 0), (0, 1), (1, 0), (0, -1)]


class Laser:
    def __init__(self, board, x, y):
        self.board = board


class Board:
    def __init__(self, size):
        self.size = size
        self.real = [[False for _ in range(size)] for _ in range(size)]

    def set_mirror(self, x, y):
        self.real[x][y] = True

    def has_mirror(self, x, y):
        return x >= 0 and x < self.size and y >= 0 and y < self.size and self.real[x][y]

    def debug(self):
        for y, row in self.real[-1::-1]:
            print(" ".join(["()" if v else "__" for v in row]))
