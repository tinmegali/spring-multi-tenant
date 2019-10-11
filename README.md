# Database based Multi-Tenancy with Spring Data MongoDB
Simple database based multi tenancy using spring data and mongoDB.

- The app creates/recovers databases on `user`'s `tenant` information.
- If the `user` doesn't have a tenant, the app retrieve a default database, 
that is shared between all users without tenant.

# Running
1. Run a docker mongodb image and build de project.
2. Navigate to [home](http://localhost:8080/).
3. Click on [greeting](http://localhost:8080/login).
4. Log in with any of the users (listed below).
5. You'll see a a *welcome* message with the `user.username` and a list of `person` related to this user tenant context.
6. Click on *add person* to add new data.
7. Logout and try another user and see how the data changes.

## Registered Users
| USER | PASSWORD | TENANT  |
| ---- | -------- | ------- |
| `user` | `password` | `tenant1` |
| `user1`| `password` | `tenant1` |
| `user2`| `password` | `tenant2` |
| `admin1`| `password` | *none*    |
| `admin2`| `password` | *none*    |

## Acknowledgment
This project used a lot of references to be build.
- [Database based Multi-Tenancy with Spring Data MongoDB](https://github.com/naveenb92/spring-data-mongodb-multitenant).
- [Spring Security - Custom Authentication](https://dzone.com/articles/spring-security-custom)
- [Multi-Tenancy Implementation for Spring Boot + Hibernate Projects](https://dzone.com/articles/spring-boot-hibernate-multitenancy-implementation)
