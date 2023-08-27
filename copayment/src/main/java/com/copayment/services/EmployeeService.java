package com.copayment.services;

import com.copayment.exception.ResourceNotFoundException;
import com.copayment.models.EmployeeModel;
import com.copayment.repositories.IEmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRespository employeeRespository;

    /**
     * el siguiente método devuelve una lista de todos los empleados utilizando el método findAll
     * */
    public ArrayList<EmployeeModel>getEmployees(){
        return (ArrayList<EmployeeModel>) employeeRespository.findAll();
    }
/**
    el siguiente   método devuelve un empleado específico por su ID utilizando el método findById de IEmployeeRespository.
    Si el empleado no se encuentra, lanza una excepción ResourceNotFoundException.
 */
    public EmployeeModel getEmployeesById(Long id){
       return  employeeRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado"));
    }
    /**
     *el metodo saveemployee recibe el objecto del empleado que se desa guardar.
     * */
    public EmployeeModel saveEmployee(EmployeeModel employeeModel){
        return employeeRespository.save(employeeModel);
    }
    /**
     *el metodo updateById actualiza el empleado recibiendo como respuesta un objecto del empleado a actualizar.
     * */
    public EmployeeModel updateById(EmployeeModel request, Long employeeID){
        // Buscar el empleado por su ID en el repositorio y lanzar una excepción si no se encuentra
        EmployeeModel employee = employeeRespository.findById(employeeID).orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado"));

        // Actualizar los campos del empleado con los valores proporcionados en el objeto request

        if((request.getApellido_materno() != null && !request.getApellido_materno().isEmpty())){
            employee.setApellido_materno(request.getApellido_materno());
        }
        if((request.getApellido_paterno() != null && !request.getApellido_paterno().isEmpty())){
            employee.setApellido_paterno(request.getApellido_paterno());
        }
        if((request.getNombre() != null && !request.getNombre().isEmpty())){
            employee.setNombre(request.getNombre());
        }
        if((request.getPago_por_hora() != null)){
            employee.setPago_por_hora(request.getPago_por_hora());
        }
        if((request.getDepartamento() != null && !request.getDepartamento().isEmpty())){
            employee.setDepartamento(request.getDepartamento());
        }
        // guarda los cambios realizados en el empleado en el repositorio.
        employeeRespository.save(employee);
        // devuelve el objeto empleado actualizado.
        return employee;
    }

    /**
     *
     * Metodo deleteEmployee elimina el registro del empleado recibiendo como parametro el
     * id del empleado
     */
    public Boolean deleteEmployee(Long id){
        try{
            /** verificar si el empleado existe en el repositorio*/
            if(!employeeRespository.findById(id).isPresent()){
                return  false;
               // ("Empleado no encontrado");
            }
             /**elimina el empleado del repositorio utilizando su ID de empleado*/
            employeeRespository.deleteById(id);
            /** devuelve true para indicar que el empleado fue eliminado correctamente*/
            return  true;
        }catch (Exception e){
            /** En caso de que ocurra una excepción, devolvera false*/
            return  false;
        }
    }
}
