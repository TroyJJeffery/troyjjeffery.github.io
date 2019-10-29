class Node(key,data):
    self.key = key
    self.data = data
    next = None
    prev = None

    def __getKey__(self):
        return self.key

    def __getData__(self):
        return self.data

    def __getNext__(self):
        return next

    def __getPrev__(self):
        return last

    def __setKey__(self, key):
        self.key = key

    def __setData__(self, data):
        self.data = data

    def __setNext__(self, next):
        self.next = next
        
    def __setPrev__(self, next):
        self.prev = prev


