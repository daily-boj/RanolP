class Edge:
    def __init__(self, vertex1, vertex2):
        self.vertex1 = vertex1
        self.vertex2 = vertex2


class VisitResult:
    CANCEL_THIS_NODE = 0
    CONTINUE = 1
    CANCEL_ALL = 2


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
            if result == VisitResult.CANCEL_THIS_NODE:
                continue
            elif result == VisitResult.CANCEL_ALL:
                return
            elif result == VisitResult.CONTINUE:
                visited.add(vertex.id)
                for edge in vertex.edge_list:
                    if edge.vertex2.id not in visited:
                        to_visit.insert(0, (edge.vertex2, depth + 1))


def connect(vertex1, vertex2):
    vertex1.add_edge_to(vertex2)
    vertex2.add_edge_to(vertex1)


n, m = map(int, input().split())
people = [Vertex(id) for id in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    connect(people[a], people[b])

found = False


def on_visit(vertex, depth):
    global found
    if depth >= 4:
        found = True
        return VisitResult.CANCEL_ALL
    return VisitResult.CONTINUE


for vertex in people:
    vertex.dfs(on_visit)

print(1 if found else 0)
