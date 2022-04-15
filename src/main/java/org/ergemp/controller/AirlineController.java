package org.ergemp.controller;

import com.couchbase.client.java.Cluster;
import org.ergemp.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirlineController {

    @Autowired
    AirlineRepository airlineRepository;

    @GetMapping("/api/airline")
    public ResponseEntity getToken() {
        //ResponseEntity retVal = ResponseEntity.status(HttpStatus.OK).body(airlineRepository.findAll());

        ResponseEntity retVal = ResponseEntity.status(HttpStatus.OK).body(airlineRepository.findAll());
        return retVal;
    }
}
