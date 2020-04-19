
class Edge:
    def __init__(self, vertex1, vertex2):
        self.vertex1 = vertex1
        self.vertex2 = vertex2


class VisitResult:
    CANCEL = 0
    CONTINUE = 1


class Vertex:
    def __init__(self, id):
        self.id = id
        self.edge_list = []

    def add_edge_to(self, other):
        self.edge_list.append(Edge(self, other))

    def dfs(self, visit_function):
        visited = set()
        to_visit = [(self, 0)]
        while len(to_visit) > 0:
            vertex, depth = to_visit.pop(0)
            result = visit_function(vertex, depth)
            if result == VisitResult.CANCEL:
                continue
            elif result == VisitResult.CONTINUE:
                visited.add(vertex.id)
                for edge in vertex.edge_list:
                    if edge.vertex2.id not in visited:
                        to_visit.insert(0, (edge.vertex2, depth + 1))

    def bfs(self, visit_function):
        visited = set()
        to_visit = [(self, 0)]
        while len(to_visit) > 0:
            vertex, depth = to_visit.pop(0)
            result = visit_function(vertex, depth)
            if result == VisitResult.CANCEL:
                continue
            elif result == VisitResult.CONTINUE:
                visited.add(vertex.id)
                for edge in vertex.edge_list:
                    if edge.vertex2.id not in visited:
                        to_visit.append([edge.vertex2, depth + 1])


def connect(vertex1, vertex2):
    vertex1.add_edge_to(vertex2)
    vertex2.add_edge_to(vertex1)

n = int(input())
vertices = [Vertex(id) for id in range(n)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    connect(vertices[a - 1], vertices[b - 1])

parents = [-1 for _ in range(n)]

visit_parents = []

def on_visit(node, depth):
    if depth >= len(visit_parents):
        visit_parents.append(node)
    if len(visit_parents) > depth:
        while len(visit_parents) > depth:
            visit_parents.pop()
        visit_parents.append(node)
    if depth == 0:
        visit_parents.append(node)
    else:
        parents[node.id] = visit_parents[-2].id + 1
    return VisitResult.CONTINUE

vertices[0].dfs(on_visit)

print(*parents[1:], sep = '\n')