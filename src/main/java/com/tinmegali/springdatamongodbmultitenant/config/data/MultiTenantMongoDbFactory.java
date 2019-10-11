package com.tinmegali.springdatamongodbmultitenant.config.data;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.tinmegali.springdatamongodbmultitenant.config.security.CustomUsernamePasswordToken;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.net.UnknownHostException;

/**
 * MongoDB Factory.
 * Gets current 'tenant' context from authenticated user.
 * If user doesn't have a 'tenant', a default database is provided.
 */
public class MultiTenantMongoDbFactory extends SimpleMongoDbFactory {

    public String DEFAULT_DB = "demo";

    public MultiTenantMongoDbFactory(MongoClientURI uri) throws UnknownHostException {
        super(uri);
    }

    @Override
    public MongoDatabase getDb() throws DataAccessException {
        // Get tenant context from authentication
        CustomUsernamePasswordToken auth = (CustomUsernamePasswordToken)
                SecurityContextHolder.getContext().getAuthentication();
        String tenant = auth.getTenant();

        if (tenant != null)
        {
            return getDb(tenant);
        } else {
            // Return a default DB
            return super.getDb(DEFAULT_DB);
        }
    }
}
