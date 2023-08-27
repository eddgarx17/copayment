package com.copayment.controllers;

import com.copayment.models.EmployeeModel;
import com.copayment.models.EmployeeSalaryModel;
import com.copayment.services.EmployeeSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController  // @RestController se utiliza para marcar una clase como un controlador REST
@RequestMapping("/employeeSalary")
public class EmployeeSalaryController {
   @Autowired
   EmployeeSalaryService employeeSalaryService;

   /**
    * Consultamos el salario diario de los empleados registrados
    * */
    @PostMapping("/getSalary")
    public List<EmployeeSalaryModel> getSalarioDiarioPorEmpleado(){
        return this.employeeSalaryService.getSalary();
    }

}
