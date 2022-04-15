package org.ergemp.mapper;

import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryResult;
import com.fasterxml.jackson.databind.JsonNode;
import org.ergemp.model.Airline;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirlineMapper {

    public static List<Airline> mapRow(QueryResult result) {
        List<Airline> airlines = new ArrayList<>();

        for(JsonObject row : result.rowsAsObject()) {
            Airline airline = new Airline();
            airline.setCallSign(row.getObject("travel-sample").getString("callsign"));
            airline.setIata(row.getObject("travel-sample").getString("iata"));

            airlines.add(airline);
        }

        return airlines;
    }
}
