package com.prudhviraj.production_ready_features.production_ready_features.clients.impl;

import com.prudhviraj.production_ready_features.production_ready_features.clients.EmployeeClient;
import com.prudhviraj.production_ready_features.production_ready_features.dto.TodoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;


@Service
public class EmployeeClientImpl implements EmployeeClient {
    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);
    @Autowired
    private RestClient restClient;

    @Override
    public List<TodoDto> getAllEmployees() {
        //logging level in order
        log.error("Error log");
        log.warn("Warn log");
        log.info("Info log");
        log.debug("Debug log");
        log.trace("Trace log");

        try {
         List<TodoDto> response = restClient.get()
                 .uri("todos")
                 .retrieve()
                 .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {// if we got any exception can are able those exception we can do this in catch by adding multiple blocks as well
                     log.error("Error message is :- {}",new String(res.getBody().readAllBytes()));
                     System.out.println(new String(res.getBody().readAllBytes()));
                     throw new RuntimeException();
                 })// exception block end
                 .body(new ParameterizedTypeReference<>() {
                 });
            log.debug("Successfully retrieved the employees in getAllEmployees");
            log.trace("Retrieved employees list in getAllEmployees : {}, {}, {}", response, "Hello", 5);
            return response;
        } catch (Exception e) {
            log.error("Exception occurred in getAllEmployees() {}",e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
