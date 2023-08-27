package com.copayment.repositories;

import com.copayment.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** @Repository marcar una clase como un componente de repositorio. */
@Repository /*Permite realizar consultas a la db*/
public interface IUserRepository extends JpaRepository<UserModel,Long> {
    /**buscamos el usuario por su nombre  en respositorio y devuelve un objeto UserModel
     * que coincide con el nombre de usuario especificado.
     ***/
    UserModel findByusuario(String usuario);
}
