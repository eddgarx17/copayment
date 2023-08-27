package com.copayment.repositories;
import com.copayment.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/** @Repository marcar una clase como un componente de repositorio. */

@Repository /*Permite realizar consultas a la db*/

 /**
  * IEmployeeRespository extiende la interfaz JpaRepository de Spring JPA.
    En este caso, la interfaz IEmployeeRespository está parametrizada con dos tipos de datos: EmployeeModel y Long.
    El tipo EmployeeModel es la entidad de la base de datos con la que se va a trabajar,
    mientras que Long es el tipo del identificador de la entidad EmployeeModel.
  **/
public interface IEmployeeRespository  extends JpaRepository<EmployeeModel, Long> {
    /**
     * JpaRepository incluye metodos como save, findById.
     * */

}
