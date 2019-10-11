# Database based Multi-Tenancy with Spring Data MongoDB
Simple database based multi tenancy using spring data and mongoDB.

- The app creates/recovers databases on `user`'s `tenant` information.
- If the `user` doesn't have a tenant, the app retrieve a default database, 
that is shared between all users without tenant.

#### Important Note
Most *spring multi-tenant* samples that I could find use the `ThreadLocalStorage` to save the `tenant` context. 
This project however, has a different approach. It uses the user `Authentication` to save this information.

 I can't say if this approach is best one out there, but it makes more sense 
 to create a close tight relation between the `user` and its `tenant` context
 thought `Authentication` object. If you disagree, please let me know.

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
This project was initially based on [Database based Multi-Tenancy with Spring Data MongoDB](https://github.com/naveenb92/spring-data-mongodb-multitenant),
however, it is so different from the original project, that shouldn't be considered a branch of it.

These were the project's main references:
- [Database based Multi-Tenancy with Spring Data MongoDB](https://github.com/naveenb92/spring-data-mongodb-multitenant).
- [Spring Security - Custom Authentication](https://dzone.com/articles/spring-security-custom)
- [Multi-Tenancy Implementation for Spring Boot + Hibernate Projects](https://dzone.com/articles/spring-boot-hibernate-multitenancy-implementation)
