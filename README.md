# Database based Multi-Tenancy with Spring Data MongoDB
Simple database based multi tenancy using spring data and mongoDB.

The app creates/recovers databases based on parameters sent in the request.

# Running
Build, run a docker mongodb image and make a get request to `http://localhost:8080/?db=db_name`.
A new database using `db` parameter will be created and a document inserted on it.

# MultiTenantMongoDbFactory.java
This is where the magic happens. We extend the SimpleMongoDbFactory provided by spring and override the getDb() method. That's all there is to it. How you do this may depend on where you are utilizing the same. As an example scenario i have implemented this in a Spring MVC app. RequestContextHolder is thread safe. 

We inject the tenantId somewhere during the request life cycle and extract it in the getDb() method. I also have added a default Db.

```
    @Override
    public DB getDb() throws DataAccessException {

        // Check the RequestContext
        Object tenant = RequestContextHolder.getRequestAttributes()
                          .getAttribute("tenantId", RequestAttributes.SCOPE_REQUEST);

        if (tenant instanceof String)
        {
            return getDb(tenant.toString());
        }

        // Return a default DB
        return super.getDb(DEFAULT_DB);
    }
```

## Acknowledges
Based on project created by [Naveen Babu](https://github.com/naveenb92/spring-data-mongodb-multitenant).
