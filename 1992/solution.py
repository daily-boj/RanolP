
def compress_quadtree(array, n):
    if n == 1:
        return str(array[0][0])
    half = n // 2
    data = [
        compress_quadtree([line[:half] for line in array[:half]], half),
        compress_quadtree([line[half:] for line in array[:half]], half),
        compress_quadtree([line[:half] for line in array[half:]], half),
        compress_quadtree([line[half:] for line in array[half:]], half),
    ]
    if (data[0] == '0' or data[0] == '1') and data[0] == data[1] and data[0] == data[2] and data[0] == data[3]:
        return data[0]
    else:
        return f"({''.join(data)})"

n = int(input())
array = [[*input()] for _ in range(n)]

print(compress_quadtree(array, n))