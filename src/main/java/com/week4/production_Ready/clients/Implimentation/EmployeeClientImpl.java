package com.week4.production_Ready.clients.Implimentation;

import com.week4.production_Ready.Advices.ResponseApi;
import com.week4.production_Ready.clients.EmployeeClient;
import com.week4.production_Ready.dtos.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        try {
            ResponseApi<List<EmployeeDTO>> employees = restClient.get()
                    .uri("/MyEmployees/Get/All")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employees.getData();
        }
        catch(Exception e)
        {
           throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long empid) {
        try {
            ResponseApi<EmployeeDTO> employee = restClient.get()
                    .uri("/MyEmployees/Get/{empid}", empid)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });

            return employee.getData();
        }
        catch(Exception e)
            {
            throw new RuntimeException(e);
            }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employee) {
        ResponseApi<EmployeeDTO> employeedto = restClient.post()
                .uri("/MyEmployees/Post")
                .body(employee)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});

        return employeedto.getData();
    }
}
