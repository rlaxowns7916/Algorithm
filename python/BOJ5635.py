N = int(input())
students:dict[str,int]={}

for _ in range(N):
    chunk = input().split(" ")
    students[chunk[0]] = int(chunk[3]) * 10000 + int(chunk[2]) * 100 + int(chunk[1])
sorted_students = sorted(students.items(), key=lambda x: x[1])

print(f"{sorted_students[-1][0]}\n{sorted_students[0][0]}")