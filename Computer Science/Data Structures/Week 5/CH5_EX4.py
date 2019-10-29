"""
4. Implement the in method (__contains__) for the hash table Map ADT implementation
"""
class Node(hash,key,data):
    self.hash = hash
    self.key = key
    self.data = data
    next = None
    prev = None

    def __getHash__(self):
        return self.hash

    def __getKey__(self):
        return self.key

    def __getData__(self):
        return self.data

    def __getNext__(self):
        return self.next

    def __getPrev__(self):
        return self.last

    def __setKey__(self, key):
        self.key = key

    def __setData__(self, data):
        self.data = data

    def __setNext__(self, next):
        self.next = next
        
    def __setPrev__(self, next):
        self.prev = prev

class HashTable:
    def __init__(self):
        self.size = 11
        self.slots = [None] * self.size
        self.data = [None] * self.size

    def put(self, key, data):
        hash_value = self.hash_function(key,len(self.slots))
        if self.slots[hash_value] == None:
            self.slots[hash_value] = key
            self.data[hash_value] = data
        else:
            if self.slots[hash_value] == key:
                self.data[hash_value] = data #replace
            else:
                next_slot = self.rehash(hash_value, len(self.slots))
                while self.slots[next_slot] != None and \
                    self.slots[next_slot] != key:
                    next_slot = self.rehash(next_slot, len(self.slots))
                    if self.slots[next_slot] == None:
                        self.slots[next_slot] = key
                        self.data[next_slot] = data
                    else:
                        self.data[next_slot] = data #replace

    def hash_function(self, key, size):
        return key % size

    def rehash(self, old_hash, size):
        return (old_hash + 1) % size

    def get(self, key):
        start_slot = self.hash_function(key, len(self.slots))
        data = None
        stop = False
        found = False
        position = start_slot
        while self.slots[position] != None and \
        not found and not stop:
            if self.slots[position] == key:
                found = True
                data = self.data[position]
            else:
                position=self.rehash(position, len(self.slots))
                if position == start_slot:
                    stop = True
        return data

    def __getitem__(self, key):
        return self.get(key)

    def __setitem__(self, key, data):
        self.put(key, data)

    def __contains__(self,i):
        if i in self.slots:
            return True, f"Key"

        elif i in self.data:
            return True, f"data"
        else:
            return False

if __name__ == "__main__":

    h=HashTable()
    h[54]="cat"
    h[26]="dog"
    h[93]="lion"
    h[17]="tiger"
    h[77]="bird"
    h[31]="cow"
    h[44]="goat"
    h[55]="pig"
    h[20]="chicken"
    print(h)



    print(h.__contains__(54))
    print(h.__contains__("lion"))
    h.put(666, "fuck")
    print(h.__contains__("fuck"))