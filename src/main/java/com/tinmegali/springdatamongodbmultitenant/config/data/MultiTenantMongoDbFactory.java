package com.tinmegali.springdatamongodbmultitenant.config;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.tinmegali.springdatamongodbmultitenant.security.CustomUsernamePasswordToken;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.net.UnknownHostException;

/**
 * Created by Naveen Babu on 12-08-2016.
 */
public class MultiTenantMongoDbFactory extends SimpleMongoDbFactory {

    public String DEFAULT_DB = "demo";

    public MultiTenantMongoDbFactory(MongoClientURI uri) throws UnknownHostException {
        super(uri);
    }

    @Override
    public MongoDatabase getDb() throws DataAccessException {

        // Check the RequestContext
        // The context was defined on HomeController
        String tenant = ((CustomUsernamePasswordToken)SecurityContextHolder.getContext().getAuthentication()).getTenant();

        if (tenant != null)
        {
            return getDb(tenant);
        } else {
            // Return a default DB
            return super.getDb(DEFAULT_DB);
        }
    }
}
