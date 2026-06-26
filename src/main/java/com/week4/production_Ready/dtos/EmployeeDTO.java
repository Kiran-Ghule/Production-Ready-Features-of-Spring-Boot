package com.week4.production_Ready.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {



        private Long id;

        private String name;

        private String email;

        private String role;

        private Boolean isActive;

        private Long Salary;


}
