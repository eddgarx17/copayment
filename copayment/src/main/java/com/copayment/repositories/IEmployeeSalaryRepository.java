package com.copayment.repositories;
import com.copayment.models.EmployeeSalaryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
/** @Repository marcar una clase como un componente de repositorio. */

@Repository /*Permite realizar consultas a la db*/
public interface IEmployeeSalaryRepository  extends JpaRepository<EmployeeSalaryModel, Long> {//CrudRepository

    /*@Procedure(name = "ConsultarSalarioDiarioPorEmpleado")
    void ConsultarSalarioDiarioPorEmpleado();*/


/*
      	SELECT  (@contador := @contador + 1),
		       T1.id_empleado,
		       T1.Nombre,
		       T1.departamento,
				 DATE(fecha) AS Dia,
				 T1.pago_por_hora,
		        (SELECT AVG(pago_por_hora)  -- Obtenemos el la media el pago por hora por departamento
				     FROM erca_empleados
					  WHERE departamento = T1.departamento
					  GROUP BY Departamento) AS media_pago_por_hora,
					(SELECT COALESCE(TIMESTAMPDIFF(HOUR,MIN(fecha),MAX(fecha) ),0)
                FROM erdo_entradas_salidas
                WHERE id_empleado = t1.id_empleado
                AND fecha >= Dia
                AND fecha < DATE_ADD(Dia, INTERVAL 1 DAY)
                GROUP BY DATE(fecha)) AS horas_trabajadas
                FROM erca_empleados T1
                INNER JOIN  erdo_entradas_salidas T2 ON T1.id_empleado = T2.id_empleado
                GROUP BY T1.id_empleado,  T1.Nombre,T1.departamento, Dia;
*/

    /**
     * Query permite realizar consultas personalizadas en el repositorio.
     * en la siguiente seccion mandaremos a llamar un procedimiento almacenado
     * que arroja el listado de los trabajadores con el salario por hora trabajadas.
     * */
    @Query(value = "{call ConsultarSalarioDiarioPorEmpleado()}", nativeQuery = true)
    //Informacion de los salarios obtenidos.
    List<EmployeeSalaryModel> employeeSalary();


}
