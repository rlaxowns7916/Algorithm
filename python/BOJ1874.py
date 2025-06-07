n = int(input())
index:int = 0
counter:int = 1 
result: list[str]= []
queue: list[int]= []
targets: list[int] = [int(input()) for _ in range(n)]


while index < n:
    if len(queue) == 0 or queue[-1] < targets[index]:
        queue.append(counter)
        counter += 1
        result.append("+")
    elif queue[-1] > targets[index]:
        result.clear()
        break
    else:
        queue.pop()
        index += 1
        result.append("-")
        
print("NO" if len(result) == 0 else "\n".join(result))