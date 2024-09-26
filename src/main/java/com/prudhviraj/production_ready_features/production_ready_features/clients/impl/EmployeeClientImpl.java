package com.prudhviraj.production_ready_features.production_ready_features.clients.impl;

import com.prudhviraj.production_ready_features.production_ready_features.clients.EmployeeClient;
import com.prudhviraj.production_ready_features.production_ready_features.dto.TodoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;

@Slf4j
@Service
public class EmployeeClientImpl implements EmployeeClient {
    @Autowired
    private RestClient restClient;

    @Override
    public List<TodoDto> getAllEmployees() {
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
            throw new RuntimeException(e.getMessage());
        }
    }
}
