/**
 * Join의 경우, Table의 개수가 많다면 더 느릴 수 있다.
 * Index를 사용할 경우 Join이 더 빠를 수도 있고, 정교한 쿼리결과를 낼 수 있다.
 */

SELECT
    Department.name AS 'Department',
    Employee.name AS 'Employee',
    Salary
FROM
    Employee
        JOIN
    Department ON Employee.DepartmentId = Department.Id
WHERE
        (Employee.DepartmentId , Salary) IN
        (   SELECT
                DepartmentId, MAX(Salary)
            FROM
                Employee
            GROUP BY DepartmentId
        )
;