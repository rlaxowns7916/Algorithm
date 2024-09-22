grade_map = {
    "A+": 4.5,
    "A0": 4.0,
    "B+": 3.5,
    "B0": 3.0,
    "C+": 2.5,
    "C0": 2.0,
    "D+": 1.5,
    "D0": 1.0,
    "F": 0.0
}
credit_sum = 0
score_sum = 0
score_threshold = 3.3

for index in range(20):
    data = input()
    subject_name, credit, grade = tuple(data.split(" "))

    if grade == 'P':
            pass
    else:
        credit_sum += float(credit)
        score_sum += float(credit) * grade_map[grade]


print(score_sum/credit_sum)
