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

    def dfs(self, visit_function, visited=None, depth=0):
        if visited is None:
            visited = set()
        result = visit_function(self, depth)
        if result == VisitResult.CANCEL:
            return
        elif result == VisitResult.CONTINUE:
            visited.add(self.id)
        for edge in self.edge_list:
            other = edge.vertex2
            if other.id in visited:
                continue
            other.visit(visit_function, visited, depth + 1)

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


people_count = int(input())

vertices = [Vertex(id) for id in range(people_count)]
for id in range(people_count):
    for (other, yes_no) in enumerate(input()):
        if yes_no == "Y":
            connect(vertices[id], vertices[other])

max_friends = 0
current_friends = set()


def on_visit(vertex, depth):
    if depth >= 3:
        return VisitResult.CANCEL
    global max_friends, current_friends
    current_friends.add(vertex.id)
    return VisitResult.CONTINUE


for vertex in vertices:
    current_friends = set()
    vertex.bfs(on_visit)
    current_friends.discard(vertex.id)
    max_friends = max(max_friends, len(current_friends))

print(max_friends)
