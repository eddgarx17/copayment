package com.copayment.services;

import com.copayment.exception.ResourceNotFoundException;
import com.copayment.models.EmployeeLogEntryModel;
import com.copayment.models.EmployeeModel;
import com.copayment.repositories.IEmployeeLogEntryRepository;
import com.copayment.repositories.IEmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service

public class EmployeeLogEntryService {
    @Autowired
    private IEmployeeLogEntryRepository employeeLogEntryRepository;
    @Autowired
    private IEmployeeRespository employeeRespository;

    public ArrayList<EmployeeLogEntryModel> getEmployeeLogEntry(){
        /***  obtenemos todas las entradas de registro de empleado del repositorio **/
        return (ArrayList<EmployeeLogEntryModel>) employeeLogEntryRepository.findAll();
    }
    public EmployeeLogEntryModel saveEmployeeLogEntry(EmployeeLogEntryModel employeeLogEntryModel){

        /*** buscamos el empleado en el repositorio utilizando el ID de empleado porporcionado en el objeto employeeLogEntryModel**/
        EmployeeModel employee = employeeRespository.findById(employeeLogEntryModel.getEmpleado().getId_empleado()).
                orElseThrow(()-> new ResourceNotFoundException("Empleado no encontrado"));
        /***  Establecemos el la informacion del empleado, la fecha actual, y el tipo de registro (entrada o salida) en la instancia de EmployeeLogEntryModel**/
        EmployeeLogEntryModel employeeLogEntry = new EmployeeLogEntryModel();
        employeeLogEntry.setEmpleado(employee);
        employeeLogEntry.setFecha(LocalDateTime.now());
        employeeLogEntry.setTipo_registro(employeeLogEntryModel.getTipo_registro());
        //System.out.println(employeeLogEntry);
        //System.out.println(employee);
         /*** Guardamos la nueva entrada o salida  de registro del empleado en el repositorio**/
        return employeeLogEntryRepository.save(employeeLogEntry);
    }
}
