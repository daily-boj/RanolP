
computer_count = int(input())
pair_count = int(input())

class Edge:
    def __init__(self, vertex1 , vertex2):
        self.vertex1 = vertex1
        self.vertex2 = vertex2

class Vertex:
    def __init__(self, id):
        self.id = id
        self.edge_list = []
    
    def add_edge_to(self, other):
        self.edge_list.append(Edge(self, other))
    
    def visit(self, visit_function, visited):
        visit_function(self)
        visited.add(self.id)
        for edge in self.edge_list:
            other = edge.vertex2
            if other.id in visited:
                continue
            other.visit(visit_function, visited)

def connect(vertex1, vertex2):
    vertex1.add_edge_to(vertex2)
    vertex2.add_edge_to(vertex1)

vertices = [Vertex(id) for id in range(computer_count)]

for _ in range(pair_count):
    a, b = map(int, input().split())
    connect(vertices[a - 1], vertices[b - 1])

dead = 0

def on_visit(vertex):
    global dead
    dead += 1

vertices[0].visit(on_visit, set())

print(dead - 1)