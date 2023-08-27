package com.copayment.controllers;

import com.copayment.models.EmployeeModel;
import com.copayment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

/**Create, Read, Update, Delete de empleados.**/

/**
 *  @RestController se utiliza para marcar una clase como un controlador REST
*/
@RestController
 /**
  * Con  RequestMapping asignamos una ruta a un controlador o a un método dentro de un controlador en Spring
  * Indica que todas las rutas definidas en ese controlador o método empezaran por "/employee"
  */
@RequestMapping("/employee")
  /**la clase EmployeeController  es responsable de manejar las solicitudes HTTP.**/

public class EmployeeController {
    /**
     * Autowired permite que se resuelva automáticamente la inyeccion de dependencias necesarias,
     * evitando la necesidad de crear y administrar manualmente las instancias de las dependencia
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * PostMapping se utiliza para mapear una solicitud http post.
     */

    /**
     * Optenemos una lista de los empleados registrados
     */
    @PostMapping("/getEmployee")
    public ArrayList<EmployeeModel>getEmployee(){
        return this.employeeService.getEmployees();
    }
    /**
     * Realiza la busqueda de empleados por Id de empleado
     */
    @PostMapping("/getEmployee/{id}")
    /**
     * PathVariable Optenemos valores de variables de ruta en una solicitud
     * @return regresa la informacion del empleado en base al id enviado, si el id de empleado
     * enviado no existe regresara un string con el mensaje empleado no encontrado
     * */
    public EmployeeModel getEmployeeById(@PathVariable Long id){
        return this.employeeService.getEmployeesById(id);
    }
    /**
    * Guardamos un nuevo empleado.
    *
    * "nombre":"Regina",
    * "apellido_paterno":"Almazan",
    * "apellido_materno":"Cruz",
    * "departamento":"Infraestructura",
    * "pago_por_hora" : 510.00
    * */
    @PostMapping("/saveEmployee")
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel employee){
        return this.employeeService.saveEmployee(employee);
    }
    /**
     * Actualizamos un empleado recibiendo como unico parametro el id del empleado.
     * @return regresa la informacion del cliente actualizada, en caso de que no exista el cliente mostrara el mensaje
     * Empleado no encontrado.
     * */
    @PostMapping("/updateEmployee/{id}")
    public EmployeeModel updateEmployeeById(@RequestBody EmployeeModel employeeModel, @PathVariable Long id){
        return  this.employeeService.updateById(employeeModel, id);
    }
    /**
     * Eliminamos un empleado recibiendo como parametro el id del empleado a eliminar.
     * @return un string indicando si el empleado con id {} fue eliminado o no existe.
     * */
    @PostMapping("/deleteEmployee/{id}")
    public String  deleteEmployee(@PathVariable Long id){
        //  System.out.println(this.employeeService);
        //  boolean isDelete = this.employeeService.deleteEmployee(id);
        //  System.out.println(isDelete);
        if(this.employeeService.deleteEmployee(id)){
            return "El empleado con el ID "+id+" fue eliminado .";
        }
        return "Error, El empleado con el ID "+id+" no existe.";
    }
}
