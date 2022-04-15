package org.ergemp.configuration;

import com.couchbase.client.java.Cluster;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
    @Value("${couchbase.server}")
    String server;

    @Value("${couchbase.username}")
    String username;

    @Value("${couchbase.password}")
    String password;

    @Value("${couchbase.bucket}")
    String bucket;

    public String getConnectionString() {
        return server;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBucketName() {
        return bucket;
    }

    public Cluster getCluster () {
        return Cluster.connect(server, username, password);
    }
}
