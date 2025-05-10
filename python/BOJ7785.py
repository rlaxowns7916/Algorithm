n = int(input())
working = set()

for i in range(n):
    name, command = input().split(" ")
    
    if command == "enter":
        working.add(name)
    else:
        working.remove(name)
              
print("\n".join(sorted(working, reverse=True)))