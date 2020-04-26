class Edge:
    def __init__(self, vertex1, vertex2):
        self.vertex1 = vertex1
        self.vertex2 = vertex2


class Vertex:
    def __init__(self, id):
        self.id = id
        self.edge_list = []

    def add_edge_to(self, other):
        if self == other:
            return
        self.edge_list.append(Edge(self, other))

    def check_polygon(self):
        visited = set()
        min_id = self.id
        to_visit = [self]
        last = None
        while len(to_visit) > 0:
            vertex = to_visit.pop(0)
            visited.add(vertex.id)
            min_id = min(min_id, vertex.id)
            last = vertex
            if len(vertex.edge_list) != 2:
                return False
            for edge in vertex.edge_list:
                if edge.vertex2.id not in visited:
                    to_visit.insert(0, edge.vertex2)
        return (
            min_id
            if any([edge for edge in self.edge_list if edge.vertex2 == last])
            else False
        )


def connect(vertex1, vertex2):
    vertex1.add_edge_to(vertex2)
    vertex2.add_edge_to(vertex1)


line_count = int(input())
node_list = [Vertex(id + 1) for id in range(line_count * 2 + 1)]
positions = {}
last_id = 1
for _ in range(line_count):
    x1, y1, x2, y2 = map(int, input().split())
    pos1 = f"{x1},{y1}"
    pos2 = f"{x2},{y2}"
    if pos1 not in positions:
        positions[pos1] = last_id
        last_id += 1
    if pos2 not in positions:
        positions[pos2] = last_id
        last_id += 1
    connect(node_list[positions[pos1]], node_list[positions[pos2]])

print(len(set(filter(lambda x: x, map(Vertex.check_polygon, node_list)))))
