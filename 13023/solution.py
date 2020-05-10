import sys


class Edge:
    def __init__(self, vertex1, vertex2):
        self.vertex1 = vertex1
        self.vertex2 = vertex2


class Vertex:
    def __init__(self, id):
        self.id = id
        self.edge_list = []

    def add_edge_to(self, other):
        self.edge_list.append(Edge(self, other))

    def dfs(self, visit_function, depth=0, visited=None):
        visit_function(self, depth)
        visited = set(visited or [])
        visited.add(self.id)
        for edge in self.edge_list:
            if edge.vertex2.id not in visited:
                edge.vertex2.dfs(visit_function, depth + 1, visited)


def connect(vertex1, vertex2):
    vertex1.add_edge_to(vertex2)
    vertex2.add_edge_to(vertex1)


n, m = map(int, input().split())
people = [Vertex(id) for id in range(2000)]
for _ in range(m):
    a, b = map(int, input().split())
    connect(people[a], people[b])


def on_visit(vertex, depth):
    if depth >= 4:
        print(1)
        sys.exit(0)


for vertex in people:
    vertex.dfs(on_visit)

print(0)
