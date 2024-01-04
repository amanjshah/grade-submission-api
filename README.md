
# Grade Submission REST API

## Overview

Simple API which allows authenticated users to create/update/view/delete student/course/grade entries in a shared MySQL database.


## Data
 
- JPA entities: Student, Grade, Course, User
- One-to-many relationship between Student and Grade
- One-to-many relationship between Course and Grade
- Many-to-many relationship between Student and Course


## Endpoints
Swagger OpenAPI spec pending completion


## Security

- Publicly available /user/registration endpoint to create user entry in db.
- Publicly available /authentication endpoint to allow users to log in, i.e. receive a JWT token in the response header to make future requests.
- JWT bearer token is needed in the header for a request to any other endpoint.
