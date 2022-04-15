package org.ergemp.repository;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.query.QueryResult;
import org.ergemp.configuration.CouchbaseConfig;
import org.ergemp.mapper.AirlineMapper;
import org.ergemp.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirlineRepository {

    @Autowired
    CouchbaseConfig couchbaseConfig ;

    @Autowired
    private Cluster cluster;

    public List<Airline> findAll() {

        QueryResult result = cluster.query("select * from `travel-sample` where type='airline'");
        List<Airline> airlines = AirlineMapper.mapRow(result);

        return airlines;

    }

}
