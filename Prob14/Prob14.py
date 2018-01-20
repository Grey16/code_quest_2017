class Node:
    # constructor
    def __init__(self, name):
        self.name = name
        self.children = []

    # used to compare Node objects
    def __eq__(self, other):
        return self.name == other.name
    def __lt__(self, other):
        return self.name < other.name
    def __gt__(self, other):
        return self.name > other.name

    # adds a child Node to children
    def add(self, child):
        self.children.append(child)

    # prints the hierarchy
    def itemPrint(self, depth):
        # prints itself if not at top level
        if depth >= 0:
            for i in range(0, depth):
                print("-", end = "")
            print(self.name)

        # check if Node has children
        if len(self.children) > 0:
            # sort children alphabetically by their name
            self.children.sort()

            # recursively print children
            for child in self.children:
                child.itemPrint(depth + 1)

def main():
    # input handling
    with open("Prob14.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]

        # initialize dictionary
        dictionary = dict()

        # set up top level
        top = Node("None")
        dictionary["None"] = top

        n = int(myList[0])
        for i in range(1, n + 1):
            currInput = myList[i].split(",")
            itemName = currInput[0]
            parentName = currInput[1]

            # create a Node for item
            item = Node(itemName)
            # put item on hashmap
            dictionary[itemName] = item

            # get the parent
            parent = dictionary.get(parentName)
            # add child Node to parent's children
            parent.add(item)

        # print hierarchy
        top.itemPrint(-1)

if __name__ == "__main__": main()
