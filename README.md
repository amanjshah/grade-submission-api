# Grade Submission REST API

Simple API which allows authenticated users to create/update/view/delete student/course/grade entries in a shared MySQL database.


## Security

- Publicly available /user/registration endpoint to create user entry in db.
- Publicly available /authentication endpoint to allow users to log in, i.e. receive a JWT token in the response header to make future requests.
- JWT bearer token is needed in the header for a request to any other endpoint.
