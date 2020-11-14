
####
mvn spring-boot:run

#### POST 
curl --location --request POST 'http://localhost:8080/employee/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName" : "Faraz",
    "lastName" : "Mohammad",
    "country" : "India",
    "department" : {
        "departmentId" : 2,
        "departmentName" : "Maths"
    }
}'


#### GET
curl --location --request GET 'http://localhost:8080/employee/630180c7-2b5f-42d3-af41-4cdd71e5f56e'

#### PUT
curl --location --request PUT 'http://localhost:8080/employee/update/630180c7-2b5f-42d3-af41-4cdd71e5f56e' \
--header 'Content-Type: application/json' \
--data-raw '{
    "employeeId": "630180c7-2b5f-42d3-af41-4cdd71e5f56e",
    "firstName": "Faraz",
    "lastName": "Mohammad",
    "country": "UAE",
    "department": {
        "departmentId": "1",
        "departmentName": "Computer Science"
    }
}'