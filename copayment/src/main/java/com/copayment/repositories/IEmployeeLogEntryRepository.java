package com.copayment.repositories;
import com.copayment.models.EmployeeLogEntryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** @Repository marcar una clase como un componente de repositorio. */
@Repository /*Permite realizar consultas a la db*/
/**
 * IEmployeeLogEntryRepository extiende la interfaz JpaRepository de Spring JPA.
 En este caso, la interfaz IEmployeeLogEntryRepository está parametrizada con dos tipos de datos: EmployeeLogEntryModel y Long.
 El tipo EmployeeLogEntryModel es la entidad de la base de datos con la que se va a trabajar,
 mientras que Long es el tipo del identificador de la entidad EmployeeLogEntryModel.
 **/
public interface IEmployeeLogEntryRepository extends JpaRepository<EmployeeLogEntryModel, Long> {

    /**
     * JpaRepository incluye metodos como save, findById.
     * */
}
