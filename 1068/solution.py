class Tree:
    def __init__(self, id):
        self.id = id
        self.children = []

    def is_leaf(self):
        return len(self.children) == 0

    def add_child(self, child):
        self.children.append(child)

    def count_leaf(self, banned_id):
        if self.id == banned_id:
            return 0
        elif self.is_leaf():
            return 1
        elif len(self.children) == 1 and self.children[0].id == banned_id:
            return 1
        else:
            return sum([child.count_leaf(banned_id) for child in self.children])


count = int(input())
trees = [Tree(id) for id in range(count)]
root_nodes = []

for id, parent in enumerate(map(int, input().split())):
    if parent == -1:
        root_nodes.append(trees[id])
    else:
        trees[parent].add_child(trees[id])

banned_id = int(input())
print(sum([node.count_leaf(banned_id) for node in root_nodes]))
