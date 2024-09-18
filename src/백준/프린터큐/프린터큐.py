from collections import deque

T = int(input())
results = []

for t in range(T):
    (N, M) = tuple(map(int, input().split(" ")))
    documents = deque(input().split(" "))

    counter = 0
    current_position = M

    while len(documents) > 0 :
        if current_position == 0:
            if documents[0] == max(documents):
                counter += 1
                break
            else:
                documents.append(documents.popleft())
                current_position = len(documents)-1
        else:
            if documents[0] == max(documents):
                documents.popleft()
                counter += 1
            else:
                documents.append(documents.popleft())
            current_position -= 1
    results.append(str(counter))

print("\n".join(results))