t = int(input())

while t > 0:
    curr = 0
    input()
    height, width = map(int, input().split())
    matrix = eval("input()," * height)

    candies = 0

    for i in range(height):
        for j in range(width):
            if matrix[i][j] == "o" and (
                (
                    i > 0
                    and i + 1 < height
                    and matrix[i - 1][j] == "v"
                    and matrix[i + 1][j] == "^"
                )
                or (
                    j > 0
                    and j + 1 < width
                    and matrix[i][j - 1] == ">"
                    and matrix[i][j + 1] == "<"
                )
            ):
                candies += 1
    print(candies)

    t -= 1
