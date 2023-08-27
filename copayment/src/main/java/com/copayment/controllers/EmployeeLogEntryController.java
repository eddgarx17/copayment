package com.copayment.controllers;

import com.copayment.models.EmployeeLogEntryModel;
import com.copayment.models.EmployeeModel;
import com.copayment.services.EmployeeLogEntryService;
import com.copayment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
/**
 * Registro de entradas y salidas
 **/
/**
 *  @RestController se utiliza para marcar una clase como un controlador REST
 */
@RestController
/**
 * Con  RequestMapping asignamos una ruta a un controlador o a un método dentro de un controlador en Spring
 * Indica que todas las rutas definidas en ese controlador o método empezaran por "/employeeLog"
 */
@RequestMapping("/employeeLog")
public class EmployeeLogEntryController {
    @Autowired
    private EmployeeLogEntryService employeeLogEntryService;

    /**
     * Consultamos todos los registros de entradas y salidas de los empleados
     * */
    @PostMapping("/getLogEntry")
    public ArrayList<EmployeeLogEntryModel> getEmployeeLogEntry(){
        return this.employeeLogEntryService.getEmployeeLogEntry();
    }
    /**
     * Guardamos un nuevo registro de entrada o salida.
     * @Request Recibe como parametros el atributo tipo_registro que
     * permite solo dos tipos de valores: entrada o salida  y
     * recibe un objecto con el id del empleado.
     * ejemplo:
     * Request
     * {
     *     "tipo_registro": "salida", salida or entrada
     *     "empleado": {
     *         "id_empleado": 15
     *     }
     * }
     * */
    @PostMapping("/LogEntry")
    public EmployeeLogEntryModel logEntry(@RequestBody EmployeeLogEntryModel employeeLogEntry){
        System.out.println(employeeLogEntry);
        return this.employeeLogEntryService.saveEmployeeLogEntry(employeeLogEntry);
    }

}
