
# Spring Boot / Kotlin - Demo Project

## REST API

Create user

    curl -X POST "localhost:9000/users" -H "Content-Type: application/json" -d '{"name": "tester", "email": "tester@test.de"}'

Get users

    curl localhost:9000/users


## GraphQL API

Create user

    mutation {
        newUser(name: "tester", email: "tester@test.de") {
            id
            name
            email
        }
    }

Get users

    {
      users {
        id
        name
        email
        lengthOfName
      }
    }
