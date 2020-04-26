NODE_LEFT = "LEFT"
NODE_RIGHT = "RIGHT"
NODE_ROOT = "ROOT"


class BinarySearchTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
        self.parent = None
        self.type = None

    def insert(self, tree):
        current = self
        while 1:
            if tree.value < current.value:
                if current.left is None:
                    current.left = tree
                    tree.parent = current
                    tree.type = NODE_LEFT
                    return
                else:
                    current = current.left
            else:
                if current.right is None:
                    tree.parent = current
                    current.right = tree
                    tree.type = NODE_RIGHT
                    return
                else:
                    current = current.right

    def dig(self):
        current = self
        while 1:
            if current.left is not None:
                current = current.left
            elif current.right is not None:
                current = current.right
            else:
                break
        return current

    def post_order_traverse(self, on_visit):
        to_visit = [self]
        while len(to_visit) > 0:
            current = to_visit.pop(0)
            on_visit(current.value)
            if current.type == NODE_LEFT:
                if current.parent.right is not None:
                    to_visit.append(current.parent.right.dig())
                else:
                    to_visit.append(current.parent)
            elif current.type == NODE_RIGHT:
                to_visit.append(current.parent)


root = BinarySearchTree(int(input()))
root.type = NODE_ROOT

try:
    while 1:
        child = BinarySearchTree(int(input()))
        root.insert(child)
except EOFError:
    pass

root.dig().post_order_traverse(print)
