# Postman Testing

Start the application and use `http://localhost:8080`.

1. POST `/api/departments`
```json
{"name":"IT"}
```

2. POST `/api/employees`
```json
{"name":"Arjun","email":"arjun@example.com","role":"Developer","department":{"id":1}}
```

3. GET `/api/employees`

4. GET `/api/employees/1`

5. PUT `/api/employees/1`
```json
{"name":"Arjun Kumar","email":"arjun.kumar@example.com","role":"Senior Developer","department":{"id":1}}
```

6. DELETE `/api/employees/1`

7. GET `/api/employees/search?name=Arjun`

8. GET `/api/employees/department/IT`

9. GET `/api/employees/role/Developer`

Validation test: send an invalid email such as `wrong-email`; the validation layer should reject the request.
