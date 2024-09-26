package com.prudhviraj.production_ready_features.production_ready_features.clients;

import com.prudhviraj.production_ready_features.production_ready_features.dto.TodoDto;

import java.util.List;


public interface EmployeeClient {
    List<TodoDto> getAllEmployees();
}
