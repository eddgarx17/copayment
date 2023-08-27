package com.copayment.services;

import com.copayment.models.EmployeeSalaryModel;
import com.copayment.repositories.IEmployeeSalaryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeSalaryService {

    //    private final  IEmployeeSalaryRepository employeeSalaryRepository;
    //    @Autowired
    //    public EmployeeSalaryService(IEmployeeSalaryRepository employeeSalaryRepository){
    //        this.employeeSalaryRepository = employeeSalaryRepository;
    //    }
    //    @Transactional
    //    public void getSalarioDiarioPorEmpleado(){
    //        employeeSalaryRepository.ConsultarSalarioDiarioPorEmpleado();
    //    }
    @Autowired //Inyeccion de dependencias
    IEmployeeSalaryRepository employeeSalaryRepository;

    public List<EmployeeSalaryModel> getSalary(){
        /** Obtener los salarios de los empleados utilizando el repositorio **/
        return  employeeSalaryRepository.employeeSalary();
    }
}
